import { React } from "react";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="container-fluid fixed-top bg-dark ">
        <nav className="navbar navbar-expand-sm navbar-dark align-items-center">
          <a
            className="nabar-brand mb-0 h3 text-light"
            style={{ marginLeft: "5rem", textDecoration: "none" }}
          >
            <img
              className="d-line-block"
              src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png"
              alt=" Logo Header Menu"
              width={20}
              height={30}
              style={{ marginRight: "1rem" }}
            />
            CHÀO MỪNG ĐẾN VỚI KÌ THI MODULE 5
          </a>

          <div
            className="collapse navbar-collapse"
            id="navbarNavDarkDropdown"
            style={{ marginLeft: "7rem" }}
          >
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <button
                  className="btn btn-dark dropdown-toggle"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Quản lý
                </button>
                <ul className="dropdown-menu dropdown-menu-dark ">
                  <li>
                    <a className="dropdown-item">
                      <Link
                        to={"/"}
                        style={{ textDecoration: "none", color: "white" }}
                      >
                        Dịch vụ
                      </Link>
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item">
                      <Link
                        to={"/customer/list"}
                        style={{ textDecoration: "none", color: "white" }}
                      >
                        Khách hàng
                      </Link>
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item">
                      <Link
                        to="/contract/list"
                        style={{ textDecoration: "none", color: "white" }}
                      >
                        Hợp đồng
                      </Link>
                    </a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>

          {/* <div
            className="collapse navbar-collapse"
            id="navbarNav"
            style={{ marginLeft: "7rem" }}
          > */}
          {/* <ul className="navbar-nav">
              <li className="nav-item active">
                <a href="#" className="nav-link active">
                  Trang Chủ
                </a>
              </li>
              <li className="nav-item active">
                <a href="#" className="nav-link">
                  Loại Phòng
                </a>
              </li>
              <li className="nav-item active">
                <a href="#" className="nav-link">
                  Ưu Đãi
                </a>
              </li>
              <li className="nav-item active">
                <a href="#" className="nav-link">
                  Đặt Phòng
                </a>
              </li>
            </ul>
          </div> */}
          <form
            action="#"
            className="d-flex mb-1"
            style={{ float: "right", marginRight: "1rem" }}
          >
            <input type="text" className="form-control me-2" />
            <button className="btn btn-outline-warning" type="submit">
              <i className="fa-solid fa-magnifying-glass" />
            </button>
          </form>
        </nav>
      </div>
    </>
  );
}
export default Header;
