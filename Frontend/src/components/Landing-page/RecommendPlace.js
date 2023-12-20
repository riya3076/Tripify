import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import HomeNavbar from "../HomeNav";
import Footer from "../footer";
import {
  Container,
  Row,
  Col,
  Button,
  Card,
  Modal,
  Form,
} from "react-bootstrap";

const RecommendPlace = () => {
  const { placeID } = useParams();
  const changePage = useNavigate();
  const [placeDetail, setplaceDetail] = useState();
  const [reviewDetail, setreviewDetail] = useState([]);
  const handletrip = () => {
    changePage("/mainpage");
  };
  const token = sessionStorage.getItem("token");
  const headers = {
    Authorization: `Bearer ${token}`,
  };
  const placeIDNum = parseInt(placeID, 10);
  console.log(placeIDNum);
  useEffect(() => {
    axios
      .post(
        "http://localhost:8090/home/place",
        { placeID: placeIDNum },
        { headers }
      )
      .then((response) => {
        console.log(response.data);
        setplaceDetail(response.data);
        console.log(placeDetail);
      })
      .catch((error) => {
        console.error("Error fetching place regions:", error);
      });
  }, []);
  useEffect(() => {
    axios
      .post(
        "http://localhost:8090/home/reviewplace",
        { place_id : placeIDNum },
        { headers }
      )
      .then((response) => {
        console.log(response.data.reviewsPlaces);
        setreviewDetail(response.data.reviewsPlaces);
      })
      .catch((error) => {
        console.error("Error fetching places list:", error);
      });
  }, []);

  useEffect(() => {
    console.log(placeDetail); // Log placeDetail when it gets updated
  }, [placeDetail]);
  useEffect(() => {
    console.log(reviewDetail); // Log placeDetail when it gets updated
  }, [reviewDetail]);

  if (!placeDetail) {
    return <div>Loading...</div>;
  }
  if (!reviewDetail) {
    return <div>Loading..reviews</div>;
  }

  const renderStars = (rating) => {
    const stars = [];
    for (let i = 1; i <= 5; i++) {
      stars.push(
        <span key={i} style={{ color: i <= rating ? "gold" : "gray" }}>
          ★
        </span>
      );
    }
    return stars;
  };

  const handleAddReview = () => {
    // Assuming the route to the review submission page is '/addReview', you can change it to the correct route.
    changePage(`/addReview/${placeID}`);
  };

  // Now you can use the fetched placeList and activityList data here
  return (
    <div>
      <div style={{ marginTop: "0px" }}>
        <HomeNavbar />
      </div>
      <Button
        onClick={handletrip}
        style={{ marginTop: "2rem", marginLeft: "7rem", marginBottom: "2rem" }}
      >
        Start your trip
      </Button>
      <Container>
        <Row>
          <h1> {placeDetail.placeName}</h1>
        </Row>
          <img src={placeDetail.placeImageLink} alt={placeDetail.placeName} style={{ width:'65%'}}></img>
          <br/>
          <p style={{ marginTop: '2%'}}> {placeDetail.description} </p>
        <div style={{borderTop:'1px solid #ccc'}}></div>
        <br/>
        { reviewDetail.length > 0 && (
        <Row>
          <h2>Reviews</h2>
        </Row>
        )}
        <br/>
        {reviewDetail.map((review) => (
          <div key={review.reviewPlaceID}>
            <p>Rating: {renderStars(review.rating)}</p>
            <p>Review: {review.reviewplaceComment}</p>
            {/* <p> DateofReview : {review.dateofreview} </p> */}
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
    </div>
  );
};

export default RecommendPlace;
