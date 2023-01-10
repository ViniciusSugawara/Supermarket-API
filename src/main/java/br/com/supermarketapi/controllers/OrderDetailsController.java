package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.OrderDetailsDTO;
import br.com.supermarketapi.services.OrderDetailsService;
import jakarta.persistence.criteria.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController extends AbsController<OrderDetailsDTO> {
    private OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @Override
    public ResponseEntity<List<OrderDetailsDTO>> findAll() {
        return new ResponseEntity<>(orderDetailsService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetailsDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderDetailsService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetailsDTO> save(OrderDetailsDTO object) {
        return new ResponseEntity<>(orderDetailsService.save(object), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderDetailsDTO> update(OrderDetailsDTO object) {
        return new ResponseEntity<>(orderDetailsService.update(object), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(OrderDetailsDTO object) {
        orderDetailsService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        orderDetailsService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
