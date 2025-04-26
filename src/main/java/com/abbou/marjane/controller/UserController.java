package com.abbou.marjane.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abbou.marjane.dtos.UserDto;
import com.abbou.marjane.model.User;
import com.abbou.marjane.request.CreateUserRequest;
import com.abbou.marjane.request.UserUpdateRequest;
import com.abbou.marjane.response.ApiResponse;
import com.abbou.marjane.service.user.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/user/{userId}/user")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId) {
        User user = (User) userService.getUserById(userId);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Found!", userDto));
        // Assignment 8

        // Create a solution to return a user with the specified information.
        // Return along with the user:
        // The user cart.
        // The user order list.

        //Hint remember the concept of the DTO and the ModelMapper
        // to break unnecessary relationship with the returning data.
    }


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserUpdateRequest request, @PathVariable Long userId) {
        User user = userService.updateUser(request, userId);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Update User Success!", userDto));
    }

    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(new ApiResponse("Delete User Success!", null));
    }


    // Assignment 5

    /*Create a user dto class to return the desired user information to the frontend.     *
     * Remember to use the model mapper to create a convenient method in
     *  the user service class to convert the user to a dto class.
     * You may want to take a look at the product service we created in the past.    *
     * GoodLuck!
     *
     *
     *
     * */

}
