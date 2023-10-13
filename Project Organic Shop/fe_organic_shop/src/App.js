
import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import { Routes,Route,BrowserRouter } from 'react-router-dom';
import Home from './components/home/Home';
import Login from './components/login/Login';

function App() {
  return (
    <>

    <Routes>
      <Route path='/' element={<Home />} ></Route>
      <Route path='/home/login' element={<Login />} ></Route>
    </Routes>

    </>
  );
}

export default App;
