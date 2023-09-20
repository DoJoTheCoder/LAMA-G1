import React from 'react'
import { Link } from 'react-router-dom'

export default function AdminHome() {
  return (
    <div>
      <div className="px-4 pt-5 my-5 text-center border-bottom">
          <h1 className="display-4 fw-bold text-body-emphasis">Welcome DummyAdmin999!</h1>
          <div className="col-lg-6 mx-auto">
            <p className="lead mb-4">You can navigate to the required pages using the buttons below or through the navigation bar at the top.</p>
            <div className="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5 text-break">
              {/* <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/home">Home</Link> */}
              <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/customer-data-management">Customer Data Management</Link>
              <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/loan-card-management">Loan Card Management</Link>
              <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/admin/item-master-data">Items Master Data</Link>
            </div>
          </div>
    {/* <div className="overflow-hidden" style="max-height: 30vh;"> */}
     </div>
   </div>


  )
}
