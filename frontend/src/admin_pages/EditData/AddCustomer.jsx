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
    const [disabledField, setDisabledField] = useState(false)

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
                    <input type="text" className="form-control" disabled={disabledField} onChange={(e)=>setEmployeeId(e.target.value)}></input>


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

                    {/* <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1"></input>
                        <label class="form-check-label" for="inlineCheckbox1">1</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2"> </input>
                        <label class="form-check-label" for="inlineCheckbox2">2</label>
                    </div> */}




                    <label className="form-label fw-bold">Date of Birth</label>
                    <input type="date" className="form-control" onChange={(e)=>setDob(e.target.value)}></input>


                    <label className="form-label fw-bold">Date of Joining</label>
                    <input type="date" className="form-control" onChange={(e)=>setDoj(e.target.value)}></input>
                    <button type="button" className="btn btn-dark btn-lg px-4 mb-4 me-sm-3 text-nowrap" onClick={handleNewRegisterSubmit}>Submit</button>
                </form>
            </div >
        </div >

    )
}