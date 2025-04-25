package iuh.strategy;

interface TaxStrategy {
    public double calculateTax(double price);
}

class VATTax implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.1;
    }
}
// Chiến lược tính thuế tiêu thụ đặc biệt
class SpecialTax implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.2; // Thuế 20%
    }
}

// Chiến lược miễn thuế
class NoTax implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return 0;
    }
}

// Lớp Product sử dụng chiến lược tính thuế
class Product {
    private String name;
    private double price;
    private TaxStrategy taxStrategy;

    public Product(String name, double price, TaxStrategy taxStrategy) {
        this.name = name;
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    public double getPriceWithTax() {
        return price + taxStrategy.calculateTax(price);
    }

    public void displayPrice() {
        System.out.println(name + " có giá sau thuế: " + getPriceWithTax());
    }
}

// Lớp kiểm thử
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000, new VATTax());
        Product product2 = new Product("Rượu", 500, new SpecialTax());
        Product product3 = new Product("Sách", 200, new NoTax());

        product1.displayPrice();
        product2.displayPrice();
        product3.displayPrice();
    }
}
