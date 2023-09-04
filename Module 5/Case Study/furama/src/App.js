import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ServiceList from "./components/service/ServiceList";
import ServiceEdit from "./components/service/ServiceEdit";
import CustomerList from "./components/customer/CustomerList";
import CustomerEdit from "./components/customer/CustomerEdit";
import CustomerCreate from "./components/customer/CustomerCreate";
import ServiceCreate from "./components/service/ServiceCreate";
import ContractList from "./components/contract/ContractList";
import ContractCreate from "./components/contract/ContractCreate";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  return (
    <>

      <BrowserRouter>
      <Header/>
        <Routes>
          <Route path="/" element={<ServiceList />} />
          <Route path="/facility/edit/:id" element={<ServiceEdit />} />
          <Route path="/facility/create" element={<ServiceCreate />} />
          <Route path="/customer/list" element={<CustomerList />} />
          <Route path="/customer/:id" element={<CustomerEdit />} />
          <Route path="/customer/create" element={<CustomerCreate />} />
          <Route path="/contract/list" element={<ContractList />} />
          <Route path="/contract/create" element={<ContractCreate />} />
        </Routes>
        <Footer /> 
      </BrowserRouter>
 
    </>
  );
}

export default App;
