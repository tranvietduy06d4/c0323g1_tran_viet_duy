import { React, useState, useEffect } from "react";
import { Formik, Form, ErrorMessage, Field } from "formik";
import { Link, useNavigate, useParams } from "react-router-dom";
import * as Yup from "yup";
import { editFacility, getFacilityById } from "../../services/FacilityService";
import { getAllFacilityTypes } from "../../services/FacilityTypeService";

function ServiceEdit() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [facility, setFacility] = useState();
  const [types, setTypes] = useState([]);

  const findFacility = async (id) => {
    const currentFacility = await getFacilityById(id);
    setFacility(currentFacility);
  };
  async function getAllTypes() {
    const typeList = await getAllFacilityTypes();
    setTypes(typeList);
  }

  useEffect(() => {
    if (facility === undefined) {
      findFacility(id);
    }
  }, [id]);

  useEffect(() => {
    getAllTypes();
  }, []);

  if (!facility) return null;

  return (
    <>
      <Formik
        initialValues={{
          ...facility,
        }}
        onSubmit={async (values, { setSubmitting }) => {
          console.log(values);
          setSubmitting(false);
          await editFacility(id, {
            ...values,
            facilityType: JSON.parse(values.facilityType)
          });
          navigate("/");
        }}
      >
        <div
          className="row col-md-12"
          style={{ minHeight: "28rem", marginTop: "5rem" }}
        >
          <div className="col-md-3" />
          <div className="col-md-6">
            <Form style={{ marginTop: "2%" }}>
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
                <Field
                  type="text"
                  className="form-control"
                  name="name"
                  id="name"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
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
              <div className="input-group" style={{ marginTop: "1rem" }}>
                <span
                  className="input-group-text mx-auto"
                  id="basic-addon1"
                  style={{ width: "12.5rem" }}
                >
                  Diện tích sử dụng
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="number"
                  className="form-control"
                  name="area"
                  id="area"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
                <ErrorMessage
                  name="area"
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
              <div className="input-group" style={{ marginTop: "1rem" }}>
                <span
                  className="input-group-text mx-auto"
                  id="basic-addon1"
                  style={{ width: "12.5rem" }}
                >
                  Chi phí thuê
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="number"
                  className="form-control"
                  name="rentalCost"
                  id="rentalCost"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
                <ErrorMessage
                  name="rentalCost"
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
              <div className="input-group" style={{ marginTop: "1rem" }}>
                <span
                  className="input-group-text mx-auto"
                  id="basic-addon1"
                  style={{ width: "12.5rem" }}
                >
                  Số lượng người tối đa
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
                  type="number"
                  className="form-control"
                  name="capacity"
                  id="capacity"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
                <ErrorMessage
                  name="capacity"
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
                  <Field as="select" name="rentalType" className="form-control">
                    <option value="Year">Năm</option>
                    <option value="Month">Tháng</option>
                    <option value="Day">Ngày</option>
                    <option value="Hour">Giờ</option>
                  </Field>
                </div>
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
                  Loại dịch vụ
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </label>
                <div className="form-control">
                  <Field
                    as="select"
                    name="facilityType"
                    className="form-control"
                  >
                    {types.map((type) => {
                      return (
                        <option value={`${JSON.stringify(type)}`}>
                          {type.name}
                        </option>
                      );
                    })}
                  </Field>
                </div>
              </div>
              {/* <div className="form-control">
                <Field
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
                <Field
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
                <Field
                  className="form-check-input"
                  type="checkbox"
                  name="inlineRadioOptions"
                  id="inlineRadio2"
                  defaultValue="option4"
                />
                <label className="form-check-label" htmlFor="inlineRadio2">
                  Giờ
                </label>
              </div> */}
              {/* </div> */}
              {/* <div style={{ height: "1rem", marginBottom: "0.8rem" }}></div>
              <div className="input-group" style={{ marginTop: "1rem" }}>
                <span
                  className="input-group-text mx-auto"
                  id="basic-addon1"
                  style={{ width: "12.5rem" }}
                >
                  Diện tích hồ bơi
                  <b style={{ color: "red", marginLeft: "0.25rem" }}>*</b>
                </span>
                <Field
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
                <Field
                  type="number"
                  className="form-control"
                  aria-label="Username"
                  aria-describedby="basic-addon1"
                />
              </div> */}
              {/* <div
                style={{
                  height: "1rem",
                  marginBottom: "0.8rem",
                  marginLeft: "12.5rem",
                }}
              ></div> */}
              <div style={{ textAlign: "center" }}>
                <button
                  type="submit"
                  className="btn btn-outline-primary"
                  style={{ color: "black" }}
                >
                  Cập nhật
                </button>
                <a>
                  <Link
                    to={"/"}
                    className="btn btn-outline-warning"
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
export default ServiceEdit;
