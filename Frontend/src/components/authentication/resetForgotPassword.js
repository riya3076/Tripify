import React, { useState } from 'react';
import axios from 'axios';
import { Container, Form, Button, Row, Col, Toast } from 'react-bootstrap';
import { Link, useNavigate  } from 'react-router-dom'; // Import useNavigate

const ResetForgotPassword = () => {
  const [pass, setPass] = useState('');
  const [newpass, setnewPass] = useState('');
  const [showToast, setShowToast] = useState(false); 
  const [showErrorToast, setShowErrorToast] = useState(false);
  const [showPasswordErrorToast, setShowPasswordErrorToast] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate(); // Initialize useNavigate

const checkPasswords = async () => {
    // Check if the new password and confirmed password are the same
    if (pass !== newpass) {
      // Show error toast if the passwords don't match
      return false;
    }
    return true;
}
  const handleForgotPassword = async () => {

    setShowPasswordErrorToast(false);
    const passMatch = await checkPasswords();
    if(!passMatch){
      setShowPasswordErrorToast(true);
      return;
    }
    const apiUrl = 'https://group09.onrender.com/auth/edit';
    const headers = {
      'Content-Type': 'application/json',
    };
    const requestBody = {
      "newpassword": pass,
    };

    try {
      setIsLoading(true);
      const response = await axios.post(apiUrl, requestBody, { headers });
      console.log('Response:', response.data);
      navigate('/login');
      // Handle the API response as needed
    } catch (error) {
      console.error('API error:', error);
      // Handle the error
    }
  };

  return (
    <div className="loginPage"
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
              <h2 className="text-center mb-4">Reset Password</h2>
              <Form>
                <Form.Group controlId="formUsername">
                  <Form.Label>New password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={pass} // Bind the value to the email state
                    onChange={(e) => setPass(e.target.value)} // Update email state on change
                  />
                  <Form.Label>Confirm your new password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={newpass} // Bind the value to the email state
                    onChange={(e) => setnewPass(e.target.value)} // Update email state on change
                  />
                </Form.Group>
                <Button
                  variant="primary"
                  className="submitButton my-2"
                  type="button" 
                  onClick={handleForgotPassword} // Call handleForgotPassword on button click
                >
                  {isLoading ? 'Loading...' : 'Submit'}
                </Button>
              </Form>
            </div>
          </Col>
        </Row>
      </Container>

      <Toast
        show={showToast}
        onClose={() => setShowToast(false)}
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
          zIndex: 9999,
          backgroundColor: '#28a745', 
          color: '#ffffff', 
        }}
        delay={2000}
        autohide
      >
        <Toast.Body>OTP Sent..Check Inbox</Toast.Body>
      </Toast>

      <Toast
        show={showErrorToast}
        onClose={() => setShowErrorToast(false)}
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
          zIndex: 9999,
          backgroundColor: '#dc3545', 
          color: '#ffffff', 
        }}
        delay={2000}
        autohide
      >
        <Toast.Body>Something went wrong..</Toast.Body>
      </Toast>
      <Toast
        show={showPasswordErrorToast}
        onClose={() => setShowPasswordErrorToast(false)}
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
          zIndex: 9999,
          backgroundColor: '#dc3545', 
          color: '#ffffff', 
        }}
        delay={2000}
        autohide
      >
        <Toast.Body>Passwords does not match</Toast.Body>
      </Toast>
    </div>
  );
};


export default ResetForgotPassword;