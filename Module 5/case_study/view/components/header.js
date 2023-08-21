import { Component } from "react";
class Header extends Component {
  render() {
    return (
      <>
        <div className="container-fluid fixed-top bg-dark ">
          <nav className="navbar navbar-expand-sm navbar-dark align-items-center">
            <a
              href="#"
              className="nabar-brand mb-0 h3 text-light"
              style={{ marginLeft: "5rem" }}
            >
              <img
                className="d-line-block"
                src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png"
                alt=" Logo Header Menu"
                width={20}
                height={30}
              />
              FURAMA
            </a>
            <button
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              className="navbar-toggler"
              aria-controls="navbar-nav"
              aria-expanded="false"
              aria-label="toggle navigation"
            >
              <span className="navbar-toggler-icon" />
            </button>
            <div
              className="collapse navbar-collapse"
              id="navbarNav"
              style={{ marginLeft: "7rem" }}
            >
              <ul className="navbar-nav">
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
            </div>
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
}
export default Header;
