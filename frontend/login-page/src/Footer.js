import React from "react";
import "./Footer.css";

function Footer() {
  return (
    <div className="footer">
      <button onClick={() => alert("Register Clicked")}>Register</button>
      <button onClick={() => alert("Overall Menu Clicked")}>Overall Menu</button>
      <button onClick={() => alert("Cart Clicked")}>Cart</button>
      <button onClick={() => alert("Checkout Clicked")}>Checkout</button>
      <button onClick={() => alert("Account Clicked")}>Account</button>
    </div>
  );
}

export default Footer;
