// 				Creational Design Patterns - Singleton Pattern - Cache Manager                        

package CreationalDesignPatterns;

import java.util.*;

//Singleton CacheManager class
class SimpleCache {
 private static SimpleCache instance;
 private Map<String, String> cache;

 // Private constructor to prevent instantiation
 private SimpleCache() {
     cache = new HashMap<>();
 }

 // Method to get the single instance of SimpleCache
 public static synchronized SimpleCache getInstance() {
     if (instance == null) {
         instance = new SimpleCache();
     }
     return instance;
 }

 // Method to add data to the cache
 public void add(String key, String value) {
     cache.put(key, value);
 }

 // Method to retrieve data from the cache
 public String retrieve(String key) {
     return cache.get(key);
 }

 // Method to remove data from the cache
 public void remove(String key) {
     cache.remove(key);
 }

 // Method to clear the cache
 public void clear() {
     cache.clear();
 }

 // Method to display the cache contents
 public void showCache() {
     System.out.println("Cache Contents: " + cache);
 }
}

//Main class to demonstrate SimpleCache usage
public class CacheManager {
 public static void main(String[] args) {
     SimpleCache cacheManager = SimpleCache.getInstance();
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("\nCache Manager Menu:");
         System.out.println("1. Add entry  || 2. Retrieve entry || 3. Remove entry || 4. Clear cache || 5. Display cache || 6. Exit");
        
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
                 System.out.print("Enter key to add: ");
                 String addKey = scanner.nextLine();
                 System.out.print("Enter value to add: ");
                 String addValue = scanner.nextLine();
                 cacheManager.add(addKey, addValue);
                 System.out.println("Entry added.");
                 break;

             case 2:
                 System.out.print("Enter key to retrieve: ");
                 String getKey = scanner.nextLine();
                 String value = cacheManager.retrieve(getKey);
                 if (value != null) {
                     System.out.println("Value for key '" + getKey + "': " + value);
                 } else {
                     System.out.println("Key not found.");
                 }
                 break;

             case 3:
                 System.out.print("Enter key to remove: ");
                 String removeKey = scanner.nextLine();
                 cacheManager.remove(removeKey);
                 System.out.println("Entry removed.");
                 break;

             case 4:
                 cacheManager.clear();
                 System.out.println("Cache cleared.");
                 break;

             case 5:
                 cacheManager.showCache();
                 break;

             case 6:
                 System.out.println("Exiting...");
                 scanner.close();
                 return;

             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }
 }
}
