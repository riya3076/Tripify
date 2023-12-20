import React, { useState, useEffect }  from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios  from 'axios';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';

const Activity = () => {
   const changePage = useNavigate();
   const { activityid }  = useParams();
   const [activityDetail,setactivityDetail] = useState();
   const [reviewDetail, setreviewDetail ] = useState([]);
   const token = sessionStorage.getItem('token');
   const headers = {
   Authorization: `Bearer ${token}`,
   };

   const activityidnum = parseInt(activityid, 10);

       // change numerical rating to stars
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
  // Add Review button on click
  const handleAddReview = () => {
    changePage(`/addReview/${activityid}`);
  };

    useEffect(()=>{
        axios.post('http://localhost:8090/home/activities', { activityID:activityidnum }, { headers })
        .then((response) => {
            console.log(response.data);
            setactivityDetail(response.data);
            console.log(activityDetail);
          })
          .catch((error) => {
            console.error('Error fetching activity regions:', error);
          });
    
        },[])

          useEffect(()=>{
            axios.post('http://localhost:8090/home/reviewactivity', { activityid: activityidnum }, { headers })
            .then((response) => {
                console.log(response.data.reviewsActivities);
                setreviewDetail(response.data.reviewsActivities);
              })
              .catch((error) => {
                console.error('Error fetching review activity list:', error);
              });
        
            },[])
        
            useEffect(() => {
                console.log(activityDetail); // Log placeDetail when it gets updated
              }, [activityDetail]);
            useEffect(() => {
                console.log(reviewDetail); // Log placeDetail when it gets updated
              }, [reviewDetail]);
       
              if (!activityDetail) {
                return <div>Loading...</div>;
              }
              if (!reviewDetail) {
                return <div>Loading..reviews</div>;
              }

   // Now you can use the fetched placeList and activityList data here
    return (
      <div>
      <HomeNavbar />     
      <Container style={{ marginTop: '2%'}}>
        <Row> 
        <Col>
            {activityDetail && (
              <>
               <h1> {activityDetail.activityName}</h1>
               <img src={activityDetail.activityLink} alt={activityDetail.activityName} style={{ width:'65%'}}></img>
                <br/>
                <p style={{ marginTop: '2%'}}> {activityDetail.activitydesc} </p>
              </>
            )} 
          </Col>
        </Row>
      <div style={{borderTop:'1px solid #ccc'}}></div>
      <br/>
      { reviewDetail.length > 0 && (
      <Row>
        <h2> Activity Reviews</h2>
       </Row>
      )}
      <br />
      {reviewDetail.map((review) => (
          <div key={review.reviewActivityID}>
              <p>Rating: {renderStars(review.rating)}</p>
               <p>Review: {review.reviewactivityComment}</p>
                       {/* <p> DateofReview : { review.dateofreview } </p> */}
                       {/* Render other review details as needed */}
          </div>
      ))}
      <br/>
      <Button onClick={handleAddReview}>Add review</Button>
      <div style={{ marginTop: '10rem' }}>
        <Footer />
      </div>
      </Container>
      </div>
    );
  };
  
  export default Activity;