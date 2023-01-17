package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.ProductIDandName;
import br.com.supermarketapi.dtos.input.ProductDTO;
import br.com.supermarketapi.dtos.output.ProductWithOrderID;
import br.com.supermarketapi.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.supermarketapi.models.Product;
@Service
@Qualifier("Product")
public class ProductService implements CrudService<ProductDTO, ProductWithOrderID, Long> {
    private ProductRepository productRepository;
    private Product product = new Product();
    private ModelMapper mapper = new ModelMapper();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductWithOrderID> findAll() {
        List<ProductWithOrderID> allProductsWithOrderId = mapToListOfProductWithOrderID(productRepository.findAll());

        return allProductsWithOrderId;
    }

    public List<ProductIDandName> findAllByIdAndName(){
        return productRepository.findAllProductsIdAndName();
    }

    public List<ProductWithOrderID> findAllSorted(String field){;
        List<ProductWithOrderID> allProductsWithOrderId = mapToListOfProductWithOrderID(productRepository.findAll(Sort.by(Sort.Direction.ASC, field)));

        return allProductsWithOrderId;
    }

    public Page<ProductWithOrderID> findAllPaginated(int currentPageNumber, int size){
        Page<Product> productPage = productRepository.findAll(PageRequest.of(currentPageNumber, size));

        Page<ProductWithOrderID> productDTOPage = productPage.map((entity) -> {
            ProductWithOrderID dto = mapper.map(entity, ProductWithOrderID.class);
            dto.setCategory_name(entity.getCategory().getName());
            return dto;
        });
        return productDTOPage;
    }

    public Page<ProductWithOrderID> findAllPaginated(int currentPageNumber, int size, String field){
        Page<Product> productPage = productRepository.findAll(PageRequest.of(currentPageNumber, size, Sort.by(field)));

        Page<ProductWithOrderID> productDTOPage = productPage.map((entity) -> {
            ProductWithOrderID dto = mapper.map(entity, ProductWithOrderID.class);
            dto.setCategory_name(entity.getCategory().getName());
            return dto;
        });
        return productDTOPage;
    }

    public Page<ProductWithOrderID> findAllPaginated(int currentPageNumber, int size, String field, String order){
        Page<Product> productPage;
        if(order.toLowerCase().startsWith("asc")) {
            productPage = productRepository.findAll(PageRequest.of(currentPageNumber, size, Sort.by(field).ascending()));
        } else {
            productPage = productRepository.findAll(PageRequest.of(currentPageNumber, size, Sort.by(field).descending()));
        }

        Page<ProductWithOrderID> productDTOPage = productPage.map((entity) -> {
            ProductWithOrderID dto = mapper.map(entity, ProductWithOrderID.class);
            dto.setCategory_name(entity.getCategory().getName());
            return dto;
        });
        return productDTOPage;
    }

    public List<ProductWithOrderID> findAllFiltered(String filterParameter){
        List<ProductWithOrderID> allProductsWithOrderId = mapToListOfProductWithOrderID(productRepository.findAll());

        List<ProductWithOrderID> filteredList =
                allProductsWithOrderId
                        .stream()
                        .filter(product -> product.getName().toLowerCase().startsWith(filterParameter)
                                || product.getCategory_name().toLowerCase().startsWith(filterParameter)
                                || product.getDescription().toLowerCase().startsWith(filterParameter))
                        .collect(Collectors.toList());

        return filteredList;
    }

    public List<ProductWithOrderID> findAllFilteredByPrice(Integer maximum, Integer minimum){
        List<ProductWithOrderID> allProductsWithOrderId = mapToListOfProductWithOrderID(productRepository.findAll());

        List<ProductWithOrderID> filteredList = new ArrayList<>();
        for(ProductWithOrderID productDTO : allProductsWithOrderId){
            if(productDTO.getPrice() < maximum && productDTO.getPrice() > minimum){
                filteredList.add(productDTO);
            }
        }
        return filteredList;
    }

    public List<ProductWithOrderID> findAllWithFilters(String... parameters){
        List<ProductWithOrderID> allProductsWithOrderId = mapToListOfProductWithOrderID(productRepository.findAll());
        return allProductsWithOrderId;
    }

    @Override
    public ProductWithOrderID findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductWithOrderID productWithOrderID = mapper.map(product, ProductWithOrderID.class);
        productWithOrderID.setCategory_name(product.getCategory().getName());

        product.getOrderDetails()
                .stream()
                .forEach((order) -> productWithOrderID.getOrderDetails_id().add(order.getId()));
        return productWithOrderID;
    }

    public ProductWithOrderID findByName(String name){
        for(Product productDTO : productRepository.findAll()){
            if (productDTO.getName().equals(name)){
                return mapper.map(productDTO, ProductWithOrderID.class);
            }
        }
        return null;
    }

    public ProductWithOrderID findByDescription(String description){
        for(Product productDTO : productRepository.findAll()){
            if (productDTO.getDescription().equals(description)){
                return mapper.map(productDTO, ProductWithOrderID.class);
            }
        }
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO object) {
        return mapper.map(
                productRepository.save(
                        mapper.map(object, Product.class)
                ),
                ProductDTO.class
        );
    }

    @Override
    public ProductDTO update(ProductDTO object) {
        productRepository.save(mapper.map(object, Product.class));
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

    private List<ProductWithOrderID> mapToListOfProductWithOrderID(List<Product> list) {
        List<ProductWithOrderID> allProductsWithOrderId = new ArrayList<>();

        for(Product product : list){
            ProductWithOrderID productWithOrderID = mapper.map(product, ProductWithOrderID.class);
            productWithOrderID.setCategory_name(product.getCategory().getName());

            product.getOrderDetails()
                    .stream()
                    .forEach((order)-> productWithOrderID.getOrderDetails_id().add(order.getId()));
            allProductsWithOrderId.add(productWithOrderID);
        }
        return allProductsWithOrderId;
    }
}
