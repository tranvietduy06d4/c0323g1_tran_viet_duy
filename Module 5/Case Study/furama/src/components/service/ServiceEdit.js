import { React } from "react";

function ServiceEdit() {
  return (
    <div
      className="row col-md-12"
      style={{ minHeight: "28rem", marginTop: "5rem" }}
    >
      <div className="col-md-3" />
      <div className="col-md-6">
        <form style={{ marginTop: "2%" }}>
          <div className="d-flex justify-content-center">
            <h2>Chỉnh sửa dịch vụ</h2>
          </div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Tên dịch vụ
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="text"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Diện tích sử dụng
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="number"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Chi phí thuê
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="number"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Số lượng người tối đa
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="number"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div className="input-group ">
            <label
              className="input-group-text mx-auto"
              htmlFor="inputGroupSelect01"
              style={{ width: "12.5rem" }}
            >
              Kiểu thuê
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </label>
            <div className="form-control">
              <input
                className="form-check-input"
                type="checkbox"
                name="inlineRadioOptions"
                id="inlineRadio1"
                defaultValue="option1"
              />
              <label className="form-check-label" htmlFor="inlineRadio1">
                Năm
              </label>
            </div>
            <div className="form-control">
              <input
                className="form-check-input"
                type="checkbox"
                name="inlineRadioOptions"
                id="inlineRadio2"
                defaultValue="option2"
              />
              <label className="form-check-label" htmlFor="inlineRadio2">
                Tháng
              </label>
            </div>
            <div className="form-control">
              <input
                className="form-check-input"
                type="checkbox"
                name="inlineRadioOptions"
                id="inlineRadio1"
                defaultValue="option3"
              />
              <label className="form-check-label" htmlFor="inlineRadio1">
                Ngày
              </label>
            </div>
            <div className="form-control">
              <input
                className="form-check-input"
                type="checkbox"
                name="inlineRadioOptions"
                id="inlineRadio2"
                defaultValue="option4"
              />
              <label className="form-check-label" htmlFor="inlineRadio2">
                Giờ
              </label>
            </div>
          </div>
          <div style={{ height: "1rem", marginBottom: "0.8rem" }}></div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Diện tích hồ bơi
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="number"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div className="input-group" style={{ marginTop: "1rem" }}>
            <span
              className="input-group-text mx-auto"
              id="basic-addon1"
              style={{ width: "12.5rem" }}
            >
              Số tầng
              <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
            </span>
            <input
              type="number"
              className="form-control"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
          </div>
          <div
            style={{
              height: "1rem",
              marginBottom: "0.8rem",
              marginLeft: "12.5rem",
            }}
          ></div>
          <div style={{ textAlign: "center" }}>
            <button
              className="btn btn-outline-primary"
              style={{ color: "black" }}
            >
              Cập nhật
            </button>
            <a
              className="btn btn-outline-warning"
              style={{ color: "black", marginLeft: "3%" }}
              href="#"
            >
              Hủy bỏ
            </a>
          </div>
        </form>
      </div>
      <div className="col-md-3"></div>
    </div>
  );
}
export default ServiceEdit;
