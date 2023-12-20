import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { FaFacebookSquare, FaTwitter, FaInstagram } from 'react-icons/fa';

const Footer = () => {
  const footerStyle = {
    backgroundColor: '#001C30',
    color: 'white',
    padding: '10px',
    textAlign: 'center',
    width: '100%',
    bottom: 0,
    left: 0,
    zIndex: 9999,
  };

  const contactLinkStyle = {
    textDecoration: 'none',
    color: 'white',
  };

  const socialMediaContainerStyle = {
    marginTop: '10px',
  };

  const socialMediaIconStyle = {
    width: '20px',
    height: '20px',
    marginRight: '10px',
    color: 'white',
    cursor: 'pointer',
  };

  const contactInfoStyle = {
    fontSize: '18px',
    marginBottom: '10px',
  };

  return (
    <footer style={footerStyle}>
      <Container>
        <Row>
          <Col>
            <p style={contactInfoStyle}>
              Contact information:
            </p>
            <p style={contactInfoStyle}>
              Email: <a href="mailto:info@tripify.com" style={contactLinkStyle}>info@tripify.com</a>
            </p>
            <p style={contactInfoStyle}>
              Phone: <a href="tel:+1234567890" style={contactLinkStyle}>+1234567890</a>
            </p>
          </Col>
        </Row>
        <Row className="justify-content-center" style={socialMediaContainerStyle}>
          <Col xs={12} sm={6} md={1} style={{width:4.33}}>
            <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">
              <FaFacebookSquare style={socialMediaIconStyle} />
            </a>
          </Col>
          <Col xs={12} sm={6} md={1} style={{width:4.33}}>
            <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer">
              <FaTwitter style={socialMediaIconStyle} />
            </a>
          </Col>
          <Col xs={12} sm={6} md={1} style={{width:4.33}}>
            <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
              <FaInstagram style={socialMediaIconStyle} />
            </a>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer;
