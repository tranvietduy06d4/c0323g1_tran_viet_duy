import { React } from "react";

function CustomerList() {
  return (
    <>
      <div style={{ minHeight: "28rem", marginTop: "5rem" }}>
        <h1 style={{ textAlign: "center" }}>Danh sách khách hàng</h1>
        <a
          href="#"
          className="btn btn-outline-success"
          style={{ float: "right", marginRight: "2rem" }}
        >
          Thêm mới
        </a>
        <table className="table table-striped table-hover mt-2">
          <thead>
            <tr>
              <th>STT</th>
              <th>Họ và tên</th>
              <th>Ngày sinh</th>
              <th>Giới tính</th>
              <th>Số CMND</th>
              <th>Số điện thoại</th>
              <th>Email</th>
              <th>Loại khách</th>
              <th>Địa chỉ</th>
              <th colSpan={2}>CHỨC NĂNG</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Trần Văn Bình</td>
              <td>13-06-2000</td>
              <td>Nam</td>
              <td>205332456</td>
              <td>0987657435</td>
              <td>binhtv@gmail.com</td>
              <td>Diamond</td>
              <td>57 Bạch Đằng, Đà Nẵng</td>
              <td>
                <a
                  className="btn btn-outline-primary border border-dark"
                  href="#"
                >
                  Sửa
                </a>
              </td>
              <td>
                <a
                  href="#"
                  className="btn btn-outline-danger btn-square border-dark"
                  data-bs-toggle="modal"
                  data-bs-target="#staticBackdrop1"
                >
                  Xóa
                </a>
              </td>
            </tr>
            <tr>
              <td>1</td>
              <td>Nguyễn Minh Châu</td>
              <td>23-07-1999</td>
              <td>Nữ</td>
              <td>205228983</td>
              <td>0976294738</td>
              <td>chaunm@gmail.com</td>
              <td>Platinium</td>
              <td>57 Bạch Đằng, Đà Nẵng</td>
              <td>
                <a href="#" className="btn btn-outline-primary border border-dark">
                  Sửa
                </a>
              </td>
              <td>
                <a
                  href="#"
                  className="btn btn-outline-danger btn-square border-dark"
                  data-bs-toggle="modal"
                  data-bs-target="#staticBackdrop1"
                >
                  Xóa
                </a>
              </td>
            </tr>
          </tbody>
        </table>
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
                  <button
                    type="button"
                    className="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  />
                </div>
                <div className="modal-body">
                  <input id="customerId" name="id" type="hidden" />
                  <span>Khách hàng tên </span>
                  <span id="customerName" name="deleteName" />
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
      </div>
    </>
  );
}
export default CustomerList;
