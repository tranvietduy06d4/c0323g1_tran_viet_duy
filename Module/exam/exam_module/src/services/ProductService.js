import axios from "axios";

export const getAllProduct = async (page,searchName,idCategory) => {
  try {
    const result = await axios.get(`http://localhost:8080/api/products/list/?page=${page}&searchName=${searchName}`);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const getProductById = async (id) => {
  try {
    const result = await axios.get("http://localhost:8080/api/products/" +id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const editProduct = async (product) => {
  try {
    const result = await axios.patch("http://localhost:8080/api/products/edit" ,product);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const deleteProduct = async (id) => {
  try {
    const result = await axios.delete("http://localhost:8080/api/products/" +id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};





