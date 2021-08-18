package in.thiago.product.catalog.services.product;

import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.domain.product.Product;
import in.thiago.product.catalog.domain.product.ProductHandler;
import in.thiago.product.catalog.ui.product.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class ProductHandlerImpl implements ProductHandler {
    @Override
    public Product productCreateCommandToProduct(ProductCommand productCommand) {
        return null;
    }

    @Override
    public ProductResult productToProductResult(Product product) {
        return null;
    }

    @Override
    public ArrayList<ProductResult> productToProductResult(List<Product> products) {
        return null;
    }

    @Override
    public ProductCreateResult productToProductCreateResult(Product product, RequestType requestType) {
        return null;
    }

    @Override
    public ProductUpdateResult productToProductUpdateResult(Product product, RequestType requestType) {
        return null;
    }

    @Override
    public ProductDeleteResult productToProductDeleteResult(Product product, RequestType requestType) {
        return null;
    }

    @Override
    public Product productCommandToProductUpdate(Product product, ProductCommand productCommand) {
        return null;
    }
}
