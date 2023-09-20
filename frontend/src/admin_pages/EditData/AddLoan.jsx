import React, { useState } from "react";
import axios from "axios";

export default function AddLoan() {

    const [loanId, setLoanId] = useState("")
    const [loanType, setLoanType] = useState("")
    const [duratinInYears, setDurationInYears] = useState(1)

    function handleNewItemAddSubmit() {

        const sendBody = {
            loanId : loanId,
            loanType : loanType,
            durationYears : duratinInYears
        }

        console.log(sendBody)

        axios
        .post("http://localhost:8080/addLoanCardMaster", sendBody
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
        <div>
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>

                    <label className="form-label fw-bold">Loan Id</label>
                    <input type="text" className="form-control" onChange={(e) => { setLoanId(e.target.value) }}></input>


                    <label className="form-label fw-bold">Loan type</label>
                    <input type="text" className="form-control" onChange={(e) => { setLoanType(e.target.value) }}></input>


                    <label className="form-label fw-bold">Duration in years</label>
                    <input type="number" className="form-control" onChange={(e) => { setDurationInYears(e.target.value) }}></input>

                    <button type="button" className="btn btn-primary" onClick={handleNewItemAddSubmit}>Submit</button>
                </form>
            </div >
        </div>
    )
}