package in.thiago.product.catalog.ui.controllers;

import in.thiago.product.catalog.domain.product.ProductService;
import in.thiago.product.catalog.ui.product.dtos.ProductCommand;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/")
    public ResponseEntity<?> get() {
        var products = productService.getAll();
            return new ResponseEntity<>(products, products.size() > 0 ? HttpStatus.OK : HttpStatus.OK.NOT_FOUND);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
        } catch (ProductCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> create(@RequestBody ProductCommand productCommand) {
        try {
            var result = productService.create(productCommand);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ProductCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (CategoryCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
