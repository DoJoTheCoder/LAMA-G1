import React, {useState, useEffect} from 'react';
import axios from "axios";
import { Link } from 'react-router-dom'

export default function CustomerDataManagement() {
  const [employeeArray, setEmployeeArray] = useState([]);

  function viewRecords () {
    



    axios
      .get("http://localhost:8080/viewEmpRecords"
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

  const handleDelete = (e, arg) => {
    e.preventDefault();
    console.log(arg)
    axios.delete("http://localhost:8080/deleteEmp/"+ arg)
    .then((response)=>{
      console.log(response.data)
    })
  }


  return (

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
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {
            employeeArray.map((employee, index)=>(
              <tr key={employee.employeeId}>
                <th scope="row">{index+1}</th>
                <td>{employee.employeeId}</td>
                <td>{employee.employeeName}</td>
                <td>{employee.designation}</td>
                <td>{employee.department}</td>
                <td>{employee.gender}</td>
                <td>{employee.userName}</td>
                <td>{employee.password}</td>
                <td>{employee.doj}</td>
                <td>{employee.dob}</td>
                <td>
                  <Link type="button" className="button1" to={"/admin/addCustomer/" + employee.employeeId}>Edit</Link>
                  <Link onClick={(e) => handleDelete(e, employee.employeeId)}>Delete</Link> 
                </td>
                {/* <td><Link className="btn btn-outline-light text-center mx-1" to='/'>Home</Link></td> */}
              </tr>
            ))
          }          
        </tbody>
      </table>
    
          
      <Link className="btn btn-outline-dark text-center mx-1" to='/admin/addCustomer'>Add Customer</Link>
    </div>
  )
}
