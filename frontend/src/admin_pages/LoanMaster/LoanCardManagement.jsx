import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router";

export default function AdminLoanCardManagement() {
  const navigate = useNavigate();
  const [searchId, setSearchId] = useState("");
  const [content, setContent] = useState([]);
  const [nullTable, setNullTable] = useState(true);

  useEffect(() => {
    console.log("Session " + sessionStorage.getItem("Session"));

    if (sessionStorage.getItem("Session") !== "Admin") {
      navigate("/");
    }

    setSearchId(JSON.parse(sessionStorage.getItem("UserID")));

    console.log(searchId);
    axios
      .get("http://localhost:8080/getLoanMasterList")
      .then((response) => {
        console.log(response.data)
        setContent(response.data)
        setNullTable(false)
      }).catch(function (error) {
        console.log(error);
      });
  }, []);

  const handleDelete = (e, arg) => {
    e.preventDefault();
    console.log(arg);
    axios
      .delete("http://localhost:8080/deleteLoanCard/" + arg)
      .then((response) => {
        console.log(response.data);
        window.location.reload();
      });
  };

  return (
    <div className="lead">
      {nullTable ? (
        <>
          <div>
            <h2>The Loan card Data table is Empty</h2>
            <h3 className="m-4">There are no records to display</h3>
            Click here to go back to{" "}
            <Link className="link-dark" to={"/admin/home"}>
              Home
            </Link>
            .
          </div>
        </>
      ) : (
        <div>
          <h1>This is a list of Loan Card Details</h1>
          <table className="table table-striped mx-auto w-75 ">
            <thead className="thead-dark">
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
                  <tr>
                    <th scope="row">{i + 1}</th>
                    <td>{x.loanId}</td>
                    <td>{x.loanType}</td>
                    <td>{x.durationInYears}</td>
                    <td>
                      <Link to={"/admin/addLoanMaster/" + x.loanId}>Edit</Link> <> </>
                      <Link onClick={(e) => handleDelete(e, x.loanId)}>Delete</Link> </td>
                  </tr>
                ))
              }
            </tbody>
          </table>
          <Link className="btn btn-outline-dark text-center mx-1 m-4" to='/admin/addLoanMaster'>Add Loan</Link>
        </div>
      )
      }
    </div>
  )

}
