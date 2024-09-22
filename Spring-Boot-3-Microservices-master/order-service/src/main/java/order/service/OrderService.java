package order.service;


import order.model.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
