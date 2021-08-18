package in.thiago.product.catalog.utils.exception;

public class ProductCollectionException extends Exception {

    public ProductCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "Product with id " + id + " NOT FOUND";
    }

    public static String ProductAlreadyExists() {
        return "Product with given name already exists";
    }
}
