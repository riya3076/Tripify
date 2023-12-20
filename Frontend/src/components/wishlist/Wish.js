import React, { useState, useEffect } from "react";
import Footer from "../footer";
import HomeNavbar from "../HomeNav";
import { Card, Button, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import axios from "axios";
import WishlistCard from "./WishlistCard";

const Wish = () => {
  const token = sessionStorage.getItem("token");
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  const [wishListDetails, setfetchedWishlist] = useState([]);

  useEffect(() => {
    axios
      .post("http://localhost:8090/home/wishlist", {}, { headers })
      .then((response) => {
        console.log("wishlist api response");
        console.log(response.data);
        setfetchedWishlist(response.data.wishLists);
      })
      .catch((error) => {
        console.error("Error fetching city details:", error);
      });
  }, []);

  return (
    <div
      style={{ minHeight: "100vh", display: "flex", flexDirection: "column" }}
    >
      <HomeNavbar />
      <div>
        <h2>Your Wishlist</h2>
        {wishListDetails.map((wishlistItem, index) => (
          <WishlistCard key={index} wishlistItem={wishlistItem} />
        ))}
      </div>
      <Footer />
    </div>
  );
};

export default Wish;
