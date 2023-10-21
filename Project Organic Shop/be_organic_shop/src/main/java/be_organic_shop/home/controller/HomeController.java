package be_organic_shop.home.controller;

import be_organic_shop.home.dto.ProductForHomePageDto;
import be_organic_shop.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
@CrossOrigin("*")
public class HomeController {
    private final IProductService productService;

    @GetMapping("/list-page")
    public ResponseEntity<Page<ProductForHomePageDto>> getListProductWithPagination(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                                       @RequestParam(defaultValue = "", required = false) String keyword,
                                                                       @RequestParam(defaultValue = "", required = false) String type,
                                                                       @RequestParam(defaultValue = "asc", required = false) String sortDirection,
                                                                       @RequestParam(defaultValue = "price", required = false) String sortBy) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, 12, sort);
        Page<ProductForHomePageDto> products = productService.getListProductWithPagination(keyword, type, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
