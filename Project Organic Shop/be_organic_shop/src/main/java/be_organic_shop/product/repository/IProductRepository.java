package be_organic_shop.product.repository;

import be_organic_shop.home.dto.ProductForHomePageDto;
import be_organic_shop.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT " +
            " p.id as productId, " +
            " p.name as productName, " +
            " p.price as productPrice, " +
            " pt.name as productTypeName , " +
            " p.image_path as productImage, " +
            " p.unit as productUnit  " +
            " FROM product p " +
            "join product_type pt on p.product_type_id = pt.id " +
            "WHERE " +
            "    p.flag_deleted = 0 " +
            "    AND p.name LIKE :keyword " +
            "    AND pt.name LIKE :type ", nativeQuery = true)
    Page<ProductForHomePageDto> getListProductWithPagination(@Param("keyword") String keyword,
                                                             @Param("type") String type,
                                                             Pageable pageable);

    boolean existsByIdAndFlagDeletedIsFalse(Long id);
}
