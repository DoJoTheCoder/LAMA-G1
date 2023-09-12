import React, { useState } from "react";
import "./LoginPage.css"

export default function LoginPage() {

    const [userName, setUserName] = useState("")
    const [password, setPassword] = useState("")

    function handleLoginSubmit() {
        console.log(userName);
        console.log(password);

        const sendBody = {
            username: userName,
            password: password,
        };
        try {
            (async () => {
                const response = await fetch("https://localhost:8080/validateLogin", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(sendBody),
                });
                const data = await response.json()
                console.log(data);
            })();
        }
        catch (e) {
            console.log(e)
        }
    }
    return (
        <div>
            <div className="loginForm">
                <form onSubmit={handleLoginSubmit}>

                    <h3>Login Page</h3>
                    <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)}></input>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}></input>
                    <button type="submit">submit</button>

                </form>
            </div>
        </div>
    )
}