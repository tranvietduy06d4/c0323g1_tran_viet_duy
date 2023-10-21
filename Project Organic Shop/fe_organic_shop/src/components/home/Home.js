import { useState, useEffect } from "react";
import Footer from "../footer/Footer";
import Header from "../header/Header";
import Carousel from "./Carousel";
import { AiOutlineEye } from "react-icons/ai";
import { BiShoppingBag } from "react-icons/bi";
import { Link, useNavigate, useParams } from "react-router-dom";
import * as productService from "../../services/ProductService";
import {
  getUserIdByUserName,
  infoUserByJwtToken,
} from "../../services/UserService";
import { ToastContainer, toast } from "react-toastify";
import { addToCartFromHomeAndDetails } from "../../services/CartService";
import Swal from "sweetalert2";
import { useDispatch } from "react-redux";
import { getAllCarts } from "../order/redux/cartAction";

const Home = () => {
  const [products, setProducts] = useState([]);
  const [userId, setUserId] = useState();
  const navigate = useNavigate();
  const [keyword, setKeyword] = useState("");
  const [type, setType] = useState("");
  const [sortBy, setSortBy] = useState("price");
  const [sortDirection, setSortDirection] = useState("asc");
  const [currentPage, setCurrentPage] = useState(1);
  const [totalElements, setTotalElements] = useState(0);
  const [isNoContent, setIsNoContent] = useState(false);
  const dispatch = useDispatch();

  useEffect(() => {
    setCurrentPage(1);
  }, []);


  useEffect(() => {
    document.title = "ANorganic - Trang chủ";
  }, []);

  useEffect(() => {
    getProductList();
  }, [currentPage, sortBy, sortDirection, type, keyword]);

  const getProductList = async () => {
    setIsNoContent(false);
    const response = await productService.searchProduct(
      currentPage - 1,
      keyword,
      type,
      sortBy,
      sortDirection
    );
    if (response.status === 204) {
      setIsNoContent(true);
    } else {
      setProducts(response.data.content);
      setTotalElements(response.data.totalElements);
      setType(type);
    }
  };

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
  };
  const handleSearchName = (event) => {
    setKeyword(event.target.value);
    setCurrentPage(1);
  };
  const handleTypeChange = (event) => {
    setType(event.target.value);
    setCurrentPage(1);
  };

  const handleSortByChange = (event) => {
    setSortBy(event.target.value);
    setCurrentPage(1);
  };

  const handleSortDirectionChange = (event) => {
    setSortDirection(event.target.value);
    setCurrentPage(1);
  };

  const addToCart = async (productId) => {
    const isLoggedIn = infoUserByJwtToken();
    if (!isLoggedIn) {
      Swal.fire("Vui lòng đăng nhập tài khoản!", "", "warning");
      navigate("/login");
    } else {
      const result = await getUserIdByUserName(isLoggedIn.sub);
      setUserId(result.data);

      const response = await addToCartFromHomeAndDetails(
        result.data,
        productId,
        1
      );
      dispatch(getAllCarts(result.data));
      toast.success("Thêm sản phẩm thành công");
      
    }
  };

  const totalPages = Math.ceil(totalElements / 12);

  return (
    <div className="min-height-300">
      <Header />
      <Carousel />
      <div className="container-xxl py-5">
        <div className="container">
          <div className="row align-items-end">
            <div className="col-lg-3">
              <div
                className="section-header text-start mb-5"
                style={{ maxWidth: 500 }}
              >
                <h1 className="display-5 mb-3">Sản phẩm</h1>
              </div>
            </div>
            <div className="col-lg-9  d-flex align-items-center text-lg-end">
              {/* <ul className="nav nav-pills d-inline-flex justify-content-end mb-5">
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
              </ul> */}
              <input
                className="input-group-text me-2 "
                placeholder="Nhập tên sản phẩm"
                onChange={handleSearchName}
              ></input>
              <select
                className="form-select me-2 "
                value={type}
                onChange={handleTypeChange}
              >
                <option value="rau">Rau</option>
                <option value="cu">Củ-Quả</option>
                <option value="trai">Trái cây</option>
              </select>
              {/* <span className="me-2 ">Sắp xếp theo: </span> */}
              <select
                className="form-select me-2 "
                value={sortBy}
                onChange={handleSortByChange}
              >
                <option value="price">Giá</option>
                <option value="name">Tên sản phẩm</option>
              </select>

              {/* <span className="me-2">Cách sắp xếp: </span> */}
              <select
                className="form-select "
                value={sortDirection}
                onChange={handleSortDirectionChange}
              >
                <option value="asc">Tăng dần</option>
                <option value="desc">Giảm dần</option>
              </select>
            </div>
          </div>
          <div className="tab-content mt-5">
            <div id="tab-1" className="tab-pane fade show p-0 active">
              <div className="row g-4">
                {isNoContent ? (
                  <p>Rất tiếc. Không tìm thấy sản phẩm. Vui lòng thử lại</p>
                ) : (
                  <>
                    {products.map((product, index) => (
                      <div className="col-xl-3 col-lg-4 col-md-6" key={index}>
                        <div className="product-item">
                          <div className="position-relative bg-light">
                            <img
                              className="img-fluid w-100"
                              src={product.productImage}
                              alt={product.productName}
                              style={{ height: "200px" }}
                            />
                            <div className="bg-success rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">
                              Mới
                            </div>
                          </div>
                          <div className="text-center p-4">
                            <span className="d-block h5 mb-2" href>
                              {product.productName}
                            </span>
                            <span className="text-success">
                              {new Intl.NumberFormat("vi-VN").format(
                                product.productPrice
                              )}{" "}
                              VNĐ
                            </span>
                          </div>
                          <div className="d-flex border-top">
                            <small className="w-50 text-center border-end py-2">
                              <Link
                                to={`/detail/${product.productId}`}
                                className="text-body text-decoration-none d-flex align-items-center justify-content-center"
                              >
                                <AiOutlineEye className="me-2" />
                                Chi tiết
                              </Link>
                            </small>
                            <small className="w-50 text-center py-2">
                              <a
                                className="text-body text-decoration-none d-flex align-items-center justify-content-center"
                                onClick={() => addToCart(product.productId)}
                              >
                                <BiShoppingBag className="me-2" />
                                Mua hàng
                              </a>
                            </small>
                          </div>
                        </div>
                      </div>
                    ))}
                    <div className="row justify-content-center mt-5">
                      <nav aria-label="Pagination" style={{ width: "100%" }}>
                        <ul className="pagination d-flex justify-content-center">
                          <li
                            className={`page-item ${
                              currentPage === 1 && "disabled"
                            }`}
                          >
                            <button
                              className="page-link"
                              onClick={() => handlePageChange(currentPage - 1)}
                              style={{ color: "rgb(27, 65, 168)" }}
                            >
                              &laquo;
                            </button>
                          </li>
                          {[...Array(totalPages).keys()].map((page) => (
                            <li
                              key={page}
                              className={`page-item ${
                                currentPage === page + 1 && "active"
                              }`}
                            >
                              <button
                                className="page-link"
                                style={{ color: "rgb(27, 65, 168)" }}
                                onClick={() => handlePageChange(page + 1)}
                              >
                                {page + 1}
                              </button>
                            </li>
                          ))}
                          <li
                            className={`page-item ${
                              currentPage === totalPages && "disabled"
                            }`}
                          >
                            <button
                              className="page-link"
                              onClick={() => handlePageChange(currentPage + 1)}
                              style={{ color: "rgb(27, 65, 168)" }}
                            >
                              &raquo;
                            </button>
                          </li>
                        </ul>
                      </nav>
                    </div>
                  </>
                )}

                {/* <div className="col-xl-3 col-lg-4 col-md-6">
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
                </div> */}
              </div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
      <ToastContainer autoClose={2000} className="toast-position" />
    </div>
  );
};

export default Home;
