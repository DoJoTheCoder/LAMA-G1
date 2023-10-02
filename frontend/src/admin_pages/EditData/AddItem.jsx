import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

export default function AddItem() {
  const [itemId, setItemId] = useState("");
  const [itemDescription, setItemDescription] = useState("");
  const [issueStatus, setIssueStatus] = useState("");
  const [itemMake, setItemMake] = useState("");
  const [itemCategory, setItemCategory] = useState("");
  const [itemValuation, setItemValuation] = useState(0);
  const [disabledField, setDisabledField] = useState(false);

  const param = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (param.id === undefined) {
      setDisabledField(false);
    } else {
      console.log("update for " + param.id);
      setItemId(param.id);
      setDisabledField(true);

      async function fetchData() {
        axios
          .get("http://localhost:8080/getItemById/" + param.id)
          .then((response) => {
            console.log(response.data);
            setItemDescription(response.data.itemDescription);
            setIssueStatus(response.data.issueStatus);
            setItemCategory(response.data.itemCategory);
            setItemMake(response.data.itemMake);
            setItemValuation(response.data.itemValuation);
          });
      }

      fetchData();
    }
  }, []);

  function handleNewItemAddSubmit() {
    const sendBody = {
      itemId: itemId,
      itemDescription: itemDescription,
      issueStatus: issueStatus,
      itemMake: itemMake,
      itemCategory: itemCategory,
      itemValuation: itemValuation,
    };

    console.log(sendBody);

    axios
      .post(
        "http://localhost:8080/addItemMaster",
        sendBody
        // title: "Hello World!",
        // body: JSON.stringify(sendBody)
        // }
      )
      .then((response) => {
        console.log(response);
        navigate("/admin/item-master-management");
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  const onSubmit = async (event) => {
    event.preventDefault(); // Prevent default submission
    handleNewItemAddSubmit();
  };

  return (
    <div className="py-5 lead">
      <div className="card col-lg-4 d-flex mx-auto p-3 lead fw-bold">
        <h2 class="title">Add/Modify item</h2>
        <form onSubmit={onSubmit}>
          <label className="form-label mt-4 fw-bold">Item Id</label>
          <input
            type="text"
            className="form-control"
            required
            value={itemId}
            disabled={disabledField}
            onChange={(e) => {
              setItemId(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Item Description</label>
          <input
            type="text"
            className="form-control"
            required
            value={itemDescription}
            onChange={(e) => {
              setItemDescription(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Issue Status (Y/N)</label>
          <select
            type="text"
            className="form-control"
            required
            value={issueStatus}
            onChange={(e) => {
              setIssueStatus(e.target.value);
            }}
          >
            <option key="Y" value="Y">
              Y
            </option>
            <option key="N" value="N">
              N
            </option>
          </select>

          <label className="form-label mt-4 fw-bold">Item Make</label>
          <input
            type="text"
            className="form-control"
            required
            value={itemMake}
            onChange={(e) => {
              setItemMake(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Item Category</label>
          <input
            type="text"
            className="form-control"
            required
            value={itemCategory}
            onChange={(e) => {
              setItemCategory(e.target.value);
            }}
          ></input>

          <label className="form-label mt-4 fw-bold">Item Valuation</label>
          <input
            type="text"
            className="form-control"
            required
            value={itemValuation}
            onChange={(e) => {
              setItemValuation(e.target.value);
            }}
          ></input>

          <button
            type="submit"
            className="btn btn-dark btn-lg px-4 m-4 me-sm-3 text-nowrap"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}
