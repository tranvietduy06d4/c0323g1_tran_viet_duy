import { React } from "react";

function CustomerEdit() {
  return (
    <>
      <div
        className="row col-md-12"
        style={{ minHeight: "28rem", marginTop: "3rem" }}
      >
        <div className="col-md-3" />
        <div className="col-md-6">
          <form style={{ marginTop: "4%" }}>
            <div className="d-flex justify-content-center">
              <h2>Chỉnh sửa khách hàng</h2>
            </div>
            <div className="input-group" style={{ marginTop: "1rem" }}>
              <span
                className="input-group-text mx-auto"
                id="basic-addon1"
                style={{ width: "12.5rem" }}
              >
                Họ và tên
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
            <div className="input-group">
              <span
                className="input-group-text mx-auto"
                id="basic-addon2"
                style={{ width: "12.5rem" }}
              >
                Ngày sinh
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </span>
              <input
                type="date"
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
                Giới tính
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </label>
              <select className="form-select" id="inputGroupSelect01">
                <option value="true">Nam</option>
                <option value="false">Nữ</option>
              </select>
            </div>
            <div style={{ height: "1rem", marginBottom: "0.8rem" }}></div>
            <div className="input-group" style={{ marginTop: "1rem" }}>
              <span
                className="input-group-text mx-auto"
                id="basic-addon1"
                style={{ width: "12.5rem" }}
              >
                Số CMND
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
            <div className="input-group mx-auto">
              <span className="input-group-text" style={{ width: "12.5rem" }}>
                Số điện thoại
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </span>
              <input type="text" className="form-control" />
            </div>
            <div
              style={{
                height: "1rem",
                marginBottom: "0.8rem",
                marginLeft: "12.5rem",
              }}
            ></div>
            <div className="input-group">
              <span
                className="input-group-text mx-auto"
                id="basic-addon3"
                style={{ width: "12.5rem" }}
              >
                Địa chỉ email
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </span>
              <input
                type="text"
                className="form-control"
                id="basic-url"
                aria-describedby="basic-addon3"
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
                Loại khách
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </label>
              <select className="form-select" id="inputGroupSelect01">
                <option value={1}>Member</option>
                <option value={2}>Silver</option>
                <option value={3}>Gold</option>
                <option value={4}>Platinium</option>
                <option value={5}>Diamond</option>
              </select>
            </div>
            <div style={{ height: "1rem", marginBottom: "0.8rem" }}></div>
            <div className="input-group">
              <span
                className="input-group-text mx-auto"
                style={{ width: "12.5rem" }}
              >
                Địa chỉ khách hàng
                <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
              </span>
              <textarea
                className="form-control"
                aria-label="With textarea"
                defaultValue={""}
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
              <button className="btn btn-primary" style={{ color: "black" }}>
                Cập nhật
              </button>
              <a
                className="btn btn-info"
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
    </>
  );
}
export default CustomerEdit;
