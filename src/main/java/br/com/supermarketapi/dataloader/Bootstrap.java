package br.com.supermarketapi.dataloader;

import br.com.supermarketapi.models.Category;
import br.com.supermarketapi.models.ClientList;
import br.com.supermarketapi.models.OrderDetails;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public Bootstrap(ProductRepository productRepository, ClientListRepository clientListRepository,
                     OrderDetailsRepository orderDetailsRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.clientListRepository = clientListRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setName("Food");
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setName("Musical Instrument");
        categoryRepository.save(category2);

        System.out.println("Saved Categories.");

        Product product1 = new Product();
        product1.setName("Apple");
        product1.setDescription("A red, sweet fruit");
        product1.setImage("img/apple.png");
        product1.setQuantity(1);
        product1.setStatus(true);
        product1.setCategory(category);
        product1.setPrice(15l);

        productRepository.save(product1);

        Product product2 = new Product("Orange", "A citric fruit","img/orange.png",1, true, category, 5l);
        productRepository.save(product2);
        Product product3 = new Product("Guitar", "A musical instrument", "img/stratocaster.png", 2,true, category2, 360l);
        productRepository.save(product3);
        System.out.println("Saved products.");

        ClientList clientList = new ClientList("Client One");

        clientListRepository.save(clientList);

        System.out.println("Saved list.");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setClientList(clientList);
        orderDetails.setProduct_order(product1);
        orderDetails.setProductQuantity(5);
        orderDetailsRepository.save(orderDetails);

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setClientList(clientList);
        orderDetails1.setProduct_order(product3);
        orderDetails1.setProductQuantity(7);
        orderDetailsRepository.save(orderDetails1);

        System.out.println("Saved orders.");

    }
}
