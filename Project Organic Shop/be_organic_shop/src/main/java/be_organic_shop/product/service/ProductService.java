package be_organic_shop.product.service;

import be_organic_shop.home.dto.ProductForHomePageDto;
import be_organic_shop.product.model.Product;
import be_organic_shop.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<ProductForHomePageDto> getListProductWithPagination(String keyword, String type, Pageable pageable) {
        String keywordParam = "%" + keyword + "%";
        String typeParam = "%" + type + "%" ;
        return productRepository.getListProductWithPagination(keywordParam,typeParam,pageable);
    }

    @Override
    public boolean existsByIdAndFlagDeletedIsFalse(Long id) {
        return productRepository.existsByIdAndFlagDeletedIsFalse(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
