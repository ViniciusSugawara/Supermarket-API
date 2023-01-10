package br.com.supermarketapi.dataloader;

import br.com.supermarketapi.models.ClientList;
import br.com.supermarketapi.models.OrderDetails;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.ClientListRepository;
import br.com.supermarketapi.repositories.OrderDetailsRepository;
import br.com.supermarketapi.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final ClientListRepository clientListRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public Bootstrap(ProductRepository productRepository, ClientListRepository clientListRepository,
                     OrderDetailsRepository orderDetailsRepository) {
        this.productRepository = productRepository;
        this.clientListRepository = clientListRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product();
        product1.setName("Apple");
        product1.setDescription("A red, sweet fruit");
        product1.setImage("/img/apple.png");
        product1.setQuantity(1);
        product1.setStatus(true);

        productRepository.save(product1);

        Product product2 = new Product("Orange", "A citric fruit","img/orange.png",1, true);
        productRepository.save(product2);
        Product product3 = new Product("Guitar", "A musical instrument", "img/stratocaster.png", 2,true);
        productRepository.save(product3);
        System.out.println("Saved products.");

        ClientList clientList = new ClientList("Person");

        clientListRepository.save(clientList);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setClientList(clientList);
        orderDetails.setProduct_order(product1);
        orderDetailsRepository.save(orderDetails);

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setClientList(clientList);
        orderDetails1.setProduct_order(product3);
        orderDetailsRepository.save(orderDetails1);

        System.out.println("Saved list.");
    }
}
