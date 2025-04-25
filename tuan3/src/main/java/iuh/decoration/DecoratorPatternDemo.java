package iuh.decoration;

// Interface phương thức thanh toán
interface Payment {
    void pay(double amount);
}

// Lớp cơ bản cho thanh toán bằng thẻ tín dụng
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " bằng Thẻ tín dụng.");
    }
}

// Lớp cơ bản cho thanh toán bằng PayPal
class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " bằng PayPal.");
    }
}

// Lớp Decorator cơ sở
abstract class PaymentDecorator implements Payment {
    protected Payment decoratedPayment;

    public PaymentDecorator(Payment payment) {
        this.decoratedPayment = payment;
    }

    @Override
    public void pay(double amount) {
        decoratedPayment.pay(amount);
    }
}

// Decorator thêm phí xử lý giao dịch
class ProcessingFeeDecorator extends PaymentDecorator {
    public ProcessingFeeDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        double fee = amount * 0.02; // Phí 2%
        System.out.println("Phí xử lý: " + fee);
        super.pay(amount + fee);
    }
}

// Decorator thêm mã giảm giá
class DiscountDecorator extends PaymentDecorator {
    public DiscountDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        double discount = amount * 0.1; // Giảm 10%
        System.out.println("Áp dụng mã giảm giá: -" + discount);
        super.pay(amount - discount);
    }
}

// Lớp kiểm thử
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Payment payment1 = new ProcessingFeeDecorator(new CreditCardPayment());
        Payment payment2 = new DiscountDecorator(new PayPalPayment());

        payment1.pay(1000);
        System.out.println("-----------------");
        payment2.pay(500);
    }
}
