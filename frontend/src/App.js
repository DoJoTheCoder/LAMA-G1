import './App.css';
// import LoginPage from './pages/Login/LoginPage';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import LoginPage from './pages/Login/LoginPage';
import RegisterationPage from './pages/RegisterationPage/RegisterationPage';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <RegisterationPage></RegisterationPage>
    </div>
  );
}

export default App;
