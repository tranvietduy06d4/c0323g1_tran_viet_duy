package be_organic_shop.orders.repository;

import be_organic_shop.orders.dto.ICartDetailTransferData;
import be_organic_shop.orders.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail,Long> {
    @Query(nativeQuery = true, value = "SELECT cd.quantity FROM cart_detail cd " +
            "WHERE cd.user_id = :userId AND cd.product_id = :productId")
    Long findProductQuantityInCart(@Param("userId") Long userId, @Param("productId") Long productId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into cart_detail (user_id, product_id, quantity)" +
            " VALUES (:userId, :productId, :newQuantity) " +
            "ON DUPLICATE KEY UPDATE quantity = quantity + :newQuantity ")
    void addToCartFromDetailsAndHome(@Param("userId") Long userId,
                                     @Param("productId") Long productId, @Param("newQuantity") Integer newQuantity);

    @Query(nativeQuery = true, value = "select c.id as cartId, c.quantity as sellQuantity, c.product_id as productId," +
            " p.name as productName, p.code as productCode, p.price as productPrice, " +
            " p.image_path as productImage, p.quantity as quantityInStock,p.flag_deleted, p.unit as productUnit " +
            "from cart_detail c join product p on c.product_id = p.id  " +
            "where c.user_id = :userId and p.flag_deleted = 0 ")
    List<ICartDetailTransferData> getAllCartByUserId(@Param("userId")Long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM cart_detail where id = :cartId ")
    int deleteCartDetailById(@Param("cartId") Long cartId);
}
