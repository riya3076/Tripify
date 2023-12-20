import React, { useState } from 'react';
import { Container, Form, Button, Row, Col, Toast } from 'react-bootstrap';
import { Link, useNavigate} from 'react-router-dom';
import axios from 'axios';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [showToast, setShowToast] = useState(false); 
  const [showErrorToast, setShowErrorToast] = useState(false);

  const history = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      setIsLoading(true);
   
      const response = await axios.post('http://localhost:8090/auth/login', { email, password });

      console.log('API response:', response.data);
      sessionStorage.setItem("token",response?.data?.token ?? "");
      localStorage.setItem("token",response?.data?.token ?? "");

      setIsLoading(false);
      setShowToast(true); 
      setTimeout(() => {
        setShowToast(false); 
        history('/landing');
      }, 2000);
    } catch (error) {
      setIsLoading(false);
      console.error('API error:', error);
      setShowErrorToast(true);
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
              <h1 className="text-center mb-4">Login</h1>
              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formUsername">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    className="formInput"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </Form.Group>
                <Form.Group controlId="formPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </Form.Group>
                <Button variant="primary" className="submitButton my-2" type="submit">
                  {isLoading ? 'Loading...' : 'Submit'}
                </Button>
                <div className="text-center">
                  <Link to="/forgot-password">Forgot Password</Link>
                </div>
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
        <Toast.Body>Login successful!</Toast.Body>
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
        <Toast.Body>Wrong credentials. Please try again.</Toast.Body>
      </Toast>
    </div>
  );
};

export default LoginPage;
