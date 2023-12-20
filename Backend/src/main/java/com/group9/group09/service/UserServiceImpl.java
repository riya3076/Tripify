package com.group9.group09.service;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.RequestDTO.UserProfileRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.RequestDTO.UserEditRequestDTO;
import com.group9.group09.DTO.ResponseDTO.UserProfileResponseDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.config.JwtService;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.Country;
import com.group9.group09.model.Notification;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.interfaces.NotificationRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Service implementation class for user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private static Logger logger = LoggerFactoryImpl.getLogger();

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Handles the user login service.
     *
     * @param user the User object containing login credentials
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO loginUserService(User user) {

        if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword())) {
            throw new UserNotFoundException("Empty fields");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        ResponseDTO loginStatus = new ResponseDTO();

        Optional<User> userInfo = userRepository.findByUsermail(user.getEmail());

        if (userInfo != null) {
            var jwtToken = jwtService.generateToken(userInfo.get());
            loginStatus.setToken(jwtToken);
            loginStatus.setEmail(user.getEmail());
            loginStatus.setSuccess("ok");
        }

        return loginStatus;
    }

    /**
     * Handles the user registration service.
     *
     * @param user the User object containing registration details
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO registerUserService(User user) {

        ResponseDTO registerStatus = new ResponseDTO();

        if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword()) || isNullOrEmpty(user.getName())) {
            throw new RuntimeException();
        }

        Optional<User> userInfo;

        try {
            userRepository.findByUsermail(user.getEmail());
            registerStatus.setSuccess("User already present");
            return registerStatus;
        } catch (RuntimeException e) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (userRepository.saveUserInfo(user) == 1) {
                var jwtToken = jwtService.generateToken(user);
                registerStatus.setToken(jwtToken);
                registerStatus.setEmail(user.getEmail());
                registerStatus.setSuccess("ok");

                Notification notification = new Notification();
                user = userRepository.getUserbyemail(user.getEmail());
                notification.setUserId(Integer.parseInt(user.getUserId()));
                notification.setDescription("Welcome to the Tripify application.");
                notification.setCategory("Registration");
                notificationRepository.setNotificationsForUser(notification);

            } else {
                throw new RuntimeException();
            }
            return registerStatus;
        }
    }

    /**
     * Handles the update user password service.
     *
     * @param
     * @return the ResponseDTO object
     */

    @Override
    public ResponseDTO updateUserpasswordService(UserEditRequestDTO userEditRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        if (isNullOrEmpty(userEditRequestDTO.getUser().getUserId()) || isNullOrEmpty(userEditRequestDTO.getNewpassword())) {
            throw new UserNotFoundException("Empty fields");
        }

        // Find the user by ID from the database
        Optional<User> userPresent = userRepository.findByUsermail(userEditRequestDTO.getEmail());

        if (userPresent.isPresent()) {
            User user = userPresent.get();

            userRepository.updateUserPassword(userEditRequestDTO.getUser(), passwordEncoder.encode(userEditRequestDTO.getNewpassword()));

            responseDTO.setSuccess("Password updated successfully");

            Notification notification = new Notification();
            user = userRepository.getUserbyemail(user.getEmail());
            notification.setUserId(Integer.parseInt(user.getUserId()));
            notification.setDescription("Your password has been reset.");
            notification.setCategory("Reset Password");
            notificationRepository.setNotificationsForUser(notification);
        } else {
            throw new UserNotFoundException("User not found");
        }

        return responseDTO;

    }

    /**
     * Retrieves the user by email.
     *
     * @param userEditRequestDTO the UserEditRequestDTO object containing user email
     * @return the User object
     */
    @Override
    public User getUserbyEmail(UserEditRequestDTO userEditRequestDTO) {

        User user;
        user = userRepository.getUserbyemail(userEditRequestDTO.getEmail());
        if (user == null) throw new UserNotFoundException("User not found");
        return user;
    }

    /**
     * Handles the update user phone number service.
     *
     * @param user the User object containing updated phone number
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO updateUserphoneNumberService(User user) {
        return null;
    }

    @Override
    public UserProfileResponseDTO getUserDetails(RequestDTO requestDTO) {

        try {
            String token = requestDTO.getToken();
            token = token.replace("Bearer ", "");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            UserProfileResponseDTO responseDTO = new UserProfileResponseDTO();
            responseDTO.setEmail(user.get().getEmail());
            responseDTO.setInterests(user.get().getInterest());
            responseDTO.setName(user.get().getName());
            responseDTO.setPhoneNumber(user.get().getPhone());
            

            Optional<Country> country = countryRepository.findByCountryId(user.get().getHomeCountry());
            responseDTO.setCountry(country.get().getCountryName());

            return responseDTO;
        }
        catch (Exception e){
            throw new RuntimeException("Error in fetching user details");
        }
    }

    @Override
    public ResponseDTO setUserDetails(UserProfileRequestDTO requestDTO) {
        try {
            String token = requestDTO.getToken();
            token = token.replace("Bearer ", "");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            ResponseDTO responseDTO = new ResponseDTO();
            User updatedUser = new User();
            updatedUser.setUserId(user.get().getUserId());

            if (requestDTO.getCountry()!=null) {
                Optional<Country> country = countryRepository.findByCountryName(requestDTO.getCountry());
                Integer countryId = country.get().getCountryID();
                updatedUser.setHomeCountry(countryId);
                userRepository.updateUserCountry(updatedUser);
            }
            if (requestDTO.getInterests()!=null){
                updatedUser.setInterest(requestDTO.getInterests());
                userRepository.updateUserInterests(updatedUser);
            }
            if (requestDTO.getName()!=null){
                updatedUser.setName(requestDTO.getName());
                userRepository.updateUserName(updatedUser);
            }
            if (requestDTO.getPhoneNumber()!= null){
                updatedUser.setPhone(requestDTO.getPhoneNumber());
                userRepository.updateUserPhone(updatedUser);
            }
            if (requestDTO.getEmail()!=null){
                updatedUser.setEmail(requestDTO.getEmail());
                userRepository.updateUserEmail(updatedUser);
            }
            return responseDTO;
        }
        catch (Exception e){
            throw new RuntimeException("Error in updating profile");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
