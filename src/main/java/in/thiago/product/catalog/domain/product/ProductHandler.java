package in.thiago.product.catalog.domain.product;

import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.ui.product.dtos.*;

import java.util.ArrayList;
import java.util.List;

public interface ProductHandler {

    Product productCreateCommandToProduct(ProductCommand  productCommand);

    ProductResult productToProductResult(Product product);

    ArrayList<ProductResult> productToProductResult(List<Product> products);

    ProductCreateResult productToProductCreateResult(Product product, RequestType requestType);

    ProductUpdateResult productToProductUpdateResult(Product product, RequestType requestType);

    ProductDeleteResult productToProductDeleteResult(Product product, RequestType requestType);

    Product productCommandToProductUpdate(Product product, ProductCommand productCommand);

}
