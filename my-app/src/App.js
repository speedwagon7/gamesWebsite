import './App.css';
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import WebNavbar from './Components/Navbar';
import TicTacToe from './Games/TicTacToe';
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from './Login/LoginPage';

function App() {
  return (

    <Router>
      <WebNavbar />
      <Routes>
        <Route path="/" />
        <Route path="/Login" element={<LoginPage/>}/>
        <Route path="/TicTacToe" element={<TicTacToe/>} />
      </Routes>

    </Router>


  );
}

export default App;
