import { React } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import * as Yup from "yup";
import { toast } from "react-toastify";

function ContactForm() {
  return (
    <>
      <Formik
        initialValues={{
          name: "",
          email: "",
          phone: "",
          message: "",
        }}
        validationSchema={Yup.object({
          name: Yup.string()
            .required("Name is not empty")
            .matches(/^[A-z a-z]+$/, "Name invalid"),
          email: Yup.string()
            .required("Email is not empty")
            .matches(
              /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
              "Email invalid"
            ),
          phone: Yup.string()
            .required("Phone is not empty")
            .matches(
              /^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$/,
              "Phone number invalid"
            ),
        })}
        onSubmit={(values, { setSubmitting }) => {
          setSubmitting(false);
          toast(`Employee ${values.name} create success`);
        }}
        
      >
        <div className="container w-50">
          <h1 className="d-flex justify-content-center">Contact Form</h1>
          <Form>
            <div className="mb-3">
              <label htmlFor="exampleFormControlInput1" className="form-label">
                Name
              </label>
              <Field
                type="text"
                className="form-control"
                id="exampleFormControlInput1"
                placeholder="Enter your name"
                name="name"
              />
              <ErrorMessage
                name="name"
                component="span"
                className="form-error"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="exampleFormControlInput2" className="form-label">
                Email
              </label>
              <Field
                type="email"
                className="form-control"
                id="exampleFormControlInput2"
                placeholder="huy@gmail.com"
                name="email"
              />
              <ErrorMessage
                name="email"
                component="span"
                className="form-error"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="exampleFormControlInput3" className="form-label">
                Phone
              </label>
              <Field
                type="text"
                className="form-control"
                id="exampleFormControlInput3"
                placeholder="Enter your phone number"
                name="phone"
              />
              <ErrorMessage
                name="phone"
                component="span"
                className="form-error"
              />
            </div>

            <div className="mb-3">
              <label
                htmlFor="exampleFormControlTextarea4"
                className="form-label"
              >
                Message
              </label>
              <textarea
                className="form-control"
                id="exampleFormControlTextarea4"
                rows={3}
                name="message"
              />
            </div>
            <div className="d-flex">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
          </Form>
        </div>
      </Formik>
    </>
  );
}
export default ContactForm;
