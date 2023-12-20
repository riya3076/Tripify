import React from 'react';
import { Button, Container} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Footer from './footer';
import HomeNavbar from './HomeNav';

const Home = () => {
  const backgroundStyle = {
    backgroundImage:
      'url("https://img.freepik.com/free-vector/hand-drawn-travel-blue-background_23-2149033527.jpg?w=996&t=st=1687980853~exp=1687981453~hmac=6799d26820dc202f3d66ebcb2009b00bfab6a007529fbc67f16ac13ff206291b")',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    minHeight: '100vh',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  };

  const headingStyle = {
    fontSize: '40px',
    color: '#333',
    marginBottom: '20px',
    marginLeft:'35%',
    fontWeight: 'bold',
    fontFamily: 'Arial, sans-serif',
    textShadow: '2px 2px 4px rgba(0, 0, 0, 0.3)',
    letterSpacing: '1px',
    justifyContent: 'center',
  };

  const navigate = useNavigate();

  const handleButton1MouseEnter = (e) => {
    e.target.style.backgroundColor = '#0f4a7e';
  };

  const handleButton1MouseLeave = (e) => {
    e.target.style.backgroundColor = '#6cc2d5';
  };

  const handleButton2MouseEnter = (e) => {
    e.target.style.backgroundColor = '#0f4a7e';
  };

  const handleButton2MouseLeave = (e) => {
    e.target.style.backgroundColor = '#6cc2d5';
  };

  return (
    <div>
      <HomeNavbar />
      <div style={backgroundStyle}>
        <Container>
          <h1 style={headingStyle}>Welcome to Tripify!!</h1>
          <div className="d-flex justify-content-center">
            <Button
              style={{ ...buttonStyle1}}
              onMouseEnter={handleButton1MouseEnter}
              onMouseLeave={handleButton1MouseLeave}
              onClick={() => navigate('/login')}
            >
              Login
            </Button>
            <Button
              style={{ ...buttonStyle2}}
              onMouseEnter={handleButton2MouseEnter}
              onMouseLeave={handleButton2MouseLeave}
              onClick={() => navigate('/signup')}
            >
              Sign up
            </Button>
          </div>
        </Container>
      </div>
      <Footer />
    </div>
  );
};

const buttonStyle1 = {
  backgroundColor: '#6cc2d5',
  color: 'white',
  border: 'none',
  borderRadius: '5px',
  padding: '12px 25px',
  margin: '20px',
  cursor: 'pointer',
  fontSize: '18px',
  boxShadow: '0 2px 4px rgba(0, 0, 0, 0.5)',
  transition: 'background-color 0.3s ease',
};

const buttonStyle2 = {
  backgroundColor: '#6cc2d5',
  color: 'white',
  border: 'none',
  borderRadius: '5px',
  padding: '12px 20px',
  margin: '20px',
  cursor: 'pointer',
  fontSize: '18px',
  boxShadow: '0 2px 4px rgba(0, 0, 0, 0.5)',
  transition: 'background-color 0.3s ease',
};

export default Home;
