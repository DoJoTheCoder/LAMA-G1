import React, { useState } from "react";
import "./LoginPage.css"
import { Link } from "react-router-dom";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css'

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
        <div className="py-5">
        <div className="card col-lg-4 d-flex mx-auto p-3">
        <form>
            <div className="mb-3">
                <label  className="form-label fw-bold">Employee Id</label>
                <input type="text" className="form-control"></input>
            </div>
            <div className="mb-3">
                <label className="form-label fw-bold">Password</label>
                <input type="password" className="form-control"></input>
            </div>
            <button type="submit" className="btn btn-primary">Login</button>
            </form>
        </div>
        </div>
    )
}