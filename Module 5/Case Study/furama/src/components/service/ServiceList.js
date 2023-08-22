import { React } from "react";

function ServiceList() {
  return (
    <>
      <div
        className="container-fluid d-flex justify-content-center row"
        style={{ marginTop: "5rem" }}
      >
        <div
          className="card col-sm-6 col-md-4 col-lg-4 "
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/03/Furama_Ocean_Deluxe-2-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="PHÒNG DELUXE HƯỚNG BIỂN"
          />
          <div className="card-body">
            <h5 className="card-title">PHÒNG DELUXE HƯỚNG BIỂN</h5>
            <span className="card-text">
              Diện tích: 43.7 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a href="#" className="btn btn-outline-danger">
                Xóa
              </a>
            </span>
          </div>
        </div>
        <div
          className="card col-sm-6 col-md-4 col-lg-4"
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="PHÒNG DELUXE HƯỚNG BIỂN"
          />
          <div className="card-body">
            <h5 className="card-title">PHÒNG STUDIO SUITE HƯỚNG BIỂN</h5>
            <span className="card-text">
              Diện tích: 40.1 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a href="#" className="btn btn-outline-danger">
                Xóa
              </a>
            </span>
          </div>
        </div>
        <div
          className="card col-sm-6  col-md-4  col-lg-4"
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="PHÒNG SUITE HƯỚNG BIỂN"
          />
          <div className="card-body">
            <h5 className="card-title">PHÒNG SUITE HƯỚNG BIỂN</h5>
            <span className="card-text">
              Diện tích: 85.8 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a href="#" className="btn btn-outline-danger">
                Xóa
              </a>
            </span>
          </div>
        </div>
        <div
          className="card col-sm-6  col-md-4 col-lg-4"
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/03/Presidential-Suite-F-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="PHÒNG PRESIDENTIAL SUITE"
          />
          <div className="card-body">
            <h5 className="card-title">PHÒNG PRESIDENTIAL SUITE</h5>
            <span className="card-text">
              Diện tích: 8130 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a href="#" className="btn btn-outline-danger">
                Xóa
              </a>
            </span>
          </div>
        </div>
        <div
          className="card col-sm-6  col-md-4 col-lg-4"
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Villas_Beach_Pool_Villas-_Exterior-1-F-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="BIỆT THỰ HƯỚNG BIỂN CÓ HỒ BƠI RIÊNG"
          />
          <div className="card-body">
            <h5 className="card-title">BIỆT THỰ HƯỚNG BIỂN CÓ HỒ BƠI RIÊNG</h5>
            <span className="card-text">
              Diện tích: 85.8 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a href="#" className="btn btn-outline-danger">
                Xóa
              </a>
            </span>
          </div>
        </div>
        <div
          className="card col-sm-6  col-md-4 col-lg-4"
          style={{ width: "28rem", margin: "2rem" }}
        >
          <img
            src="https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Villas_Pool_Villas-F-370x239.jpg"
            width={370}
            height={239}
            className="card-img-top"
            alt="BIỆT THỰ HƯỚNG VƯỜN CÓ HỒ BƠI RIÊNG"
          />
          <div className="card-body">
            <h5 className="card-title">BIỆT THỰ HƯỚNG VƯỜN CÓ HỒ BƠI RIÊNG</h5>
            <span className="card-text">
              Diện tích: 85.8 m<sup>2</sup>
            </span>
            <span style={{ float: "right" }}>
              <a href="#" className="btn btn-outline-primary me-2">
                Sửa
              </a>
              <a
                href="#"
                className="btn btn-outline-danger"
                data-bs-toggle="modal"
                data-bs-target="#staticBackdrop1"
              >
                Xóa
              </a>
            </span>
          </div>
        </div>
      </div>
      {/*modal-delete*/}
      <div
        className="modal fade"
        id="staticBackdrop1"
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabIndex={-1}
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog modal-dialog">
          <div className="modal-content">
            <form>
              <div
                className="modal-header"
                style={{ backgroundColor: "#FFD333" }}
              >
                <h5 className="modal-title fs-5" id="staticBackdropLabel">
                  Bạn chắc chắn muốn xóa
                </h5>
                <a type="button" data-bs-dismiss="modal">
                  <i
                    className="fa-regular fa-rectangle-xmark fa-2xl"
                    style={{ color: "#1f1e1e" }}
                  />
                </a>
              </div>
              <div className="modal-body">
                <input id="deleteServiceId" name="deleteId" type="hidden" />
                <span>Dịch vụ tên </span>
                <span id="serviceName" name="deleteName" />
              </div>
              <div className="modal-footer">
                <button type="submit" className="btn btn-danger">
                  Xóa
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
export default ServiceList;
