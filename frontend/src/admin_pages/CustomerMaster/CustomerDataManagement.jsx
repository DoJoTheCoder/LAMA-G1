import React, {useState, useEffect} from 'react';
import axios from "axios";

export default function CustomerDataManagement() {
  const [employeeArray, setEmployeeArray] = useState([]);

  function viewRecords () {
    



    axios
      .get("http://localhost:8080/viewAllRecords"
          // title: "Hello World!",
          // body: JSON.stringify(sendBody)
      // }
      )
      .then((response) => {
          console.log(response);
          setEmployeeArray(response.data);
      }).catch(function (error){
          console.log(error);
      });
  }

  useEffect(() => {
    viewRecords();
  }, [])

  return (
    // <div>EmployeeAdmin</div>

    /*
    1. edit employee
    2. remove empoyee
    3. view employee records
    
    
    */

    <div>
      {/* <h1>This is the list of Purchased Ite/h1> */}
      <table className="table table-dark">
        <thead>
          <tr>
            <th scope="col">Employee ID</th>
            <th scope="col">Employee Name</th>
            <th scope="col">Designation</th>
            <th scope="col">Department</th>
            <th scope="col">Gender</th>
            <th scope="col">Username</th>
            <th scope="col">Password</th>
            <th scope="col">Date of Joining</th>
            <th scope="col">Date of Birth</th>
            {/* <th scope="col">Loan ID</th> */}
          </tr>
        </thead>
        <tbody>
          {
            employeeArray.map((item, index)=>(
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
