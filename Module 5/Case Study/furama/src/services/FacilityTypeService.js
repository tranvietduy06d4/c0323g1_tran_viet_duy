import axios from "axios";

export const getAllFacilityTypes = async () => {
  try {
    const result = await axios.get("http://localhost:8080/facilityTypes");
    return result.data;
  } catch (e) {
    console.log(e);
  }
};
