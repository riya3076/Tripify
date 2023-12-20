import React, { useState } from 'react';
import axios from 'axios';
import { Container, Form, Button, Row, Col, Toast } from 'react-bootstrap';
import { Link, useNavigate  } from 'react-router-dom'; 

const OTP = () => {
  const [otp, setOTP] = useState('');
  const [showToast, setShowToast] = useState(false); 
  const [showErrorToast, setShowErrorToast] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate(); 

  const handleForgotPassword = async () => {
    const apiUrl = 'https://group09.onrender.com/auth/otp';
    const headers = {
      'Content-Type': 'application/json',
    };
    const requestBody = {
      "otp": otp,
    };

    try {
      setIsLoading(true);
      const response = await axios.post(apiUrl, requestBody, { headers });
      console.log('Response:', response.data);
      navigate('/resetForgotPassword');
    } catch (error) {
      console.error('API error:', error);

    }
  };

  return (
    <div
      className="loginPage"
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
              <h2 className="text-center mb-4">Enter OTP</h2>
              <Form>
                <Form.Group controlId="formUsername">
                  <Form.Label>OTP</Form.Label>
                  <Form.Control type="text" className="formInput"
                  value={otp}
                  onChange={(e) => setOTP(e.target.value)}
                   />
                </Form.Group>
              
                <Button
                  variant="primary"
                  className="submitButton my-2"
                  type="button" 
                  onClick={handleForgotPassword} 
                >
                  {isLoading ? 'Loading...' : 'Proceed'}
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
        <Toast.Body>OTP Verified</Toast.Body>
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
    </div>
  );
};

export default OTP;
