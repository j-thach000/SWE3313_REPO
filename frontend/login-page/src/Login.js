import React, { useState } from "react";
import axios from "axios";
import "./Login.css";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:3000/auth/login", {
        email,
        password
      });
      console.log(response.data);
      setMessage("Login successful ✔");
    } catch (error) {
      console.error(error.response.data);
      setMessage(error.response.data.error || "Login failed 🚫");
    }
  };
  
  return (
    <div className="login-page">
      <div className="login-container">
        {/* Display the Pizza Logo */}
        <img src="/pizza.png" alt="Pizza Logo" className="logo" />

        <h2>Sign in to PizzaVibe</h2>
        <form onSubmit={handleLogin}>
          <div className="input-group">
            <input
              type="email"
              placeholder="Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="input-group">
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="forgot-password">
            <button className="forgot-password-btn" onClick={() => alert("Forgot Password Clicked")}>
              Forgot Password?
            </button>
          </div>
          <button type="submit" className="sign-in-btn">Sign In</button>
          {message && <p>{message}</p>}
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
