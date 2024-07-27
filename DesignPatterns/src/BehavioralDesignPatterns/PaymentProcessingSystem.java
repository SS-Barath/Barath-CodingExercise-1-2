// 				Behavioral Design Patterns - Strategy Pattern - Payment Processing System                         

package BehavioralDesignPatterns;

import java.util.Scanner;

//PaymentStrategy Interface
interface PaymentStrategy {
 void pay(int amount);
}

//Concrete Strategy for Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;
 private String cardHolderName;

 public CreditCardPayment(String cardNumber, String cardHolderName) {
     this.cardNumber = cardNumber;
     this.cardHolderName = cardHolderName;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid ₹" + amount + " using Credit Card.");
     System.out.println("Card Number: " + cardNumber);
     System.out.println("Card Holder: " + cardHolderName);
 }
}

//Concrete Strategy for PayPal Payment
class PayPalPayment implements PaymentStrategy {
 private String email;

 public PayPalPayment(String email) {
     this.email = email;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid ₹" + amount + " using PayPal.");
     System.out.println("Email: " + email);
 }
}

//Concrete Strategy for Cryptocurrency Payment
class CryptoPayment implements PaymentStrategy {
 private String cryptoAddress;

 public CryptoPayment(String cryptoAddress) {
     this.cryptoAddress = cryptoAddress;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid $" + amount + " using Cryptocurrency.");
     System.out.println("Address: " + cryptoAddress);
 }
}

//Concrete Strategy for Google Pay Payment
class GooglePayPayment implements PaymentStrategy {
 private String phoneNumber;

 public GooglePayPayment(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid ₹" + amount + " using Google Pay.");
     System.out.println("Phone Number: " + phoneNumber);
 }
}

//Context Class
class ShoppingCart {
 private PaymentStrategy paymentStrategy;

 public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
     this.paymentStrategy = paymentStrategy;
 }

 public void checkout(int amount) {
     paymentStrategy.pay(amount);
 }
}

//Main Class
public class PaymentProcessingSystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ShoppingCart cart = new ShoppingCart();

     System.out.println("Choose payment method: (1) Credit Card (2) PayPal (3) Cryptocurrency (4) Google Pay");
     int choice = scanner.nextInt();
     scanner.nextLine(); // consume the newline

     switch (choice) {
         case 1: {
             System.out.print("Enter card number: ");
             String cardNumber = scanner.nextLine();
             System.out.print("Enter card holder name: ");
             String cardHolderName = scanner.nextLine();
             cart.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName));
             break;
         }
         case 2: {
             System.out.print("Enter PayPal email: ");
             String email = scanner.nextLine();
             cart.setPaymentStrategy(new PayPalPayment(email));
             break;
         }
         case 3: {
             System.out.print("Enter cryptocurrency address: ");
             String cryptoAddress = scanner.nextLine();
             cart.setPaymentStrategy(new CryptoPayment(cryptoAddress));
             break;
         }
         case 4: {
             System.out.print("Enter phone number for Google Pay: ");
             String phoneNumber = scanner.nextLine();
             cart.setPaymentStrategy(new GooglePayPayment(phoneNumber));
             break;
         }
         default:
             System.out.println("Invalid choice.");
             scanner.close();
             return;
     }

     System.out.print("Enter amount to pay: ");
     int amount = scanner.nextInt();
     scanner.close();

     cart.checkout(amount);
 }
}
