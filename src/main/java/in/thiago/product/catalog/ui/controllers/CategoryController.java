package in.thiago.product.catalog.ui.controllers;

import in.thiago.product.catalog.domain.category.CategoryService;
import in.thiago.product.catalog.repository.category.CategoryRepository;
import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {

        try {
            return new ResponseEntity<>(categoryService.get(id), HttpStatus.OK);
        } catch (CategoryCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAll() {
        var categories = categoryService.getAll();
        return new ResponseEntity<>(categories, categories.size() > 0 ? HttpStatus.OK : HttpStatus.OK.NOT_FOUND);
    }

    @PostMapping("/category")
    public ResponseEntity<?> create(@RequestBody CategoryCommand categoryCommand) {
        try {
            var result = categoryService.create(categoryCommand);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (CategoryCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody CategoryCommand categoryCommand) {
        try {
            var result = categoryService.update(id, categoryCommand);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (CategoryCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
