import { Field, Form, Formik } from "formik";
import React, { useEffect, useState } from "react";
import { BsFacebook } from "react-icons/bs";
import { AiFillGoogleCircle } from "react-icons/ai";
import { Link, useNavigate } from "react-router-dom";
import { LoginSocialFacebook } from "reactjs-social-login";
import Header from "../header/Header";
import Footer from "../footer/Footer";
import * as userService from "../../services/UserService";
import Swal from "sweetalert2";

const Login = () => {
  const navigate = useNavigate();
  useEffect(() => {
    document.title = "ANorganic - Đăng nhập";
  }, []);

  const loginByUserName = async (user) => {
    try {
        const result = await userService.loginByUserName(user);
        userService.addJwtTokenToLocalStorage(result.data.token);
        // const tempURL = localStorage.getItem("tempURL");
        // localStorage.removeItem("tempURL");
        // if (tempURL) {
        //     navigate(tempURL);
        // } else {
            navigate('/');

        
    } catch (e) {
        Swal.fire({
            icon: 'error',
            title: "Tài khoản không tồn tại",
        })

    }

}

  return (
    <>
      <Header />
      <Formik
        initialValues={{
          userName: "",
          password: "",
        }}
        onSubmit={(values, {setSubmitting}) => {
          setSubmitting(false);
          loginByUserName(values);

        }}
      >
        <Form>
        <div className="vh-100 d-flex justify-content-center align-items-center">
          <div className="col-md-4 p-5 shadow-sm border rounded-3">
            <h2 className="text-center mb-4 " style={{ color: "#61c245" }}>
              Đăng nhập
            </h2>

            <div className="mb-1">
              <label htmlFor="userName" className="form-label">
                Tài khoản <span className="text-danger">*</span>
              </label>
              <Field
                type="text"
                className="form-control border border-success"
                name="userName"
              />
              <div style={{ height: "15px" }}></div>
            </div>

            <div className="mb-1">
              <label htmlFor="password" className="form-label">
                Mật khẩu <span className="text-danger">*</span>
              </label>
              <Field
                type="password"
                className="form-control border border-success"
                name="password"
              />
              <div style={{ height: "15px" }}></div>
            </div>

            <div className="mt-4 d-flex justify-content-center">
              <button className="btn btn-success " type="submit">
                Đăng nhập
              </button>
            </div>

            <div className="mt-3 d-flex justify-content-between align-items-center">
              <div className="mb-0">
                Bạn chưa có tài khoản?&nbsp;
                <a
                  className="fw-bold text-decoration-none"
                  style={{ color: "#61c245" }}
                >
                  Đăng ký
                </a>
              </div>
            </div>
          </div>
        </div>
        </Form>
      </Formik>

      <Footer />
    </>
  );
};
export default Login;
