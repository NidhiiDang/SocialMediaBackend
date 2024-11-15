package com.nidhi.social_media.Controller;

import com.nidhi.social_media.CustomResponses.ApiResponse;
import com.nidhi.social_media.Dto.UserDto;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Services.UserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Users>> addUser(@Valid @RequestBody UserDto user) {
        try {
            Users result = userService.registerUser(user);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users/all")
    public ResponseEntity<ApiResponse<List<Users>>> getAll(){
        try{
            List<Users> users = userService.getAllUsers();
            ApiResponse<List<Users>> response = new ApiResponse<>("Success",users);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            ApiResponse<List<Users>> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/secure/user/{id}")
    public ResponseEntity<ApiResponse<Users>> getUserById(@PathVariable Long id) {
        try {
            Users result = userService.findUserById(id);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/secure/find/{username}")
    public ResponseEntity<ApiResponse<Users>> getUserByEmail(@PathVariable String username) {
        try {
            Users result = userService.findUserByUsername(username);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/secure/edit/{id}")
    public ResponseEntity<ApiResponse<Users>> updateUser(@PathVariable Long id, @RequestBody Users newUser) {
        try {
            Users result = userService.updateUser(id, newUser);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/secure/follow/{userId1}/{userId2}")
    public ResponseEntity<ApiResponse<Users>> followUserHandle(@PathVariable Long userId1, @PathVariable Long userId2) {
        try {
            Users result = userService.followUser(userId1,userId2);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/secure/unfollow/{userId1}/{userId2}")
    public ResponseEntity<ApiResponse<Users>> unFollowUserHandle(@PathVariable Long userId1, @PathVariable Long userId2) {
        try {
            Users result = userService.unFollowUser(userId1,userId2);
            ApiResponse<Users> response = new ApiResponse<>("Success", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<Users> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/secure/search")
    public ResponseEntity<ApiResponse<List<Users>>> searchUser(@RequestParam("query") String query) {
        try {
            List<Users> users = userService.searchUser(query);
            ApiResponse<List<Users>> list = new ApiResponse<>("success", users);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<List<Users>> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}