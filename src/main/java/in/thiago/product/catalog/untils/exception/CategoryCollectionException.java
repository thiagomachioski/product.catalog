package in.thiago.product.catalog.untils.exception;

public class CategoryCollectionException extends Exception {

    public CategoryCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "Category with " + id + " NOT FOUND";
    }

    public static String CategoryAlreadyExists() {
        return "Category with given name already exists";
    }
}
