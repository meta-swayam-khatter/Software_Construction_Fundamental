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

public class ShoppingCart {
    HashMap<Item, Integer> Cart = new HashMap<Item, Integer>();

    Item createItem(String Name, String Description, int Price) {
        Item newItem = new Item(Name, Description, Price);
        return newItem;
    }

    void addToCart(Item item, int quantity) {
        if(Cart.containsKey(item)) {
            System.out.println("This item is already present in the cart !!\n");
            return;
        }
        Cart.put(item, quantity);
        System.out.println("Item added Successfully !!\n");
    }

    int displayQty(Item item) {
        if(!Cart.containsKey(item)) {
            System.out.println("This item is not in the Cart\n");
            return 0;
        }
        return Cart.get(item);
    }

    void updateQty(Item item, int quantity) {
        if(!Cart.containsKey(item)) {
            System.out.println("This item is not in the Cart\n");
            return;
        }
        Cart.replace(item, quantity);
        System.out.println("Item updated Successfully !!\n");
    }

    void deleteItem(Item item) {
        if(!Cart.containsKey(item)) {
            System.out.println("This item is not in the Cart\n");
            return;
        }
        Cart.remove(item);
        System.out.println("Item deleted Successfully !!\n");
    }

    double displayBill() {
        if(Cart.isEmpty()) {
            System.out.println("No item in Cart yet !!\n");
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
        HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

        Item item1 = new Item("item1", "This is Item 1", 100);
        Item item2 = new Item("item2", "This is Item 2", 200);
        Items.put(1, item1);
        Items.put(2, item2);

        ShoppingCart shoppingcart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose your option:\n0. Exit\n1. Add\n2. Display Quantity\n3. Update Quantity\n4. Delete Item\n5. Display Bill\n6. Create Item");
        int input = sc.nextInt();
        int item;
        Item ITEM;
        int quantity;
        while(input != 0) {
            try {
                switch(input){
                    case 0:
                        System.out.println("Exiting..................");
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
                        System.out.println("Choose the Item for which you want to display the quantity: ");
                        for (int i : Items.keySet()) {
                            System.out.println(i + ". ID: " + Items.get(i).ItemId + " Name: " + Items.get(i).Name + " Price: " + Items.get(i).Price);
                        }
                        item = sc.nextInt();
                        ITEM = Items.get(item);
                        //display
                        System.out.println("Quantity of " + ITEM.Name + ": " + shoppingcart.displayQty(ITEM) + "\n");
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
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Enter the name of the Item: (without spaces)");
                        String name = sc.next();
                        sc.nextLine();
                        System.out.println("Enter the description of the Item: ");
                        String desc = sc.nextLine();
                        System.out.println("Enter the price of the Item: ");
                        int price = sc.nextInt();
                        Item temp = shoppingcart.createItem(name, desc, price);
                        int size = Items.size();

                        Items.put(size+1, temp);
                        System.out.println("Item created Successfully!!\n");
                    default:
                        System.out.println("Choose a valid option!!\n");
                        break;
                }
                System.out.println("Choose your option:\n0. Exit\n1. Add\n2. Display Quantity\n3. Update Quantity\n4. Delete Item\n5. Display Bill\n6. Create Item");
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type!!\n");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("An error occured: " + e.getMessage() + "\n");
            }
        }
        sc.close();
    }
}