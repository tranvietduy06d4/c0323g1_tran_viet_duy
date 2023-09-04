import axios from "axios";
import { takeLatest, put } from "redux-saga/effects";
import {
  FETCH_USERS_SUCCESS,
  GET_ALL_USER,
  DELETE_USER,
} from "../redux/Action";
import * as userService from "../services/UserService";

function* getAllUsers(action) {
  try {
    const result = yield userService.getAll();
    yield put({
      type: FETCH_USERS_SUCCESS,
      payload: result,
    });
  } catch (e) {
    console.log(e);
  }
}

function* removeUser(action) {
  const result = yield userService.deleteUser(action.payload);
  yield put({
    type: GET_ALL_USER,
  });
}

export default function* rootSaga() {
  yield takeLatest(GET_ALL_USER, getAllUsers);
  yield takeLatest(DELETE_USER, removeUser);
}
