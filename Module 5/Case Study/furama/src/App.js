import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ServiceList from "./components/service/ServiceList";

function App() {
  return (
    <>
      <Header />
      <div className="min-vh-100">
        <ServiceList />
      </div>
      <Footer />
    </>
  );
}

export default App;
