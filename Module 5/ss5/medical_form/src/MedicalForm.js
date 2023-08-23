import { React } from "react";
import * as Yup from "yup";
import { Formik, Form, Field, ErrorMessage } from "formik";

function MedicalForm() {
  return (
    <>
      <Formik
        initialValues={{
          name: "",
          idCard: "",
          birthYear: "",
          gender: "0",
          nation: "",
          company: "",
          department: "",
          medicalCard: "0",
          city: "",
          district: "",
          ward: "",
          detailAddress: "",
          phone: "",
          email: "",
          cityHistory: "",
          sickBehavour: [],
        }}
        validationSchema={Yup.object({
          name: Yup.string()
            .required("Tên không được để trống")
            .matches(/^[A-z a-z]+$/, "Tên không hợp lệ"),
          idCard: Yup.string().required("Số CMND/ CCCD không được để trống"),
          birthYear: Yup.number()
            .required("Năm sinh không được để trống")
            .min(1900, "Năm sinh phải lớn hơn 1900"),
          nation: Yup.string().required("Tên quốc gia không được để trống"),
          city: Yup.string().required("Tên tỉnh/thành phố không được để trống"),
          district: Yup.string().required("Tên quận/huyện không được để trống"),
          ward: Yup.string().required("Tên phường/xã không được để trống"),
          detailAddress: Yup.string().required(
            "Tên Số nhà, phố, tổ dân phố /thôn /đội không được để trống"
          ),
          phone: Yup.string()
            .required("Số điện thoại không được để trống")
            .matches(
              /^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$/,
              "Số điện thoại không hợp lệ"
            ),
          email: Yup.string()
            .required("Đại chỉ email không được để trống")
            .matches(
              /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
              "Địa chỉ eamil không hợp lệ"
            ),
        })}
      >
        <div
          className="container-fluid"
          style={{ marginTop: 80, marginBottom: 30 }}
        >
          <Form>
            <p className="text-center display-3" style={{ color: "#d5b981" }}>
              Thông tin Tờ khai y tế
            </p>
            <div className="row">
              {/* Name input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="name">
                  Họ và tên
                </label>
                <Field
                  type="text"
                  id="name"
                  className="form-control w-75"
                  name="name"
                />
                <ErrorMessage
                  name="name"
                  component="span"
                  className="form-error"
                />
              </div>

              {/* Birthday input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="birthDay">
                  Năm sinh
                </label>
                <Field
                  type="number"
                  id="birthDay"
                  className="form-control w-75"
                  name="birthYear"
                />
                <ErrorMessage
                  name="birthYear"
                  component="span"
                  className="form-error"
                />
              </div>
            </div>

            <div className="row">
              {/* Nation input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="nation">
                  Quốc tịch
                </label>
                <Field
                  type="text"
                  id="nation"
                  className="form-control w-75"
                  name="nation"
                />
                <ErrorMessage
                  name="nation"
                  component="span"
                  className="form-error"
                />
              </div>

              {/* ID Card input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="idCard">
                  Số CMND/CCCD
                </label>
                <Field
                  type="text"
                  id="idCard"
                  className="form-control w-75"
                  name="idCard"
                />
                <ErrorMessage
                  name="idCard"
                  component="span"
                  className="form-error"
                />
              </div>
            </div>

            <div className="row">
              {/* Company input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="company">
                  Tên công ty
                </label>
                <Field
                  type="text"
                  id="company"
                  className="form-control w-75"
                  name="company"
                />
              </div>

              {/* Department input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="department">
                  Tên bộ phận
                </label>
                <Field
                  type="text"
                  id="department"
                  className="form-control w-75"
                  name="department"
                />
              </div>
            </div>

            <div className="row">
              {/* Gender input */}
              <div className="form-outline mb-4 col-lg-6">
                <div className="form-label">Giới tính</div>
                <Field
                  className="form-check-input"
                  type="radio"
                  id="gender1"
                  value="0"
                  name="gender"
                />
                <label className="form-label mx-2" htmlFor="gender1">
                  Nam
                </label>

                <Field
                  className="form-check-input"
                  type="radio"
                  id="gender2"
                  value="0"
                  name="gender"
                />
                <label className="form-label mx-2" htmlFor="gender2">
                  Nữ
                </label>
              </div>

              {/* medicalCard input */}
              <div className="form-outline mb-4 col-lg-6">
                <div className="form-label">Thẻ bảo hiểm y tế</div>
                <Field
                  type="radio"
                  id="medicalCard"
                  className="form-check-input"
                  name="medicalCard"
                  value="1"
                />
                <label className="form-label mx-2" htmlFor="medicalCard">
                  Có thẻ bảo hiểm y tế
                </label>
              </div>
            </div>

            <h3 className="text-center">Địa chỉ liên lạc tại Việt Nam</h3>

            <div className="row">
              {/* City input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="city">
                  Tỉnh/Thành phố
                </label>
                <Field
                  type="text"
                  id="city"
                  className="form-control w-75"
                  name="city"
                />
              </div>

              {/* District input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="city">
                  Quận/Huyện
                </label>
                <Field
                  type="text"
                  id="district"
                  className="form-control w-75"
                  name="district"
                />
              </div>
            </div>

            <div className="row">
              {/* Ward input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="city">
                  Phường/Xã
                </label>
                <Field
                  type="text"
                  id="ward"
                  className="form-control w-75"
                  name="ward"
                />
              </div>

              {/* detailAddress input */}
              <div className="form-outline mb-4 col-lg-6">
                <label className="form-label" htmlFor="city">
                  Số nhà, phố, tổ dân phố /thôn /đội
                </label>
                <Field
                  type="text"
                  id="detailAddress"
                  className="form-control w-75"
                  name="detailAddress"
                />
              </div>
            </div>

            <div className="row col-lg-6">
              <h3>
                Trong vòng 14 ngày qua, anh/chị có đến quốc gia vùng lãnh thổ
                nào ? (Có thể đi qua nhiều quốc gia)
              </h3>
              <Field
                type="text"
                id="cityHistory"
                className="form-control mb-2"
                name="cityHistory"
              />

              <h3>Trong vòng 14 ngày qua, Anh/Chị có dấu hiệu nào sau đây?</h3>
              <Field
                type="checkbox"
                id="sickBehavour1"
                className="form-check-input"
                name="sickBehavour"
                value="0"
              />
              <label className="form-label" htmlFor="sickBehavour1">
                Sốt
              </label>
              <Field
                type="checkbox"
                id="sickBehavour2"
                className="form-check-input"
                name="sickBehavour"
                value="1"
              />
              <label className="form-label" htmlFor="sickBehavour2">
                Ho
              </label>
              <Field
                type="checkbox"
                id="sickBehavour3"
                className="form-check-input"
                name="sickBehavour"
                value="2"
              />
              <label className="form-label" htmlFor="sickBehavour3">
                Khó thở
              </label>
              <Field
                type="checkbox"
                id="sickBehavour4"
                className="form-check-input"
                name="sickBehavour"
                value="3"
              />
              <label className="form-label" htmlFor="sickBehavour4">
                Viêm phổi
              </label>
              <Field
                type="checkbox"
                id="sickBehavour5"
                className="form-check-input"
                name="sickBehavour"
                value="4"
              />
              <label className="form-label" htmlFor="sickBehavour5">
                Đau họng
              </label>
              <Field
                type="checkbox"
                id="sickBehavour6"
                className="form-check-input"
                name="sickBehavour"
                value="5"
              />
              <label className="form-label" htmlFor="sickBehavour6">
                Mệt mỏi
              </label>


              <h3>Trong vòng 14 ngày qua, Anh/Chị có tiếp xúc với?</h3>
              <Field
                type="checkbox"
                id="sickContact1"
                className="form-check-input"
                name="sickContact"
                value="0"
              />
              <label className="form-label" htmlFor="sickContact1">
              Người bệnh nghi ngờ,mắc bệnh COVID-19
              </label>
              <Field
                type="checkbox"
                id="sickContact2"
                className="form-check-input"
                name="sickContact"
                value="1"
              />
              <label className="form-label" htmlFor="sickContact2">
              Người từ nước có bệnh COVID-19
              </label>
              <Field
                type="checkbox"
                id="sickContact"
                className="form-check-input"
                name="sickContact3"
                value="2"
              />
              <label className="form-label" htmlFor="sickContact3">
              Người có biểu hiện (Sốt,ho,khó thở,viêm phổi)
              </label>
            </div>

            <div className="row">
              {/* Submit button */}
              <div className="text-center mt-2">
                <button
                  type="submit"
                  className="btn btn-primary btn-block mx-3 "
                >
                  Khai báo
                </button>
                <a>
                  <button type="button" className="btn btn-danger btn-block">
                    Hủy
                  </button>
                </a>
              </div>
            </div>
          </Form>
        </div>
      </Formik>
    </>
  );
}
export default MedicalForm;
