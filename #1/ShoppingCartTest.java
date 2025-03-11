import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    ShoppingCart obj = new ShoppingCart();
    Item item = new Item("test", "testing", 100);
    @Test
    public void createItemTest() {
        assertEquals(item.Name, obj.createItem("test", "testing", 100).Name);
        assertEquals(item.Description, obj.createItem("test", "testing", 100).Description);
        assertEquals(item.Price, obj.createItem("test", "testing", 100).Price);
    }

    @Test
    public void addToCart() {
        
    }

    @Test
    public void displayQtyTest() {
        
    }
}