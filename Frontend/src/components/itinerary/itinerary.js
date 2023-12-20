import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import { useParams } from 'react-router-dom';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import { Button } from 'react-bootstrap';
import jsPDF from 'jspdf';

const localizer = momentLocalizer(moment);

const Itinerary = () => {
 // const { data } = useParams();
//  console.log("==========>"+data);
 // console.log("*********"+decodeURIComponent(data) );
//  const itinerary = JSON.parse(decodeURIComponent(data));
  //console.log(itinerary);

  const [userItinerary, setUserItinerary] = useState([]);

  useEffect(() => {
    // Fetch the itinerary data from the backend using the API
    const token = sessionStorage.getItem('token');
    const headers = {
      Authorization: `Bearer ${token}`,
    };

    const requestBody = { };

    axios.post('http://localhost:8090/home/itinerary',requestBody ,{ headers })
      .then((response) => {
        console.log('User itinerary:', response.data.itineraryObjectList);
        // Save the fetched itinerary data to the state
        setUserItinerary(response.data.itineraryObjectList);
        const startDateTime = moment(response.data.itineraryObjectList[0].date).format('YYYY-MM-DD HH:mm');
        console.log(startDateTime);
      })
      .catch((error) => {
        console.error('Error fetching user itinerary:', error);
        // Handle error here if needed
      });
  }, []);

  const generatePDF = () => {
    const doc = new jsPDF();
  
    // Add title to the PDF
    doc.setFontSize(20);
    doc.text('Itinerary', 10, 20);
  
    // Add itinerary details
    const yOffset = 30;
    userItinerary.forEach((item, index) => {
      const startDateTime = moment(item.startdate).format('YYYY-MM-DD HH:mm');
      const endDateTime = moment(item.endDate).format('YYYY-MM-DD HH:mm');
      const text = `${index + 1}. ${item.title}: ${startDateTime} to ${endDateTime}`;
      doc.text(text, 10, yOffset + index * 10);
    });
  
    // Save the PDF as a file
    doc.save('itinerary.pdf');
  };
  
  const formattedEvents = userItinerary.map((item, index) => {
    const startDateTime = moment(`${item.startdate}`, 'YYYY-MM-DD HH:mm').toDate();
    const endDateTime = moment(`${item.endDate}`, 'YYYY-MM-DD HH:mm').toDate();
    
    return {
      id: index,
      title: item.title,
      start: startDateTime,
      end: endDateTime,
      allDay: false,
    };
  });
  
  const handleSavePDF = () => {
    generatePDF();
  };

  return (
    <>
      <HomeNavbar />
      <div style={{ height: '650px', padding: '20px' }}>
        <h2>Itinerary</h2>
        
        <div style={{ height: '600px', overflow: 'auto' }}>
          <Calendar
            localizer={localizer}
            events={formattedEvents}
            startAccessor="start"
            endAccessor="end"
            defaultView="month"
            views={['month', 'day']}
            step={60}
            showMultiDayTimes
            defaultDate={new Date()}
            min={new Date(null, null, null, 0, 0)} // Set the time to 00:00 (midnight)
            max={new Date(null, null, null, 23, 59)} // Set the time to 23:59 (11:59 PM)
          />
        </div>
      </div>
      <Button style={{marginLeft:'85rem', marginTop:'2rem', height:'1cm', width:'3cm'}} onClick={handleSavePDF}>
        Save as PDF
      </Button>
      <div style={{ marginTop: '5rem' }}>
        <Footer />
      </div>
    </>
  );
};

export default Itinerary;
