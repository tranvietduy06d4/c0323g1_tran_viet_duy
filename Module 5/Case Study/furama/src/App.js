import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import CustomerCreate from "./components/customer/CustomerCreate";

function App() {
  return (
    <>
      <Header />
      <div className="min-vh-100">
        <CustomerCreate />
      </div>
      <Footer />
    </>
  );
}

export default App;
