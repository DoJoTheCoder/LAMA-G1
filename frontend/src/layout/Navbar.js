import React from 'react'

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
    <button className="btn btn-outline-light text-center mx-1">Home</button>
    <button className="btn btn-outline-light text-center mx-1">Get loan</button>
    <button className="btn btn-outline-light text-center mx-1">Current Loans</button>
    <button className="btn btn-outline-light text-center mx-1">Items purchased</button>
    </div>

    <button className="btn btn-outline-light">Logout</button>


    </div>
</nav>



    </div>
  )
}
