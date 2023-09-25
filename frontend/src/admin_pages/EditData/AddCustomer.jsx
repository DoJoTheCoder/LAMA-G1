import React, {useState, useEffect} from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'


export default function AddCustomer() {

    const [employeeId, setEmployeeId] = useState("");
    const [employeeName, setEmployeeName] = useState("");
    const [designation, setDesignation] = useState("");
    const [department, setDepartment] = useState("");
    const [dob, setDob] = useState(Date);
    const [doj, setDoj] = useState(Date);
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [gender, setGender] = useState("");
    const [accessType, setAccessType] = useState("");
    const [disabledField, setDisabledField] = useState(false);

    const param = useParams()
    const navigate = useNavigate()


    useEffect(() => {
        if (param.id === undefined) {
            setDisabledField(false)
        }
        else {
            console.log("update for " + param.id)
            setEmployeeId(param.id)
            setDisabledField(true)

            async function fetchData() {
                axios
                .get("http://localhost:8080/findEmp/" + param.id
                )
                .then((response) => {
                    console.log(response.data)
                    setEmployeeId(response.data.employeeId)
                    setEmployeeName(response.data.employeeName)
                    setAccessType(response.data.accessType)
                    setDepartment(response.data.department)
                    setDesignation(response.data.designation)
                    setDob(response.data.dob)
                    setDoj(response.data.doj)
                    setGender(response.data.gender)
                    setPassword(response.data.password)
                    setUserName(response.data.userName)
                })

            }

            fetchData();
        }
    }, []);


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
            dob : dob,
            accessType : accessType
        }
        console.log(sendBody);
        axios
            .post("http://localhost:8080/addEmployeeMaster", sendBody
                // title: "Hello World!",
                // body: JSON.stringify(sendBody)
            // }
            )
            .then((response) => {
                navigate("/admin/customer-data-management")
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
                    <input type="text" className="form-control" value={employeeId} disabled={disabledField} onChange={(e)=>setEmployeeId(e.target.value)}></input>

                    <label className="form-label fw-bold">Employee Name</label>
                    <input type="text" className="form-control" value={employeeName} onChange={(e)=>{setEmployeeName(e.target.value)}}></input>

                    <label className="form-label fw-bold">Enter Username</label>
                    <input type="text" className="form-control" value={userName} onChange={(e)=>{setUserName(e.target.value)}}></input>

                    <label className="form-label fw-bold">Enter Password</label>
                    <input type="text" className="form-control" value={password} onChange={(e)=>{setPassword(e.target.value)}}></input>

                    <label className="form-label fw-bold">Designation</label>
                    <input type="text" className="form-control" value={designation} onChange={(e)=>{setDesignation(e.target.value)}}></input>

                    <label className="form-label fw-bold">Department</label>
                    <input type="text" className="form-control" value={department} onChange={(e)=>{setDepartment(e.target.value)}}></input>

                    <label className="form-label fw-bold">Gender(M/F)</label>
                    <input type="text" className="form-control" value={gender} onChange={(e)=>setGender(e.target.value)}></input>

                    <label className="form-label fw-bold">Date of Birth</label>
                    <input type="date" className="form-control" value={dob} onChange={(e)=>setDob(e.target.value)}></input>

                    <label className="form-label fw-bold">Date of Joining</label>
                    <input type="date" className="form-control" value={doj} onChange={(e)=>setDoj(e.target.value)}></input>

                    <label className="form-label fw-bold">Access Type (Admin/User)?</label>
                    <input type="text" className="form-control" value={accessType} onChange={(e)=>setAccessType(e.target.value)}></input><br/>

                    <button type="button" className="btn btn-primary" onClick={handleNewRegisterSubmit}>Submit</button>
                </form>
            </div >
        </div >

    )
}