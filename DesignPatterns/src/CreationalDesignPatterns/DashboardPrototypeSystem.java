// 				Creational Design Patterns - Prototype Pattern - Dashboard Prototype System

package CreationalDesignPatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Prototype Interface
interface DashboardTemplate extends Cloneable {
    DashboardTemplate clone();
    void customize(String customization);
    void display();
}

// Concrete Prototype 1
class SalesDashboard implements DashboardTemplate {
    private String layout;

    public SalesDashboard() {
        this.layout = "Sales Dashboard Layout";
    }

    @Override
    public DashboardTemplate clone() {
        return new SalesDashboard();
    }

    @Override
    public void customize(String customization) {
        this.layout += " with " + customization;
    }

    @Override
    public void display() {
        System.out.println(layout);
    }
}

// Concrete Prototype 2
class MarketingDashboard implements DashboardTemplate {
    private String layout;

    public MarketingDashboard() {
        this.layout = "Marketing Dashboard Layout";
    }

    @Override
    public DashboardTemplate clone() {
        return new MarketingDashboard();
    }

    @Override
    public void customize(String customization) {
        this.layout += " with " + customization;
    }

    @Override
    public void display() {
        System.out.println(layout);
    }
}

// Prototype Registry
class DashboardRegistry {
    private Map<String, DashboardTemplate> templates = new HashMap<>();

    public DashboardRegistry() {
        loadTemplates();
    }

    private void loadTemplates() {
        templates.put("Sales", new SalesDashboard());
        templates.put("Marketing", new MarketingDashboard());
    }

    public DashboardTemplate getTemplate(String type) {
        DashboardTemplate template = templates.get(type);
        if (template == null) {
            System.out.println("Invalid dashboard type.");
            return null;
        }
        return template.clone();
    }
}

// Main Class
public class DashboardPrototypeSystem {
    public static void main(String[] args) {
        DashboardRegistry registry = new DashboardRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter dashboard type (Sales/Marketing) or 'exit' to quit: ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("exit")) {
                break;
            }

            DashboardTemplate dashboard = registry.getTemplate(type);
            if (dashboard != null) {
                System.out.print("Enter customization for the " + type + " Dashboard: ");
                String customization = scanner.nextLine();
                dashboard.customize(customization);
                dashboard.display();
            }
        }
        scanner.close();
    }
}
