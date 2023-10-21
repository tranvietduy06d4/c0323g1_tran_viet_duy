import axios from "axios";

export async function addToCartFromHomeAndDetails(
  userId,
  productId,
  newQuantity
) {
  const result = await axios.post(
    `http://localhost:8080/api/v1/carts/add-from-home-details?userId=${userId}&productId=${productId}&newQuantity=${newQuantity}`
  );
  return result.status;
}

export async function getQuantityInCart(userId, productId) {
  const result = await axios.get(
    `http://localhost:8080/api/v1/carts/get-quantity-in-cart?userId=${userId}&productId=${productId}`
  );
  return result.data;
}

export async function checkQuantity(productId, inputQuantity) {
  const result = await axios.get(
    `http://localhost:8080/api/v1/carts/check-quantity?productId=${productId}&inputQuantity=${inputQuantity}`
  );
  return result.status;
}

export async function getAllCartByUserId(userId) {
  const result = await axios.get(
    `http://localhost:8080/api/v1/carts/get-all-cart-details-by-user?userId=${userId}`
  );
  return result;
}

export async function deleteCartDetail(cartId) {
  const result = await axios.delete(
    `http://localhost:8080/api/v1/carts/delete-cart?cartId=${cartId}`
  );
  return result;
}
