package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.ProductDTO;
import br.com.supermarketapi.models.ListOfProduct;
import br.com.supermarketapi.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import br.com.supermarketapi.models.Product;
@Service
@Qualifier("Product")
public class ProductService implements CrudService<ProductDTO, Long> {
    private ProductRepository productRepository;
    private Product product = new Product();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> listProducts = productRepository.findAll();
        List<ProductDTO> listProductDTO= new ArrayList<>();

        for (Product product: listProducts ) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(filterProduct(product) , productDTO);
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }

    @Override
    public ProductDTO findById(Long id) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(filterProduct((productRepository
                                                .findById(id))
                                                .orElse(null)), productDTO);
        return productDTO;
    }

    public ProductDTO findByName(String name){
        for(ProductDTO productDTO : findAll()){
            if (productDTO.getName().equals(name)){
                return productDTO;
            }
        }
        return null;
    }

    public ProductDTO findByDescription(String description){
        for(ProductDTO productDTO : findAll()){
            if (productDTO.getDescription().equals(description)){
                return productDTO;
            }
        }
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO object) {
        BeanUtils.copyProperties(object, this.product);
        productRepository.save(this.product);
        return object;
    }

    @Override
    public ProductDTO update(ProductDTO object) {
        BeanUtils.copyProperties(object, this.product);
        productRepository.save(this.product);
        return object;
    }

    public ProductDTO deactivate(ProductDTO object, String status){
        BeanUtils.copyProperties(object, this.product);
        if(status.equals("true")){
            this.product.setStatus(true);
        } else {
            this.product.setStatus(false);
        }
        productRepository.save(this.product);
        return object;
    }

    @Override
    public void delete(ProductDTO object) {
        BeanUtils.copyProperties(object, this.product);
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO filterProduct(Product product){
        List<ListOfProduct> filteredProducts = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);

        for(ListOfProduct listOfProduct : product.getProductList()){
            filteredProducts.add(filterListProducts(listOfProduct));
        }
        productDTO.setProductList(filteredProducts);
        return productDTO;
    }
    // Metodo criado para que nao seja retornado um conjunto redundante de autor, que eh lido dentro do JSON
    // causando erro de stack overflow.
    private ListOfProduct filterListProducts(ListOfProduct product){
        ListOfProduct prototype = new ListOfProduct();
        BeanUtils.copyProperties(product, prototype , "shoplist");
        return prototype;
    }
}
