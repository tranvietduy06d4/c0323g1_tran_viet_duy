import { Formik, Field, Form } from "formik";
import * as bookService from "../services/BookService";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";


export function BookEdit() {
  const navigate = useNavigate();

  const {id} = useParams();

  const [book,setBook] = useState();



  
  const findBook = async () =>{
    const currentBook = await axios.get(`http://localhost:8080/books/`+id);
    console.log(currentBook.data.title);
    setBook(prev => ({...prev,...currentBook})); 
  }

  useEffect(()=>{
    if(book===undefined) {
      findBook();
    }

},[book])
console.log(book);

  const editBook = async (values) => {
    const result = await bookService.editBook(id,values);
    navigate("/");
  };

  return (
    <>
    {book !== undefined ?
      <Formik
        // enableReinitialize={true}
        initialValues={{
          ...book.data,
        }}
        onSubmit={async (values, { setSubmitting }) => {
          setSubmitting(false);
          await editBook(values);
        }}
      >
        <Form>
          <div className="mb-3">
            <h1 htmlFor="title" className="form-label">
              Edit book
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
      </Formik> : ""}
    </>
  );
}
