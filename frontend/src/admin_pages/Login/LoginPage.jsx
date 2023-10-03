import React, { useState } from "react";
import "./LoginPage.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function AdminLoginPage() {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  function handleLoginSubmit() {
    console.log(userName);
    console.log(password);

    const sendBody = {
      userName: userName,
      password: password,
    };

        (async () => {

            axios
                .post("http://localhost:8080/validateLogin", sendBody)
                .then((response) => {
                    console.log(response)
                    if (response.data[0] === "Admin") {
                        console.log("Hello admin")
                        sessionStorage.setItem("UserName", JSON.stringify(userName))
                        sessionStorage.setItem("UserID", JSON.stringify(response.data[1]))
                        sessionStorage.setItem("Session", response.data[0])
                        navigate("/admin/home")
                    }
                    else{
                        alert("Invalid credentials")
                        setPassword("");
                        setUserName("")
                    }
                }).catch(function (error) {
                    console.log(error.response)
                    alert(error.response.data.message)
                });

        })();

    }
    return (
        <div className="py-4">
            <div className="card col-lg-4 d-flex mx-auto p-3">
                <form>
                    <div className="loginForm1 lead fw-bold">
                        Admin Username<br/>
                        <input type="text" className="loginInputs lead mb-4 fw-light" value={userName} onChange={(e) => { setUserName(e.target.value) }}></input><br/>
                        Password<br/>
                        <input type="password" className="loginInputs lead mb-2 fw-light" value={password} onChange={(e) => { setPassword(e.target.value) }}></input><br/>
                    </div>
                    <div className="outLoginForm lead">
                        <button type="button" className="btn btn-dark btn-lg px-4 mb-4 me-sm-3 text-nowrap"  onClick={handleLoginSubmit}>Login</button><br />
                        New Admin? Click <Link className= "link-dark" to={"/admin-new-register"}>here</Link>.
                    </div>
                </form>
            </div>
        </div>
    )
}
