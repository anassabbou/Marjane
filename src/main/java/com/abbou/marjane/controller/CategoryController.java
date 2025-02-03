package com.abbou.marjane.controller;

import com.abbou.marjane.model.Category;
import com.abbou.marjane.response.ApiResponse;
import com.abbou.marjane.service.category.ICategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;



@RestController
@RequiredArgsConstructor
@RequestMapping ("${api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories(){
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse("Found", categories));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error :", e.getMessage()));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody  Category category){
        try {
            Category theCategory = categoryService.addCategory(category);
            return ResponseEntity.ok(new ApiResponse("Success", theCategory));
        } catch (EntityExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse("Error :", e.getMessage()));
        }
    }

    @GetMapping("/category/{id}/category")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id){
        try {
            Category theCategory = categoryService.findCategoryById(id);
            return ResponseEntity.ok(new ApiResponse("Success", theCategory));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Error :", e.getMessage()));
        }
    }

}
