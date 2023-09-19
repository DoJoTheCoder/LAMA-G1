import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios';
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
      .get("http://localhost:8080/getLoanMasterList", {
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
      <h1>Loan Card Master Details</h1>
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
                <td>{i+1}</td>
                <td>{x.loanId}</td>
                <td>{x.loanType}</td>
                <td>{x.durationYears}</td>
                <td>
                  <Link type="button" className="button1" to="#">Edit</Link> <> </>
                  <Link type="button" className="button2" to="#">Delete</Link> </td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}