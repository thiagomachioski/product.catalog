package in.thiago.product.catalog.ui.controllers;

import in.thiago.product.catalog.domain.category.CategoryRepository;
import in.thiago.product.catalog.domain.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

}
