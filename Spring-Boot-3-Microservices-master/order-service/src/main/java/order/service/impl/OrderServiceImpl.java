package order.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import order.client.InventoryClient;
import order.model.dto.OrderRequest;
import order.model.entity.Order;
import order.repository.OrderRepository;
import order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            //map request to order obj, save order to repo
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            order.setSkyCode(orderRequest.skuCode());
            orderRepository.save(order);
        } else {

            throw new RuntimeException("Product with skuCode" + orderRequest.skuCode() + " is not in stock");
        }
    }
}
