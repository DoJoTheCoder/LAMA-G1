import './App.css';
// import LoginPage from './pages/Login/LoginPage';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import LoginPage from './pages/Login/LoginPage';
import RegisterationPage from './pages/RegisterationPage/RegisterationPage';
import Home from './pages/Home/Home';
import GetLoan from './pages/GetLoan/GetLoan';
import CurrentLoans from './pages/CurrentLoans/CurrentLoans';
import ItemsPurchased from './pages/ItemsPurchased/ItemsPurchased';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <Router>

        {/* <Routes>
        <Route exact path ="/login" element={<LoginPage/>}></Route>

        <Route exact path ="/user" element={<Navbar/>}></Route>
        <Route exact path ="/user/" element={<Home/>}></Route>
        <Route exact path ="/user/get-loan" element={<GetLoan/>}></Route>
        <Route exact path ="/user/current-loans" element={<CurrentLoans/>}></Route>
        <Route exact path ="/user/items-purchased" element={<ItemsPurchased/>}></Route>
        
        </Routes> */}

        <Navbar callFrom="appPage"></Navbar>
        <Routes>
          <Route exact path="/" element={<LoginPage />}></Route>          
          <Route exact path="/login" element={<LoginPage />}></Route>
          <Route exact path="newRegister" element={<RegisterationPage></RegisterationPage>}></Route>
          <Route exact path="/home" element={<Home />}></Route>
          <Route exact path="/get-loan" element={<GetLoan />}></Route>
          <Route exact path="/current-loans" element={<CurrentLoans />}></Route>
          <Route exact path="/items-purchased" element={<ItemsPurchased />}></Route>
          {/* <Route exact path = "loanList" element={<CurrentLoans></CurrentLoans>}></Route> */}
        </Routes>

      </Router>
    </div>
  );
}

export default App;
