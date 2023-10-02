import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

export default function AddLoan() {
  const [loanId, setLoanId] = useState("");
  const [loanType, setLoanType] = useState("");
  const [duratinInYears, setDurationInYears] = useState(1);
  const [disabledField, setDisableField] = useState(false);
  const param = useParams();

  const navigate = useNavigate();

  useEffect(() => {
    if (param.id === undefined) {
      setDisableField(false);
    } else {
      setLoanId(param.id);
      setDisableField(true);
      async function fetchData() {
        axios
          .get("http://localhost:8080/findLoan/" + param.id)
          .then((response) => {
            console.log(response.data);
            setLoanType(response.data.loanType);
            setDurationInYears(response.data.durationInYears);
          });
      }

      fetchData();
    }
  }, []);

  function handleNewLoanddSubmit() {
    const sendBody = {
      loanId: loanId,
      loanType: loanType,
      durationInYears: duratinInYears,
    };

    console.log(sendBody);

    // if (param.id === undefined) {
    axios
      .post(
        "http://localhost:8080/addLoanCardMaster",
        sendBody
        // title: "Hello World!",
        // body: JSON.stringify(sendBody)
        // }
      )
      .then((response) => {
        console.log(response);

        navigate("/admin/loan-card-management");
      })
      .catch(function (error) {
        console.log(error);
      });
    // }
    // else{
    //     console.log("edit-LoanCard")
    //     axios
    //         .put("http://localhost:8080/editLoan/"+{loanId}, sendBody
    //             // title: "Hello World!",
    //             // body: JSON.stringify(sendBody)
    //             // }
    //         )
    //         .then((response) => {
    //             console.log(response);

    //             navigate("/admin/loan-card-management")
    //         }).catch(function (error) {
    //             console.log(error);
    //         });
    // }
  }
  // if (param === {}) {

  //     return (
  //         <div>
  //             {console.log(param)}
  //             <div className="card col-lg-4 d-flex mx-auto p-3">
  //                 <form>

  //                     <label className="form-label fw-bold">Loan Id</label>
  //                     <input type="text" className="form-control" onChange={(e) => { setLoanId(e.target.value) }}></input>

  //                     <label className="form-label fw-bold">Loan type</label>
  //                     <input type="text" className="form-control" onChange={(e) => { setLoanType(e.target.value) }}></input>

  //                     <label className="form-label fw-bold">Duration in years</label>
  //                     <input type="number" className="form-control" onChange={(e) => { setDurationInYears(e.target.value) }}></input>

  //                     <button type="button" className="btn btn-primary" onClick={handleNewItemAddSubmit}>Submit</button>
  //                 </form>
  //             </div >
  //         </div>
  //     )
  // }

  // else {

  const onSubmit = async (event) => {
    event.preventDefault();
    if(duratinInYears>0){
      handleNewLoanddSubmit();
    }
    else{
      alert("Invalid Duration of Years : " + duratinInYears)
    }
    
  };

  return (
    <div className="py-5 lead">
      <div className="card col-lg-4 d-flex mx-auto p-3 lead fw-bold">
        <h2 class="title">Add/Modify Loan</h2>
        <form onSubmit={onSubmit}>
          <label className="form-label mt-4 fw-bold">Loan Id</label>
          <input
            type="text"
            className="form-control"
            required
            value={loanId}
            disabled={disabledField}
            onChange={(e) => {
              setLoanId(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Loan type</label>
          <input
            type="text"
            className="form-control"
            required
            value={loanType}
            disabled={disabledField}
            onChange={(e) => {
              setLoanType(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Duration in years</label>
          <input
            type="number"
            className="form-control"
            required
            value={duratinInYears}
            onChange={(e) => {
              setDurationInYears(e.target.value);
            }}
          ></input>

          <button
            type="submit"
            className="btn btn-dark btn-lg px-4 m-4 me-sm-3 text-nowrap"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}
