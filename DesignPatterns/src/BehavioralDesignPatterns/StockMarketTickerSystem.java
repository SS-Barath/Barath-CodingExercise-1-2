// 				Behavioral Design Patterns - Observer Pattern - Stock Market Ticker System 

package BehavioralDesignPatterns;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Subject Interface
interface StockMarket{
	void registerClient(Client client);
	void removeClient(Client client);
	void notifyClients();
}

// Concrete Subject implementing the StockMarket interface
class ConcreteStockMarket implements StockMarket {
	private List<Client> clients;     // List of clients(observers)
    private Map<String, Double> stockPrices; // Stock prices data
    
    public ConcreteStockMarket() {
    	clients = new ArrayList<>();
    	stockPrices = new LinkedHashMap<>();
    }
    
    // Method to update stock price and notify all clients
    public void updateStockPrice(String stock, double price) {
    	stockPrices.put(stock, price);
    	notifyClients(); // Notify all registered clients about the price update 
    }
    
    //Register a new client(observer)
    public void registerClient(Client client) {
    	clients.add(client);
    }
    
    //Remove an existing client(observer)
    public void removeClient(Client client) {
    	clients.remove(client);
    }
    
    //Notify all registered clients about the latest stock prices
    public void notifyClients() {
    	for(Client client : clients) {
    		client.update(stockPrices);
    	}
    }
}

//Observer Interface
interface Client { 
	void update(Map<String, Double> stockPrices);
}

//Concrete Observer implementing the Client interface for Mobile App
class MobileAppClient implements Client{
	public void update(Map<String, Double> stockPrices) {
		System.out.println("Mobile App    - Stock Prices: " + stockPrices);
	}
}

//Another Concrete Observer implementing the Client interface for Web Dashboard
class WebDashboardClient implements Client {
	public void update(Map<String, Double> stockPrices) {
		System.out.println("Web Dashboard - Stock Prices: " + stockPrices);
	}
}

public class StockMarketTickerSystem { 
	public static void main(String args[]) {
		ConcreteStockMarket stockMarket = new ConcreteStockMarket();
	
	    //Concrete instances of clients
		Client mobileApp = new MobileAppClient();
		Client WebDashboard = new WebDashboardClient();
		
		//Register the clients with the stock market
		stockMarket.registerClient(mobileApp);
		stockMarket.registerClient(WebDashboard);
		
		//Scanner to get input from the user
		Scanner sc = new Scanner(System.in);
		
		//Loop to get user input for stock prices
		while(true) {
			System.out.print("Enter Stock Symbol (or 'exit' to quit):");
            String stockSymbol = sc.nextLine();
            
            if(stockSymbol.equalsIgnoreCase("exit")) {
            	break;
            }
		
            System.out.print("Enter Stock Price:");
            try {
                double stockPrice = Double.parseDouble(sc.nextLine());
              //Update stock prices and notify all registered clients
                stockMarket.updateStockPrice(stockSymbol, stockPrice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the stock price.");
            }		
		}
		sc.close();
	}
}
