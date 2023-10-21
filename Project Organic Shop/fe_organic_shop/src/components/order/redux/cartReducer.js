const initState = {
  carts: []
};

const cartReducer = (state = initState, action) => {
  switch (action.type) {
    case "GET_ALL_CART":
      return {...state, carts: action.payload};
    default:
      return state;
  }
};

export default cartReducer;
