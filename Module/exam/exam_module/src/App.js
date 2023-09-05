import { BrowserRouter, Routes, Route } from "react-router-dom";
import { React } from "react";
import ProductList from "./components/ProductList";
import ProductEdit from "./components/ProductEdit";
// import {ProductList} from "../src/components/ProductList";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ProductList />} />
          <Route path="/edit/:id" element={<ProductEdit />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
