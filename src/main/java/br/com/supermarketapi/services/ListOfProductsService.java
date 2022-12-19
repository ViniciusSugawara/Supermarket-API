package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.ListOfProductDTO;
import br.com.supermarketapi.models.ListOfProduct;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.ListOfProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("ListOfProducts")
public class ListOfProductsService implements CrudService<ListOfProductDTO,Long>
{
    private ListOfProductsRepository listOfProductsRepository;
    private ListOfProduct listOfProduct = new ListOfProduct();

    public ListOfProductsService(ListOfProductsRepository listOfProductsRepository) {
        this.listOfProductsRepository = listOfProductsRepository;
    }

    @Override
    public List<ListOfProductDTO> findAll() {
        List<ListOfProduct> listOfProductsList = listOfProductsRepository.findAll();
        List<ListOfProductDTO> listOfProductDTOList = new ArrayList<>();

        for (ListOfProduct listOfProduct : listOfProductsList ) {
            ListOfProductDTO listOfProductDTO = new ListOfProductDTO();
            BeanUtils.copyProperties(filterList(listOfProduct), listOfProductDTO);
            listOfProductDTOList.add(listOfProductDTO);
        }
        return listOfProductDTOList;
    }

    @Override
    public ListOfProductDTO findById(Long id) {
        ListOfProductDTO listOfProductDTO = new ListOfProductDTO();
        BeanUtils.copyProperties(listOfProductsRepository.findById(id), listOfProductDTO);
        return listOfProductDTO;
    }

    @Override
    public ListOfProductDTO save(ListOfProductDTO object) {
//        for(Product product : object.getProducts()){
//            this.listOfProducts.getProducts().add(product);
//        }
        BeanUtils.copyProperties(object, this.listOfProduct);
        listOfProductsRepository.save(this.listOfProduct);
        return object;
    }

    //By now, will be using this method to update products inside the list, changing their quantities using RequestBody.
    //Should have a dedicated method with respective business logic.
    @Override
    public ListOfProductDTO update(ListOfProductDTO object) {
        BeanUtils.copyProperties(object, this.listOfProduct);
        listOfProductsRepository.save(listOfProduct);
        return object;
    }

    @Override
    public void delete(ListOfProductDTO object) {
        BeanUtils.copyProperties(object, this.listOfProduct);
        listOfProductsRepository.delete(listOfProduct);
    }

    @Override
    public void deleteById(Long id) {
        listOfProductsRepository.deleteById(id);
    }

    private ListOfProductDTO filterList(ListOfProduct listOfProduct){
        List<Product> filteredProducts = new ArrayList<>();
        ListOfProductDTO listOfProductDTO = new ListOfProductDTO();
        BeanUtils.copyProperties(listOfProduct, listOfProductDTO);

        for(Product product : listOfProduct.getShoplist()){
            filteredProducts.add(filterListProducts(product));
        }
        listOfProductDTO.setShoplist(filteredProducts);
        return listOfProductDTO;
    }
    private Product filterListProducts(Product product){
        Product prototype = new Product();
        BeanUtils.copyProperties(product, prototype , "productList");
        return prototype;
    }
}
