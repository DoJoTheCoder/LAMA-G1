import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios';
import "./CurrentLoans.css"
import { useNavigate } from 'react-router';


export default function AdminLoanCardManagement() {

  const navigate = useNavigate()
  const [searchId, setSearchId] = useState("")
  const [content, setContent] = useState([])

  useEffect(() => {

    console.log("Session " + (sessionStorage.getItem("Session")))

    if ((sessionStorage.getItem("Session")) !== "Valid") {
      navigate("/login")
    }

    setSearchId(JSON.parse(sessionStorage.getItem("UserID")))

    console.log(searchId)
    axios
      .post("http://localhost:8080/getLoanList", {
        searchId: JSON.parse(sessionStorage.getItem("UserID"))
      }
      )
      .then((response) => {
        console.log(response.data)
        setContent(response.data)
      }).catch(function (error) {
        console.log(error);
      });
  }, []);




  return (
    <div>
      <h1>Customer Master Details</h1>
      {/* <button className="refreshButton" onClick={getLoanList}>Refresh Table</button> */}
      <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Loan ID</th>
            <th scope="col">Loan Type</th>
            <th scope="col">Duration</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>

        <tbody>
          {
            content.map((x, i) => (
              // Dummy values below
              <tr>
                <td>1</td>
                <td>L001</td>
                <td>Furniture</td>
                <td>5</td>
                <td><Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="#">Edit</Link>  <Link type="button" className="btn btn-primary btn-lg px-4 me-sm-3 bg-dark text-nowrap" to="#">Delete</Link> </td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}