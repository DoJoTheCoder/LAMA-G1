import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">DummyUser123</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>   

    <div class="text-cente">
    <Link className="btn btn-outline-light text-center mx-1" to='/'>Home</Link>
    <Link className="btn btn-outline-light text-center mx-1" to='/get-loan'>Get loan</Link>
    <Link className="btn btn-outline-light text-center mx-1" to='/current-loans'>Current Loans</Link>
    <Link className="btn btn-outline-light text-center mx-1" to='/items-purchased'>Items purchased</Link>
    </div>

    <Link className="btn btn-outline-light" to='/login'>Logout</Link>


    </div>
</nav>



    </div>
  )
}
