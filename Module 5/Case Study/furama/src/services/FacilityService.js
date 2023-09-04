import axios from "axios";

export const getAll = async () => {
  try {
    const result = await axios.get("http://localhost:8080/facilities");
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
export const getFacilityById = async (id) => {
  try {
    const result = await axios.get("http://localhost:8080/facilities/" +id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const addFacility = async (facility) => {
  try {
    const result = await axios.post(
      "http://localhost:8080/facilities",
      facility
    );
    console.log(result);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const editFacility = async (id, facility) => {
  try {
    const result = await axios.patch(
      "http://localhost:8080/facilities/" + id,
      facility
    );
    return result.data;
  } catch (e) {
    console.log(e);
  }
};

export const deleteFacility = async (id) => {
  try {
    const result = await axios.delete("http://localhost:8080/facilities/"+id);
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
