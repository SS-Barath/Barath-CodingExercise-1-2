// 				Structural Design Patterns - Composite Pattern - Menu System (Eg. Restaurant Menu)

package StructuralDesignPatterns;

import java.util.*;

//Component abstract class
abstract class MenuComponent {
 public void add(MenuComponent menuComponent) {
     throw new UnsupportedOperationException();
 }

 public void remove(MenuComponent menuComponent) {
     throw new UnsupportedOperationException();
 }

 public MenuComponent getChild(int i) {
     throw new UnsupportedOperationException();
 }

 public String getName() {
     throw new UnsupportedOperationException();
 }

 public double getPrice() {
     throw new UnsupportedOperationException();
 }

 public void print() {
     throw new UnsupportedOperationException();
 }
}

//Leaf class MenuItem
class MenuItem extends MenuComponent {
 String name;
 double price;

 public MenuItem(String name, double price) {
     this.name = name;
     this.price = price;
 }

 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

 public void print() {
     System.out.println(" " + getName() + " - ₹" + getPrice());
 }
}

//Composite class Menu
class Menu extends MenuComponent {
 List<MenuComponent> menuComponents = new ArrayList<>();
 String name;

 public Menu(String name) {
     this.name = name;
 }

 public void add(MenuComponent menuComponent) {
     menuComponents.add(menuComponent);
 }

 public void remove(MenuComponent menuComponent) {
     menuComponents.remove(menuComponent);
 }

 public MenuComponent getChild(int i) {
     return menuComponents.get(i);
 }

 public String getName() {
     return name;
 }

 public void print() {
     System.out.println("\n" + getName());
     System.out.println("--------------------------------");
     for (MenuComponent menuComponent : menuComponents) {
         menuComponent.print();
     }
 }
}

//Main class to demonstrate MenuSystem
public class MenuSystem {
 private static final Map<String, MenuItem> menuItemMap = new HashMap<>();

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     MenuComponent allMenus = new Menu("ALL MENUS");

     while (true) {
         System.out.println("\nMenu System:");
         System.out.println("1. Add Menu || 2. Add Menu Item || 3. Display Menu || 4.Exit");
         System.out.print("Choose an option: ");
         
         try {
             int choice = Integer.parseInt(scanner.nextLine());
             
             switch (choice) {
                 case 1:
                     System.out.print("Enter menu name: ");
                     String menuName = scanner.nextLine();
                     allMenus.add(new Menu(menuName));
                     System.out.println("Menu added.");
                     break;

                 case 2:
                     System.out.print("Enter menu item name: ");
                     String itemName = scanner.nextLine();
                     
                     // Check if item already exists
                     if (menuItemMap.containsKey(itemName)) {
                         System.out.println("Error: Menu item with name '" + itemName + "' already exists.");
                         break;
                     }
                     
                     System.out.print("Enter menu item price: ");
                     double itemPrice = Double.parseDouble(scanner.nextLine());
                     MenuItem newItem = new MenuItem(itemName, itemPrice);
                     allMenus.add(newItem);
                     menuItemMap.put(itemName, newItem);
                     System.out.println("Menu item added.");
                     break;

                 case 3:
                     allMenus.print();
                     break;

                 case 4:
                     System.out.println("Exiting...");
                     scanner.close();
                     return;

                 default:
                     System.out.println("Invalid option. Please try again.");
             }
         } catch (NumberFormatException e) {
             System.out.println("Invalid input. Please enter a number.");
         } catch (Exception e) {
             System.out.println("An error occurred: " + e.getMessage());
         }
     }
 }
}

