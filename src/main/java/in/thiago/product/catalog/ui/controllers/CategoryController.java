package in.thiago.product.catalog.ui.controllers;

import in.thiago.product.catalog.domain.category.CategoryRepository;
import in.thiago.product.catalog.domain.category.CategoryService;
import in.thiago.product.catalog.ui.category.dtos.CategoryCreateCommand;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/category")
    public ResponseEntity<?> create(@RequestBody CategoryCreateCommand categoryCreateCommand) {
        try {
            categoryService.create(categoryCreateCommand);
            return new ResponseEntity<>(categoryCreateCommand,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (CategoryCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
