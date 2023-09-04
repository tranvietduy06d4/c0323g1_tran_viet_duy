import axios from "axios";

export const getAll = async () => {
  try {
    const result = await axios.get("http://localhost:8080/customers");
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const getCustomerByName = async (page,searchName) => {
  try {
    const result = await axios.get(`http://localhost:8080/customers?_page=${page}&_limit=3&name_like=${searchName}`);
    console.log(result);
    return result;
  } catch (e) {
    console.log(e);
  }
};

export const getCustomerById = async (id) => {
  try {
    const result = await axios.get("http://localhost:8080/customers/" +id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const addCustomer = async (customer) => {
  try {
    const result = await axios.post(
      "http://localhost:8080/customers",
      customer
    );
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const editCustomer = async (id, customer) => {
  try {
    const result = await axios.patch(
      "http://localhost:8080/customers/" + id,
      customer
    );
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const deleteCustomer = async (id) => {
  try {
    const result = await axios.delete("http://localhost:8080/customers/" + id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
