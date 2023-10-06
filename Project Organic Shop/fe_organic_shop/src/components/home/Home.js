import Footer from "../footer/Footer";
import Header from "../header/Header";
import Carousel from "./Carousel";
import { AiOutlineEye } from "react-icons/ai";
import { BiShoppingBag } from "react-icons/bi";

const Home = () => {
  return (
    <div className="min-height-300">
      <Header />
      <Carousel />
      <div className="container-xxl py-5">
        <div className="container">
          <div className="row align-items-end">
            <div className="col-lg-6">
              <div
                className="section-header text-start mb-5"
                style={{ maxWidth: 500 }}
              >
                <h1 className="display-5 mb-3">Sản phẩm</h1>
              </div>
            </div>
            <div className="col-lg-6 text-start text-lg-end">
              <ul className="nav nav-pills d-inline-flex justify-content-end mb-5">
                <li className="nav-item me-2">
                  <a
                    className="btn btn-outline-success border-2 active"
                    data-bs-toggle="pill"
                    href="#tab-1"
                  >
                    Rau củ
                  </a>
                </li>
                <li className="nav-item me-2">
                  <a
                    className="btn btn-outline-success border-2"
                    data-bs-toggle="pill"
                    href="#tab-2"
                  >
                    Trái cây{" "}
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <div className="tab-content">
            <div id="tab-1" className="tab-pane fade show p-0 active">
              <div className="row g-4">
                <div className="col-xl-3 col-lg-4 col-md-6">
                  <div className="product-item">
                    <div className="position-relative bg-light">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-1.jpg"}
                        alt
                      />
                      <div className="bg-success rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Cà chua
                      </a>
                      <span className="text-success">15.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-2.jpg"}
                        alt
                      />
                      <div className="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Dứa
                      </a>
                      <span className="text-primary me-1">20.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6 ">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-3.jpg"}
                        alt
                      />
                      <div className="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Ớt
                      </a>
                      <span className="text-primary me-1">20.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6 ">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-4.jpg"}
                        alt
                      />
                      <div className="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Dâu tây
                      </a>
                      <span className="text-primary me-1">99.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-5.jpg"}
                        alt
                      />
                      <div className="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Dưa chuột
                      </a>
                      <span className="text-primary me-1">28.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6 ">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-6.jpg"}
                        alt
                      />
                      <div className="rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Cà chua Đà Lạt
                      </a>
                      <span className="text-primary me-1">22.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2" />
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2" />
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-7.jpg"}
                        alt
                      />
                      <div className="bg-light rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Khoai tây
                      </a>
                      <span className="text-primary me-1">26.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2"/>
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href="#">
                          <BiShoppingBag className="me-2"/>
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-xl-3 col-lg-4 col-md-6 border ">
                  <div className="product-item">
                    <div className="position-relative bg-light ">
                      <img
                        className="img-fluid w-100"
                        src={process.env.PUBLIC_URL + "img/product-8.jpg"}
                        alt
                      />
                      <div className="bg-secondary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                        Mới
                      </div>
                    </div>
                    <div className="text-center p-4">
                      <a className="d-block h5 mb-2" href>
                        Chuối
                      </a>
                      <span className="text-primary me-1">29.000 VNĐ</span>
                    </div>
                    <div className="d-flex border-top">
                      <small className="w-50 text-center border-end py-2">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center" href>
                          <AiOutlineEye className="me-2"/>
                          Chi tiết
                        </a>
                      </small>
                      <small className="w-50 text-center py-2 ">
                        <a className="text-body text-decoration-none d-flex align-items-center justify-content-center " href="#">
                          <BiShoppingBag className="me-2"/>
                          Mua hàng
                        </a>
                      </small>
                    </div>
                  </div>
                </div>
                <div className="col-12 text-center ">
                  <a
                    className="btn btn-outline-success rounded-pill py-3 px-5 text-decoration-none"
                    href
                  >
                    Xem thêm
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
};

export default Home;
