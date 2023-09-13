import React from 'react'

export default function ItemsPurchased() {
  return (
    <div>
    <h1>This is the list of Purchased Items</h1>
    <table className="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Loan ID</th>
      <th scope="col">Item Description</th>
      <th scope="col">Item make</th>
      <th scope="col">Item category</th>
      <th scope="col">Item valuation</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>L0001</td>
      <td>Washing Machine</td>
      <td>Steel</td>
      <td>Appliance</td>
      <td>35000</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>L0002</td>
      <td>Microwave oven</td>
      <td>Steel</td>
      <td>Appliance</td>
      <td>22000</td>
    </tr>
  </tbody>
</table>
    </div>
  )
}