import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function ItemsPurchased() {

  const [employeeItemsArr, setEmployeeItemsArr] = useState([])
  const navigate = useNavigate();

  useEffect(() => {
    getItemCategoryData("E10001");

    //This is to check if user is logged in before allowing apply loan
    //TODO: Uncomment after completing the login and session management
    // checkLoginStatus();
    
  }, [navigate]);

  function checkLoginStatus(){
    const isLoggedIn = localStorage.getItem('employeeId');
    if (!isLoggedIn) {
        alert("Please login to continue!")
        navigate('/');
    }
  }

  const getItemCategoryData = (empId) => {
    
    axios.get("http://localhost:8080/getEmployeeItems/" + empId)
            .then((response) => {setEmployeeItemsArr(response.data);})
            .catch(error => {alert("error happened:"+error)});
  }

  return (
    <div>
      <h1>This is the list of Purchased Items</h1>
      <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Loan ID</th>
            <th scope="col">Item Description</th>
            <th scope="col">Item make</th>
            <th scope="col">Item category</th>
            <th scope="col">Item valuation</th>
          </tr>
        </thead>
        <tbody>
          {
            employeeItemsArr.map((item, index)=>(
              <tr key={item.issueId}>
                <th scope="row">{index+1}</th>
                <td>{item.issueId}</td>
                <td>{item.itemDescription}</td>
                <td>{item.itemMake}</td>
                <td>{item.itemCategory}</td>
                <td>{item.itemValuation}</td>
              </tr>
            ))
          }          
        </tbody>
      </table>
    </div>
  )
}