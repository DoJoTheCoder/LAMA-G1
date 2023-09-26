import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function AdminItemMasterManagement() {

  const [employeeItemsArr, setEmployeeItemsArr] = useState([])
  const navigate = useNavigate();

  useEffect(() => {
    console.log(sessionStorage.getItem("UserID"))
    // getItemCategoryData("E10002");

    axios.get("http://localhost:8080/getAllItems")
      .then((response) => {
        setEmployeeItemsArr(response.data);
        console.log(response.data)
      })
      .catch(error => { alert("error happened:" + error) });

  }, [navigate]);

  function checkLoginStatus() {
    const isLoggedIn = localStorage.getItem('employeeId');
    if (!isLoggedIn) {
      alert("Please login to continue!")
      navigate('/');
    }
  }

  const handleDelete = (e, arg) => {
    e.preventDefault();
    console.log(arg)
    axios.delete("http://localhost:8080/deleteItemRecord/"+ arg)
    .then((response)=>{
      console.log(response.data)
    })
  }

  return (
    <div>
      <h1>ItemMaster table</h1>
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
          {
            employeeItemsArr.map((item, index) => (
              <tr key={item.issueId}>
                <th scope="row">{index + 1}</th>
                <td>{item.itemId}</td>
                <td>{item.itemDescription}</td>
                <td>{item.itemMake}</td>
                <td>{item.itemCategory}</td>
                <td>{item.itemValuation}</td>
                <td>
                  <Link to={"/admin/addItemMaster/"+item.itemId}>Edit</Link> <> </>
                  <Link onClick={(e) => handleDelete(e, item.itemId)} >Delete</Link>
                  </td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}