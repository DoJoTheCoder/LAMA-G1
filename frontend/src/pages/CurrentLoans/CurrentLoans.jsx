import React from 'react'

export default function CurrentLoans() {
  return (
    <div>
    <h1>This is a list of Current Loans</h1>
    <table className="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Loan ID</th>
      <th scope="col">Loan Type</th>
      <th scope="col">Duration</th>
      {/* <th scope="col">Card Issue Date</th> */}
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>L0001</td>
      <td>Washing Machine</td>
      <td>5</td>
      {/* <td>1/1/2020</td> */}
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>L0002</td>
      <td>Microwave oven</td>
      <td>2</td>
      {/* <td>2/1/2023</td> */}
    </tr>
  </tbody>
</table>
    </div>
  )
}