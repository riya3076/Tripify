import React, { useState, useEffect } from "react";
import { Form, Button, Container, Row, Col, Alert } from "react-bootstrap";
import { useParams } from "react-router-dom";
import HomeNavbar from "../HomeNav";
import Footer from "../footer";
import RatingStars from "./RatingStars"; // Import the RatingStars component
import axios from "axios";

const useStyles = {
  container: {
    margin: "50%",
  },
  content: {
    marginTop: "70px",
    marginBottom: "70px",
  },
  textField: {
    marginBottom: 0,
  },
  heading: {
    marginTop: "50%",
    color: "#212529",
  },
};

const AddReviewsPage = () => {
  const classes = useStyles;
  debugger;
  const { placeID } = useParams();
  const [message, setReview] = useState("");
  const [rating, setRating] = useState(0);
  const [showSnackbar, setShowSnackbar] = useState(false);

  const handleReviewChange = (e) => {
    setReview(e.target.value);
  };

  const handleRatingChange = (newRating) => {
    setRating(newRating);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setShowSnackbar(true);

    const token = sessionStorage.getItem("token");

    const headers = {
      Authorization: `Bearer ${token}`,
    };

    // Prepare the data to send to the backend
    const data = {
      review_message: message,
      rating: rating,
      place_id: parseInt(placeID, 10),
    };

    // Make the HTTP POST request to your backend API
    axios
      .post("http://localhost:8090/home/addreviewplace", data, { headers })
      .then((response) => {
        console.log("Review successfully saved!", response.data);
        // Add any additional actions after the successful review submission if needed.
      })
      .catch((error) => {
        console.error("Error saving review:", error);
        // Handle errors or show an error message to the user if needed.
      });

    // Clear the review message and rating after submitting
    setReview("");
    setRating(0);
  };

  const handleCloseSnackbar = () => {
    setShowSnackbar(false);
  };

  useEffect(() => {
    // Now you can use the placeID in this component as needed
    console.log("Place ID:", placeID);
  }, [placeID]);

  return (
    <div className={classes.container}>
      <HomeNavbar />
      <Container
        className={classes.content}
        style={{ marginTop: "70px", marginBottom: "70px" }}
      >
        <h4
          className={classes.heading}
          style={{ fontSize: "35px", fontWeight: "600" }}
        >
          Write your Review
        </h4>
        <Form onSubmit={handleSubmit}>
          <Row>
            <Col xs={12}>
              <Form.Group controlId="formReview">
                <Form.Label>Review</Form.Label>
                <Form.Control
                  as="textarea"
                  rows={4}
                  placeholder="Write your Review"
                  value={message}
                  onChange={handleReviewChange}
                />
              </Form.Group>
            </Col>
            <Col xs={12}>
              <Form.Group controlId="formRating">
                <Form.Label>Rating</Form.Label>
                <RatingStars
                  initialRating={rating}
                  onChange={handleRatingChange}
                />
              </Form.Group>
            </Col>
            <Col xs={12}>
              <Button
                type="submit"
                variant="outline-primary"
                style={{
                  marginTop: "15px",
                  color: "#001C30",
                  borderColor: "#001C30",
                }}
              >
                Send Review
              </Button>
            </Col>
          </Row>
        </Form>
        <Alert
          variant="success"
          show={showSnackbar}
          onClose={handleCloseSnackbar}
          dismissible
        >
          Review Added successfully!
        </Alert>
      </Container>
      <Footer />
    </div>
  );
};

export default AddReviewsPage;
