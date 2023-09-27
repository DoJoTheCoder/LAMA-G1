import React from 'react'
import { Link } from 'react-router-dom'

export default function PageNotFoundHandler() {
    // TODO: make this page look good 
  return (
    <div className='container min-vh-100 d-flex'>
        <div className='my-auto mx-auto align-items-center'>
            <h1>404 Error</h1><br/>
            <p>The page you have requested does not exist.</p><br/>
            <Link to={"/"}>Click here to go back</Link>
        </div>

    </div>
  )
}
