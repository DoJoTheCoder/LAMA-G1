import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";

export default function CurrentLoans() {

  const navigate = useNavigate()
  const [searchId, setSearchId] = useState("")
  const [content, setContent] = useState([])
  const [nullTable, setNullTable] = useState(true)
  let count = 0
  useEffect(() => {
    console.log("Session " + sessionStorage.getItem("Session"));

    if (sessionStorage.getItem("Session") !== "User") {
      navigate("/");
    }

    setSearchId(JSON.parse(sessionStorage.getItem("UserID")));

    console.log(searchId);
    axios
      .post("http://localhost:8080/getLoanList", {
        searchId: JSON.parse(sessionStorage.getItem("UserID")),
      })
      .then((response) => {
        console.log(response.data);
        setContent(response.data);
        if (response.data.length > 0) {
          setNullTable(false);
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  return (
    <div className="lead">
      <br/>
      {nullTable ? <>
        <div>
          <h1 className="mb-4">You have no current loans!</h1>
          Click here to go back to <Link to={"/home"}>Home</Link>.
        </div>
      </> : <>
        <div>
          <h1 className="mb-4">This is a list of Current Loans</h1>
          <table className="table table-striped mx-auto w-75 ">
            <thead className="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Loan ID</th>
                <th scope="col">Loan Type</th>
                <th scope="col">Duration</th>
                <th scope="col">Card Issue Date</th>
              </tr>
            </thead>

            <tbody>
              {
                content.map((x, i) => (
                  <tr key={count++}>
                    <td>{i + 1}</td>
                    <td>{x.loan_id}</td>
                    <td>{x.loan_type}</td>
                    <td>{x.duration_in_years}</td>
                    <td>{x.card_issue_date}</td>
                  </tr>
                ))}
              </tbody>
            </table>
        </div>
        </>
      }
    </div>
  );
}
