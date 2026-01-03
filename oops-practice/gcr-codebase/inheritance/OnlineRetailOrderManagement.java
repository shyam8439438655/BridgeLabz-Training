class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("001", "2024-06-01");
        System.out.println("Order ID: " + order.orderId + ", Status: " + order.getOrderStatus());

        ShippedOrder shippedOrder = new ShippedOrder("002", "2024-06-02", "TRACK123");
        System.out.println("Order ID: " + shippedOrder.orderId + ", Status: " + shippedOrder.getOrderStatus());

        DeliveredOrder deliveredOrder = new DeliveredOrder("003", "2024-06-03", "TRACK456", "2024-06-05");
        System.out.println("Order ID: " + deliveredOrder.orderId + ", Status: " + deliveredOrder.getOrderStatus());
    }
}
