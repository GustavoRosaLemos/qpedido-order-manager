package br.com.qpedido.order.manager.order;

import br.com.qpedido.order.manager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public OrderRepresentation.GetOrdersResponse getOrdersService() {
        OrderRepresentation.GetOrdersResponse response = new OrderRepresentation.GetOrdersResponse();
        response.setOrders(orderRepository.findAll());
        return response;
    }
}
