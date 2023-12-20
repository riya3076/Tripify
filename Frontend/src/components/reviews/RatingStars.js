import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar as solidStar } from "@fortawesome/free-solid-svg-icons";
import { faStar as regularStar } from "@fortawesome/free-regular-svg-icons";

const RatingStars = ({ initialRating, onChange }) => {
  const [rating, setRating] = useState(initialRating || 0);

  const handleStarClick = (index) => {
    const newRating = index + 1;
    setRating(newRating);
    onChange(newRating);
  };

  return (
    <div>
      {[...Array(5)].map((_, index) => (
        <FontAwesomeIcon
          key={index}
          icon={index < rating ? solidStar : regularStar}
          onClick={() => handleStarClick(index)}
        />
      ))}
    </div>
  );
};

export default RatingStars;
