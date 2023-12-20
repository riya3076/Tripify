import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link,useNavigate, useParams } from 'react-router-dom';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const State = () => {
  const [stateData, setStateData] = useState();
  /* const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]); */

  const { stateName } = useParams();
  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  useEffect(() => {
    axios
      .post('http://localhost:8090/home/location', { location: stateName }, { headers })
      .then((response) => {
        console.log(response.data);
        setStateData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching state data:', error);
      });
  }, []);

  if (!stateData) {
    return <div>Loading...</div>;
  }
  /*
  const handleOpenDialog = (index) => {
    setShowDialog(index);
  };

  const handleCloseDialog = () => {
    setShowDialog(false);
  };  

  const handleDateChange = (event) => {
    setSelectedDate(event.target.value);
  };

  const handleTimeChange = (event) => {
    setSelectedTime(event.target.value);
  };

  const handleEndDateChange = (event) => {
    setSelectedEndDate(event.target.value);
  };

  const handleEndTimeChange = (event) => {
    setSelectedEndTime(event.target.value);
  };

  const handleSaveItinerary = (title) => {
    const item = {
      date: selectedDate,
      endDate: selectedEndDate,
      title: title,
      time: selectedTime,
      endTime: selectedEndTime,
    };
    setItinerary([...itinerary, item]);
    setShowDialog(false);
    setSelectedDate('');
    setSelectedEndDate('');
    setSelectedTime('');
    setSelectedEndTime('');
  };
*/
 /*   commented out wishlsit
 const handleAddToWishlist = (title) => {
    const itemIndex = wishlist.findIndex((item) => item.activityName === title);

    if (itemIndex !== -1) {
      const updatedWishlist = [...wishlist];
      updatedWishlist.splice(itemIndex, 1);
      setWishlist(updatedWishlist);
    } else {
      const item = {
        activityName: title,
      };
      setWishlist([...wishlist, item]);
    }
  };

  const isItemInWishlist = (title) => {
    console.log(title);
    return wishlist.some((item) => item.activityName === title);
  }; */

  const renderCities = () => {
    if (!stateData.cities) {
      return <div>No cities to display.</div>;
    }

    return stateData.cities.map((city, index) => {
      const uniqueIndex = index;
    //  const cityInWishlist = isItemInWishlist(city.cityName);
    // console.log(cityInWishlist);
      return (
        <Col xs={12} md={6} lg={4} key={uniqueIndex} className ="g-4">
            <Card>
            <Link to={`/city/${city.cityId}`} style={{ textDecoration: 'none', color: 'inherit' }}>
            {city.cityImageLink && <Card.Img variant="top" src={city.cityImageLink} />}
            
            <Card.Body>
              <Card.Title>{city.cityName}</Card.Title>
              <Card.Text style={{ display: '-webkit-box', WebkitBoxOrient: 'vertical', WebkitLineClamp: 2, overflow: 'hidden' }}>{city.description}</Card.Text>
            </Card.Body>
            </Link>
           {/*  <Card.Footer>
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(city.cityName)}>
                {cityInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
            </Card.Footer> */}
          </Card>
          
          {/* <Modal show={showDialog === uniqueIndex} onHide={handleCloseDialog}>
            <Modal.Header closeButton>
              <Modal.Title>Select Date and Time</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form.Group>
                <Form.Label>Start Date</Form.Label>
                <Form.Control type="date" value={selectedDate} onChange={handleDateChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>Start Time</Form.Label>
                <Form.Control type="time" value={selectedTime} onChange={handleTimeChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>End Date</Form.Label>
                <Form.Control type="date" value={selectedEndDate} onChange={handleEndDateChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>End Time</Form.Label>
                <Form.Control type="time" value={selectedEndTime} onChange={handleEndTimeChange} />
              </Form.Group>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleCloseDialog}>
                Cancel
              </Button>
              <Button variant="primary" onClick={() => handleSaveItinerary(city.cityName)}>
                Save
              </Button>
            </Modal.Footer>
          </Modal>  */}
        </Col>
      );
    });
  };



  return (
    <>
      <HomeNavbar />
      <Container>
        <Row>
          <Col>
            <div>
              <h2 style={{ fontSize: '2rem' }}>{stateData.stateName}</h2>
            </div>
            <div>
              {stateData.description && <p>{stateData.description}</p>}
            </div>
            <div>
              <h2 className="mb-3">Cities to Visit</h2>
              <Row>{renderCities()}</Row>
            </div>
          </Col>
        </Row>
      </Container>
      <Footer />
    </>
  );
};

export default State;
