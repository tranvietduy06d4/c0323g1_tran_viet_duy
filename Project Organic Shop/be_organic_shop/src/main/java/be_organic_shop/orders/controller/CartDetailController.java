package be_organic_shop.orders.controller;

import be_organic_shop.orders.dto.ICartDetailTransferData;
import be_organic_shop.orders.service.ICartDetailService;
import be_organic_shop.product.model.Product;
import be_organic_shop.product.service.IProductService;
import be_organic_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartDetailController {
    private final IProductService productService;
    private final UserService userService;
    private final ICartDetailService cartDetailService;

    @GetMapping("/get-quantity-in-cart")
    public ResponseEntity<?> getQuantityInCart(@RequestParam("userId") Long userId,
                                               @RequestParam("productId") Long productId) {

        if (userService.existsById(userId) && productService.existsByIdAndFlagDeletedIsFalse(productId)) {
            return new ResponseEntity<>(cartDetailService.findProductQuantityInCart(userId, productId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/check-quantity")
    public ResponseEntity<?> checkQuantity(@RequestParam("productId") Long productId,
                                           @RequestParam("inputQuantity") Long inputQuantity) {
        Product product = productService.getProductById(productId);
        if (productService.existsByIdAndFlagDeletedIsFalse(productId)
                && product.getQuantity() >= inputQuantity) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/add-from-home-details")
    public ResponseEntity<?> addToCartFromHomeAndDetails(@RequestParam("userId") Long userId,
                                                         @RequestParam("productId") Long productId,
                                                         @RequestParam("newQuantity") Integer newQuantity) {
        if (!userService.existsById(userId) || !productService.existsByIdAndFlagDeletedIsFalse(productId)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            cartDetailService.addToCartFromDetailsAndHome(userId, productId, newQuantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/get-all-cart-details-by-user")
    public ResponseEntity<?> getAllCartDetailByUser(@RequestParam("userId") Long id) {
        List<ICartDetailTransferData> cartList = cartDetailService.getAllCardDetailsByUserId(id);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @DeleteMapping("/delete-cart")
    public ResponseEntity<?> deleteCartDetail(@RequestParam("cartId") Long cartId) {
        if (cartDetailService.deleteCartDetailById(cartId) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}
