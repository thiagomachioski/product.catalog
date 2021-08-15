package in.thiago.product.catalog.ui.category.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryCommand {
    private String category;
    private Date createdAt;
    private Date updatedAt;
}
