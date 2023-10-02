import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AdminHome() {
  const navigate = useNavigate();
  const [username, setUsername] = useState();
  useEffect(() => {
    console.log("Session " + sessionStorage.getItem("Session"));

    if (sessionStorage.getItem("Session") !== "Admin") {
      console.log("Admin not verified");
      navigate("/login");
    }
    setUsername(JSON.parse(sessionStorage.getItem("UserName")));
  }, [navigate]);

  return (
    <div>
      <div className="px-4 pt-5 my-5 text-center border-bottom">
        <h1 className="display-4 fw-bold text-body-emphasis">
          Welcome Admin {username}
        </h1>
        <div className="col-lg-6 mx-auto">
          <p className="lead mb-4">
            You can navigate to the required pages using the buttons below or
            through the navigation bar at the top.
          </p>
          <div className="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5 text-break">
            <Link
              type="button"
              className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap"
              to="/admin/customer-data-management"
            >
              Customer Management
            </Link>
            <Link
              type="button"
              className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap"
              to="/admin/loan-card-management"
            >
              Loan Card Management
            </Link>
            <Link
              type="button"
              className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap"
              to="/admin/item-master-management"
            >
              Item Management
            </Link>
          </div>
        </div>
        {/* <div className="overflow-hidden" style="max-height: 30vh;"> */}
      </div>
    </div>
  );
}
