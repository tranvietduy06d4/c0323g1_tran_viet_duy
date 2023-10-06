import Footer from "../footer/Footer";
import Header from "../header/Header";

const ProductDetail = () => {
  return (
    <>
      <Header />
      <div id="hannah" className="pb-5">
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
                    src={process.env.PUBLIC_URL + "img/product-1.jpg"}
                    className="d-block w-100"
                    alt="..."
                  />
                </div>
              </div>
              <div className=" col col-md-6 col-auto">
                <h1>Cà chua</h1>
                <h4>
                  <span>15.000 VNĐ</span>
                  <span> / Kg </span>
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
                  <div className="btn-input-group col d-flex justify-content-start align-items-end ">
                    <input
                      type="button"
                      defaultValue="-"
                      className="btn-minus"
                      data-field="quantity"
                    />
                    <input
                      id="quantity-value"
                      type="number"
                      step={1}
                      maxlength="2"
                      min="1"
                      max="99"
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
                    />
                  </div>
                  <button
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
                  <span className=" fw-bold">Mã sản phẩm: </span>
                  <span>P-0001</span>
                </p>
                <hr />
                <p>
                  <span className=" fw-bold">Danh mục: </span>
                  <span>Quả</span>
                </p>
                <hr />
              </div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
};
export default ProductDetail;
