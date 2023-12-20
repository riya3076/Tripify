import React, { useState, useEffect }  from 'react';
import axios  from 'axios';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';

const Notification = () => {
   const [notificationDetail,setnotificationDetail] = useState([]);
    useEffect(()=>{
        const token = sessionStorage.getItem('token');
        const headers = {
        Authorization: `Bearer ${token}`,
        }; 
        axios.post('http://localhost:8090/fetchNotifications', null, {headers})
        .then((response) => {
            console.log(response.data);
            setnotificationDetail(response.data);
          })
          .catch((error) => {
            console.error('Error fetching place regions:', error);
          });
    
        },[])
    return (
        <>
      <HomeNavbar />
        <Container>
            <Row>
                <Col>
                    <br></br>
                    <h2>Notification Details </h2>
                    <br></br>
                    {notificationDetail.map((notification, index) => (
                        <Card key={index} className="mb-3">
                            <Card.Body>
                                <Card.Title>{notification.category}</Card.Title>
                                <Card.Text>{notification.description}</Card.Text>
                                {/* You can display other details in the card as needed */}
                            </Card.Body>
                        </Card>
                    ))}
                </Col>
            </Row>
        </Container>
        <Footer />
    </>
    ) }
export default Notification;