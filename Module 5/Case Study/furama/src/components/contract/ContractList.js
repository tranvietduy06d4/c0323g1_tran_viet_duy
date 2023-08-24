import { React } from "react";

function ContractList() {
  return (
    <>
      <div style={{ minHeight: "28rem", marginTop: "5rem" }}>
        <h1 style={{ textAlign: "center" }}>Danh sách hợp đồng</h1>
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
              <th>Số hợp đồng</th>
              <th>Ngày bắt đầu</th>
              <th>Ngày kết thúc</th>
              <th>Số tiền cọc trước</th>
              <th>Tổng số tiền thanh toán</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>C-0001</td>
              <td>13-06-2023</td>
              <td>20-06-2023</td>
              <td>2000000</td>
              <td>15000000</td>
            </tr>
            <tr>
              <td>2</td>
              <td>C-0002</td>
              <td>16-07-2023</td>
              <td>22-07-2023</td>
              <td>3000000</td>
              <td>17000000</td>
            </tr>
            <tr>
              <td>3</td>
              <td>C-0003</td>
              <td>26-08-2023</td>
              <td>30-08-2023</td>
              <td>4000000</td>
              <td>20000000</td>
            </tr>
          </tbody>
        </table>
      </div>
    </>
  );
}
export default CustomerList;


