import axios from "axios";
import jwt_decode from "jwt-decode";

export const loginByUserName = async (request) => {
  const result = await axios.post(
    `http://localhost:8080/api/v1/auth/authenticate`,
    request
  );
  return result;
};

export const registerByUserName = async (request) => {
  const result = await axios.post(
    `http://localhost:8080/api/v1/auth/register`,
    request
  );
  return result;
};

export const addJwtTokenToLocalStorage = (jwtToken) => {
  localStorage.setItem("JWT", jwtToken);
};

export const infoUserByJwtToken = () => {
  const jwtToken = localStorage.getItem("JWT");
  if (jwtToken) {
    const result = jwt_decode(jwtToken);
    return result;
  }else {
    return null;
  }
};

export const getUserIdByUserName = async (userName) => {
  const id = await axios.get(
    `http://localhost:8080/api/v1/users/get-user-id/${userName}`
  );
  return id;
};

export const logout = async(request) => {
  await axios.post(
    `http://localhost:8080/api/v1/auth/logout`,
    request
  );
}
