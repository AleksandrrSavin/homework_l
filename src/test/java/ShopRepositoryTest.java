import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "Помидоры", 185);
    Product product2 = new Product(2, "Огурцы", 255);
    Product product3 = new Product(3, "Яблоки", 125);
    Product product4 = new Product(4, "Груши", 175);


    private ShopRepository fillProducts() {
        ShopRepository products = new ShopRepository();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        return products;
    }


    @Test
    public void shouldDelete() {
        ShopRepository products = fillProducts();
        products.remove(4);
        Product expected = null;
        Product actual = products.findById(4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDelete() {
        ShopRepository products = fillProducts();
        Assertions.assertThrows(NotFoundException.class, () -> {
            products.remove(8);
        });
    }
}