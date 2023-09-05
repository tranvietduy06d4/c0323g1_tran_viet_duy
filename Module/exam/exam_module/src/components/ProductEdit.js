import { Formik, Form, Field, ErrorMessage } from "formik";
import { React, useState, useEffect } from "react";
import * as Yup from "yup";
import { Link, useParams, useNavigate } from "react-router-dom";
import { getAllProductType } from "../services/ProductTypeService";
import { editProduct, getProductById } from "../services/ProductService";

function ProductEdit() {
  const [product, setProduct] = useState();
  const [types, setTypes] = useState([]);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    findProductById(id);
  }, [id]);

  useEffect(() => {
    getAllTypes();
  }, []);

  const getAllTypes = async () => {
    const result = await getAllProductType();
    setTypes(result);
  };

  const findProductById = async (id) => {
    const result = await getProductById(id);
    setProduct(result);
  };


  if (product === undefined) return null;
  if (types.length===0) return null;

  return (
    <>
      <Formik
        initialValues={{
          ...product,
          category: JSON.stringify(product.category),
          
        }}
        validationSchema={Yup.object({
          name: Yup.string()
            .required("Tên sản phẩm không được để trống"),

          importDate: Yup.date()
            .required("Vui lòng điền ngày nhập hàng"),

          quantity: Yup.number()
            .required("Vui lòng điền số lượng sản phẩm")
            .min(1),
        })}
        
        onSubmit={async (values, { setSubmitting }) => {
          setSubmitting(false);
          console.log(values);
          await editProduct({
            ...values,
            category: JSON.parse(values.category)
          })
          alert("Đã chỉnh sửa thành công sản phẩm");

          navigate("/");
        }}
      >
        <div
          className="row col-md-12"
          style={{ minHeight: "28rem", marginTop: "3rem" }}
        >
          <div className="col-md-3" />
          <div className="col-md-6">
            <Form style={{ marginTop: "4%" }}>
              <div className="d-flex justify-content-center">
                <h2>Chỉnh sửa sản phẩm</h2>
              </div>
              <div className="input-group" style={{ marginTop: "1rem" }}>
                <span
                  className="input-group-text mx-auto"
                  id="basic-addon1"
                  style={{ width: "12.5rem" }}
                >
                  Tên sản phẩm
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="text"
                  className="form-control"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                  name="name"
                  id="name"
                />
                <ErrorMessage
                  name="name"
                  components="span"
                  className="form-error"
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
                  Ngày nhập sản phẩm
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="date"
                  className="form-control"
                  aria-label="Username"
                  aria-describedby="basic-addon2"
                  name="importDate"
                  id="importDate"
                />
                <ErrorMessage
                  name="importDate"
                  components="span"
                  className="form-error"
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
                  Số lượng sản phẩm
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="number"
                  className="form-control"
                  name="quantity"
                  id="quantity"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
                <ErrorMessage
                  name="quantity"
                  components="span"
                  className="form-error"
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
                  htmlFor="category"
                  style={{ width: "12.5rem" }}
                >
                  Loại sản phẩm
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </label>

                <Field as="select" name="category" className="form-control">
                  {types.map((type) => (
                    <option value={`${JSON.stringify(type)}`}>
                      {type.name}
                    </option>
                  ))}
                </Field>
              </div>
              <div style={{ height: "1rem", marginBottom: "0.8rem" }}></div>

              <div style={{ textAlign: "center" }}>
                <button
                  type="submit"
                  className="btn btn-primary"
                  style={{ color: "black" }}
                >
                  Cập nhật
                </button>
                <a>
                  <Link
                    to={"/"}
                    className="btn btn-info"
                    style={{ color: "black", marginLeft: "3%" }}
                  >
                    Hủy bỏ
                  </Link>
                </a>
              </div>
            </Form>
          </div>
          <div className="col-md-3"></div>
        </div>
      </Formik>
    </>
  );
}
export default ProductEdit;
