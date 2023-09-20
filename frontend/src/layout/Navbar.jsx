import { Button } from 'bootstrap'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Navbar() {

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
            <Link className="btn btn-outline-light text-center mx-1" to='/home'>Home</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/get-loan'>Get loan</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/current-loans'>Current Loans</Link>
            <Link className="btn btn-outline-light text-center mx-1" to='/items-purchased'>Items purchased</Link>
          </div>

          {/* <Button>Logout</Button> */}


        </div>
      </nav>
    </div>
  )
}
