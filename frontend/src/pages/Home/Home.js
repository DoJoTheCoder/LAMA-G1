import React from 'react'
import { Link } from 'react-router-dom'

export default function Home() {
  return (
    <div>


<div class="px-4 pt-5 my-5 text-center border-bottom">
    <h1 class="display-4 fw-bold text-body-emphasis">Welcome DummyUser123!</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">You can navigate to the require pages using the buttons below or through the navigation bar at the top.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5 text-break">
        <Link type="button" class="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/">Home</Link>
        <Link type="button" class="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/get-loan">Get loan</Link>
        <Link type="button" class="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/current-loans">Current Loans</Link>
        <Link type="button" class="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="/items-purchased">Items purchased</Link>
      </div>
    </div>
    {/* <div class="overflow-hidden" style="max-height: 30vh;"> */}

    </div>
  </div>


  )
}
