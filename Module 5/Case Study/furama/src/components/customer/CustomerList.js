import { React, useState, useEffect } from "react";
import { getAll, getCustomerByName } from "../../services/CustomerService";
import { deleteCustomer } from "../../services/CustomerService";
import { Link } from "react-router-dom";

function CustomerList() {
  const [customers, setCustomers] = useState([]);
  const [page, setPage] = useState(1);
  const [totalPage, setTotalPage] = useState();
  const [searchName, setSearchName] = useState("");

  useEffect(() => {
    loadCustomerList(page, searchName);
  }, [page, searchName]);

  const prevPage = () => {
    if (page > 1) {
      setPage((pre) => pre - 1);
    }
  };

  const nextPage = () => {
    console.log(page);
    console.log(totalPage);
    if (page < totalPage) {
      setPage((pre) => pre + 1);
    }
  };

  const makeSearchName = () => {
    const newSearchName = document.getElementById("searchName").value;
    setSearchName(newSearchName);
    setPage(1);
  };

  const loadCustomerList = async () => {
    const result = await getCustomerByName(page, searchName);
    setTotalPage(Math.ceil(result.headers["x-total-count"] / 3));
    setCustomers(result.data);
  };

  const removeCustomer = async (id) => {
    const result = await deleteCustomer(id);
    loadCustomerList();
    alert("Xóa khách hàng thành công");
  };

  if (customers.length === 0) {
    return null;
  }

  return (
    <>
      <div style={{ minHeight: "28rem", marginTop: "5rem" }}>
        <h1 style={{ textAlign: "center" }}>Danh sách khách hàng</h1>

        <div className="d-flex justify-content-end mb-1">
          <div className="d-flex">
            <input type="text" className="form-control mx-2" id="searchName" />

            <button
              onClick={() => makeSearchName()}
              className="btn btn-outline-warning me-2"
              type="button"
            >
              <i className="fa-solid fa-magnifying-glass" />
            </button>

            <Link
              to={"/customer/create"}
              className="btn btn-outline-primary"
              style={{
                textDecoration: "none",
                marginRight: "2rem",
                width: "10rem",
              }}
            >
              Thêm mới
            </Link>
          </div>
        </div>

        <table className="table table-striped table-hover mt-2">
          <thead>
            <tr>
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
            {customers.map((customer) => (
              <tr key={customer.id}>
                <td>{customer.name}</td>
                <td>{customer.birthday}</td>
                <td>{customer.gender ? "Nam" : "Nữ"}</td>
                <td>{customer.idCard}</td>
                <td>{customer.phone}</td>
                <td>{customer.email}</td>
                <td>{customer.customerType.name}</td>
                <td>{customer.address}</td>
                <td>
                  <a className="btn btn-outline-primary border border-dark">
                    <Link
                      to={`/customer/${customer.id}`}
                      style={{ textDecoration: "none" }}
                    >
                      Sửa
                    </Link>
                  </a>
                </td>
                <td>
                  <button
                    type="button"
                    onClick={() => removeCustomer(`${customer.id}`)}
                    className="btn btn-outline-danger btn-square border-dark"
                    // data-bs-toggle="modal"
                    // data-bs-target="#staticBackdrop1"
                  >
                    Xóa
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        <nav className="d-flex justify-content-center">
          <ul className="pagination">
            <li className="page-item">
              <button
                type="button"
                className="page-link"
                onClick={() => prevPage()}
              >
                Prev
              </button>
            </li>
            <li className="page-item active" aria-current="page">
              <a className="page-link" href="#">
                {page}
              </a>
            </li>
            <li className="page-item">
              <button
                type="button"
                className="page-link"
                onClick={() => nextPage()}
              >
                Next
              </button>
            </li>
          </ul>
        </nav>
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
