import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function RegisterationPage(props) {
  const [employeeId, setEmployeeId] = useState("");
  const [employeeName, setEmployeeName] = useState("");
  const [designation, setDesignation] = useState("");
  const [department, setDepartment] = useState("");
  const [dob, setDob] = useState(Date);
  const [doj, setDoj] = useState(Date);

  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [gender, setGender] = useState("M");
  const [accessType, setAccessType] = useState("User");
  const [accessTypeField, setAccessTypeField] = useState(true);

  const navigate = useNavigate();
  useEffect(() => {
    console.log(props.from);
    if (props.from === "admin") {
      setAccessTypeField(false);
    }
    console.log(accessTypeField);
  }, []);

  function handleNewRegisterSubmit() {
    const sendBody = {
      employeeId: employeeId,
      employeeName: employeeName,
      designation: designation,
      department: department,
      gender: gender,
      userName: userName,
      password: password,
      doj: doj,
      dob: dob,
      accessType: accessType,
    };
    console.log(sendBody);
    axios
      .post(
        "http://localhost:8080/addEmployeeMaster",
        sendBody
        // title: "Hello World!",
        // body: JSON.stringify(sendBody)
        // }
      )
      .then((response) => {
        alert("Registration Successful");
        navigate("/");
        console.log(response);
      })
      .catch(function (error) {
        alert("Registration Failed");
        console.log(error);
      });
  }

  return (
    <div className="py-5">
      <div className="card col-lg-4 d-flex mx-auto p-3 lead fw-bold">
        <h2 class="title">Registration Form</h2>
        <form  >
          <label className="form-label fw-bold mt-4">Employee Id</label>
          <input
            type="text"
            className="form-control"
            onChange={(e) => setEmployeeId(e.target.value)}
            required
          ></input>

          <label className="form-label fw-bold mt-4">Employee Name</label>
          <input
            type="text"
            className="form-control"
            required
            onChange={(e) => {
              setEmployeeName(e.target.value);
            }}
          ></input>

          <label className="form-label fw-bold mt-4">Enter Username</label>
          <input
            type="text"
            className="form-control"
            required
            onChange={(e) => {
              setUserName(e.target.value);
            }}
          ></input>

          <label className="form-label fw-bold mt-4">Enter Password</label>
          <input
            type="text"
            className="form-control"
            required
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          ></input>

          <label className="form-label fw-bold mt-4">Designation</label>
          <input
            type="text"
            className="form-control"
            required
            onChange={(e) => {
              setDesignation(e.target.value);
            }}
          ></input>

          <label className="form-label fw-bold mt-4">Department</label>
          <input
            type="text"
            className="form-control"
            required 
            value = {department}
            onChange={(e) => {
              setDepartment(e.target.value);
            }
          }
         
          ></input>

          <label class="form-label fw-bold mt-4 ">Gender</label>
          <div class="p-t-10 fw-light">
            <label class="radio-container mx-3">Male</label>
            <input
              type="radio"
              checked="checked"
              name="gender"
              value="M"
              
              onChange={(e) => setGender(e.target.value)}
            ></input>
            <span class="checkmark"></span>

            <label class="radio-container mx-3">Female</label>
            <input
              type="radio"
              name="gender"
              value="F"
              onChange={(e) => setGender(e.target.value)}
            ></input>
            <span class="checkmark"></span>
          </div>

          <label className="form-label fw-bold mt-4">Date of Birth</label>
          <input
            type="date"
            className="form-control"
            onChange={(e) => setDob(e.target.value)}
            required
          ></input>

          <label className="form-label fw-bold mt-4">Date of Joining</label>
          <input
            type="date"
            className="form-control"
            onChange={(e) => setDoj(e.target.value)}
            required
          ></input>

          <label className="form-label fw-bold mt-4">
            Access Type (User/Admin)?
          </label>
          <input
            type="text"
            className="form-control"
            value={accessType}
            disabled={accessTypeField}
            onChange={(e) => {
              setAccessType(e.target.value);
            }}
          ></input>

          <button
            type="submit"
            className="btn btn-dark btn-lg px-4 mb-4 me-sm-3 text-nowrap"
            onSubmit={handleNewRegisterSubmit}
          >
            Submit
          </button>
        </form>
      </div>
    </div>

  );
}
