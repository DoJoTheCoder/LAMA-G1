import React from 'react'

export default function GetLoan() {
  return (
    
    <div class="py-5">
        <h1>Get Loan</h1>
        <div class="card col-lg-4 d-flex mx-auto p-3">
        <form>
            <div class="mb-3">
                <label  class="form-label fw-bold">Employee Id</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Item Description</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Item make</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Item category</label>
                <input type="text" class="form-control"></input>
            </div>

            <div class="mb-3">
                <label  class="form-label fw-bold">Item value</label>
                <input type="text" class="form-control"></input>
            </div>

            <button type="submit" class="btn btn-primary">Apply Loan</button>
            </form>
        </div>
        </div>
  )
}