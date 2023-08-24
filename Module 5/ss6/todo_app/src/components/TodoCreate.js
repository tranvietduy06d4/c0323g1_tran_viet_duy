import * as todoService from "../services/TodoService";
import { Formik, Field, Form, ErrorMessage } from "formik";

export function TodoCreate() {
  const addWork = async (values) => {
    const result = await todoService.addItem(values);
    todoService.getAll();
  };

  return (
    <>
      <Formik
        initialValues={{
          userId: "",
          title: "",
          completed: true,
        }}
        onSubmit={async (values, { setSubmitting }) => {
          setSubmitting(false);
          await addWork(values);
        }}
      >
        <Form>
          <div className="mb-3">
            <h1 htmlFor="title" className="form-label">
              Todo List
            </h1>
            <Field
              type="text"
              className="form-control"
              id="title"
              name="title"
            />
            <ErrorMessage name="title" component="span" className="form-error" />
          </div>
          <button type='submit' className='btn btn-primary'>Submit</button>
        </Form>
        
      </Formik>
    </>
  );
}
