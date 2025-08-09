package com.web;
import java.util.*;

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
}

class Portfolio {
    private Map<String, Integer> holdings;
    private double balance;

    public Portfolio(double initialBalance) {
        holdings = new HashMap<>();
        balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.getSymbol(),
                    holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (holdings.getOrDefault(stock.getSymbol(), 0) >= quantity) {
            double revenue = stock.getPrice() * quantity;
            balance += revenue;
            holdings.put(stock.getSymbol(),
                    holdings.get(stock.getSymbol()) - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    public void viewPortfolio(Map<String, Stock> market) {
        System.out.println("\n--- Portfolio ---");
        for (String symbol : holdings.keySet()) {
            int qty = holdings.get(symbol);
            double currentPrice = market.get(symbol).getPrice();
            double totalValue = qty * currentPrice;
            System.out.println(symbol + ": " + qty + " shares (Value: Rs." + totalValue + ")");
        }
        System.out.println("Cash Balance: Rs." + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simulated market data
        Map<String, Stock> market = new HashMap<>();
        market.put("TCS", new Stock("TCS", 3500));
        market.put("INFY", new Stock("INFY", 1450));
        market.put("RELI", new Stock("RELI", 2500));

        Portfolio portfolio = new Portfolio(10000); // Starting balance

        while (true) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Market Data ---");
                    for (Stock stock : market.values()) {
                        System.out.println(stock.getSymbol() + " - Rs." + stock.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.next().toUpperCase();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        portfolio.buyStock(market.get(buySymbol), qty);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.next().toUpperCase();
                    if (market.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int qtySell = sc.nextInt();
                        portfolio.sellStock(market.get(sellSymbol), qtySell);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;
                case 4:
                    portfolio.viewPortfolio(market);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for trading!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

