package be_organic_shop.product.service;

import be_organic_shop.home.dto.ProductForHomePageDto;
import be_organic_shop.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductForHomePageDto> getListProductWithPagination(String keyword, String type, Pageable pageable);

    boolean existsByIdAndFlagDeletedIsFalse(Long id);

    Product getProductById(Long id);
}
