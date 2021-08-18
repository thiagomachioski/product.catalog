package in.thiago.product.catalog.domain.product;

import in.thiago.product.catalog.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private double price;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;
    private Category category;

    public Product(String title, String description, double price, int quantity, Date createdAt, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.category = category;
    }
}
