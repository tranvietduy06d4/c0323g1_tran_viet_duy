import { Formik, Field, Form } from "formik";
import * as bookService from "../services/BookService";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export function BookEdit() {
  const navigate = useNavigate();

  const {id} = useParams();

  const [book,setBook] = useState({   
      title:"",
      quantity:""
  })

  useEffect(()=>{
      findBook();
  },[])

  
  const findBook = async () =>{
    const result = await axios.get(`http://localhost:8080/books/${id}`);
    console.log(result.data.title);
    setBook(result.data);
  }

  const editBook = async (id,value) => {
    const result = await bookService.editBook(id,value);
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
      </Formik>
    </>
  );
}
