package be_organic_shop.orders.dto;

public interface ICartDetailTransferData {
    Long getCartId();
    Long getSellQuantity();
    Long getProductId();
    String getProductName();
    String getProductCode();
    Double getProductPrice();
    String getProductImage();

    Long getQuantityInStock();
    String getProductUnit();

    Boolean getFlag_deleted();
}
