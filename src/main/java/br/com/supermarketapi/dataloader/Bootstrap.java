package br.com.supermarketapi.dataloader;

import br.com.supermarketapi.models.ListOfProduct;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.ListOfProductsRepository;
import br.com.supermarketapi.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap  implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final ListOfProductsRepository listOfProductsRepository;

    public Bootstrap(ProductRepository productRepository, ListOfProductsRepository listOfProductsRepository) {
        this.productRepository = productRepository;
        this.listOfProductsRepository = listOfProductsRepository;
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

        ListOfProduct listOfProduct = new ListOfProduct();
        listOfProduct.getShoplist().add(product1);
        listOfProduct.getShoplist().add(product3);

        listOfProductsRepository.save(listOfProduct);
        System.out.println("Saved list.");
    }
}
