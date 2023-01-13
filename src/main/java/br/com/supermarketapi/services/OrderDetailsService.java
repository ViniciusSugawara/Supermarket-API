package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.input.OrderDetailsDTO;
import br.com.supermarketapi.dtos.output.OrderDetailsWithIDs;
import br.com.supermarketapi.models.OrderDetails;
import br.com.supermarketapi.repositories.OrderDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("OrderDetails")
public class OrderDetailsService implements CrudService<OrderDetailsDTO, OrderDetailsWithIDs, Long> {
    private OrderDetailsRepository orderDetailsRepository;
    private ModelMapper mapper = new ModelMapper();

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public List<OrderDetailsWithIDs> findAll() {
        List<OrderDetails> allListOrders = orderDetailsRepository.findAll();
        List<OrderDetailsWithIDs> listOrderDTO = new ArrayList<>();

        for(OrderDetails orderDetails : allListOrders){
            OrderDetailsWithIDs target = mapper.map(orderDetails, OrderDetailsWithIDs.class);
            target.setProduct_order_id(orderDetails.getProduct_order().getId());
            target.setClientList_id(orderDetails.getClientList().getId());
            listOrderDTO.add(target);
        }
        return listOrderDTO;
    }

    @Override
    public OrderDetailsWithIDs findById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElse(null);
        OrderDetailsWithIDs target = mapper.map(orderDetails, OrderDetailsWithIDs.class);
        target.setProduct_order_id(orderDetails.getProduct_order().getId());
        target.setClientList_id(orderDetails.getClientList().getId());
        return target;
    }

    @Override
    public OrderDetailsDTO save(OrderDetailsDTO object) {
        orderDetailsRepository.save(mapper.map(object, OrderDetails.class));
        return object;
    }

    @Override
    public OrderDetailsDTO update(OrderDetailsDTO object) {
        orderDetailsRepository.save(mapper.map(object, OrderDetails.class));
        return object;
    }

    @Override
    public void delete(OrderDetailsDTO object) {
        orderDetailsRepository.delete(mapper.map(object, OrderDetails.class));
    }

    @Override
    public void deleteById(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
