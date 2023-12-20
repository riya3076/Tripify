import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import axios from 'axios';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const City = () => {
  const [cityDetail, setCityDetail] = useState();
  const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);
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




  const handleSaveItinerary = (placeId, placeName) => {

    const startDate = new Date(selectedDate + 'T' + selectedTime);
    const endDate = new Date(selectedEndDate + 'T' + selectedEndTime);

    const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };

    const data = {
      startdate: startDate.toISOString(), 
      enddate: endDate.toISOString(),
      placeid: placeId,
      title: placeName
    };
    console.log(data);
    axios.post('http://localhost:8090/home/addtoitinerary', data, { headers }).then((response)=>{
      console.log('Itinerary created:', response.data);
    }).catch((error)=>{
      console.error('Error adding item to itinerary:', error);
    })

    setItinerary([...itinerary, data]);
   // setItemCounter((prevCounter) => prevCounter + 1);
    setShowDialog(false);
    setSelectedDate('');
    setSelectedEndDate('');
    setSelectedTime('');
    setSelectedEndTime('');
  };

  const handleAddToWishlist = (title) => {
    const itemIndex = wishlist.findIndex((item) => item.placeName === title);

    if (itemIndex !== -1) {
      const updatedWishlist = [...wishlist];
      updatedWishlist.splice(itemIndex, 1);
      setWishlist(updatedWishlist);
    } else {
      const item = {
        placeName: title,
      };
      setWishlist([...wishlist, item]);
    }
  };

  const isItemInWishlist = (title) => {
    return wishlist.some((item) => item.placeName === title);
  };

  const { cityID } = useParams();
  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };
  const cityIDAsNumber = parseInt(cityID, 10);

  useEffect(() => {
    axios
      .post('http://localhost:8090/home/city', { cityID: cityIDAsNumber }, { headers })
      .then((response) => {
        console.log(response.data);
        setCityDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching city details:', error);
      });
  }, []);

  const handleAddToItinerary = (placeId) => {
        console.log(`Added place with ID: ${placeId} to itinerary.`);
  };

  const renderCards = (data, type) => {
    const cards = data.map((item, index) => {
      const uniqueIndex = index + data.length * type;
      const isInWishlist = isItemInWishlist(item.placeName);
      return (
        <Col xs={12} md={6} lg={4} key={uniqueIndex}>
        
            <Card>
            <Link to={`/Place/${item.placeId}`} style={{ textDecoration: 'none', color: 'inherit' }}>
                <Card.Img variant="top" src={item.placeImageLink} alt={item.placeName} />
                <Card.Body>
                  <Card.Title>{item.placeName}</Card.Title>
                  <Card.Text>{item.description}</Card.Text>
                </Card.Body>
                </Link>
                <Card.Footer>
               
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(item.place)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
             </Card.Footer>
            </Card>
       
          <Modal show={showDialog === uniqueIndex} onHide={handleCloseDialog}>
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
              <Button variant="primary"
              onClick ={ () => handleSaveItinerary(item.placeId, item.placeName)}>
              {/* //  onClick={() => handleSaveItinerary(item.title)}> */}
                Save
              </Button>
            </Modal.Footer>
          </Modal>
        </Col>
      );
    });

    return cards;
  };

  if (!cityDetail) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <HomeNavbar />
      <Container>
        <Row>
          <Col>
            <h1>{cityDetail.cityName}</h1>
            <p>{cityDetail.description}</p>
          </Col>
        </Row>
        <Row>
          <h2>Places to Visit</h2>
        </Row>
        <Row>{renderCards(cityDetail.placeObjectResponseList, 1)}</Row>
      </Container>
      <Footer/>
    </>
  );
};

export default City;
