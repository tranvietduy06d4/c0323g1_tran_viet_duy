import React from "react";
import { SiGooglemaps } from "react-icons/si";
import { FaRegEnvelope } from "react-icons/fa";
import { BiLogoFacebook } from "react-icons/bi";
import { BiLogoTwitter } from "react-icons/bi";
import { BiLogoLinkedin } from "react-icons/bi";
import { BiLogoInstagramAlt } from "react-icons/bi";
import {BiSearch} from "react-icons/bi";
import {BiUser} from "react-icons/bi";
import {BiShoppingBag} from "react-icons/bi";
const Header = () => {
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
              <a href="#" className="nav-item nav-link active">
                Trang chủ
              </a>
              <a href="#" className="nav-item nav-link">
                Giới thiệu
              </a>
              <a href="#" className="nav-item nav-link">
                Sản phẩm
              </a>
              <div className="nav-item dropdown">
                <a
                  href="#"
                  className="nav-link dropdown-toggle"
                  data-bs-toggle="dropdown"
                >
                  Trang
                </a>
                <div className="dropdown-menu">
                  <a href="#" className="dropdown-item">
                    Blog Grid
                  </a>
                  <a href="#" className="dropdown-item">
                    Our Features
                  </a>
                  <a href="#" className="dropdown-item">
                    Testimonial
                  </a>
                  <a href="#" className="dropdown-item">
                    404 Page
                  </a>
                </div>
              </div>
              <a href="#" className="nav-item nav-link">
                Liên hệ
              </a>
            </div>
            <div className="d-none d-lg-flex">
              <a
                className="btn"
                href="#"
              >
                <BiSearch />
              </a>
              <a
                className="btn ms-1"
                href="#"
              >
                <BiUser />
              </a>
              <a
                className="btn ms-1"
                href="#"
              >
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
