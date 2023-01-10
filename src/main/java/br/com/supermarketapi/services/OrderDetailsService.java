package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.OrderDetailsDTO;
import br.com.supermarketapi.dtos.ProductDTO;
import br.com.supermarketapi.models.OrderDetails;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.OrderDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("OrderDetails")
public class OrderDetailsService implements CrudService<OrderDetailsDTO, Long> {
    private OrderDetailsRepository orderDetailsRepository;
    private ModelMapper mapper = new ModelMapper();

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public List<OrderDetailsDTO> findAll() {
        List<OrderDetails> listOrder = orderDetailsRepository.findAll();
        List<OrderDetailsDTO> listOrderDTO= new ArrayList<>();

        for (OrderDetails order: listOrder ) {
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
            BeanUtils.copyProperties(order , orderDetailsDTO);
            listOrderDTO.add(orderDetailsDTO);
        }
        return listOrderDTO;
    }

    @Override
    public OrderDetailsDTO findById(Long id) {
        return mapper.map(orderDetailsRepository.findById(id).orElse(null), OrderDetailsDTO.class);
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
