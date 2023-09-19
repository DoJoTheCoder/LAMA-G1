import React, { useEffect, useState } from "react";
import "./LoginPage.css"
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

export default function AdminLoginPage() {

    const [userName, setUserName] = useState("")
    const [password, setPassword] = useState("")
    const [validity, setValidity] = useState("Valid")

    const navigate = useNavigate();

    function handleLoginSubmit() {

        console.log(userName);
        console.log(password);

        const sendBody = {
            userName: userName,
            password: password
        };

        (async () => {

            axios
                .post("http://localhost:8080/validateLogin", sendBody
                    // {
                    //     title: "Hello World!",
                    //     body: JSON.stringify(sendBody)
                    // })
                )
                .then((response) => {
                    console.log(response)
                    setValidity(response.data);
                    console.log(validity)
                    if (response.data !== "Invalid" && response.data !== "Null Credentials" && response.data !== "") {
                        sessionStorage.setItem("UserName", JSON.stringify(userName))
                        sessionStorage.setItem("UserID", JSON.stringify(response.data))
                        // const validity = "Valid"
                        sessionStorage.setItem("Session", validity)
                        navigate("/home")
                    }
                }).catch(function (error) {
                    console.log(error);
                });

        })();

        // try {
        //     (async () => {
        //         const res = await fetch("http://localhost:8080/validateLogin", {
        //             // mode: "no-cors",
        //             method: "POST",
        //             headers: { "Content-Type": "application/json" },
        //             body: JSON.stringify(sendBody),
        //         });
        //         const data = res.body;
        //         console.log(data);
        //     })();
        // }
        // catch (e) {
        //     console.log(e)
        // }
    }
    return (
        <div className="py-5">
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>
                    <div className="loginForm1">
                        Admin Username
                        <input type="text" className="loginInputs" value={userName} onChange={(e) => { setUserName(e.target.value) }}></input>
                        Password
                        <input type="password" className="loginInputs" value={password} onChange={(e) => { setPassword(e.target.value) }}></input>
                    </div>
                    <div className="outLoginForm">
                        <button type="button" className="submitButton" onClick={handleLoginSubmit}>Admin Login</button><br />
                        New Admin? Click <Link to={"/newRegister"}>here</Link>.
                    </div>
                </form>
            </div>
        </div>
    )
}