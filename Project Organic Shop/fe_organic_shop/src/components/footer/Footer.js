import {BiHomeHeart} from "react-icons/bi";
import {BiEnvelope} from "react-icons/bi";
import {BiPhone} from "react-icons/bi";
const Footer = () => {
  return (
    <>
      <footer
        className="text-center text-lg-start text-dark  pt-1"
        style={{ backgroundColor: "#ECEFF1" }}
      >
        <section className>
          <div className="container text-center text-md-start mt-5">
            <div className="row mt-3">
              <div className="col-md-4 col-lg-4 col-xl-3 mx-auto mb-4">
                <h6 className="text-uppercase fw-bold">AN ORGANIC</h6>
                <hr
                  className="mb-4 mt-0 d-inline-block mx-auto text-align-center"
                  style={{ width: 60, backgroundColor: "#7c4dff", height: 2 }}
                />
                <p>
                  Cộng đồng khỏe - Nông dân vui
                </p>
              </div>
              <div className="col-md-4 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 className="text-uppercase fw-bold">Giới thiệu</h6>
                <hr
                  className="mb-4 mt-0 d-inline-block mx-auto"
                  style={{ width: 60, backgroundColor: "#7c4dff", height: 2 }}
                />
                <p>
                  <a href="#!" className="text-dark">
                    Về chúng tôi
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-dark">
                    Liên hệ
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-dark">
                    Dịch vụ
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-dark">
                    Chính sách
                  </a>
                </p>
              </div>
              
              <div className="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <h6 className="text-uppercase fw-bold">Địa chỉ</h6>
                <hr
                  className="mb-4 mt-0 d-inline-block mx-auto"
                  style={{ width: 60, backgroundColor: "#7c4dff", height: 2 }}
                />
                <p>
                  <BiHomeHeart/> 293 Trần Hưng Đạo, Đà Nẵng
                </p>
                <p>
                  <BiEnvelope /> annhienorganic@gmail.com
                </p>
                <p>
                  <BiPhone /> + 02363 189 579
                </p>
              </div>
            </div>
          </div>
        </section>
        <div
          className="text-center p-3"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}
        >
          © 2023 Bản quyền thuộc về:
            AnNhienOrganic
        </div>
      </footer>
    </>
  );
};
export default Footer;
