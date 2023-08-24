import axios from "axios";

export const getAll = async () => {
  try {
    const result = await axios.get("http://localhost:8080/books");
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const addBook = async (book) => {
  try {
    const result = await axios.post("http://localhost:8080/books", book);
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const deleteBook = async (id) => {
  try {
    const result = await axios.delete("http://localhost:8080/books/" + id);
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
