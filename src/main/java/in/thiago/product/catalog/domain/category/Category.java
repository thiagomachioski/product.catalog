package in.thiago.product.catalog.domain.category;

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
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    private String category;
    private Date createdAt;
    private Date updatedAt;

    public Category(String id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(String category, Date createdAt) {
        this.category = category;
        this.createdAt = createdAt;
    }
}
