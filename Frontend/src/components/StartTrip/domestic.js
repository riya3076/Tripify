import React, { useEffect, useState } from 'react';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import DateRangePicker from '../DateRangePicker';
import { useNavigate } from 'react-router-dom';
import ReviewsPage from '../reviews/review.js';
import axios from 'axios';

const Domestic = ({ selectedState }) => {
  const changePage = useNavigate();
  const [searchButton, setSearchButton] = useState(false);
  const [itemCounter, setItemCounter] = useState(0);
  const [selectedStateName, setselectedStateName] = useState();
  const [selectedStateDesc, setselectedStateDesc] = useState();
  const [selectedStateimg, setselectedStateimg] = useState();
  
  
  const handleSearchButton = () => {
    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
      Authorization: `Bearer ${token}`,
    };
    console.log(selectedState);
    const selectedValue = JSON.parse(selectedState);
    const stateName = selectedValue.stateName;
    const stateDescription = selectedValue.description;
    const stateimg = selectedValue.stateImageLink;
    console.log(stateName);
    console.log(stateDescription);
    setselectedStateName(stateName);
    setselectedStateDesc(stateDescription);
    setselectedStateimg(stateimg);
   
    axios.post('http://localhost:8090/home/location', { location: selectedValue.stateName }, { headers })
      .then((response) => {
        console.log(response.data);
        console.log(response.data.cities);
        setPlaceToVisit(response.data.cities);
      })
      .catch((error) => {
        console.error('Error fetching domestic regions:', error);
      });

    setSearchButton(true);
  };

  /* const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]); */
  const [reviewsToShow, setReviewsToShow] = useState([]);
  const [placeToVisit, setPlaceToVisit] = useState([]);

/*   const handleOpenDialog = (index) => {
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

  const handleseeReviews = (reviews) => {
    setReviewsToShow(reviews);
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
    setItemCounter((prevCounter) => prevCounter + 1);
    setShowDialog(false);
    setSelectedDate('');
    setSelectedEndDate('');
    setSelectedTime('');
    setSelectedEndTime('');
  };

  const handleAddToWishlist = (title) => {
    const itemIndex = wishlist.findIndex((item) => item.title === title);

    if (itemIndex !== -1) {
      const updatedWishlist = [...wishlist];
      updatedWishlist.splice(itemIndex, 1);
      setWishlist(updatedWishlist);
    } else {
      const item = {
        title: title,
      };
      setWishlist([...wishlist, item]);
    }
  };

  const isItemInWishlist = (title) => {
    console.log(title);
    return wishlist.some((item) => item.title === title);
  };
*/
  /* const handleItinerary = () => {
    console.log(itinerary);
    const pass = encodeURIComponent(JSON.stringify(itinerary));
    changePage('/itinerary/' + pass);
  };

  const handleWishlist = () => {
    const pass = encodeURIComponent(JSON.stringify(wishlist));
    changePage('/wish/' + pass);
  };
 */
  const ReviewsDisplay = ({ reviews }) => {
    return (
      <div>
        {reviews.map((review, index) => (
          <div key={index}>
            <p>Review {index + 1}: {review.review}</p>
            <p>Rating {index + 1}: {review.rating}</p>
            <p>Date of Review {index + 1}: {review.dateofreview}</p>
            <p>Username {index + 1}: {review.username}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  };

  const handleReviews = (item) => {
    const pass = encodeURIComponent(JSON.stringify(item));
    changePage('/reviews/' + pass);
  };

  const handleCity = (cityID) => {
    changePage('/city/' + cityID);
  };

  const renderCards = (data, type) => {
    const cards = data.map((item, index) => {
      const uniqueIndex = index + data.length * type;
     /*  const isInWishlist = isItemInWishlist(item.cityName);
      console.log(isInWishlist); */
      console.log(item.data);

      return (
        <Col xs={12} md={6} lg={4} key={uniqueIndex} className ="g-4">  
          <Card>
          {item.cityImageLink && <Card.Img variant="top" src={item.cityImageLink} />}
            <Card.Body>
              <Card.Title>
                <Button variant="link" onClick={() => handleCity(item.cityId)}>
                  <h5>{item.cityName}</h5>
                </Button>
              </Card.Title>
              <Card.Text style={{ display: '-webkit-box', WebkitBoxOrient: 'vertical', WebkitLineClamp: 2, overflow: 'hidden' }}>{item.description}</Card.Text>
              {/* <Card.Footer>
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(item.cityName)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
              </Card.Footer> */}
            </Card.Body>
          </Card>
      {/*     <Modal show={showDialog === uniqueIndex} onHide={handleCloseDialog}>
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
              <Button variant="primary" onClick={() => handleSaveItinerary(item.title)}>
                Save
              </Button>
            </Modal.Footer>
          </Modal> */}
        </Col>
      );
    });

    return <Row>{cards}</Row>;
  };

  return (
    <>
      <br />
      <Container>
        <Row>
          <br />
          <Col>
           
            <div>
              <p className="mb-3">Select your travel date</p>
              <DateRangePicker style={{ height: '100px', width: '100px', fontSize: '1rem' }} />
            </div>
          </Col>
        </Row>
      </Container>
      <div className="text-left" style={{ padding: '15px' }}>
        <Button variant="primary" size="lg" onClick={handleSearchButton}>
          Search
        </Button>
      </div>
      <Container></Container>
      {searchButton && (
        <>
          <Container>
            <Row>
              <br />
              <Col>
              <div>
              <h2 style={{ fontSize: '2rem' }}>{selectedStateName}</h2>
                </div>
              <div>
              {selectedStateimg && <img src={selectedStateimg} alt="State" />}
              </div>
              
                <div>
                  {selectedStateDesc}
                </div>

                <div>
                  <h2 className="mb-3">Cities to Visit</h2>
                </div>
              </Col>
            </Row>
            <Row>{renderCards(placeToVisit, 1)}</Row>
          </Container>
          <br />
          {reviewsToShow.length > 0 && (
            <Container>
              <Row>
                <br />
                <Col>
                  <div>
                    <h2 className="mb-3">Reviews</h2>
                    <ReviewsDisplay reviews={reviewsToShow} />
                  </div>
                </Col>
              </Row>
            </Container>
          )}
        </>
      )}
    </>
  );
};

export default Domestic;
