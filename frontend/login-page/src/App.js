import React from "react";
import Login from "./Login";
import Footer from "./Footer";

function App() {
  return (
    <div className="App">
      <Login />
      <Footer /> {/* Add Footer below the Login form */}
    </div>
  );
}

export default App;
