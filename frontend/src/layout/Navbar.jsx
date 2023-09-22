import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Navbar() {

  const navigate = useNavigate()
  const [username, setUserName] = useState("")

  useEffect(() => {
    if ((sessionStorage.getItem("Session")) === "Valid") {
      setUserName(JSON.parse(sessionStorage.getItem("UserName")))
    }
    else{
      navigate("/")
    }
  }, [username, navigate])

  //TODO:check if sessionStorage needs to be fully cleared or just some fields
  function logoutUser(){
    sessionStorage.clear()
    console.log("login status:"+sessionStorage.getItem("Session"))
    navigate("/")
  }

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <div className="navbar-brand">{username}</div>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerContent" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>

        <div className="collapse navbar-collapse" id="navbarTogglerContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className="btn btn-outline-light text-center mx-1" to='/home'>Home</Link>
            </li>
            <li className="nav-item">
              <Link className="btn btn-outline-light text-center mx-1" to='/get-loan'>Get loan</Link>
            </li>
            <li className="nav-item">
              <Link className="btn btn-outline-light text-center mx-1" to='/current-loans'>Current Loans</Link>
            </li>
            <li className="nav-item">
              <Link className="btn btn-outline-light text-center mx-1" to='/items-purchased'>Items purchased</Link>
            </li>
            <li className='nav-item'>
              <button className="btn btn-outline-light text-center mx-1" onClick={()=>logoutUser()}>Log out</button>
            </li>
          </ul>
        </div>
          


        </div>
      </nav>
    </div>
  )
}
