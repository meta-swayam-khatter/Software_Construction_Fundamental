import java.util.*;

class Item {
    String ItemId;
    String Name;
    String Description;
    int Price;
    UUID uniqueID = UUID.randomUUID(); 

    Item(String Name, String Description, int Price) {
        this.ItemId = uniqueID.toString();
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
    }
}

class ShoppingCart {
    HashMap<Item, Integer> Cart = new HashMap<Item, Integer>();

    void addToCart(Item item, int quantity) {
        if(Cart.get(item) != null) {
            System.out.println("This item is already present in the cart !!");
            System.out.println();
            return;
        }
        Cart.put(item, quantity);
        System.out.println("Item added Successfully !!");
        System.out.println();
    }

    int displayQty(Item item) {
        if(Cart.get(item) == null) {
            System.out.println("This item is not in the Cart");
            return 0;
        }
        return Cart.get(item);
    }

    void updateQty(Item item, int quantity) {
        if(Cart.get(item) == null) {
            System.out.println("This item is not in the Cart");
            System.out.println();
            return;
        }
        Cart.replace(item, quantity);
        System.out.println("Item updated Successfully !!");
        System.out.println();
    }

    void deleteItem(Item item) {
        Cart.remove(item);
        System.out.println("Item deleted Successfully !!");
        System.out.println();
    }

    double displayBill() {
        if(Cart.size() == 0) {
            System.out.println("No item in Cart yet !!");
            return 0;
        }
        double total = 0;

        for (Item i : Cart.keySet()) {
            total += i.Price * Cart.get(i);
            System.out.println("Item: " + i.Name + " Price: " + i.Price + " Quantity: " + Cart.get(i));
        }

        return total;
    }

    public static void main(String[] args) {
        Item item1 = new Item("item1", "This is Item 1", 100);
        Item item2 = new Item("item2", "This is Item 2", 200);

        HashMap<Integer, Item> Items = new HashMap<Integer, Item>();
        Items.put(1, item1);
        Items.put(2, item2);

        ShoppingCart shoppingcart = new ShoppingCart();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your option:\n0. Exit\n1. Add\n2. Display Quantity\n3. Update Quantity\n4. Delete Item\n5. Display Bill");
        int input = sc.nextInt();
        int item;
        Item ITEM;
        int quantity;
        while(input != 0) {
            switch(input){
                case 0:
                    break;
                case 1:
                    //take input for item
                    System.out.println("Choose the Item you want to add into cart: \n");
                    for (int i : Items.keySet()) {
                        System.out.println(i + ". ID: " + Items.get(i).ItemId + " Name: " + Items.get(i).Name + " Price: " + Items.get(i).Price);
                    }
                    item = sc.nextInt();
                    ITEM = Items.get(item);

                    if(ITEM == null) {
                        System.out.println("This item does not exist !!");
                        System.out.println();
                        break;
                    }

                    //take input for quantity
                    System.out.println("Enter the quantity you want to add: ");
                    quantity = sc.nextInt();

                    //add
                    shoppingcart.addToCart(ITEM, quantity);
                    break;
                case 2:
                    //take input for item
                    System.out.println("Choose the Item for which you want to display the quantity: \n");
                    for (int i : Items.keySet()) {
                        System.out.println(i + ". ID: " + Items.get(i).ItemId + " Name: " + Items.get(i).Name + " Price: " + Items.get(i).Price);
                    }
                    item = sc.nextInt();
                    ITEM = Items.get(item);
                    //display
                    System.out.println("Quantity of " + ITEM.Name + ": " + shoppingcart.displayQty(ITEM));
                    break;
                case 3:
                    //take input for item
                    System.out.println("Choose the Item you want to update the quantity: \n");
                    for (int i : Items.keySet()) {
                        System.out.println(i + ". ID: " + Items.get(i).ItemId + " Name: " + Items.get(i).Name + " Price: " + Items.get(i).Price);
                    }
                    item = sc.nextInt();
                    ITEM = Items.get(item);

                    //take input for quantity
                    System.out.println("Enter the quantity: ");
                    quantity = sc.nextInt();

                    //add
                    shoppingcart.updateQty(ITEM, quantity);
                    break;
                case 4:
                    //take input for item
                    System.out.println("Choose the Item you want to delete: \n");
                    for (int i : Items.keySet()) {
                        System.out.println(i + ". ID: " + Items.get(i).ItemId + " Name: " + Items.get(i).Name + " Price: " + Items.get(i).Price);
                    }
                    item = sc.nextInt();
                    ITEM = Items.get(item);
                    //delete
                    shoppingcart.deleteItem(ITEM);
                    break;
                case 5:
                    double bill = shoppingcart.displayBill();
                    System.out.println("Total bill is: " + bill);
                    break;
                default:
                    System.out.println("Choose a valid option!!");
                    break;
            }
            System.out.println("Choose your option:\n0. Exit\n1. Add\n2. Display Quantity\n3. Update Quantity\n4. Delete Item\n5. Display Bill");
            input = sc.nextInt();
        }
    }
}