import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

export default function GetLoan() {

    //setting default value of emp Id as localstorage val
    const [employeeId, setEmployeeId] = useState("")
    const [itemCategory, setItemCategory] = useState("")
    const [itemMake, setItemMake] = useState("")
    const [itemDescription, setItemDescription] = useState("")
    const [itemValue, setItemValue] = useState("")
    const [itemCategoryArray, setItemCategoryArray] = useState([])
    const [itemMakeArray, setItemMakeArray] = useState([])
    const [itemDescArray, setItemDescArray] = useState([])
    const navigate = useNavigate();
    const itemMakeDropdown = document.getElementById("itemMakeInput")
    const itemDescDropdown = document.getElementById("itemDescriptionInput")

    useEffect(() => {
        console.log("Session " + (sessionStorage.getItem("Session")))

        if ((sessionStorage.getItem("Session")) !== "User") {
            navigate("/")
        }

        console.log("User:" + (sessionStorage.getItem("UserID")))
        setEmployeeId(JSON.parse(sessionStorage.getItem("UserID")))

        // for dropdown item category
        getItemCategoryData();

    }, [navigate]);

    function applyLoanSubmit(event) {

        event.preventDefault()
        console.log("submit button pressed")

        if (itemCategory === "") {
            alert("itemCategory is undefined");
        }
        else if (itemMake === "") {
            alert("itemMakeSelected is undefined");
        }
        else if (itemDescription === "") {
            alert("itemDescription is undefined");
        }
        else {
            console.log("Form Validated")
            const sendBody = {
                employeeId: employeeId,
                itemDescription: itemDescription
            }

            axios.post("http://localhost:8080/addNewLoan", sendBody)
                .then((response) => {
                    console.log(response.data)
                    if (response.data === "ok") {
                        alert("Added Loan successfully!")
                        navigate("/current-loans")
                    }

                    else
                        alert("Failed to add loan! Try again later.")
                })
                .catch((error) => { alert("Error: " + error) })
        }
    }

    const getItemCategoryData = () => {
        axios.get("http://localhost:8080/getAllItemCategories")
            .then((response) => { setItemCategoryArray(response.data); })
            .catch(error => { alert("error happened:" + error) });
    }

    const getItemMakeData = (itemCatSelected) => {
        // console.log("category selected:" + itemCatSelected)
        if (itemCatSelected !== "Null") {
            // console.log("not null")
            
            axios.get("http://localhost:8080/getItemMakes/"+itemCatSelected)
            .then((response) => {
                setItemMakeArray(response.data)
                itemMakeDropdown.disabled = false
            })
            .catch(error => {alert("error happened:"+error)});
        }
        else {
            itemMakeDropdown.disabled = true
            itemMakeDropdown.value = "Null"
        }
        itemDescDropdown.disabled = true
        itemDescDropdown.value = "Null"
        setItemValue("")


    }

    const getItemDescriptionData = (itemMakeSelected) => {
        console.log("Make selected:" + itemMakeSelected)
        if (itemMakeSelected !== "Null") {
            // console.log("not null")
            
            axios.get("http://localhost:8080/getItemDescriptions/"+itemCategory+"/"+itemMakeSelected)
            .then((response) => {
                setItemDescArray(response.data)
                itemDescDropdown.disabled = false
            })
            .catch(error => {alert("error happened:"+error)});
        }
        else {
            itemDescDropdown.disabled = true
            itemDescDropdown.value = "Null"
        }
        setItemValue("")
    }

    const setItemValueField = (itemDescSelected) => {
        // console.log("Desc selected:" + itemDescSelected)
        if (itemDescSelected !== "Null") {
            // console.log("not null")
            
            axios.get("http://localhost:8080/getItemValue/"+itemDescSelected)
            .then((response) => {
                setItemValue(response.data)
            })
            .catch(error => {alert("error happened:"+error)});
        }
        else {
            setItemValue("")
        }
    }

    return (

        <div className="py-5 lead fw-bold align-center">
            <h1>Get Loan</h1>
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form id="newLoanForm" onSubmit={(e) => applyLoanSubmit(e)}>
                    <div className="mb-3">
                        <label  className="form-label fw-bold">Employee Id</label>
                        <input type="text" className="form-control" 
                            value={employeeId} disabled></input>
                    </div>

                    <div className="input-group flex-fill mb-3">
                        <div className="input-group-prepend">
                            <label className="input-group-text" htmlFor="itemCategoryInput">Item Category</label>
                        </div>
                        <select className="custom-select" id="itemCategoryInput" defaultValue="Null" 
                        onChange={ (e) => { getItemMakeData(e.target.value); setItemCategory(e.target.value)}}>
                            <option key="None" value="Null">None</option>
                            {
                                itemCategoryArray.map((cat, index) => (
                                    <option key={cat} value={cat}>{cat}</option>
                                ))
                            }
                        </select>
                    </div>

                    <div className="input-group mb-3">
                        <div className="input-group-prepend">
                            <label className="input-group-text" htmlFor="itemMakeInput">Item Make</label>
                        </div>
                        <select className="custom-select" id="itemMakeInput" defaultValue="Null"
                            onChange={(e) => { getItemDescriptionData(e.target.value); setItemMake(e.target.value) }} disabled>
                            <option key="None" value="Null">None</option>
                            {
                                itemMakeArray.map((make, index) => (
                                    <option key={make} value={make}>{make}</option>
                                ))
                            }
                        </select>
                    </div>

                    <div className="input-group mb-3">
                        <div className="input-group-prepend">
                            <label className="input-group-text" htmlFor="itemDescriptionInput">Item Description</label>
                        </div>
                        <select className="custom-select" id="itemDescriptionInput" defaultValue="Null" 
                        onChange={(e) =>{ setItemDescription(e.target.value); setItemValueField(e.target.value) } } disabled>
                            <option key="None" value="Null">None</option>
                            {
                                itemDescArray.map((itemDesc, index) => (
                                    <option key={itemDesc} value={itemDesc}>{itemDesc}</option>
                                ))
                            }
                        </select>
                    </div>     

                    <div className="mb-3">
                        <label className="form-label fw-bold">Item value</label>
                        <input id='itemValueInput' type="text" value={itemValue} className="form-control" disabled></input>
                    </div>

                    <button id="submitBtn" type="submit" className="btn btn-dark btn-lg px-4 mb-4 me-sm-3 text-nowrap">Apply Loan</button>
                </form>
            </div>
        </div>
    )
}