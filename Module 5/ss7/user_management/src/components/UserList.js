import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DELETE_USER, GET_ALL_USER } from "../redux/Action";

function UserList() {
  const users = useSelector(state => state.users);
  const dispatch = useDispatch();

  const getAll = () => {
    dispatch({
      type: GET_ALL_USER,
    })

  }

  const handleDelete = (id) => {
    dispatch({
      type: DELETE_USER,
      payload: id,
    })
  }
  useEffect(() => {
   getAll();
  }, [])
  return (
    <div>
        <button>Get users</button>
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Website</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map(user => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.username}</td>
              <td>{user.email}</td>
              <td>{user.website}</td>
              <td><button onClick={() => handleDelete(`${user.id}`)}>Delete</button></td>

            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default UserList;