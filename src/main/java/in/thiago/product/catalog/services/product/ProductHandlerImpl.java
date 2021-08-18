package in.thiago.product.catalog.services.product;

import in.thiago.product.catalog.domain.category.Category;
import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.domain.product.Product;
import in.thiago.product.catalog.domain.product.ProductHandler;
import in.thiago.product.catalog.ui.product.dtos.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductHandlerImpl implements ProductHandler {

    @Override
    public Product productCreateCommandToProduct(ProductCommand productCommand) {
        return new Product(productCommand.getTitle(), productCommand.getDescription(),
                productCommand.getPrice(), productCommand.getQuantity(), new Date(System.currentTimeMillis()),
                new Category(productCommand.getProductCategoryCommand().getId(), productCommand.getProductCategoryCommand().getCategory()));
    }

    @Override
    public ProductResult productToProductResult(Product product) {
        return new ProductResult(product.getId(), product.getTitle(),
                product.getDescription(), product.getPrice(), product.getQuantity(),
                new ProductCategoryResult(product.getCategory().getId(), product.getCategory().getCategory()));
    }

    @Override
    public ArrayList<ProductResultList> productToProductResult(List<Product> products) {
        var productsResult = new ArrayList<ProductResultList>();
        for (var product : products) {
            productsResult.add(new ProductResultList(product.getId(), product.getTitle(),
                    product.getDescription(), product.getPrice(), product.getQuantity(),
                    new ProductCategoryResult(product.getCategory().getId(), product.getCategory().getCategory())));
        }
        return productsResult;
    }

    @Override
    public ProductCreateResult productToProductCreateResult(Product product, RequestType requestType) {
        return setProductToProductResults(product, requestType);
    }

    @Override
    public ProductUpdateResult productToProductUpdateResult(Product product, RequestType requestType) {
        return null;
    }

    @Override
    public ProductDeleteResult productToProductDeleteResult(Product product, RequestType requestType) {
        return setProductToProductResults(product, requestType);
    }

    @Override
    public Product productCommandToProductUpdate(Product product, ProductCommand productCommand) {
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> T setProductToProductResults(Product product, RequestType requestType) {

        if (requestType == RequestType.POST) {
            return (T) new ProductCreateResult(
                    product.getId(),
                    product.getTitle(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getQuantity(),
                    new ProductCategoryResult(product.getCategory().getId(), product.getCategory().getCategory()));
        }
        else if (requestType == RequestType.PUT) {
            return (T) new ProductUpdateResult(
                    product.getId(),
                    product.getTitle(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getQuantity(),
                    new ProductCategoryResult(product.getCategory().getId(), product.getCategory().getCategory()));
        }
        return (T) new ProductDeleteResult(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                new ProductCategoryResult(product.getCategory().getId(), product.getCategory().getCategory()));
    }
}
