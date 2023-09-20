import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

export default function AddItem() {

    const [itemId, setItemId] = useState("")
    const [itemDescription, setItemDescription] = useState("")
    const [issueStatus, setIssueStatus] = useState('')
    const [itemMake, setItemMake] = useState("")
    const [itemCategory, setItemCategory] = useState("")
    const [itemValuation, setItemValuation] = useState(100)
    const [disabledField, setDisabledField] = useState(false)

    const param = useParams()
    const navigate = useNavigate()


    useEffect(() => {
        if (param.id === undefined) {
            setDisabledField(false)
        }
        else {
            console.log("update for " + param.id)
            setItemId(param.id)
            setDisabledField(true)
        }
    }, []);

    function handleNewItemAddSubmit() {

        const sendBody = {
            itemId: itemId,
            itemDescription: itemDescription,
            issueStatus: issueStatus,
            itemMake: itemMake,
            itemCategory: itemCategory,
            itemValuation: itemValuation
        }

        console.log(sendBody)

        axios
            .post("http://localhost:8080/addItemMaster", sendBody
                // title: "Hello World!",
                // body: JSON.stringify(sendBody)
                // }
            )
            .then((response) => {
                console.log(response);
                navigate("/admin/item-master-management")
            }).catch(function (error) {
                console.log(error);
            });
    }

    return (
        <div>
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>

                    <label className="form-label fw-bold">Item Id</label>
                    <input type="text" className="form-control" value={itemId} disabled={disabledField} onChange={(e) => { setItemId(e.target.value) }}></input>


                    <label className="form-label fw-bold">Item Description</label>
                    <input type="text" className="form-control" onChange={(e) => { setItemDescription(e.target.value) }}></input>


                    <label className="form-label fw-bold">Issue Status (Y/N)</label>
                    <input type="text" className="form-control" onChange={(e) => { setIssueStatus(e.target.value) }}></input>


                    <label className="form-label fw-bold">Item Make</label>
                    <input type="text" className="form-control" onChange={(e) => { setItemMake(e.target.value) }}></input>


                    <label className="form-label fw-bold">Item Category</label>
                    <input type="text" className="form-control" onChange={(e) => { setItemCategory(e.target.value) }}></input>

                    <label className="form-label fw-bold">Item Valuation</label>
                    <input type="text" className="form-control" onChange={(e) => { setItemValuation(e.target.value) }}></input>

                    <button type="button" className="btn btn-primary" onClick={handleNewItemAddSubmit}>Submit</button>
                </form>
            </div >
        </div>
    )
}