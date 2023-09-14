import React, { useState } from 'react'
import axios from 'axios';
import "./CurrentLoans.css"


export default function CurrentLoans() {


  const [searchId, setSearchId] = useState("")
  const [content, setContent] = useState([])

  function getUserId() {
    setSearchId(JSON.parse(sessionStorage.getItem("UserID")))
  }
  function getLoanList() {
    // console.log()

    getUserId()
    console.log(searchId)
    axios
      .post("http://localhost:8080/getLoanList", {
        searchId: searchId
      }
      )
      .then((response) => {
        console.log(response.data)
        setContent(response.data)
      }).catch(function (error) {
        console.log(error);
      });
  }

  return (
    <div>
      <h1>This is a list of Current Loans</h1>
      <button className="refreshButton" onClick={getLoanList}>Refresh Table</button>
      <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Loan ID</th>
            <th scope="col">Loan Type</th>
            <th scope="col">Duration</th>
            <th scope="col">Card Issue Date</th>
          </tr>
        </thead>

        {/* {console.log(content)} */}
        <tbody>
          {
            content.map((x, i) => (
              <tr>
                <td>{i + 1}</td>
                <td>{x.loan_id}</td>
                <td>{x.loan_type}</td>
                <td>{x.duration_in_years}</td>
                <td>{x.card_issue_date}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}