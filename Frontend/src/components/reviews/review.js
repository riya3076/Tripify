import React from 'react';
import { useParams } from 'react-router-dom';
import { Container, Row, Col, Carousel } from 'react-bootstrap';
import HomeNavbar from '../HomeNav';

const ReviewsPage = () => {
    const { data } = useParams();
    const item = JSON.parse(decodeURIComponent(data));

    const review = {
        border: '1px solid #ccc',
        padding: '10px',
        marginBottom: '20px'
    }

    const rating = {
        color: 'gold',
        fontSize: '24px'
    }

  return (
    <div>
    <HomeNavbar />
     <Container>
        <Row> 
           <h1> { item.title} </h1>
        </Row>
        <Carousel>
            <Carousel.Item>
                <img className="d-block w-100" src={item.imgSrc} alt="First slide"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" src={item.imgSrc} alt="Second slide"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" src={item.imgSrc} alt="Third slide"/>
            </Carousel.Item>
        </Carousel>
       <Row>
        <h3> About </h3>
        <p> { item.content } </p>
       </Row>
       <Row>
        <h2>Reviews</h2>
       </Row>
      {item.reviews.map((review, index) => (
        <div key={index}>
            <div className="review" style={review}>
                <p>{index + 1} : {review.username}</p>
            <div className="rating" style={rating}>
                {Array.from({ length: review.rating }).map((_, index) => (
                <span key={index} role="img" aria-label="star">
                    ⭐
                </span>
                ))}
            </div>
        <p>{review.review}</p>
        <p> Written {review.dateofreview} </p>

    </div>
        </div>
      ))}
     </Container>

    </div>
  );
};

export default ReviewsPage;