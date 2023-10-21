package be_organic_shop.product.controller;

import be_organic_shop.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/detail")
    public ResponseEntity<?> getProductById(@RequestParam("id") String productId) {
        try {
            Long id = Long.parseLong(productId);
            if (productService.existsByIdAndFlagDeletedIsFalse(id)) {
                return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
            }
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
