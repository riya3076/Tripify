import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import axios from 'axios';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const Place = () => {
  const changePage = useNavigate();
  const [placeDetail, setPlaceDetail] = useState();
  const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);
  const [reviewDetail, setreviewDetail ] = useState([]);
  
  const { placeID } = useParams();
  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };
  const placeIDAsNumber = parseInt(placeID, 10);

  useEffect(() => {
    axios
      .post('http://localhost:8090/home/place', { placeID: placeIDAsNumber }, { headers })
      .then((response) => {
        console.log("inplace"+response.data);
        setPlaceDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching place details:', error);
      });
  }, []);

  useEffect(()=>{
    axios.post('http://localhost:8090/home/reviewplace', { place_id: placeIDAsNumber }, { headers })
    .then((response) => {
        console.log(response.data.reviewsPlaces);
        setreviewDetail(response.data.reviewsPlaces);
      })
      .catch((error) => {
        console.error('Error fetching places list:', error);
      });
    },[])
  
  const handleAddReview = () => {
      changePage(`/addReview/${placeID}`);
  };

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

  const handleSaveItinerary = (activityId, activityName) => {

    const startDate = new Date(selectedDate + 'T' + selectedTime);
    const endDate = new Date(selectedEndDate + 'T' + selectedEndTime);

    const data = {
      startdate: startDate.toISOString(), 
      enddate: endDate.toISOString(),
      activityid: activityId,
      title: activityName
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
    return wishlist.some((item) => item.activityName === title);
  };

  const renderStars = (rating) => {
    const stars = [];
    for (let i = 1; i <= 5; i++) {
      stars.push(
        <span key={i} style={{ color: i <= rating ? 'gold' : 'gray' }}>
          ★
        </span>
      );
    }
    return stars;
  };

  const getactivityList = (activityid) => {
    changePage('/Activity/' + activityid);
  }

  const renderActivityCards = () => {
    if (!placeDetail || !placeDetail.activityObjectsResponseList) {
      return <div>Loading...</div>;
    }

    return placeDetail.activityObjectsResponseList.map((activity, index) => {
      console.log(placeDetail.activityObjectsResponseList);
      const uniqueIndex = index;

      const isInWishlist = isItemInWishlist(activity.activityName);

      return (
        <Col xs={12} md={6} lg={4} key={uniqueIndex}>
          <Card>
          <Link to={`/Activity/${activity.activityId}`} style={{ textDecoration: 'none', color: 'inherit' }}>
            {activity.activityImageLink && <Card.Img variant="top" src={activity.activityImageLink} />}
            <Card.Body>
              <Card.Title>
                {activity.activityName} 
              </Card.Title>
              <Card.Text>{activity.description}</Card.Text>
            </Card.Body>
            </Link>
            <Card.Footer>
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(activity.activityName)}>
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
              <Button variant="primary" onClick={() => handleSaveItinerary(activity.activityId,activity.activityName)}>
                Save
              </Button>
            </Modal.Footer>
          </Modal>
  
        </Col>
      );
    });
  };

  return (
    <>
      <HomeNavbar />
      <Container style={{ marginTop: '2%'}}>
        <Row>
          <Col>
            {placeDetail && (
              <>
               <h1> {placeDetail.placeName}</h1>
               <img src={placeDetail.placeImageLink} alt={placeDetail.placeName} style={{ width:'65%'}}></img>
                <br/>
                <p style={{ marginTop: '2%'}}> {placeDetail.description} </p>
              </>
            )}
          </Col>
        </Row>
        <Row>
          <h2>Activities to Enjoy</h2>
        </Row>
        <Row>{renderActivityCards()}</Row>
        <br/>
        <div style={{borderTop:'1px solid #ccc'}}></div>
        <br/>
        { reviewDetail.length > 0 && (
        <Row>
          <h2> Place Reviews</h2>
        </Row>
        )}
        <br/>
          {reviewDetail.map((review) => (
            <div key={review.reviewPlaceID}>
              <p>Rating: {renderStars(review.rating)}</p>
              <p>Review: {review.reviewplaceComment}</p>
              {/*  <p> DateofReview : { review.dateofreview } </p> */}
              <div style={{borderTop:'1px solid #ccc', width:'30%'}}></div>         
            <br/>
              </div>
            ))}
        <br/>
        <Button onClick={handleAddReview}>Add review</Button>
        <div style={{ marginTop: "10rem" }}>
          <Footer />
        </div>
      </Container>
    </>
  );
};

export default Place;
