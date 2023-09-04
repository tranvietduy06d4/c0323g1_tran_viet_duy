import { React, useState, useEffect } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { Link, useNavigate, useParams } from "react-router-dom";
import * as customerService from "../../services/CustomerService";
import * as Yup from "yup";
import { getAllCustomerTypes } from "../../services/CustomerTypeService";

function CustomerEdit() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [customer, setCustomer] = useState();
  const [types, setTypes] = useState([]);

  const findCustomer = async (id) => {
    const currentCustomer = await customerService.getCustomerById(id);
    setCustomer(currentCustomer);
  };

  async function getAllTypes() {
    const typeList = await getAllCustomerTypes();
    setTypes(typeList);
  }

  useEffect(() => {
    if (customer === undefined) {
      findCustomer(id);
    }
  }, [id]);

  useEffect(() => {
    getAllTypes();
  }, []);

  if (!customer) return null;

  return (
    <>
      <Formik
        enableReinitialize={true}
        initialValues={{
          ...customer,
          gender: `${customer.gender}`,
          customerType: JSON.stringify(customer.customerType)
        }}
        validationSchema={Yup.object({
          name: Yup.string()
            .required("Họ và tên không được để trống"),
            // .matches(
            //   /^([\p{Lu}][\p{Ll}]{1,8})(\s([\p{Lu}]|[\p{Lu}][\p{Ll}]{1,10})){0,5}$/,
            //   "Tên không hợp lệ"
            // ),

          birthday: Yup.string().required("Vui lòng điền ngày sinh"),

          idCard: Yup.string().required("Số CMND/CCCD không được để trống"),

          phone: Yup.string()
            .required("Số điện thoại không được để trống")
            .matches(
              /^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$/,
              "Số điện thoại không hợp lệ"
            ),
          address: Yup.string().required(
            "Địa chỉ khách hàng không được để trống"
          ),
        })}
        onSubmit={async (values, { setSubmitting }) => {
          setSubmitting(false);
          console.log(values);
          await customerService.editCustomer(id, {
            ...values,
            gender: values.gender === "true",
            customerType: JSON.parse(values.customerType),
          });
          navigate("/customer/list");
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
                  component="span"
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
                  Ngày sinh
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="date"
                  className="form-control"
                  aria-label="Username"
                  aria-describedby="basic-addon2"
                  name="birthday"
                  id="birthday"
                />
                <ErrorMessage
                  name="birthday"
                  component="span"
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
                <label
                  className="input-group-text mx-auto"
                  htmlFor="gender"
                  style={{ width: "12.5rem" }}
                >
                  Giới tính
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </label>
                <Field
                  className="form-check"
                  type="radio"
                  id="male"
                  value="true"
                  name="gender"
                />
                <label className="form-label mx-2" htmlFor="male">
                  Nam
                </label>
                <Field
                  className="form-check"
                  type="radio"
                  id="female"
                  value="false"
                  name="gender"
                />
                <label className="form-label mx-2" htmlFor="female">
                  Nữ
                </label>
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
                <Field
                  type="text"
                  className="form-control"
                  name="idCard"
                  id="idCard"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
                <ErrorMessage
                  name="idCard"
                  component="span"
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
              <div className="input-group mx-auto">
                <span className="input-group-text" style={{ width: "12.5rem" }}>
                  Số điện thoại
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="text"
                  className="form-control"
                  name="phone"
                  id="phone"
                />
                <ErrorMessage
                  name="phone"
                  component="span"
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
                  id="basic-addon3"
                  style={{ width: "12.5rem" }}
                >
                  Địa chỉ email
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="text"
                  className="form-control"
                  id="email"
                  name="email"
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
                  htmlFor="customerType"
                  style={{ width: "12.5rem" }}
                >
                  Loại khách
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </label>

                <Field as="select" name="customerType" className="form-control">
                  {/* <option value={customer.customerType.name}>{customer.customerType.name}</option> */}
                  {types.map((type) => {
                    return (
                      <option value={`${JSON.stringify(type)}`}>
                        {type.name}
                      </option>
                    );
                  })}
                </Field>
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
                <Field
                  type="texarea"
                  className="form-control"
                  aria-label="With textarea"
                  name="address"
                />
                <ErrorMessage
                  name="address"
                  component="span"
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
                    to={"/customer/list"}
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
export default CustomerEdit;
