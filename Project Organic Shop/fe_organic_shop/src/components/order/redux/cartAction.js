import { getAllCartByUserId } from "../../../services/CartService";


export const getAllCarts = (userId) => async (dispatch) => {
  console.log(userId);
  try {
    const res = await getAllCartByUserId(userId);
    dispatch({
      type: "GET_ALL_CART",
      payload: res.data,
    });
  } catch (err) {
    console.log(err);
  }
};
