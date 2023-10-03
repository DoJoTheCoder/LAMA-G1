import image from "../background.jpg";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AdminNavbar() {
  const navigate = useNavigate();
  const [username, setUserName] = useState("");

  useEffect(() => {
    if (sessionStorage.getItem("Session") === "Admin") {
      setUserName(JSON.parse(sessionStorage.getItem("UserName")));
    } else {
      navigate("/");
    }
  }, [username, navigate]);

  function logoutAdmin() {
    sessionStorage.clear();
    console.log("login status:" + sessionStorage.getItem("Session"));
    navigate("/");
  }

  return (
    <div style={{ backgroundImage: `url(${image})` }}>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <div className="navbar-brand">{username}</div>

          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarTogglerContent"
            aria-controls="navbarTogglerDemo01"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          <div className="collapse navbar-collapse" id="navbarTogglerContent">
            <ul className="navbar-nav mx-auto me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link
                  className="btn btn-outline-light text-center mx-2"
                  to="/admin/home"
                >
                  Home
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className="btn btn-outline-light text-center mx-2"
                  to="/admin/customer-data-management"
                >
                  Customer Data
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className="btn btn-outline-light text-center mx-2"
                  to="/admin/loan-card-management"
                >
                  Loan Cards
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className="btn btn-outline-light text-center mx-2"
                  to="/admin/item-master-management"
                >
                  Items Data
                </Link>
              </li>
              <li className="nav-item">
                <button
                  className="btn btn-outline-light text-center mx-2"
                  onClick={() => logoutAdmin()}
                >
                  Log out
                </button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}
