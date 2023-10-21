import { useEffect, useState } from "react";
import Footer from "../footer/Footer";
import Header from "../header/Header";
import { useNavigate, useParams } from "react-router-dom";
import { checkQuantity, getProductById } from "../../services/ProductService";
import {
  getUserIdByUserName,
  infoUserByJwtToken,
} from "../../services/UserService";
import Swal from "sweetalert2";
import moment from "moment";
import { toast, ToastContainer } from "react-toastify";
import {
  addToCartFromHomeAndDetails,
  getQuantityInCart,
} from "../../services/CartService";
import { useDispatch } from "react-redux";
import { getAllCarts } from "../order/redux/cartAction";

const ProductDetail = () => {
  const productId = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState({});
  const [userId, setUserId] = useState();
  const dispatch = useDispatch();

  useEffect(() => {
    document.title = "ANorganic - Thông tin chi tiết";
  }, []);

  useEffect(() => {
    getProductDetail();
  }, []);

  const getProductDetail = async () => {
    try {
      const res = await getProductById(productId.id);
      setProduct(res.data);
    } catch (error) {
      console.error(error);
      if (error.response && error.response.status === 406) {
        Swal.fire("Không tìm thấy sản phẩm bạn cần tìm!", "", "error");
        navigate("/");
      }
    }
  };

  const addToCart = async (productId) => {
    const isLoggedIn = infoUserByJwtToken();
    if (!isLoggedIn) {
      Swal.fire("Vui lòng đăng nhập tài khoản!", "", "warning");
      localStorage.setItem("tempURL", window.location.pathname);
      navigate("/login");
    } else {
      // extract userId from token
      const result = await getUserIdByUserName(isLoggedIn.sub);

      setUserId(result.data);
      // do checking
      const quantity = document.getElementById("quantity-value").value;
      const quantityInCart = await getQuantityInCart(result.data, productId);

      if (parseInt(quantity) <= 0) {
        Swal.fire("Vui lòng thêm ít nhất 1 sản phẩm!", "", "warning");
      } else {
        try {
          const res = await checkQuantity(
            productId,
            parseInt(quantity) + quantityInCart
          );

          const add = await addToCartFromHomeAndDetails(
            result.data,
            productId,
            parseInt(quantity)
          );

          dispatch(getAllCarts(result.data));
          toast.success("Thêm sản phẩm thành công!");
        } catch {
          Swal.fire(
            "Sản phẩm vượt quá số lượng cho phép!",
            "Số lượng trong giỏ hàng của bạn: " + quantityInCart,
            "warning"
          );
        }
      }
    }
  };

  function handlePlus() {
    let quantityInput = document.getElementById("quantity-value");
    if (quantityInput.value < product.quantity) {
      quantityInput.value = parseInt(quantityInput.value) + 1;
    } else {
      quantityInput.value = product.quantity;
    }
  }

  function handleMinus() {
    let quantityInput = document.getElementById("quantity-value");
    if (quantityInput.value > 1) {
      quantityInput.value = parseInt(quantityInput.value) - 1;
    }
    if (quantityInput.value > product.quantity) {
      quantityInput.value = product.quantity;
    }
  }

  const currency = (money) => {
    return new Intl.NumberFormat("vi-VN").format(money);
  };

  return (
    <>
      <Header />
      <div id="productDetail" className="pb-5">
        <div className="mb-5">
          <div
            className="container mt-5 position-relative"
            style={{ top: "5rem" }}
          >
            <div className=" row row-cols-md-2 row-cols-1 ">
              <div id="carouselExampleIndicators" style={{ height: "100%" }}>
                {/* ----- */}
                <div className="carousel-inner">
                  <img
                    src={product.imagePath}
                    className="d-block w-100"
                    alt="..."
                  />
                </div>
              </div>
              <div className=" col col-md-6 col-auto">
                <h1 style={{ color: "#61c245" }}>{product.name}</h1>
                <h4 style={{ color: "#f65005" }}>
                  <span>{currency(product.price)} VNĐ</span>
                  <span> / {product.unit} </span>
                </h4>
                <div
                  style={{
                    backgroundColor: "lightblue",
                    borderRadius: 10,
                  }}
                  className="p-4"
                >
                  <p className="m-0" style={{ fontSize: "14px" }}>
                    Giá đã bao gồm Thuế.
                  </p>
                  <p className=" m-0" style={{ fontSize: "14px" }}>
                    Phí vận chuyển và các chi phí khác (nếu có) sẽ được thể hiện
                    khi đặt hàng
                  </p>
                </div>

                <div className="buttons d-flex justify-content-between align-items-center mt-3">
                  <div className="btn-input-group col d-flex justify-content-start  ">
                    <input
                      type="button"
                      defaultValue="-"
                      className="btn-minus"
                      data-field="quantity"
                      onClick={handleMinus}
                    />
                    <input
                      id="quantity-value"
                      type="number"
                      step={1}
                      maxlength="2"
                      min="1"
                      max={product.quantity}
                      defaultValue={1}
                      style={{
                        width: "50px",
                        height: "35px",
                        border: "1px white",
                        borderRadius: "5px",
                      }}
                      name="quantity"
                      className=" input-quantity text-center px-2"
                    />
                    <input
                      type="button"
                      defaultValue="+"
                      className="btn-plus"
                      data-field="quantity"
                      onClick={handlePlus}
                    />
                  </div>
                  <button
                    onClick={() => addToCart(product.id)}
                    className="col btn fw-bold mb-0"
                    style={{
                      backgroundColor: "orange",
                      height: "38px",
                      textDecoration: "none",
                      color: "black",
                      cursor: "pointer",
                    }}
                  >
                    THÊM VÀO GIỎ HÀNG
                  </button>
                </div>
                <hr />
                <p>
                  <span className=" fw-bold" style={{ color: "#f65005" }}>
                    Mã sản phẩm:{" "}
                  </span>
                  <span>{product.code}</span>
                </p>
                <hr />
                <p>
                  <span className=" fw-bold" style={{ color: "#f65005" }}>
                    Xuất xứ:{" "}
                  </span>
                  <span>{product.origin}</span>
                </p>
                <hr />
                <p>
                  <span className=" fw-bold" style={{ color: "#f65005" }}>
                    Hạn sử dụng:{" "}
                  </span>
                  <span>{moment(product.expiry).format("DD/MM/YYYY")}</span>
                </p>
                <hr />
                <p>
                  <span className=" fw-bold" style={{ color: "#f65005" }}>
                    Mô tả:{" "}
                  </span>
                  <span>{product.note}</span>
                </p>
                <hr />
              </div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
      <ToastContainer autoClose={2000} className="toast-position" />
    </>
  );
};
export default ProductDetail;
