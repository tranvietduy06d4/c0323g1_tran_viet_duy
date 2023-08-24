import { Formik, Field, Form } from "formik";
import * as bookService from "../services/BookService";
import { useNavigate } from "react-router-dom";

export function BookCreate() {
  const navigate = useNavigate();
  const addBook = async (book) => {
    const result = await bookService.addBook(book);
    navigate("/");
  };

  return (
    <>
      <Formik
        initialValues={{
          title: "",
          quantity: "",
        }}
        onSubmit={async (values, { setSubmitting }) => {
          setSubmitting(false);
          await addBook(values);
        }}
      >
        <Form>
          <div className="mb-3">
            <h1 htmlFor="title" className="form-label">
              Add new book
            </h1>
            <label htmlFor="title" className="form-label">
              Title
            </label>
            <Field
              type="text"
              className="form-control"
              id="title"
              name="title"
            />
            <label htmlFor="title" className="form-label">
              Quantity
            </label>
            <Field
              type="number"
              className="form-control"
              id="quantity"
              name="quantity"
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </Form>
      </Formik>
    </>
  );
}
