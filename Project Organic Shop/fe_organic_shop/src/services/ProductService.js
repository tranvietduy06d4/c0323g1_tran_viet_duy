import axios from "axios";

export const searchProduct = async (
  page,
  keyword,
  type,
  sortBy,
  sortDirection
) => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/v1/home/list-page?page=${page}&keyword=${keyword}&type=${type}&sortBy=${sortBy}&sortDirection=${sortDirection}`
    );
    return response;
  } catch (error) {
    console.log(error);
  }
};

export async function checkQuantity(productId, inputQuantity) {
  const res = await axios.get(
    `http://localhost:8080/api/v1/carts/check-quantity?productId=${productId}&inputQuantity=${inputQuantity}`
  );
  return res.status;
}

export const getProductById = async (productId) => {
  const result = await axios.get(
    `http://localhost:8080/api/v1/products/detail?id=${productId}`
  );
  return result;
};
