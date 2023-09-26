import React, { useEffect, useState } from "react";
import "./LoginPage.css"
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

export default function AdminLoginPage() {

    const [userName, setUserName] = useState("")
    const [password, setPassword] = useState("")

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
                    console.log(response.data)
                    if (response.data[0] === "User") {
                        console.log("Hello User")
                        sessionStorage.setItem("UserName", JSON.stringify(userName))
                        sessionStorage.setItem("UserID", JSON.stringify(response.data[1]))
                        sessionStorage.setItem("Session", response.data[0])
                        navigate("/home")
                    }
                    else{
                        alert("Invalid credentials")
                        setPassword("");
                        setUserName("")
                    }
                }).catch(function (error) {
                    console.log(error.response);
                    alert(error.response.data.message)
                    setPassword("");
                    setUserName("");
                });

        })();
    }
    return (
        <div className="py-4">
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>
                    <div className="loginForm1">
                        Employee Username<br/>
                        <input type="text" className="loginInputs" value={userName} onChange={(e) => { setUserName(e.target.value) }}></input><br/>
                        Password<br/>
                        <input type="password" className="loginInputs" value={password} onChange={(e) => { setPassword(e.target.value) }}></input><br/>
                    </div>
                    <div className="outLoginForm">
                        <button type="button" className="submitButton" onClick={handleLoginSubmit}>Login</button><br />
                        New User? Click <Link to={"/user-new-register"}>here</Link>.
                    </div>
                </form>
            </div>
        </div>
    )
}