import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import RoleSelect from "./layout/SelectUser";
import Navbar from "./layout/Navbar";
import AdminNavbar from "./layout/AdminNavbar";

import Home from "./pages/Home/Home";
import RegisterationPage from "./pages/RegisterationPage/RegisterationPage";
import GetLoan from "./pages/GetLoan/GetLoan";
import CurrentLoans from "./pages/CurrentLoans/CurrentLoans";
import ItemsPurchased from "./pages/ItemsPurchased/ItemsPurchased";

import AdminLoginPage from "./admin_pages/Login/LoginPage";
import AdminHome from "./admin_pages/Home/Home";
import AdminLoanCardManagement from "./admin_pages/LoanMaster/LoanCardManagement";
import AdminItemMasterManagement from "./admin_pages/ItemMasterManagement/ItemMasterManagement";
import CustomerDataManagement from "./admin_pages/CustomerMaster/CustomerDataManagement";

import AddItem from "./admin_pages/EditData/AddItem";
import AddLoan from "./adminw_pages/EditData/AddLoan";
import AddCustomer from "./admin_pages/EditData/AddCustomer";
import NotFound from "./layout/InvalidURL";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<RoleSelect />}></Route>

          {/* USER PAGES BELOW */}
          {/* <Route exact path="/login" element={<LoginPage />}></Route> */}
          <Route
            exact
            path="/user-new-register"
            element={<RegisterationPage from="user"></RegisterationPage>}
          ></Route>
          <Route
            exact
            path="/home"
            element={
              <div>
                <Navbar /> <Home />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/get-loan"
            element={
              <div>
                <Navbar />
                <GetLoan />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/current-loans"
            element={
              <div>
                <Navbar />
                <CurrentLoans />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/items-purchased"
            element={
              <div>
                <Navbar />
                <ItemsPurchased />
              </div>
            }
          ></Route>

          {/* ADMIN PAGES BELOW */}
          <Route exact path="/admin/login" element={<AdminLoginPage />}></Route>
          <Route
            exact
            path="/admin-new-register"
            element={<RegisterationPage from="admin"></RegisterationPage>}
          ></Route>
          <Route
            exact
            path="/admin/home"
            element={
              <div>
                <AdminNavbar /> <AdminHome />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/customer-data-management"
            element={
              <div>
                <AdminNavbar /> <CustomerDataManagement />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/loan-card-management"
            element={
              <div>
                <AdminNavbar />
                <AdminLoanCardManagement />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/item-master-management"
            element={
              <div>
                <AdminNavbar /> <AdminItemMasterManagement />
              </div>
            }
          ></Route>

          {/* Note ADD and EDIT pages are the same */}
          {/* Add Data paths */}
          <Route
            exact
            path="/admin/addItemMaster"
            element={
              <div>
                <AdminNavbar /> <AddItem />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/addLoanMaster"
            element={
              <div>
                <AdminNavbar /> <AddLoan />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/addCustomer"
            element={
              <div>
                <AdminNavbar /> <AddCustomer />
              </div>
            }
          ></Route>

          {/* Edit Data paths */}
          <Route
            exact
            path="/admin/addItemMaster/:id"
            element={
              <div>
                <AdminNavbar />
                <AddItem />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/addLoanMaster/:id"
            element={
              <div>
                <AdminNavbar />
                <AddLoan />
              </div>
            }
          ></Route>
          <Route
            exact
            path="/admin/addCustomer/:id"
            element={
              <div>
                <AdminNavbar />
                <AddCustomer />
              </div>
            }
          ></Route>

          {/* For Invalid Paths */}
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
