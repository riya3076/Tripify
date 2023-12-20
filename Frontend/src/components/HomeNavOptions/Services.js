import React from 'react';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const ServicesPage = () => {
  const root = {
    marginBottom: 14,
  }
  const heading =  {
    color: '#333',
    fontWeight: 'bold',
    textTransform: 'uppercase',
    alignItems: 'center',
    marginLeft: 30,
    marginTop: 30,
    fontSize: 30
  }
  const serviceItem = {
    display: 'flex', 
    alignItems: 'center', 
    marginBottom: 2,
  }
  const icon = {
    width: 150,
    height: 150,
    marginRight: 2,
  }
  const serviceTitle = {
    marginBottom: 1,
    color: '#333',
    fontWeight: 'bold',
    fontSize: 20
  }
  const serviceDescription = {
    color: '#777',
  }
  
  return (
    <div>
      <div style={root}>
        <HomeNavbar />
        <h4 style={heading}>Our Services</h4>

        <div style={serviceItem}>
          <img
            src="https://img.freepik.com/premium-vector/vector-cartoon-map-pointer-icon-comic-style-gps-navigation-mark-illustration-pictogram-pointer-destination-business-splash-effect-concept_157943-5365.jpg?w=2000"
            alt="Explore"
            style={icon}
          />
          <div>
            <h4 variant="h6" style={serviceTitle}>
              Explore a Wide Range of Destinations
            </h4>
            <h5 variant="body1" style={serviceDescription}>
              Discover amazing destinations around the world. Whether you're looking for a relaxing beach getaway or an adventurous mountain trek, we've got you covered.
            </h5>
          </div>
        </div>

        <div style={serviceItem}>
          <img
            src="https://thumbs.dreamstime.com/z/wishlist-icon-comic-style-like-document-cartoon-vector-illustration-white-isolated-background-favorite-list-splash-effect-260045823.jpg?w=768"
            alt="wishlist"
            style={icon}
          />
          <div>
            <h4 variant="h6" style={serviceTitle}>
              Wishlist
            </h4>
            <h5 variant="body1" style={serviceDescription}>
            Discover captivating destinations and exciting activities on Tripify - simply click to add your favorites to the wishlist, turning your travel dreams into curated realities.
            </h5>
          </div>
        </div>

        <div style={serviceItem}>
          <img
            src="https://media.istockphoto.com/id/1434050915/vector/audit-document-icon-in-comic-style-result-report-vector-cartoon-illustration-on-white.jpg?s=612x612&w=0&k=20&c=W8sU37P5I4oRKsVCVBdtry4b2Shpvl7tJYJ29cNaFC0="
            alt="Plan"
            style={icon}
            />
          <div>
            <h4 variant="h6" style={serviceTitle}>
              Plan Your Itinerary Effortlessly
            </h4>
            <h5 variant="body1" style={serviceDescription}>
              Take the stress out of trip planning with our easy-to-use itinerary planner. Customize your schedule, add attractions, and get recommendations to make the most of your time.
            </h5>
          </div>
        </div>
      </div>
      <Footer/>
    </div>
  );
};

export default ServicesPage;