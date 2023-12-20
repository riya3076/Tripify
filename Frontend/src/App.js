import "./App.css";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Login from "./components/authentication/Login";
import Home from "./components/Home";
import Signup from "./components/authentication/Signup";
import Error from "./components/Error";
import ForgotPassword from "./components/authentication/forgot";
import ContactPage from "./components/HomeNavOptions/Contact";
import ServicesPage from "./components/HomeNavOptions/Services";
import AboutPage from "./components/HomeNavOptions/About";
import MainPage from "./components/Landing-page/Main";

import "bootstrap/dist/css/bootstrap.css";
import Itinerary from "./components/itinerary/itinerary";
import UserProfile from "./components/UserProfile/profile";
import ReviewsPage from "./components/reviews/review";
import Landing from "./components/Landing-page/landing";
import RecommendPlace from "./components/Landing-page/RecommendPlace";
import RecommendActivity from "./components/Landing-page/RecommendActivity";
import Resetpwd from "./components/UserProfile/Resetpwd";

import ThingsToCarry from "./components/ThingsToCarry/thingsToCarry";
import City from "./components/StartTrip/City";
import OTP from "./components/authentication/otp";
import ResetForgotPassword from "./components/authentication/resetForgotPassword";
import Place from "./components/StartTrip/Place";
import State from "./components/StartTrip/State";
import Activity from "./components/StartTrip/Activity";
import AddReviewsPage from "./components/reviews/Addreview";
import Notification from "./components/StartTrip/Notification";
import Wish from "./components/wishlist/Wish";

export function isLoggedIn() {
  const token = sessionStorage.getItem("token");
  return token !== null;
}

export function Auth({ children }) {
  return isLoggedIn() ? children : null;
}
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/otp" element={<OTP />} />
        <Route path="/resetForgotPassword" element={<ResetForgotPassword />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="/mainpage" element={<MainPage />} />
        <Route
          path="/itinerary"
          element={
            <Auth>
              <Itinerary />
            </Auth>
          }
        />
        <Route
          path="/wish/:data"
          element={
            <Auth>
              <Wish />
            </Auth>
          }
        />
        <Route
          path="/profile"
          element={
            <Auth>
              <UserProfile />
            </Auth>
          }
        />
        <Route
          path="/landing"
          element={
            <Auth>
              <Landing />
            </Auth>
          }
        />
        <Route
          path="/recommendplace/:placeID"
          element={
            <Auth>
              <RecommendPlace />
            </Auth>
          }
        />
        <Route
          path="/recommendactivity/:activityid"
          element={
            <Auth>
              <RecommendActivity />
            </Auth>
          }
        />
        <Route
          path="/resetpassword"
          element={
            <Auth>
              <Resetpwd />{" "}
            </Auth>
          }
        />
        <Route
          path="/thingsToCarry"
          element={
            <Auth>
              <ThingsToCarry />
            </Auth>
          }
        />
        <Route
          path="/city/:cityID"
          element={
            <Auth>
              <City />
            </Auth>
          }
        />
        <Route
          path="/Place/:placeID"
          element={
            <Auth>
              <Place />
            </Auth>
          }
        />
        <Route
          path="/state/:stateName"
          element={
            <Auth>
              <State />
            </Auth>
          }
        />
        <Route
          path="/Activity/:activityid"
          element={
            <Auth>
              <Activity />
            </Auth>
          }
        />
        <Route path="/Addreview/:placeID" element={<AddReviewsPage />} />
        <Route path="/Addreview/:placeID" element={<AddReviewsPage />} />
        <Route
          path="/Notification"
          element={
            <Auth>
              <Notification />
            </Auth>
          }
        />
        <Route
          path="/Wish"
          element={
            <Auth>
              <Wish />
            </Auth>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
