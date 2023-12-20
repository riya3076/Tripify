import React from 'react';
import { Container, Row, Col, Image } from 'react-bootstrap';
import HomeNavbar from '../HomeNav.js';
import Footer from '../footer.js';

const AboutUs = () => {

  const textContainer = {
    marginTop: 100,
    fontFamily: 'Sans-Serif',
  };
  
  const root = {
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100vh',
    backgroundImage: 'url("https://img.freepik.com/free-vector/watercolor-adventure-background_52683-83928.jpg?w=996&t=st=1688448732~exp=1688449332~hmac=d19abdada8c94a6a1233e20d6f3f533ed25a0c0ca4c57802ea5dacb239c1b942")',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    justifyContent: 'center',  
  };
  
  const content = {
    flex: '1 0 auto',
    backgroundColor: 'rgba(255, 255, 255, 0.9)',
    borderRadius: 2,
  };
  
  const title = {
    marginBottom: 10,
    fontWeight: 'bold',
    color: '#000',
    fontSize: 30,
  };
  const text = {
    marginBottom: 3,
  }
  
  const teamMember = {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
  }
  
  const avatar = {
    width: 200,
    height: 200,
    marginBottom: 10,
    marginTop: 10,
  }
  

return (
  <div style={root}>
  <div style={content}>
    <HomeNavbar />
    <Container>
      <Row className="justify-content-center">
        <Col xs={12} md={6}>
          <div>
            <Image src="https://img.freepik.com/free-vector/watercolor-luggage-with-camera-hat-travel-design_1035-23553.jpg?t=st=1688449151~exp=1688449751~hmac=36fb7774d54b5329618353255c4670c8d8f784aeb13bfac1d9e353479e71a64c" alt="Tripify" fluid />
          </div>
        </Col>
        <Col xs={12} md={6}>
         <div style = {textContainer}>
            <h6 style={title}>
              Welcome to Tripify!
            </h6>
            <br></br>
            <h6 variant="body1" style={text}>
              At Tripify, we believe that everyone deserves to have amazing travel experiences. Our mission is to help you plan your dream trips and create unforgettable memories.
            </h6>
            <br></br>
            <h6 variant="body1" style={text}>
              With Tripify, you can explore a wide range of destinations, discover popular attractions, find the best hotels, and plan your itinerary effortlessly. Whether you're a solo traveler, a couple on a romantic getaway, or a family seeking adventure, Tripify has got you covered.
            </h6>
            <br></br>
            <h6 variant="body1" style={text}>
              Our team of experienced travel enthusiasts works tirelessly to curate the most comprehensive travel information and provide you with up-to-date recommendations. We understand that each traveler is unique, so we offer personalized suggestions tailored to your preferences and interests.
            </h6>
            <br></br>
            <h6 variant="body1" style={text}>
              So why wait? Start your journey with Tripify today and turn your travel dreams into reality. We're here to inspire, guide, and support you every step of the way.
            </h6>
            <br></br>
          </div>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col xs={12} md={10}>
          <br></br>
          <h4 variant="h4" style={title}>
            Meet Our Team
          </h4>
          <br></br>
        </Col>
        <Col xs={12} md={4} style={teamMember}>
          <Image src="https://cdn-icons-png.flaticon.com/512/1785/1785918.png" alt="Team Member 1" style={avatar} fluid />
          <h4 variant="h6" style={text}>
            Riya Patel
          </h4>
        </Col>
        <Col xs={12} md={4} style={teamMember}>
          <Image src="https://cdn-icons-png.flaticon.com/512/5556/5556468.png" alt="Team Member 2" style={avatar} fluid />
          <h4 variant="h6" style={text}>
            Aharnish Solanki
          </h4>
        </Col>
        <Col xs={12} md={4} style={teamMember}>
          <Image src="https://cdn-icons-png.flaticon.com/512/2810/2810731.png" alt="Team Member 3" style={avatar} fluid />
          <h4 variant="h6" style={text}>
            Bhavisha Oza
          </h4>
        </Col>
        <br></br>
        <Col xs={12} md={4} style={teamMember}>
          <Image src="https://cdn-icons-png.flaticon.com/512/5556/5556499.png" alt="Team Member 4" style={avatar} fluid />
          <h4 variant="h6" style={text}>
            Jaskaran Singh
          </h4>
        </Col>
        <Col xs={12} md={4} style={teamMember}>
          <Image src="https://cdn-icons-png.flaticon.com/512/2810/2810674.png" alt="Team Member 5" style={avatar} fluid />
          <h4 variant="h6" style={text}>
            Abhisha Thaker
          </h4>
        </Col>
        <br></br>
        <br></br>
      </Row>
    </Container>
  </div>
  <Footer />
</div>
);
};

export default AboutUs;
