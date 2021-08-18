package in.thiago.product.catalog.ui.controllers;

import in.thiago.product.catalog.domain.product.ProductService;
import in.thiago.product.catalog.ui.product.dtos.ProductCommand;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

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
