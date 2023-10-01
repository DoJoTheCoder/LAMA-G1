import image from "../background.jpg";
import React, { useState } from "react";
import LoginPage from "../pages/Login/LoginPage";
import AdminLoginPage from "../admin_pages/Login/LoginPage";

export default function RoleSelect() {
  const [selectedRole, setSelectedRole] = useState(null);

  const handleRoleSelection = (role) => {
    setSelectedRole(role);
  };
  return (
    <div>
      <div
        className="px-4 pt-5 text-center border-bottom"
        style={{ backgroundImage: `url(${image})` }}
      >
        <h1 className="display-4 fw-bold text-body-emphasis">
          Select your role here!
        </h1>
        <div className="col-lg-6 mx-auto">
          <p className="lead mb-4">
            You can navigate to the login page for the corresponding role using
            the buttons below.
          </p>
          <div className="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5 text-break">
            <button
              onClick={() => handleRoleSelection("user")}
              type="button"
              className="btn btn-dark btn-lg px-4 me-sm-3 text-nowrap"
              to="/admin/home"
            >
              User
            </button>
            {/* <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/customer-data-management">Customer Data Management</Link> */}
            <button
              onClick={() => handleRoleSelection("admin")}
              type="button"
              className="btn btn-dark btn-lg px-4 me-sm-3 text-nowrap"
              to="/admin/loan-card-management"
            >
              Admin
            </button>
            {/* <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/item-master-data">Items Master Data</Link> */}
          </div>
        </div>
      </div>

      {selectedRole === "admin" && <AdminLoginPage />}
      {selectedRole === "user" && <LoginPage />}
    </div>
  );
}
