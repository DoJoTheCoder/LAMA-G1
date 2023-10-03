import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";

export default function ItemsPurchased() {
  const [employeeItemsArr, setEmployeeItemsArr] = useState([]);
  const [nullTable, setNullTable] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    console.log("Session " + sessionStorage.getItem("Session"));

    if (sessionStorage.getItem("Session") !== "User") {
      navigate("/");
    }

    console.log("User:" + sessionStorage.getItem("UserID"));
    getEmployeePurchases(JSON.parse(sessionStorage.getItem("UserID")));
  }, [navigate]);

  const getEmployeePurchases = (empId) => {
    axios
      .get("http://localhost:8080/getEmployeeItems/" + empId)
      .then((response) => {
        setEmployeeItemsArr(response.data);
        if (response.data.length > 0) {
          setNullTable(false);
        }
      })
      .catch((error) => {
        alert("error happened:" + error);
      });
  };

  return (
    <div className="lead">
    {nullTable ? (
      <>
        <div>
          <h1 className="mb-4">You have not purchased any item!</h1>
          Click here to go back{" "}
          <Link className="link-dark" to={"/home"}>
            Home.
          </Link>
        </div>
      </>
    ) : (
      <>
        <div>
          <h1>This is a list of Purchased Items</h1>
          <table className="table table-striped mx-auto w-75 ">
            <thead className="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Issue ID</th>
                <th scope="col">Item Description</th>
                <th scope="col">Item make</th>
                <th scope="col">Item category</th>
                <th scope="col">Item valuation</th>
              </tr>
            </thead>
            <tbody>
              {employeeItemsArr.map((item, index) => (
                <tr key={item.issueId}>
                  <th scope="row">{index + 1}</th>
                  <td>{item.issueId}</td>
                  <td>{item.itemDescription}</td>
                  <td>{item.itemMake}</td>
                  <td>{item.itemCategory}</td>
                  <td>{item.itemValuation}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </>
    )}
  </div>
)
}
