package iuh.State;

public interface OrderState {
    void handleOrder(OrderContext orderContext);

    class OrderContext {
        private OrderState orderState;

        public OrderContext(OrderState orderState) {
            this.orderState = orderState;
        }

        public void setOrderState(OrderState orderState) {
            this.orderState = orderState;
        }

        public OrderState getState() {
            return orderState;
        }


        public void order() {
            orderState.handleOrder(this);
        }
    }

    class NewOrderState implements OrderState {
        @Override
        public void handleOrder(OrderContext orderContext) {
            System.out.println("Tạo đơn hàng mới!");
            orderContext.setOrderState(new ProcessingOrderState());
        }
    }

    class ProcessingOrderState implements OrderState {
        @Override
        public void handleOrder(OrderContext orderContext) {
            System.out.println("Đơn hàng đang trong quá trình xử lý!");
            orderContext.setOrderState(new DoneOrderState());
        }
    }

    class DoneOrderState implements OrderState {
        @Override
        public void handleOrder(OrderContext orderContext) {
            System.out.println("Đơn hàng đã xử lý xong!");
        }
    }

    class CancelOrderState implements OrderState {
        @Override
        public void handleOrder(OrderContext orderContext) {
            System.out.println("Đơn hàng đã bị hủy!");
        }
    }

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext(new NewOrderState());
        orderContext.order();
        orderContext.order();

        // Kiểm tra xem đơn hàng có bị hủy không
        if (orderContext.getState() instanceof CancelOrderState) {
            System.out.println("Đơn hàng đã bị hủy!");
        } else {
            System.out.println("Đơn hàng vẫn đang trong quá trình xử lý.");
        }
        orderContext.order();

    }
}
