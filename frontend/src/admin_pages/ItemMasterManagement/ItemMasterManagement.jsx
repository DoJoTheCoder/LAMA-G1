import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function AdminItemMasterManagement() {
  const [employeeItemsArr, setEmployeeItemsArr] = useState([]);
  const navigate = useNavigate();
  const [nullTable, setNullTable] = useState(true);

  useEffect(() => {
    console.log(sessionStorage.getItem("UserID"));

    axios
      .get("http://localhost:8080/getAllItems")
      .then((response) => {
        setEmployeeItemsArr(response.data);
        console.log(response.data);
        if (response.data.length > 0) {
          setNullTable(false);
        }
      })
      .catch((error) => {
        alert("error happened:" + error);
      });
  }, [navigate]);

  function checkLoginStatus() {
    const isLoggedIn = localStorage.getItem("employeeId");
    if (!isLoggedIn) {
      alert("Please login to continue!");
      navigate("/");
    }
  }

  const handleDelete = (e, arg) => {
    e.preventDefault();
    console.log(arg);
    axios
      .delete("http://localhost:8080/deleteItemRecord/" + arg)
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
            <h2> The Item Master table is Empty</h2>
            <h3>There are no records to display</h3>
            Click here to go back to{" "}
            <Link className="link-dark" to={"/admin/home"}>
              Home
            </Link>
            .
          </div>
        </>
      ) : (
        <>
        <h1>This is a list of Item Details</h1>
        <table className="table table-striped mx-auto w-75 ">
          <thead className="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Item ID</th>
                <th scope="col">Item Description</th>
                <th scope="col">Item make</th>
                <th scope="col">Item category</th>
                <th scope="col">Item valuation</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
              {employeeItemsArr.map((item, index) => (
                <tr key={item.itemId}>
                  <th scope="row">{index + 1}</th>
                  <td>{item.itemId}</td>
                  <td>{item.itemDescription}</td>
                  <td>{item.itemMake}</td>
                  <td>{item.itemCategory}</td>
                  <td>{item.itemValuation}</td>
                  <td>
                    <Link to={"/admin/addItemMaster/" + item.itemId}>Edit</Link>{" "}
                    <> </>
                    <Link onClick={(e) => handleDelete(e, item.itemId)}>
                      Delete
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
      <Link
        className="btn btn-outline-dark text-center m-4"
        to="/admin/addItemMaster"
      >
        Add Item
      </Link>
    </div>
  );
}
