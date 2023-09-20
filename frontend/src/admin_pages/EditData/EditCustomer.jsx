import React, {useState, useEffect} from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

export default function EditCustomer() {

    //setting default value of emp Id as localstorage val
    const [employeeId, setEmployeeId] = useState("E10001")
    const [itemCategory, setItemCategory] = useState("")
    const [itemDescription, setItemDescription] = useState("")
    const [itemValue, setItemValue] = useState("")
    const [itemMake, setItemMake] = useState("")
    const [itemCategoryArray, setItemCategoryArray] = useState([])
    const navigate = useNavigate();


    useEffect(() => {
        getItemCategoryData();

        //This is to check if user is logged in before allowing apply loan
        //TODO: Uncomment after completing the login and session management
        // checkLoginStatus();
        
        //
    }, [navigate]);

    function checkLoginStatus(){
        const isLoggedIn = localStorage.getItem('employeeId');
        if (!isLoggedIn) {
            alert("Please login to continue!")
            navigate('/');
        }
        else{
          setEmployeeId(isLoggedIn)
        }
    }

    function EditCustomer() {
        alert("Edit Customer button clicked!")
    }

    const getItemCategoryData = () => {
        axios.get("http://localhost:8080/getAllItemCategories")
            .then((response) => {setItemCategoryArray(response.data);})
            .catch(error => {alert("error happened:"+error)});
    }


    return (

        <div className="py-5">
            <h1>Get Loan</h1>
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>
                    <div className="mb-3">
                        <label  className="form-label fw-bold">Employee Id</label>
                        <input type="text" className="form-control" 
                            value={employeeId} disabled></input>
                    </div>

                    <div className="input-group mb-3">
                        <div className="input-group-prepend">
                            <label className="input-group-text" htmlFor="itemCategoryInput">Item Category</label>
                        </div>
                        <select className="custom-select" id="itemCategoryInput">
                            {
                                itemCategoryArray.map((cat,index) =>(
                                    <option key={cat} value={cat}>{cat}</option>
                                ))
                            }
                        </select>
                    </div>

                    <div className="input-group mb-3">
                        <div className="input-group-prepend">
                            <label className="input-group-text" htmlFor="itemMakeInput">Item Make</label>
                        </div>
                        <select className="custom-select" id="itemMakeInput">
                            <option value="1">none</option>
                        </select>
                    </div>

                    <div className="mb-3">
                        <label  className="form-label fw-bold">Item Description</label>
                        <input type="text" className="form-control"onChange={(e) => setItemDescription(e.target.value)}></input>
                    </div>

                    

                    <div className="mb-3">
                        <label  className="form-label fw-bold">Item value</label>
                        <input type="text" className="form-control"></input>
                    </div>

                            {/* TODO: add onclick functionality */}
                    <button type="submit" className="btn btn-primary" >Save Customer</button>
                </form>
            </div>
        </div>
    )
}