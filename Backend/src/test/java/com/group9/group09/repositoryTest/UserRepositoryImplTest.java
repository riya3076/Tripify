package com.group9.group09.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.UserRepositoryImpl;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class UserRepositoryImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUserInfo() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");
        user.setPassword("password");
        user.setInterest("Sports");

        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class))).thenReturn(1);

        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int result = userRepository.saveUserInfo(user);

        assertEquals(1, result);
    }
    @Test
    public void testFindByUserId() {
        String userId = "123";
        User expectedUser = new User();

        when(jdbcTemplate.queryForObject(anyString(), any(UserRowMapper.class), eq(userId)))
                .thenReturn(expectedUser);

        Optional<User> result = userRepository.findByUserId(userId);

        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    @Test
    public void testFindByUsermail() {
        String email = "john@example.com";
        User expectedUser = new User();

        when(jdbcTemplate.queryForObject(anyString(), any(UserRowMapper.class), eq(email)))
                .thenReturn(expectedUser);

        Optional<User> result = userRepository.findByUsermail(email);

        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    @Test
    public void testDeleteByUserId_UserNotFound() {

        String userId = "nonExistentUser";

        doThrow(new UserNotFoundException()).when(jdbcTemplate).update("DELETE FROM User WHERE UserID = ?", userId);

        assertThrows(UserNotFoundException.class, () -> userRepository.deleteByUserId(userId));
        verify(jdbcTemplate).update("DELETE FROM User WHERE UserID = ?", userId);
    }
    @Test
    public void testGetUserByEmail_Success() {

        String email = "test@example.com";
        User expectedUser = new User();
        expectedUser.setUserId("user123");
        expectedUser.setEmail(email);

        when(jdbcTemplate.queryForObject(anyString(), any(UserRowMapper.class), eq(email)))
                .thenReturn(expectedUser);

        User actualUser = userRepository.getUserbyemail(email);

        assertNotNull(actualUser);
        assertEquals(expectedUser.getUserId(), actualUser.getUserId());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        verify(jdbcTemplate).queryForObject(anyString(), any(UserRowMapper.class), eq(email));
    }
}
