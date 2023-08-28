import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ServiceList from "./components/service/ServiceList";
import CustomerList from "./components/customer/CustomerList";

function App() {
  return (
    <>
      <Header />
      <div className="min-vh-100">
        <CustomerList />
      </div>
      <Footer />
    </>
  );
}

export default App;
