import { React } from "react";

function Footer() {
  return (
    <>
      <div
        className="container-fluid bg-dark text-light mt-5 pt-5"
      >
        <div className="row px-xl-5 pt-5">
          <div className="col-lg-3 col-md-12 mb-5 pr-3 pr-xl-5">
            <h5 className="text-light text-uppercase mb-4">FURAMA</h5>
            <p className="mb-2">
              <i
                className="fa fa-map-marker-alt mr-3"
                style={{ marginRight: "0.2rem" }}
              />
              103-105 Võ Nguyên Giáp, Đà Nẵng, Việt Nam
            </p>
            <p className="mb-2">
              <i
                className="fa fa-envelope mr-3"
                style={{ marginRight: "0.2rem" }}
              />
              reservation@furamavietnam.com
            </p>
            <p className="mb-0">
              <i
                className="fa fa-phone-alt mr-3"
                style={{ marginRight: "0.2rem" }}
              />
              84-236-3847 333/888
            </p>
          </div>
          <div className="col-lg-9 col-md-12">
            <div className="row">
              <div className="col-md-3 mb-5">
                <h5 className="text-light text-uppercase mb-4">Công Ty</h5>
                <div className="d-flex flex-column justify-content-start">
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}} >
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Giới thiệu
                  </a>
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}}>
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Tuyển dụng
                  </a>
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}}>
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Liên hệ
                  </a>
                </div>
              </div>
              <div className="col-md-4 mb-5">
                <h5 className="text-light text-uppercase mb-4">
                  Chính sách khách hàng
                </h5>
                <div className="d-flex flex-column justify-content-start">
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}}>
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Chính sách khách hàng thân thiết
                  </a>
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}}>
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Chính sách bảo mật
                  </a>
                  <a className="text-light mb-2" href="#" style={{textDecoration: "none"}}>
                    <i
                      className="fa fa-angle-right mr-2"
                      style={{ marginRight: "0.2rem" }}
                    />
                    Câu hỏi thường gặp
                  </a>
                </div>
              </div>
              <div className="col-md-5 mb-5">
                <h5 className="text-light text-uppercase mb-4">
                  THAM GIA BẢNG TIN CỦA FURAMA
                </h5>
                <form action="">
                  <div className="input-group">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Email..."
                      style={{ marginRight: "0.5rem" }}
                    />
                    <div className="input-group-append">
                      <button className="btn btn-outline-light">Đăng Ký</button>
                    </div>
                  </div>
                </form>
                <h6 className="text-light text-uppercase mt-4 mb-3">
                  Theo dõi chúng tôi
                </h6>
                <div className="d-flex">
                  <a
                    className="btn btn-light btn-square mr-2"
                    href="#"
                    style={{ marginRight: "0.2rem" }}
                  >
                    <i className="fab fa-twitter" />
                  </a>
                  <a
                    className="btn btn-light btn-square mr-2"
                    href="#"
                    style={{ marginRight: "0.2rem" }}
                  >
                    <i className="fab fa-facebook-f" />
                  </a>
                  <a
                    className="btn btn-light btn-square mr-2"
                    href="#"
                    style={{ marginRight: "0.2rem" }}
                  >
                    <i className="fab fa-linkedin-in" />
                  </a>
                  <a
                    className="btn btn-light btn-square"
                    href="#"
                    style={{ marginRight: "0.2rem" }}
                  >
                    <i className="fab fa-instagram" />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div
          className="row border-top mx-xl-5 py-4"
          style={{ borderColor: "rgba(256, 256, 256, .1) !important" }}
        >
          <div className="col-md-12 px-xl-0">
            <p className="mb-md-0 text-center text-md-left text-light">
              © Furama Resort Đà Nẵng 103-105 Võ Nguyên Giáp, phường Khuê Mỹ,
              quận Ngũ Hành Sơn, Đà Nẵng, Việt Nam
            </p>
          </div>
        </div>
      </div>
    </>
  );
}
export default Footer;
