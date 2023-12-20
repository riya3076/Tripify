import React, { useState } from 'react';
import { Container, Form, Button, Row, Col, Toast } from 'react-bootstrap';
import axios from 'axios';
import { Link, useNavigate  } from 'react-router-dom'; // Import useNavigate

const Resetpwd = () => {
  const [oldPassword, setOldPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [retypeNewPassword, setRetypeNewPassword] = useState('');
  const [passwordsMatch, setPasswordsMatch] = useState(false);
  const [oldAndNewDifferent, setOldAndNewDifferent] = useState(false);
  const [showSuccessToast, setShowSuccessToast] = useState(false);
  const navigate = useNavigate(); // Initialize useNavigate

  const handleOldPasswordChange = (e) => {
    setOldPassword(e.target.value);
    setOldAndNewDifferent(e.target.value !== newPassword);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleNewPasswordChange = (e) => {
    setNewPassword(e.target.value);
    setPasswordsMatch(e.target.value === retypeNewPassword);
    setOldAndNewDifferent(e.target.value !== oldPassword);
  };

  const handleRetypeNewPasswordChange = (e) => {
    setRetypeNewPassword(e.target.value);
    setPasswordsMatch(e.target.value === newPassword);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (passwordsMatch && oldAndNewDifferent) {
      const fetchUserData = async () => {
        const apiUrl = 'http://localhost:8090/auth/edit';
        const headers = {
          'Content-Type': 'application/json'
        };

        const requestBody = {
          "email" : email,
          "password": oldPassword,
          "newpassword" : newPassword
        }
  
        try {
          const response = await axios.post(apiUrl, requestBody, { headers: headers });
          console.log(response);
          setMessage(response.data.success);
          await setShowSuccessToast(true);
        } catch (error) {
          console.error('API error:', error);
        }
      };
  
      fetchUserData();
      setTimeout(() => {
      navigate('/profile');
      },2000);
    } else {
      setMessage('Passwords do not match or Old and New Passwords are the same!');
    }
  };



  return (
    <div
      className="resetPage"
      style={{
        backgroundImage: `url('https://img.freepik.com/free-photo/top-view-passport-tickets-camera_23-2148786120.jpg?w=1060&t=st=1687293728~exp=1687294328~hmac=0237669a31b51fa53dc2b368ce4a4b1c6695c7f9f20bed1cab6f09b88d09f5c4')`,
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'right',
      }}
    >
      <Container className="vh-100">
        <Row className="justify-content-left align-items-center h-100">
          <Col xs={10} md={3} lg={5}>
            <div className="loginContainer p-4 rounded-lg shadow">
              <h1 className="text-center mb-4">Reset Password</h1>
              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formEmail">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control type="text" className="formInput" 
                  value={email}
                  onChange={handleEmailChange}/>
                </Form.Group>

                <Form.Group controlId="formPassword">
                  <Form.Label>Old Password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={oldPassword}
                    onChange={handleOldPasswordChange}
                  />
                </Form.Group>

                <Form.Group controlId="formNewPassword">
                  <Form.Label>New Password</Form.Label>
                  <Form.Control
                    type="text"
                    className="formInput"
                    value={newPassword}
                    onChange={handleNewPasswordChange}
                  />
                </Form.Group>

                <Form.Group controlId="formRetypeNewPassword">
                  <Form.Label>Retype New Password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={retypeNewPassword}
                    onChange={handleRetypeNewPasswordChange}
                  />
                </Form.Group>

                <Button
                  variant="primary"
                  className="submitButton my-2"
                  type="submit"
                  disabled={!passwordsMatch || !oldAndNewDifferent}
                >
                  Reset Password
                </Button>
              </Form>
            </div>
          </Col>
        </Row>
      </Container>

      <Toast
        show={showSuccessToast}
        onClose={() => setShowSuccessToast(false)}
        style={{
          position: 'absolute',
          top: '60px',
          right: '30px',
          zIndex: 9999,
          backgroundColor: '#dc3545',
          color: '#ffffff',
        }}
        delay={2000}
        autohide
      >
        <Toast.Body>{message}</Toast.Body>
      </Toast>
    </div>
  );
};

export default Resetpwd;
