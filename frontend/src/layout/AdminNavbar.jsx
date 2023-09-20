import { Button } from 'bootstrap'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'


export default function AdminNavbar() {

  // TODO: This part needs to be edited, since admin NAVBAR
  const navigate = useNavigate()
  const [username, setUserName] = useState("")
  useEffect(() => {
    if ((sessionStorage.getItem("Session")) === "Valid") {
      setUserName(JSON.parse(sessionStorage.getItem("UserName")))
    }
  }, [username, navigate])

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">{username}</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>   

          <div className="text-center">
            <Link className="btn btn-outline-light text-center mx-1" to='/admin/home'>Home</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/admin/customer-data-management'>Customer Data</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/admin/loan-card-management'>Loan Cards</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/admin/item-master-data'>Items Data</Link>
          </div>

          {/* <Button>Logout</Button> */}


        </div>
      </nav>
    </div>
  )
}
