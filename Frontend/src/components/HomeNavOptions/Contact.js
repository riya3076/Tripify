import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const useStyles = {
  container: {
    margin: '50%'
  },
  content: {
    marginTop: '70px',
    marginBottom: '70px',
  },
  textField: {
    marginBottom: 0,
  },
  heading: {
    marginTop: '50%',
    color: '#212529',
  }
};

const ContactPage = () => {
  const classes = useStyles;
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [showSnackbar, setShowSnackbar] = useState(false);

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleMessageChange = (e) => {
    setMessage(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setShowSnackbar(true);
    setName('');
    setEmail('');
    setMessage('');
  };

  const handleCloseSnackbar = () => {
    setShowSnackbar(false);
  };

  return (
    <div className={classes.container}>
    <HomeNavbar />
    <Container className={classes.content} style={{marginTop: '70px',
    marginBottom: '70px'}}>
      <h4 className={classes.heading} style={{fontSize:'35px',fontWeight:'600'}}>Contact Us</h4>
      <Form onSubmit={handleSubmit}>
        <Row>
          <Col xs={12} sm={6}>
            <Form.Group controlId="formName">
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter your name"
                value={name}
                onChange={handleNameChange}
              />
            </Form.Group>
          </Col>
          <Col xs={12} sm={6}>
            <Form.Group controlId="formEmail">
              <Form.Label>Email</Form.Label>
              <Form.Control
                type="email"
                placeholder="Enter your email"
                value={email}
                onChange={handleEmailChange}
              />
            </Form.Group>
          </Col>
          <Col xs={12}>
            <Form.Group controlId="formMessage">
              <Form.Label>Message</Form.Label>
              <Form.Control
                as="textarea"
                rows={4}
                placeholder="Enter your message"
                value={message}
                onChange={handleMessageChange}
              />
            </Form.Group>
          </Col>
          <Col xs={12}>
            <Button type="submit" variant="outline-primary" style={{marginTop:'15px',color:'#001C30',borderColor:'#001C30'}}>
              Send Message
            </Button>
          </Col>
        </Row>
      </Form>
      <Alert variant="success" show={showSnackbar} onClose={handleCloseSnackbar} dismissible>
        Message sent!
      </Alert>
    </Container>
    <Footer />
  </div>
  );
};

export default ContactPage;
