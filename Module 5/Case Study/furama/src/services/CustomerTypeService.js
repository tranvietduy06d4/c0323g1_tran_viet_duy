import axios from "axios";

export const getAllCustomerTypes = async () => {
  try {
    const result = await axios.get("http://localhost:8080/customerTypes");
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
