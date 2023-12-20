import React, { useEffect, useState } from 'react';
import { Container, Row, Col, Form } from 'react-bootstrap';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import International from '../StartTrip/international';
import Domestic from '../StartTrip/domestic';
import axios from 'axios';

const MainPage = () => {
  const [destinationType, setDestinationType] = useState('International');
  const [regionList, setRegionList] = useState([]);

  const[selectState,setselectState] = useState('Default');
  const[selectCountry, setselectCountry] = useState('Default');

  const handleDestinationTypeChange = (event) => {
    const selectedDestination = event.target.value;
    setDestinationType(selectedDestination);

    if (selectedDestination === 'National') {
      fetchDomesticRegions();
    } else {
      setRegionList([]);
    }

    if (selectedDestination === 'International') {
      fetchInternationalRegions();
    } else {
      setRegionList([]);
    }
  };

  const fetchDomesticRegions = () => {
    const token = sessionStorage.getItem('token');
    console.log(token);
  const headers = {
    Authorization: `Bearer ${token}`,
  };
    axios.post('http://localhost:8090/home/choice', { region: 'domestic' }, { headers })
      .then((response) => {
        console.log(response.data.regionList);
        setRegionList(response.data.regionList);
       // setselectCountry(response.data.regionList.selectCountry);
        setselectState(response.data.regionList);
      })
      .catch((error) => {
        console.error('Error fetching domestic regions:', error);
      });
  };

  const fetchInternationalRegions = () => {
    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
      Authorization: `Bearer ${token}`,
    };

    axios.post('http://localhost:8090/home/choice', { region: 'International' }, { headers })
      .then((response) => {
        console.log(response.data.regionList);
        setRegionList(response.data.regionList);
        setselectCountry(response.data.regionList);
      })
      .catch((error) => {
        console.error('Error fetching international regions:', error);
      });
  };

  useEffect(() => {
    fetchInternationalRegions();
  }, []);

  const handleChangeState = (event) => {
    setselectState(event.target.value);
  };

  const [selectCity, setselectCity] = useState();
  const handleChangeCity = (event) => {
    setselectState(event.target.value);
  };

  const handleChangeCountry = (event) => {
    setselectCountry(event.target.value);
  };

  return (
    <div
      style={{
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '125vh',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
    >
      <HomeNavbar />
      <Container>
        <Row className="my-4">
          <Col>
            <div className="text-center">
              <h1 style={{ color: 'ActiveCaption' }}>Where do you want to go?</h1>
            </div>
            <div className="d-flex justify-content-center mt-4">
              <Form>
                <Form.Group>
                  <div className="d-flex justify-content-center">
                    <Form.Check
                      type="radio"
                      label="International"
                      name="destinationType"
                      value="International"
                      checked={destinationType === 'International'}
                      onChange={handleDestinationTypeChange}
                      style={{ marginRight: '20px' }}
                    />
                    <Form.Check
                      type="radio"
                      label="Domestic"
                      name="destinationType"
                      value="National"
                      checked={destinationType === 'National'}
                      onChange={handleDestinationTypeChange}
                    />
                  </div>
                </Form.Group>
                {destinationType === 'National' && (
                <div>
                  <Form.Group controlId="formStateChange">
                    <Form.Label> Which state you want to go </Form.Label>
                    <Form.Control as="select" value={selectState} onChange={handleChangeState}>
                    <option>Select State</option>
                      {regionList.map((region) => (
                        <option key={`${region.stateName}-${region.id}`} value={JSON.stringify(region)}>
                          {region.stateName}
                        </option>

                      ))}
                    </Form.Control>
                  </Form.Group>
                </div>
              )}
              {destinationType === 'International' && (
                    <div>
                      <Form.Group controlId="formCountryChange">
                        <Form.Label> Country</Form.Label>
                        <Form.Control as="select" value={selectCountry} onChange={handleChangeCountry} >
                        <option>Select Country</option>
                        {regionList.map((region) => (
                              <option key={`${region.countryName}-${region.countryID}`} value={JSON.stringify(region)}>
                                {region.countryName}
                              </option>
                            ))}
                        </Form.Control>
                  </Form.Group>
                    </div>
                  )}
               <br></br>
               <div>    
               
            </div>

               {destinationType === 'National' && <Domestic selectedState={selectState}/> }

               {destinationType === 'International' && <International selectedCountry={selectCountry} /> }
              </Form>
            </div>
          </Col>
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default MainPage;
