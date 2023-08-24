import * as todoService from "../services/TodoService";
import { useEffect, useState } from "react";
import { Formik, Field, Form, ErrorMessage } from "formik";

export function TodoList() {
  const [todos, setTodos] = useState([]);
  useEffect(() => {
    getAll();
  }, []);

  const getAll = async () => {
    const result = await todoService.getAll();
    setTodos((prev) => result);
  };

  const addWork = async (values) => {
    await todoService.addItem(values);
    getAll();
  };

  return (
    <>
      <h1>Todo List</h1>
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
            <Field
              type="text"
              className="form-control"
              id="title"
              name="title"
            />
            <ErrorMessage
              name="title"
              component="span"
              className="form-error"
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </Form>
      </Formik>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>UserId</th>
            <th>Title</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.userId}</td>
              <td>{todo.title}</td>
              <td>{todo.completed ? "true" : "false"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
