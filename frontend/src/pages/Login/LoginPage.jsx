import React, { useState } from "react";
import "./LoginPage.css"
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

export default function LoginPage() {

    const [userName, setUserName] = useState("")
    const [password, setPassword] = useState("")
    const [validity, setValidity] = useState("")

    const navigate = useNavigate();

    function handleLoginSubmit() {

        console.log(userName);
        console.log(password);

        const sendBody = {
            userName: userName,
            password: password
        };

        console.log(sendBody)

        axios
            .post("http://localhost:8080/validateLogin", sendBody
            // {
            //     title: "Hello World!",
            //     body: JSON.stringify(sendBody)
            // })
            )
            .then((response) => {
                setValidity(response.data);
                console.log(validity)
            }).catch(function (error){
                console.log(error);
            });

            if(validity=== "Valid"){
                navigate("/home")
            }

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
        <div>
            <div>
                <form>
                    <div className="loginForm">
                        Employee Username
                        <input type="text" className="loginInputs" value={userName} onChange={(e)=>{setUserName(e.target.value)}}></input>
                        Password
                        <input type="password" className="loginInputs" value={password} onChange={(e)=>{setPassword(e.target.value)}}></input>
                    </div>
                    <div className="outLoginForm">
                    <button type="button" className="submitButton" onClick={handleLoginSubmit}>Login</button><br/>
                    New User? Click <Link to={"/newRegister"}>here</Link>.
                    </div>
                </form>
            </div>
        </div>
    )
}