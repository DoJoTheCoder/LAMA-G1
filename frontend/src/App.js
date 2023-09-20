import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import RoleSelect from './layout/SelectUser';
import Navbar from './layout/Navbar';
import AdminNavbar from './layout/AdminNavbar';


import LoginPage from './pages/Login/LoginPage';
import Home from './pages/Home/Home';
import RegisterationPage from './pages/RegisterationPage/RegisterationPage';
import GetLoan from './pages/GetLoan/GetLoan';
import CurrentLoans from './pages/CurrentLoans/CurrentLoans';
import ItemsPurchased from './pages/ItemsPurchased/ItemsPurchased';
import EmployeeAdmin from './admin/EmployeeAdmin/EmployeeAdmin';


import AdminLoginPage from './admin_pages/Login/LoginPage';
import AdminHome from './admin_pages/Home/Home';
import AdminLoanCardManagement from './admin_pages/LoanMaster/LoanCardManagement';
import AdminItemMaster from './admin_pages/ItemMaster/ItemMaster';
import AdminCustomerDataManagement from './admin_pages/CustomerMaster/CustomerDataManagement';

import AddItem from './admin_pages/EditData/AddItem';
import AddLoan from './admin_pages/EditData/AddLoan';
import EditLoan from './admin_pages/EditData/EditLoan';



function App() {
  return (
    <div className="App">
      <Router>
        

        <Routes>
          <Route exact path="/selectRole" element={<RoleSelect/>}></Route>


          {/* USER PAGES BELOW */}
          <Route exact path="/" element={<LoginPage />}></Route>          
          <Route exact path="/login" element={<LoginPage />}></Route>
          <Route exact path="/newRegister" element={<RegisterationPage></RegisterationPage>}></Route>
          <Route exact path="/home" element={<div><Navbar /> <Home /></div>}></Route>
          <Route exact path="/get-loan" element={<div><Navbar /><GetLoan /></div>}></Route>
          <Route exact path="/current-loans" element={<div><Navbar /><CurrentLoans /></div>}></Route>
          <Route exact path="/items-purchased" element={<div><Navbar /><ItemsPurchased /></div>}></Route>


          
          {/* ADMIN PAGES BELOW */}
          <Route exact path="/admin" element={<AdminLoginPage />}></Route>
          <Route exact path="/admin/home" element={<div><AdminNavbar /> <AdminHome /></div>}></Route>
          <Route exact path="/admin/login" element={<AdminLoginPage />}></Route>
          <Route exact path="/admin/customer-data-management" element={<div><AdminNavbar /> <AdminCustomerDataManagement /></div>}></Route>
          <Route exact path="/admin/loanCardManagement" element={<div><AdminNavbar /><AdminLoanCardManagement /></div>}></Route>
          <Route exact path="/admin/item-master-data" element={<div><AdminNavbar /><AdminItemMaster /></div>}></Route>
          <Route exact path="/admin/addItemMaster" element={<AddItem/>}></Route>
          <Route exact path="/admin/addLoanMaster" element={<AddLoan/>}></Route>
          
          {/* Note ADD and EDIT pages are the same */}
          <Route exact path="/admin/edit-loan" element={<EditLoan/>}></Route>
          <Route exact path="/admin/edit-customer" element={<EmployeeAdmin />}></Route>
          <Route exact path="/admin/edit-item" element={<EmployeeAdmin />}></Route>

          {/* <Route exact path = "loanList" element={<CurrentLoans></CurrentLoans>}></Route> */}


        </Routes>

      </Router>
    </div>
  );
}

export default App;
