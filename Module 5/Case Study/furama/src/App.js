import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ServiceCreate from "./components/service/ServiceCreate";

function App() {
  return (
    <>
      <Header />
      <div className="min-vh-100">
        <ServiceCreate />
      </div>
      <Footer />
    </>
  );
}

export default App;
