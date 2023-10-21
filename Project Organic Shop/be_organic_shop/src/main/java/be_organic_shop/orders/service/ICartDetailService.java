package be_organic_shop.orders.service;

import be_organic_shop.orders.dto.ICartDetailTransferData;
import be_organic_shop.product.model.Product;

import java.util.List;

public interface ICartDetailService {
    Long findProductQuantityInCart(Long userId, Long productId);

    void addToCartFromDetailsAndHome(Long userId, Long productId, Integer newQuantity);

    List<ICartDetailTransferData> getAllCardDetailsByUserId(Long id);

    int deleteCartDetailById(Long cartId);
}
