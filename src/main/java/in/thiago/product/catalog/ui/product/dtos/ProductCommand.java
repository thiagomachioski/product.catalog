package in.thiago.product.catalog.ui.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCommand {
    private String title;
    private String description;
    private double price;
    private int quantity;
    private ProductCategoryCommand productCategoryCommand;
}
