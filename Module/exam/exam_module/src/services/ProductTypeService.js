import axios from "axios";

export const getAllProductType = async () => {
  try {
    const result = await axios.get("http://localhost:8080/api/productTypes");
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
