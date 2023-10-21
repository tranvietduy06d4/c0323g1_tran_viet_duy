import { Formik, Form, ErrorMessage, Field, swap } from "formik";
import * as yup from "yup";
import Header from "../header/Header";
import Footer from "../footer/Footer";
import { useEffect, useState } from "react";
import {
  getUserIdByUserName,
  infoUserByJwtToken,
} from "../../services/UserService";
import Swal from "sweetalert2";
import { Link, useNavigate } from "react-router-dom";
import {
  addToCartFromHomeAndDetails,
  checkQuantity,
  deleteCartDetail,
  getAllCartByUserId,
} from "../../services/CartService";
import { FaTrashCan } from "react-icons/fa6";
import { useDispatch } from "react-redux";
import { getAllCarts } from "./redux/cartAction";
const Cart = () => {
  const [userId, setUserId] = useState();
  const [carts, setCarts] = useState([]);
  const dispatch = useDispatch();

  const navigate = useNavigate();
  

  useEffect(() => {
    getAllCart();
  }, []);

  useEffect(() => {
    document.title = "ANorganic - Giỏ Hàng";
  }, []);

  const currency = (money) => {
    return new Intl.NumberFormat("vi-VN").format(money);
  };

  const getUserId = async () => {
    const isLoggedIn = infoUserByJwtToken();
    if (!isLoggedIn) {
      Swal.fire("Vui lòng đăng nhập tài khoản!", "", "warning");
      navigate("/login");
    } else {
      const result = await getUserIdByUserName(isLoggedIn.sub);
      setUserId(result.data);
      return result.data;
    }
  };

  const getAllCart = async () => {
    const id = await getUserId();
    const result = await getAllCartByUserId(id);
    setCarts(result.data);
  };

  async function handlePlus(productId, quantityInStock) {
    let newSellQuantity = document.getElementById("input-quantity" + productId);
    try {
      const res = await checkQuantity(
        productId,
        parseInt(newSellQuantity.value) + 1
      );
      // if enuf - allow to buy maximum 99
      if (newSellQuantity.value < quantityInStock) {
        newSellQuantity.value = parseInt(newSellQuantity.value) + 1;
      } else {
        newSellQuantity.value = quantityInStock;
      }
      await addToCartFromHomeAndDetails(
        userId,
        productId,
        newSellQuantity.value
      );
      // setIsUpdated((prev) => !prev);
      // update the quantity in selectedMedicines state
      setCarts(
        carts.map((cart) =>
          cart.productId === productId
            ? { ...cart, sellQuantity: newSellQuantity.value }
            : cart
        )
      );
      console.log(carts);
    } catch {
      Swal.fire(
        "Sản phẩm vượt quá số lượng cho phép!",
        "Số lượng hiện có ở cửa hàng: " + quantityInStock,
        "warning"
      );
    }
  }

  async function handleMinus(productId) {
    let newSellQuantity = document.getElementById("input-quantity" + productId);
    try {
      if (newSellQuantity.value > 1) {
        newSellQuantity.value = parseInt(newSellQuantity.value) - 1;
      }
      await addToCartFromHomeAndDetails(
        userId,
        productId,
        newSellQuantity.value
      );

      // update the quantity in card detail
      setCarts(
        carts.map((cart) =>
          cart.productId === productId
            ? { ...cart, sellQuantity: newSellQuantity.value }
            : cart
        )
      );
      console.log(carts);
    } catch (e) {
      console.log(e);
    }
  }

  async function handleDelete(cart) {
    let cartId = cart.cartId;

    Swal.fire({
      title: "Bạn có muốn xoá sản phẩm " + cart.productName + " khỏi giỏ hàng?",
      text: cart.productName,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Đồng ý!",
      cancelButtonText: "Huỷ",
    }).then(async (willDelete) => {
      if (willDelete.isConfirmed) {
        await deleteCartDetail(cartId);

        // update the cart list
        setCarts(carts.filter((cart) => cart.cartId !== cartId));
        Swal.fire("Xoá sản phẩm thành công!", "", "success");
        const isLoggedIn = infoUserByJwtToken();

        const result = await getUserIdByUserName(isLoggedIn.sub);

        dispatch(getAllCarts(result.data));
      }
    });
  }
  return (
    <>
      <Header />
      <div id="cart-info" className="pb-5 pt-5">
        <div className="container-fluid p-1 position-relative">
          <h1 className="text-center my-5 mx-auto" style={{ color: "#61c245" }}>
            GIỎ HÀNG
          </h1>

          <div className="container-fluid w-100">
            <div className="row">
              <div className=" col col-sm-12 col-md-12 col-lg-8 col-xl-8 p-0">
                <div className=" d-flex flex-column justify-content-center align-items-center">
                  <table className="table table-hover reponse">
                    <thead className="text-secondary">
                      <tr className="text-center fw-bold">
                        <td>SẢN PHẨM</td>
                        <td>Giá (VNĐ)</td>
                        <td>Số lượng</td>
                        <td>Tổng (VNĐ)</td>
                        <td>Xóa</td>
                      </tr>
                    </thead>
                    <tbody>
                      {carts.length > 0 &&
                        carts.map((el) => {
                          return (
                            <tr key={`el_${el.cartId}`}>
                              <td>
                                <div className="d-flex flex-column flex-md-row align-items-center justify-content-start ms-3">
                                  <img
                                    src={el.productImage}
                                    style={{
                                      width: "3.5rem",
                                      height: "4.0rem",
                                      cursor: "pointer",
                                    }}
                                    onClick={() =>
                                      navigate(`/detail/${el.productId}`)
                                    }
                                  />
                                  <div
                                    style={{ cursor: "pointer" }}
                                    className="text-center align-middle mx-2"
                                    onClick={() =>
                                      navigate(`/detail/${el.productId}`)
                                    }
                                  >
                                    <div>{el.productName}</div>
                                  </div>
                                </div>

                                <small className="text-center text-danger align-middle ms-3">
                                  Số lượng hiện có ở cửa hàng:{" "}
                                  <small>
                                    {el.quantityInStock} ({el.productUnit}){" "}
                                  </small>
                                </small>
                              </td>

                              <td className=" text-center align-middle fw-bold">
                                {currency(el.productPrice)}
                              </td>

                              <td className="align-middle">
                                <div className=" d-flex flex-md-row flex-column justify-content-center align-items-center">
                                  <input
                                    onClick={() => handleMinus(el.productId)}
                                    type="button"
                                    defaultValue="-"
                                    className=" d-flex justify-content-center align-items-end btn-minus"
                                  />
                                  <input
                                    readOnly
                                    id={`input-quantity${el.productId}`}
                                    type="number"
                                    step={1}
                                    min="1"
                                    max={el.quantity}
                                    defaultValue={el.sellQuantity}
                                    style={{
                                      width: "50px",
                                      height: "35px",
                                      border: "1px white",

                                      borderRadius: "5px",
                                    }}
                                    name="quantity"
                                    className="text-center input-quantity"
                                  />
                                  <input
                                    onClick={() =>
                                      handlePlus(
                                        el.productId,
                                        el.quantityInStock
                                      )
                                    }
                                    type="button"
                                    defaultValue="+"
                                    className=" d-flex justify-content-center btn-plus"
                                  />
                                </div>
                              </td>
                              {/*                            total price*/}
                              <td className="align-middle text-center fw-bold">
                                {currency(el.productPrice * el.sellQuantity)}{" "}
                              </td>
                              <td className="align-middle text-center fw-bold">
                                <a type="button" onClick={() => handleDelete(el)}>
                                  <FaTrashCan style={{ color: "red" }} />
                                  
                                </a>
                              </td>
                            </tr>
                          );
                        })}
                    </tbody>
                  </table>
                  <div
                    className=" mb-3"
                    //   style={{ display: showCf ? "block" : "none" }}
                    id="confirm-order"
                  >
                    <h3 className=" text-center" style={{ color: "#0340c1" }}>
                      XÁC NHẬN THÔNG TIN GIAO HÀNG
                      <img
                        style={{
                          marginLeft: "20px",
                          height: "60px",
                          width: "60px",
                          opacity: "20%",
                        }}
                        src="https://static.vecteezy.com/system/resources/previews/002/206/240/original/fast-delivery-icon-free-vector.jpg"
                      />
                    </h3>
                    <Formik
                      initialValues={{
                        id: "1",
                        name: "Hoàng Văn Bách",
                        phoneNumber: "0975354965",
                        email: "bachhv@gmail.com",
                        address: "57 Trần Phú, Đà Nẵng",
                        note: "",
                      }}
                    >
                      <Form>
                        <div className=" d-flex flex-column justify-content-center align-items-center">
                          <div className=" mb-1 w-100">
                            <label htmlFor="name">
                              Tên khách hàng{" "}
                              <span className=" text-danger">*</span>
                            </label>
                            <Field
                              type="text"
                              id="name"
                              name="name"
                              className=" form-control w-100"
                            ></Field>
                            <ErrorMessage
                              name="name"
                              component="p"
                              className="text-danger"
                            ></ErrorMessage>
                          </div>
                        </div>

                        <div className=" mb-1 w-100">
                          <label htmlFor="phoneNumber">
                            Số điện thoại{" "}
                            <span className=" text-danger">*</span>
                          </label>
                          <Field
                            type="text"
                            id="phoneNumber"
                            name="phoneNumber"
                            className=" form-control w-100"
                          ></Field>
                          <ErrorMessage
                            name="phoneNumber"
                            component="span"
                            className=" text-danger"
                          ></ErrorMessage>
                        </div>
                        <div className=" mb-1 w-100">
                          <label htmlFor="email">
                            Email<span className=" text-danger">*</span>
                          </label>
                          <Field
                            type="text"
                            id="email"
                            name="email"
                            className=" form-control w-100"
                          ></Field>
                          <ErrorMessage
                            name="email"
                            component="span"
                            className=" text-danger"
                          ></ErrorMessage>
                        </div>
                        <div className="  mb-1 w-100">
                          <label htmlFor="address">
                            Địa chỉ<span className=" text-danger">*</span>
                          </label>
                          <Field
                            type="text"
                            id="address"
                            name="address"
                            className=" form-control w-100"
                          ></Field>
                          <ErrorMessage
                            name="address"
                            component="span"
                            className=" text-danger"
                          ></ErrorMessage>
                        </div>
                        <div className="mb-1 w-100">
                          <label htmlFor="note">Ghi chú:</label>
                          <Field
                            as="textarea"
                            id="note"
                            name="note"
                            className=" form-control w-100"
                          ></Field>
                          <ErrorMessage
                            name="note"
                            component="span"
                            className=" text-danger"
                          ></ErrorMessage>
                        </div>
                        <div className=" w-100 d-flex justify-content-center">
                          <button
                            type="submit"
                            className=" fw-bold btn btn-success mt-3 w-50"
                          >
                            XÁC NHẬN VÀ THANH TOÁN
                          </button>
                        </div>
                      </Form>
                    </Formik>
                  </div>
                  <div className=" w-100 d-flex justify-content-center">
                    <button
                      className="btn fw-bold w-50"
                      style={{
                        marginBottom: "20px",
                        color: "black",
                        backgroundColor: "#119cd4",
                        border: "1px #119cd4 solid ",
                        //   display: checkout ? "block" : "none",
                      }}
                      // onClick={handleVNPAY}
                    >
                      THANH TOÁN VỚI VNPAY
                    </button>
                  </div>
                  <div id="paypal-button-container" className="w-50"></div>

                  <Link to={"/"} className="btn btn-outline-primary mb-5">
                    ← Tiếp tục xem sản phẩm
                  </Link>
                </div>
              </div>
              <div className="col-sm-12 col-md-12 col-lg-4 col-xl-4 container position-relative">
                <div className="shadow rounded p-3 mb-5 position-sticky top-0 mt-3">
                  <div>
                    <div className="text-secondary fs-5 fw-bold">
                      TỔNG SỐ LƯỢNG
                    </div>
                    <hr className="text-secondary h-2" />
                    <div className="">
                      <div className="border-bottom mb-2 pb-2">
                        <span>Tạm Tính</span>
                        <span className="fw-bold" style={{ float: "right" }}>
                          300.000 VNĐ
                        </span>
                      </div>
                      <div className="border-bottom mb-2 pb-2">
                        <span>Giảm giá:</span>
                        <span className="fw-bold" style={{ float: "right" }}>
                          30.000 VNĐ
                          <input
                            className="fw-bold discount"
                            type="hidden"
                            value="10%"
                          />
                        </span>
                      </div>
                      <div className="border-bottom mb-2 pb-2">
                        <span>Tổng Tiền</span>
                        <span className="fw-bold" style={{ float: "right" }}>
                          <input
                            className="fw-bold total-price"
                            type="hidden"
                            //   value={totalPrice - discount}
                          />
                          270.000 VNĐ
                        </span>
                      </div>
                    </div>
                    <button
                      className="w-100 btn btn-warning mt-3 fw-bold"
                      // onClick={proceedOrder}
                      // disabled={showCf}
                    >
                      TIẾN HÀNH THANH TOÁN
                    </button>
                    <hr />
                    {/* <div>
                        <p className="m-0" style={{ color: "orange" }}>
                          Sử dụng điểm tích luỹ:{" "}
                          <span style={{ fontSize: "14px" }}>
                            (1 RETRO = 1 VNĐ)
                          </span>
                        </p>
                        <small className=" d-inline-block mb-1">
                          Tích luỹ hiện có:
                          <small className=" text-danger mx-2">
                            {currency(point)} RETRO
                            <input
                              className="fw-bold point"
                              type="hidden"
                              value={point}
                            />
                          </small>{" "}
                        </small>
                        <input
                          type="number"
                          min={0}
                          defaultValue={0}
                          className="input-quantity form-control w-100 input-point"
                        />
                        <button
                          className="w-100 btn btn-outline-success mt-3"
                          onClick={checkLoyaltyPoint}
                        >
                          Áp dụng
                        </button>
                      </div> */}
                  </div>
                  {/*                payment*/}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};
export default Cart;
