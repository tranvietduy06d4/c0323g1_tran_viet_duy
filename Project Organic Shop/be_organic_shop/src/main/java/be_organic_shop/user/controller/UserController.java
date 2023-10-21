package be_organic_shop.user.controller;

import be_organic_shop.user.model.Users;
import be_organic_shop.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final IUserService userService;
    @GetMapping("/get-user-id/{userName}")
    public ResponseEntity<Object> getIdByUserName(@PathVariable String userName){
        Users user = userService.findByUserName(userName);
        Long id = user.getId();
        if(id == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
        return ResponseEntity.ok().body(id);
    }


}
