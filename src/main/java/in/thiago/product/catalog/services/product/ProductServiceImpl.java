package in.thiago.product.catalog.services.product;

import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.domain.product.ProductHandler;
import in.thiago.product.catalog.domain.product.ProductService;
import in.thiago.product.catalog.repository.category.CategoryRepository;
import in.thiago.product.catalog.repository.product.ProductRepository;
import in.thiago.product.catalog.ui.product.dtos.*;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductHandler productHandler;

    @Override
    public ProductResult get(String id) throws ProductCollectionException {
        var product = productRepository.findById(id);
        if (!product.isPresent())
            throw new ProductCollectionException(ProductCollectionException.NotFoundException(id));
        return productHandler.productToProductResult(product.get());
    }

    @Override
    public List<ProductResultList> getAll() {
        var products = productRepository.findAll();
        if (products.size() > 0)
            return productHandler.productToProductResult(products);
        return new ArrayList<ProductResultList>();
    }

    @Override
    public ProductCreateResult create(ProductCreateCommand product) throws ConstraintViolationException, ProductCollectionException, CategoryCollectionException {

        var category = categoryRepository.findById(product.getProductCategoryCreateCommand().getId());

        if (!category.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.NotFoundException(product.getProductCategoryCreateCommand().getId()));

        var productWithSameTitle = productRepository.findByTitle(product.getTitle());

        if (productWithSameTitle.isPresent())
            throw new ProductCollectionException(ProductCollectionException.ProductAlreadyExists());

        var result = productRepository.save(productHandler.productCreateCommandToProduct(product));
        return productHandler.productToProductCreateResult(result, RequestType.POST);
    }

    @Override
    public ProductUpdateResult update(String id, ProductUpdateCommand product) throws ProductCollectionException, CategoryCollectionException {

        var categoryWithId = categoryRepository.findById(product.getProductCategoryUpdateCommand().getId());

        if (!categoryWithId.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.NotFoundException(id));

        var productWithId = productRepository.findById(id);

        if (!productWithId.isPresent())
            throw new ProductCollectionException(ProductCollectionException.NotFoundException(id));

        var productWithSameTitle = productRepository.findByTitle(product.getTitle());

        if (productWithSameTitle.isPresent() && productWithSameTitle.get().getId().equals(id))
            throw new ProductCollectionException(ProductCollectionException.ProductAlreadyExists());

        var productToUpdate = productHandler.productUpdateCommandToProduct(productWithId.get(), product, categoryWithId.get().getCategory());
        var result = productRepository.save(productToUpdate);
        return productHandler.productToProductUpdateResult(result, RequestType.PUT);
    }

    @Override
    public ProductDeleteResult delete(String id) throws ProductCollectionException {
        var result = productRepository.findById(id);
        if (!result.isPresent())
            throw new ProductCollectionException(ProductCollectionException.NotFoundException(id));
        productRepository.deleteById(id);

        return productHandler.productToProductDeleteResult(result.get(), RequestType.DELETE);
    }
}