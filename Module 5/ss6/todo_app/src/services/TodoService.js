import axios from "axios";

export const getAll = async () => {
  try {
    const result = await axios.get(
      "http://localhost:8080/todos"
    );
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const addItem = async (item) => {
  try {
    const result = await axios.post("http://localhost:8080/todos",item);
    console.log(result);
    return result.data;
  } catch(e) {
    console.log(e);
  }

}
