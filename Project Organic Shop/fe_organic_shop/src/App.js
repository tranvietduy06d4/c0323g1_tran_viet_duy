
import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import "react-toastify/dist/ReactToastify.css";
import { Routes,Route,BrowserRouter } from 'react-router-dom';
import Home from './components/home/Home';
import Login from './components/login/Login';
import ProductDetail from './components/product/ProductDetail';
import Register from './components/login/Register';
import Cart from './components/order/Cart';

function App() {
  return (
    <>

    <Routes>
      <Route path='/' element={<Home />} ></Route>
      <Route path='/login' element={<Login />} ></Route>
      <Route path='/register' element={<Register />} ></Route>
      <Route path='/detail/:id' element={<ProductDetail />} ></Route>
      <Route path='/cart' element={<Cart />} ></Route>

    </Routes>

    </>
  );
}

export default App;
