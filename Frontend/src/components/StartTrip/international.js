import React, { useState } from 'react';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import DateRangePicker from '../DateRangePicker';
import { useNavigate } from 'react-router-dom';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import axios from 'axios';

const International = ({ selectedCountry }) => {
  const changePage = useNavigate();
  const [searchButton, setSearchButton] = useState(false);
  const [selectedCountryName, setselectedCountryName] = useState();
  const [selectedCountryDesc, setselectedCountryDesc] = useState();
  const [itemCounter, setItemCounter] = useState(0);
  const [selectedCountryimg, setselectedCountryimg] = useState();

  const handleSearchButton = () => {
    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
      Authorization: `Bearer ${token}`,
    };

    console.log(selectedCountry);

    const parsedCountry = JSON.parse(selectedCountry);
    const countryName = parsedCountry.countryName;
    const countryDescription = parsedCountry.description;
    const countryimg = parsedCountry.countryImageLink;

    console.log(countryName);

    console.log(countryDescription);

    setselectedCountryName(countryName);
    setselectedCountryDesc(countryDescription);
    setselectedCountryimg(countryimg);

    axios.post('http://localhost:8090/home/country', { country_name: countryName }, { headers })
      .then((response) => {
        console.log(response.data.stateList);
        setPlaceToVisit(response.data.stateList);
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

    return wishlist.some((item) => item.title === title);

  };


  */



/*
  const handleItinerary = () => {

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




  const handleState = (stateName) => {

    changePage('/state/' + stateName);

  };




 

  const renderCards = (data, type) => {
    const cards = data.map((item, index) => {
      const uniqueIndex = index + data.length * type;
     // const isInWishlist = isItemInWishlist(item.stateName);
      console.log(item.stateName);
      return (

        <Col xs={12} md={6} lg={4} key={uniqueIndex} className ="g-4">

          <Card>

          {item.stateImageLink && <Card.Img variant="top" src={item.stateImageLink} />}

            <Card.Body>

              <Card.Title>

                <Button variant="link" onClick={() => handleState(item.stateName)}>

                  <h5>{item.stateName}</h5>

                </Button>




              </Card.Title>

              <Card.Text style={{ display: '-webkit-box', WebkitBoxOrient: 'vertical', WebkitLineClamp: 2, overflow: 'hidden' }}>{item.description}

            </Card.Text>

           {/*  <Card.Footer>

              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>

                Add to Itinerary

              </Button>

              <Button variant="link" onClick={() => handleAddToWishlist(item.stateName)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>

              </Card.Footer>     */}          

            </Card.Body>

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

              <Button variant="primary" onClick={() => handleSaveItinerary(item.title)}>

                Save

              </Button>

            </Modal.Footer> */}

          {/* </Modal> */}

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

              <DateRangePicker style={{ height: '100px', width: '100px', fontSize: '2rem' }} />

            </div>

          </Col>

        </Row>

      </Container>

      <div className="text-left" style={{ padding: '15px' }}>

        <Button variant="primary" size="lg" onClick={handleSearchButton}>

          Search

        </Button>

      </div>

      {searchButton && (

        <>

          <Container>

            <Row>

              <br />

              <Col>

              <div>

              <h2 style={{ fontSize: '2rem' }}>{selectedCountryName}</h2>

                </div>

              <div>

                {selectedCountryimg && <img src={selectedCountryimg} alt="Country"/>}

              </div>

             

                <div>

                  {selectedCountryDesc}

                </div>

                <div>

                  <h2 className="mb-3">States to Visit</h2>

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




export default International;