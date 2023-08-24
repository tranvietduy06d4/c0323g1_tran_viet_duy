import { useEffect, useState } from "react";
import { Formik, Field, Form, ErrorMessage } from "formik";
import * as bookService from "../services/BookService";
import { Link } from "react-router-dom";

export function BookList() {
  const [books, setBooks] = useState([]);
  useEffect(() => {
    getAll();
  }, []);

  const getAll = async () => {
    const result = await bookService.getAll();
    setBooks((prev) => result);
  };

  const deleteBook = async (values) => {
    await bookService.deleteBook(values);
    alert("Delete book success");
    getAll();
  };

  return (
    <>
      <h1 className="my-3">Library</h1>
      <Formik
        initialValues={{
          title: "",
          quantity: "",
        }}
      >
        <Link
          to={"/create"}
          className="btn btn-outline-primary mx-5"
          style={{ float: "right" }}
        >
          Add new book
        </Link>
      </Formik>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Title</th>
            <th>Quantity</th>
            <th colSpan={2}>Action</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr key={book.id}>
              <td>{book.title}</td>
              <td>{book.quantity}</td>
              <td>
                <Link to={`/edit/${book.id}`}  className="btn btn-outline-primary">Edit</Link>
              </td>
              <td>
                <button
                  onClick={() => deleteBook(`${book.id}`)}
                  className="btn btn-outline-danger"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
