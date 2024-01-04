import './App.css';
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import WebNavbar from './Components/Navbar';
import TicTacToe from './Games/TicTacToe';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (

    <Router>
      <WebNavbar />
      <Routes>
        <Route path="/" />
        <Route path="/TicTacToe" element={<TicTacToe/>} />
      </Routes>

    </Router>


  );
}

export default App;
