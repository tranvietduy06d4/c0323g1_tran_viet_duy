package be_organic_shop.orders.service;

import be_organic_shop.orders.dto.ICartDetailTransferData;
import be_organic_shop.orders.repository.ICartDetailRepository;
import be_organic_shop.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService{
    @Autowired
    private ICartDetailRepository cartDetailRepository;
    @Override
    public Long findProductQuantityInCart(Long userId, Long productId) {
        return cartDetailRepository.findProductQuantityInCart(userId,productId);
    }

    @Override
    public void addToCartFromDetailsAndHome(Long userId, Long productId, Integer newQuantity) {
        cartDetailRepository.addToCartFromDetailsAndHome(userId,productId,newQuantity);

    }

    @Override
    public List<ICartDetailTransferData> getAllCardDetailsByUserId(Long userId) {
        return cartDetailRepository.getAllCartByUserId(userId);
    }

    @Override
    public int deleteCartDetailById(Long cartId) {
        return cartDetailRepository.deleteCartDetailById(cartId);
    }
}
