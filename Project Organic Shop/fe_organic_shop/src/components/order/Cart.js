import { Formik, Form, ErrorMessage, Field } from "formik";
import * as yup from "yup";
import Header from "../header/Header";
import Footer from "../footer/Footer";
const Cart = () => {
  return (
    <>
    <Header />
      <div id="hannah" className="pb-5 pt-5">
        <div className="container-fluid p-1 position-relative">
          <h1 className="text-center my-5 mx-auto" style={{ color: "#0340c1" }}>
            GIỎ HÀNG
          </h1>


            <div className="container-fluid w-100">
              <div className="row">
                <div className=" col col-sm-12 col-md-12 col-lg-8 col-xl-8 p-0">
                  <div className=" d-flex justify-content-end">
                    <button
                      type="button"
                      className=" mx-5 p-0 text-primary"
                      style={{
                        cursor: "pointer",
                        fontSize: "14px",
                      }}
                    //   onClick={handleCheckedAll}
                    >
                      Chọn tất cả
                    </button>
                    <button
                      type="button"
                      className=" mx-5 p-0 text-primary"
                      style={{
                        cursor: "pointer",
                        fontSize: "14px",
                      }}
                    //   onClick={handleDelete}
                    >
                      Xoá sản phẩm
                    </button>
                  </div>
                  <div className=" d-flex flex-column justify-content-center align-items-center">
                    <table className="table table-hover">
                      <thead className="text-secondary">
                        <tr className="text-center fw-bold">
                          <td>SẢN PHẨM</td>
                          <td>Giá (VNĐ)</td>
                          <td>Số lượng</td>
                          <td>Tổng (VNĐ)</td>
                        </tr>
                      </thead>
                      <tbody>
                        {/* {carts.length > 0 &&
                          carts.map((el) => {
                            return ( */}
                              <tr>
                                <td>
                                  <div className="d-flex flex-column flex-md-row align-items-center justify-content-start ">
                                    <span>
                                      <input
                                        id="1"
                                        type="checkbox"
                                        name="multiSelect"
                                        style={{
                                          width: "15px",
                                          height: "15px",
                                          marginRight: "20px",
                                        }}
                                        // onChange={() => handleMultiSelect(el)}
                                      />
                                    </span>
                                    <img
                                      src={process.env.PUBLIC_URL + "img/product-1.jpg"}
                                      style={{
                                        width: "3.5rem",
                                        height: "4.0rem",
                                        cursor: "pointer",
                                      }}
                                    //   onClick={() =>
                                    //     navigate(`/details/${el.medicineId}`)
                                    //   }
                                    />
                                    <div
                                      style={{ cursor: "pointer" }}
                                      className="text-center align-middle mx-2"
                                    //   onClick={() =>
                                    //     navigate(`/details/${el.medicineId}`)
                                    //   }
                                    >
                                      <div>Cà chua</div>
                                    </div>
                                  </div>
                                 
                                    <small className="text-center text-danger align-middle">
                                      Số lượng còn lại ở kho:{" "}
                                      <small>100</small>
                                    </small>
                            
                                </td>

                                <td className=" text-center align-middle fw-bold">
                                    15.000 VNĐ
                                  {/* {currency(el.medicinePrice)} */}
                                </td>
                                {/*                            quantity*/}
                                <td className="align-middle">
                                  <div className=" d-flex flex-md-row flex-column justify-content-center align-items-center">
                                    <input
                                    //   onClick={() =>
                                    //     handleMinus(
                                    //       el.medicineId,
                                    //       el.medicineName,
                                    //       el.cartId
                                    //     )
                                    //   }
                                      type="button"
                                      defaultValue="-"
                                      className=" d-flex justify-content-center align-items-end btn-minus"
                                    />
                                    <input
                                      readOnly
                                      id="1"
                                      type="number"
                                      step={1}
                                      maxlength="2"
                                      min="1"
                                      max="99"
                                      defaultValue="50"
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
                                    //   onClick={() =>
                                    //     handlePlus(
                                    //       el.medicineId,
                                    //       el.medicineQuantity,
                                    //       el.conversionRate
                                    //     )
                                    //   }
                                      type="button"
                                      defaultValue="+"
                                      className=" d-flex justify-content-center btn-plus"
                                    />
                                  </div>
                                </td>
                                {/*                            total price*/}
                                <td className="align-middle text-center fw-bold">
                                    300.000 VNĐ
                                  {/* {currency(
                                    el.medicinePrice * el.quantityInCart
                                  )}{" "} */}
                                </td>
                              </tr>
                            {/* );
                          })} */}
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

                    <a  className="btn btn-outline-primary mb-5">
                      ← Tiếp tục xem sản phẩm
                    </a>
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
