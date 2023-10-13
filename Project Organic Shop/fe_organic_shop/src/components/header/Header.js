import React, { useEffect, useState } from "react";
import { SiGooglemaps } from "react-icons/si";
import { FaRegEnvelope } from "react-icons/fa";
import { BiLogoFacebook } from "react-icons/bi";
import { BiLogoTwitter } from "react-icons/bi";
import { BiLogoLinkedin } from "react-icons/bi";
import { BiLogoInstagramAlt } from "react-icons/bi";
import { BiSearch } from "react-icons/bi";
import { BiUser } from "react-icons/bi";
import { BiShoppingBag } from "react-icons/bi";
import { Link, useNavigate } from "react-router-dom";
import * as userService from "../../services/UserService"
const Header = () => {
  const navigate = useNavigate();
  const [JwtToken, setJwtToken] = useState(localStorage.getItem("JWT"));
  const [userName,setUserName] = useState("");

  useEffect(() => {
    getUsername();
  }, []);

  const getUsername = async () => {
    const result = await userService.infoUserByJwtToken();
    console.log(result);
    setUserName(result.sub);
  };

  const logOut = () => {
    localStorage.removeItem("JWT")
  }

  return (
    <>
      <div className="container-fluid bg-gray-200 fixed-top">
        <div className="row d-flex align-items-center">
          <div className="col-6 px-5">
            <small>
              <SiGooglemaps className="me-1" />
              293 Trần Hưng Đạo, Đà Nẵng, Việt Nam
            </small>
            <small className="ms-4">
              <FaRegEnvelope className="me-1" />
              annhienorganic@gmail.com
            </small>
          </div>
          <div className="col-6 text-end">
            <small>Theo dõi shop:</small>
            <a className="text-body ms-3" href="#">
              <BiLogoFacebook className="me-1" />
            </a>
            <a className="text-body ms-3" href="#">
              <BiLogoTwitter className="me-1" />
            </a>
            <a className="text-body ms-3" href="">
              <BiLogoLinkedin className="me-1" />
            </a>
            <a className="text-body ms-3" href="">
              <BiLogoInstagramAlt className="me-1" />
            </a>
          </div>
        </div>
        <nav className="navbar navbar-expand-lg navbar-light ms-5">
          <a href="#" className="navbar-brand">
            <h1 className="fw-bold" style={{ color: "#61c245" }}>
              AN
              <span className="fw-bold" style={{ color: "#f65005" }}>
                organic
              </span>
            </h1>
          </a>
          <button
            type="button"
            className="navbar-toggler me-4"
            data-bs-toggle="collapse"
            data-bs-target="#navbarCollapse"
          >
            <span className="navbar-toggler-icon" />
          </button>
          <div className="collapse navbar-collapse" id="navbarCollapse">
            <div className="navbar-nav ms-auto p-4 p-lg-0">
              <Link to={"/"} href="#" className="nav-item nav-link active">
                Trang chủ
              </Link>
              <a href="#" className="nav-item nav-link">
                Giới thiệu
              </a>
              <div className="nav-item dropdown">
                <a
                  href="#"
                  className="nav-link dropdown-toggle"
                  data-bs-toggle="dropdown"
                >
                  Sản phẩm
                </a>
                <div className="dropdown-menu">
                  <a href="#" className="dropdown-item">
                    Rau
                  </a>
                  <a href="#" className="dropdown-item">
                    Củ quả
                  </a>
                  <a href="#" className="dropdown-item">
                    Trái cây
                  </a>
                </div>
              </div>
              <a href="#" className="nav-item nav-link">
                Liên hệ
              </a>
            </div>
            <div className="d-none d-lg-flex align-items-center">
              <a className="btn" href="#">
                <BiSearch />
              </a>
              <div className="nav-item dropdown d-flex ">
                <span className="me-1 text-success">{userName ? userName:""}</span>
                <a
                  href="#"
                  className="nav-link dropdown-toggle"
                  data-bs-toggle="dropdown"
                >
                  <BiUser />
                </a>
                <div className="dropdown-menu">
                  <Link to={"/home/login"} className="dropdown-item">
                    Đăng nhập
                  </Link>
                  <a type="button" onClick={() => logOut()} className="dropdown-item">
                    Đăng xuất
                  </a>
                </div>
              </div>
              {/* <a
                className="btn ms-1"
                href="#"
              >
                <BiUser />
              </a> */}
              <a className="btn ms-1" href="#">
                <BiShoppingBag />
              </a>
            </div>
          </div>
        </nav>
      </div>
    </>
  );
};
export default Header;
