import React from "react";
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import { FiUser } from 'react-icons/fi'; 
import { isLoggedIn } from "../App";

const logoStyle = {
  textDecoration: 'none',
  fontSize: '24px',
  fontWeight: 'bolder',
  color: 'white',
  marginLeft: '40px',
  transition: 'color 0.3s ease',
};

const logoHoverStyle = {
  color: '#FFAAC9',
};

const navBarGroup = {
  marginLeft: "60%",
  fontSize: '50',
};

const optionStyle = {
  textDecoration: 'none',
  color: 'white',
  marginLeft: '5px',
  marginRight: '5px',
  transition: 'color 0.3s ease',
};

const optionHoverStyle = {
  color: '#FFAAC9',
};

const HomeNavbar = () => {
  const changePage = useNavigate();

  const handleLogoHover = (e) => {
    e.target.style.color = e.type === 'mouseenter' ? logoHoverStyle.color : logoStyle.color;
  };

  const handleOptionHover = (e) => {
    e.target.style.color = e.type === 'mouseenter' ? optionHoverStyle.color : optionStyle.color;
  };

  const handleContact = () => {
    changePage('/contact');
  };

  const handleAbout = () => {
    changePage('/about');
  };

  const handleServices = () => {
    changePage('/services');
  };

  const handleNotifications = () => {
    changePage('/Notification');
  }

  const handleLogo = () => {
    if(isLoggedIn()){
      changePage('/landing');
    }
    else{
      changePage('/');
    }
  };

  const handleProfileOption = (eventKey) => {
    switch (eventKey) {
      case 'profile':
      
        console.log('Profile clicked');
        break;
      case 'settings':
  
        console.log('Settings clicked');
        break;
      case 'logout':

        console.log('Logout clicked');
        break;
      default:
        break;
    }
  };
  const handleProfile = () =>{
    changePage('/profile')
  }

  const handleItenary = () =>{
    changePage('/itinerary')
  }

  const handleWishlist = () =>{
    changePage('/wish')
  }

  const handleThingsToCarry = () =>{
    changePage('/thingsToCarry')
  }
  const handleLogout = () =>{
    sessionStorage.removeItem('token');
    changePage('/');
  }
  return (
    <Navbar bg="dark" variant="dark">
      <Navbar.Brand style={logoStyle} onClick={handleLogo} onMouseEnter={handleLogoHover} onMouseLeave={handleLogoHover}>
        Tripify
      </Navbar.Brand>
      <Nav className="justify-content-end" style={navBarGroup}>
      <Nav.Link to="/Notification" onClick={handleNotifications} style={optionStyle} onMouseEnter={handleOptionHover} onMouseLeave={handleOptionHover}>
          Notification
        </Nav.Link>
        <Nav.Link to="/contact" onClick={handleContact} style={optionStyle} onMouseEnter={handleOptionHover} onMouseLeave={handleOptionHover}>
          Contact
        </Nav.Link>
        <Nav.Link to="/about" onClick={handleAbout} style={optionStyle} onMouseEnter={handleOptionHover} onMouseLeave={handleOptionHover}>
          About
        </Nav.Link>
        <Nav.Link to="/services" onClick={handleServices} style={optionStyle} onMouseEnter={handleOptionHover} onMouseLeave={handleOptionHover}>
          Services
        </Nav.Link>
        {isLoggedIn() && (
          <NavDropdown title={<FiUser size={24} />} id="profile-dropdown" onSelect={handleProfileOption} >
            <NavDropdown.Item onClick={handleProfile} >Profile</NavDropdown.Item>
            <NavDropdown.Item  onClick={handleItenary}>Itinerary</NavDropdown.Item>
            <NavDropdown.Item  onClick={handleWishlist}>Wishlist</NavDropdown.Item>
            <NavDropdown.Item  onClick={handleThingsToCarry}>Items to carry</NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item onClick={handleLogout} >Logout</NavDropdown.Item>
          </NavDropdown>
        )}
      </Nav>
    </Navbar>
  );
};

export default HomeNavbar;
