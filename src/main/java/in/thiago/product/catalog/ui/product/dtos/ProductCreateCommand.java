package in.thiago.product.catalog.ui.product.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateCommand {
    private String title;
    private String description;
    private double price;
    private int quantity;
    @JsonProperty("category")
    private ProductCategoryCreateCommand productCategoryCreateCommand;
}
