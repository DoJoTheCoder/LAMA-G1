import React, { useState } from "react";
import axios from "axios";

export default function RegisterationPage() {

    const [employeeId, setEmployeeId] = useState("");
    const [employeeName, setEmployeeName] = useState("");
    const [designation, setDesignation] = useState("");
    const [department, setDepartment] = useState("");
    const [dob, setDob] = useState(Date);
    const [doj, setDoj] = useState(Date);

    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [gender, setGender] = useState("");

    function handleNewRegisterSubmit(){

        const sendBody = {
            employeeId : employeeId,
            employeeName : employeeName,
            designation : designation,
            department : department,
            gender : gender,
            userName : userName,
            password :password,
            doj : doj,
            dob : dob
        }
        console.log(sendBody);
        axios
            .post("http://localhost:8080/addEmployeeMaster", sendBody
                // title: "Hello World!",
                // body: JSON.stringify(sendBody)
            // }
            )
            .then((response) => {
                console.log(response);
            }).catch(function (error){
                console.log(error);
            });

    }

    return (
        <div className="py-5">
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>

                    <label className="form-label fw-bold">Employee Id</label>
                    <input type="text" className="form-control" onChange={(e)=>setEmployeeId(e.target.value)}></input>


                    <label className="form-label fw-bold">Employee Name</label>
                    <input type="text" className="form-control" onChange={(e)=>{setEmployeeName(e.target.value)}}></input>


                    <label className="form-label fw-bold">Enter Username</label>
                    <input type="text" className="form-control" onChange={(e)=>{setUserName(e.target.value)}}></input>


                    <label className="form-label fw-bold">Enter Password</label>
                    <input type="text" className="form-control" onChange={(e)=>{setPassword(e.target.value)}}></input>


                    <label className="form-label fw-bold">Designation</label>
                    <input type="text" className="form-control" onChange={(e)=>{setDesignation(e.target.value)}}></input>

                    <label className="form-label fw-bold">Department</label>
                    <input type="text" className="form-control" onChange={(e)=>{setDepartment(e.target.value)}}></input>

                    <label className="form-label fw-bold">Gender(M/F)</label>
                    <input type="text" className="form-control" onChange={(e)=>setGender(e.target.value)}></input>



                    <label className="form-label fw-bold">Date of Birth</label>
                    <input type="date" className="form-control" onChange={(e)=>setDob(e.target.value)}></input>


                    <label className="form-label fw-bold">Date of Joining</label>
                    <input type="date" className="form-control" onChange={(e)=>setDoj(e.target.value)}></input>
                    <button type="button" className="btn btn-primary" onClick={handleNewRegisterSubmit}>Submit</button>
                </form>
            </div >
        </div >

        // <div>
        //     <div classNameName="registerationForm">
        //         <form onSubmit={handleLoginSubmit}>

        //             <h3>Registeration Page</h3>
        //             Employee ID : <input type="text" value={employeeId} onChange={(e) => setEmployeeId(e.target.value)}></input><br/>
        //             Employee Name : <input type="text" value={employeeName} onChange={(e) => setEmployeeName(e.target.value)}></input><br/>
        //             Enter Username : <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)}></input><br/>
        //             Enter Password : <input type="text" value={password} onChange={(e) => setPassword(e.target.value)}></input><br/>
        //             Designation : <input type="text" value={designation} onChange={(e) => setDesignation(e.target.value)}></input><br/>
        //             Department : <input type="text" value={department} onChange={(e) => setDepartment(e.target.value)}></input><br/>
        //             Gender(M/F) : <input type="text" value={gender} onChange={(e) => setGender(e.target.value)}></input><br/>
        //             Date of Birth : <input type="text" value={dob} onChange={(e) => setDob(e.target.value)}></input><br/>
        //             Date of Joining : <input type="text" value={doj} onChange={(e) => setDoj(e.target.value)}></input><br/>
        //             <button type="submit">submit</button>

        //         </form>
        //     </div>
        // </div>
    )
}