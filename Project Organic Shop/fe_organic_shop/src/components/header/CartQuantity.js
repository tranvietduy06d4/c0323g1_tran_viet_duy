const CartQuantity = () => {
return(
    <span className="cart-number">{localStorage.getItem("cartQuantity")}</span>
);
}
export default CartQuantity;