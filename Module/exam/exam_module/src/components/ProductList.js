import { React, useState, useEffect } from "react";
import {Link,useNavigate} from "react-router-dom";
import { deleteProduct, getAllProduct } from "../services/ProductService";
import { getAllProductType } from "../services/ProductTypeService";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [types, setTypes] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPage, setTotalPage] = useState();
  const [searchName, setSearchName] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    loadProductList(page,searchName);
    getAllTypes();
  },[page,searchName]);



  const getAllTypes = async () => {
    const result = await getAllProductType();
    setTypes(result);
  };

  const loadProductList = async (page,searchName) => {
    const result = await getAllProduct(page,searchName);
    setTotalPage(Math.ceil(result.size/2));
    setProducts(result.content);
  };

  const previousPage = () => {
    if (page > 0) {
      setPage((pre) => pre - 1);
    }
  };

  const nextPage = () => {
    if (page < totalPage) {
      setPage((pre) => pre + 1);
    }
  };

  const makeSearchName = () => {
    const newSearchName = document.getElementById("searchName").value;
    setSearchName(newSearchName);
    setPage(0);
  };

  const removeProduct = async(id) => {
    await deleteProduct(id);
    alert("Đã xóa thành công sản phẩm");
    navigate("/");
    
  }


  if (types.length===0) return null;

  return (
    <>
      <h1 style={{ textAlign: "center" }}>Danh sách sản phẩm</h1>

      <div className="d-flex justify-content-end mb-1">
        <div className="d-flex">
          <input type="text" className="form-control mx-2" id="searchName" placeholder="Nhập tên sản phẩm" />
          <select>
            <option value="0">Chọn loại sản phẩm</option>
            <option value="1">Bánh</option>
            <option value="2">Kẹo</option>
            <option value="3">Nước ngọt</option>


          </select>

          <button onClick={() => makeSearchName()} className="btn btn-outline-warning me-2" type="button">
            Tìm kiếm
          </button>

          <a
            className="btn btn-outline-primary"
            style={{
              textDecoration: "none",
              marginRight: "2rem",
              width: "10rem",
            }}
          >
            Thêm mới
          </a>
        </div>
      </div>

      <table className="table table-striped table-hover mt-2">
        <thead>
          <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Ngày nhập</th>
            <th>Số lượng</th>
            <th>Loại sản phẩm</th>
            <th colSpan={2}>Chức năng</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.code}</td>
              <td>{product.name}</td>
              <td>{product.importDate}</td>
              <td>{product.quantity}</td>
              <td>{product.category.name}</td>
              <td>
                <Link to={`/edit/${product.id}`} className="btn btn-outline-primary border border-dark">
                  Sửa
                </Link>
              </td>
              <td>
                <button
                  type="button"
                  onClick={() => removeProduct(product.id)}
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
              onClick={() => previousPage()}
              className="page-link">
              Prev
            </button>
          </li>
          <li className="page-item active" aria-current="page">
            <a className="page-link" href="#">
              {page}
            </a>
          </li>
          <li className="page-item">
            <button  onClick={() => nextPage()} type="button" className="page-link">
              Next
            </button>
          </li>
        </ul>
      </nav>
    </>
  );
}

export default ProductList;
