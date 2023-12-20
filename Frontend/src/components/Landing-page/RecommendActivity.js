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

const RecommendActivity = () => {
  const { activityid } = useParams();
  const [activityDetail, setactivityDetail] = useState([]);
  const changePage = useNavigate();
  const [reviewDetail, setreviewDetail] = useState([]);
  const token = sessionStorage.getItem("token");
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  const handletrip = () => {
    changePage("/mainpage");
  };

  const handleAddReview = () => {
    // Assuming the route to the review submission page is '/addReview', you can change it to the correct route.
    changePage(`/addReview/${activityid}`);
  };

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

  const activityidnum = parseInt(activityid, 10);
  useEffect(() => {
    axios
      .post(
        "http://localhost:8090/home/activities",
        { activityID: activityidnum },
        { headers }
      )
      .then((response) => {
        console.log(response.data);
        setactivityDetail(response.data);
        console.log(activityDetail);
      })
      .catch((error) => {
        console.error("Error fetching activity regions:", error);
      });
  }, []);

  useEffect(() => {
    axios
      .post(
        "http://localhost:8090/home/reviewactivity",
        { activityid: activityidnum },
        { headers }
      )
      .then((response) => {
        console.log(response.data.reviewsActivities);
        setreviewDetail(response.data.reviewsActivities);
      })
      .catch((error) => {
        console.error("Error fetching places list:", error);
      });
  }, []);

  useEffect(() => {
    console.log(activityDetail); // Log placeDetail when it gets updated
  }, [activityDetail]);

  useEffect(() => {
    console.log(reviewDetail); // Log placeDetail when it gets updated
  }, [reviewDetail]);
  useEffect(() => {
    console.log(activityDetail); // Log placeDetail when it gets updated
  }, [activityDetail]);
  useEffect(() => {
    console.log(reviewDetail); // Log placeDetail when it gets updated
  }, [reviewDetail]);
      
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
          <h1> {activityDetail.activityName}</h1>
        </Row>
        <img src={activityDetail.activityLink} alt={activityDetail.activityName} style={{ width:'65%'}}></img>
        <br/>
        <p style={{ marginTop: '2%'}}> {activityDetail.activitydesc} </p>
        <div style={{borderTop:'1px solid #ccc'}}></div>
        <br/>
        { reviewDetail.length > 0 && (
        <Row>
          <h2>Reviews</h2>
        </Row>
        )}
        {reviewDetail.map((review) => (
          <div key={review.reviewActivityID}>
            <p>Rating: {renderStars(review.rating)}</p>
            <p>Review: {review.reviewactivityComment}</p>
            { /*<p> DateofReview : {review.dateofreview} </p> */}
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

export default RecommendActivity;
