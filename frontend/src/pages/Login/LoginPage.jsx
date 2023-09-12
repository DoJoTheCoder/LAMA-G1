import React, { useState } from "react";
import "./LoginPage.css"
import { Link } from "react-router-dom";
import axios from "axios";

export default function LoginPage() {

    const [userName, setUserName] = useState("")
    const [password, setPassword] = useState("")

    function handleLoginSubmit() {

        console.log(userName);
        console.log(password);

        const sendBody = {
            userName: userName,
            password: password
        };

        console.log(sendBody)

        axios
            .post("http://localhost:8080/validateLogin", {
                title: "Hello World!",
                body: JSON.stringify(sendBody)
            })
            .then((response) => {
                console.log(response.data);
            });

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
            <div className="loginForm">
                <h3>Login Page</h3>
                <form>
                    Username : <input className="loginInputs" type="text" value={userName} onChange={(e) => setUserName(e.target.value)}></input><br />
                    Password : <input className="loginInputs" type="password" value={password} onChange={(e) => setPassword(e.target.value)}></input><br />
                    <button type="button" className="submitButton" onClick={handleLoginSubmit}>submit</button><br />

                    New User? Register <Link to="/newRegisteration">here</Link>

                </form>
            </div>
        </div>
    )
}