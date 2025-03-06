public class TestClass {
    ShoppingCart cart = new ShoppingCart();
    Item testItem;

    void testCreateItem() {
        testItem = cart.createItem("Test_Item", "testing", 1000);
    }

    void testAddToCart() {
        cart.addToCart(testItem, 12);
    }

    int testDisplayQty() {
        return cart.displayQty(testItem);
    }

    void testUpdateQty() {
        cart.updateQty(testItem, 10);
    }

    double testDisplayBill() {
        return cart.displayBill();
    }

    void testDeleteItem() {
        cart.deleteItem(testItem);
    }

    public static void main(String[] args) {
        TestClass test = new TestClass();
        test.testCreateItem();
        test.testAddToCart();
        test.testDisplayQty();
        test.testUpdateQty();
        test.testDisplayBill();
        test.testDeleteItem();
    }
}
