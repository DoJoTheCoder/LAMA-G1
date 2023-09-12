import React, { useState } from "react";

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

    function handleLoginSubmit(){
        console.log(employeeId);
    }

    return (
        <div class="py-5">
        <div class="card col-lg-4 d-flex mx-auto p-3">
        <form>
            <div class="mb-3">
                <label  class="form-label fw-bold">Employee Id</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Employee Name</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Enter Username</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Enter Password</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Designation</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Gender(M/F)</label>
                <input type="text" class="form-control"></input>
            </div>
            {/* this is a comment */}

            <div class="mb-3">
                <label  class="form-label fw-bold">Date of Birth</label>
                <input type="date" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Date of Joining</label>
                <input type="date" class="form-control"></input>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        </div>

        // <div>
        //     <div className="registerationForm">
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