import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import axios from "axios";

const WishlistCard = ({ wishlistItem }) => {
  const [details, setDetails] = useState(null);
  const token = sessionStorage.getItem("token");
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  useEffect(() => {
    if (wishlistItem.placeID) {
      axios
        .post(
          "http://localhost:8090/home/place",
          {
            placeID: wishlistItem.placeID,
          },
          { headers }
        )
        .then((response) => {
          setDetails(response.data);
        })
        .catch((error) => {
          console.error("Error fetching place details:", error);
        });
    } else if (wishlistItem.activityID) {
      axios
        .post(
          "http://localhost:8090/home/activity",
          {
            activityID: wishlistItem.activityID,
          },
          { headers }
        )
        .then((response) => {
          setDetails(response.data);
        })
        .catch((error) => {
          console.error("Error fetching activity details:", error);
        });
    }
  }, [wishlistItem]);

  return (
    <Card>
      <Card.Body>
        {details && (
          <div>
            <Card.Title>Place Name: {details.placeName}</Card.Title>
            <Card.Text> {details.description}</Card.Text>
          </div>
        )}
      </Card.Body>
    </Card>
  );
};

export default WishlistCard;
