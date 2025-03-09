import React from "react";
import "./Login.css";

function Login() {
  return (
    <div className="login-page">
      <div className="login-container">
        {/* Display the Pizza Logo */}
        <img src="/pizza.png" alt="Pizza Logo" className="logo" />

        <h2>Sign in to PizzaVibe</h2>
        <form>
          <div className="input-group">
            <input type="email" placeholder="Email" />
          </div>
          <div className="input-group">
            <input type="password" placeholder="Password" />
          </div>
          <div className="forgot-password">
            <button className="forgot-password-btn" onClick={() => alert("Forgot Password Clicked")}>
              Forgot Password?
            </button>
          </div>
          <button type="submit" className="sign-in-btn">Sign In</button>
          <div className="social-login">
            <button className="facebook-btn">Sign in with Facebook</button>
            <button className="google-btn">Sign in with Google</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
