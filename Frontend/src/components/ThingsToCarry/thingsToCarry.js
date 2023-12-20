import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, Row, Col, Form } from 'react-bootstrap';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import International from '../StartTrip/international';
import Domestic from '../StartTrip/domestic';

const ThingsToCarry = () => {
    const [response, setResponse] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [showErrorToast, setShowErrorToast] = useState(false);

    useEffect(() => {
        const fetchItemsToCarry = async () => {
            const apiUrl = 'http://localhost:8090/home/itemstocarry';
            const token = window.localStorage.getItem("token");
            const headers = {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '.concat(token)
            };
            const requestBody = {
                "item_id": 1
            };

            try {
                setIsLoading(true);
                const response = await axios.post(apiUrl, requestBody, { headers: headers });
                setIsLoading(false);
                console.log('Response:', response.data);
                setResponse(response.data.itemstoCarryResponseList);
            } catch (error) {
                setIsLoading(false);
                console.error('API error:', error);
                setShowErrorToast(true);
            }
        };

        fetchItemsToCarry();
    }, []);

    return (
        <div>
            <div style={{ marginTop: '0px' }}>
                <HomeNavbar />
            </div>
            <div>
                {/* Display the data and error message as before */}
                {isLoading ? (
                    <div>Loading...</div>
                ) : (
                    <div style={styles.listShow}>
                        {response.map((item) => (
                            <div key={item.itemID} style={styles.listItem}>
                                {item.itemName}
                            </div>
                        ))}
                    </div>
                )}
                {showErrorToast && <div>Error: Failed to fetch data</div>}
            </div>
            <div style={{ marginTop: '10rem' }}>
                <Footer />
            </div>
        </div>
    );
};

const styles = {
    listShow: {
        display: 'grid',
        gridTemplateColumns: 'repeat(3, 1fr)',
        gap: '20px',
        justifyContent: 'center',
        maxWidth: '1200px',
        margin: '20px auto',
    },
    listItem: {
        padding: '10px 20px',
        borderBottom: '1px solid #ddd',
    },
};

export default ThingsToCarry;
