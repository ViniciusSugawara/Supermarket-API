package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.ListOfProductsDTO;
import br.com.supermarketapi.dtos.ProductDTO;
import br.com.supermarketapi.models.ListOfProducts;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.ListOfProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("ListOfProducts")
public class ListOfProductsService implements CrudService<ListOfProductsDTO,Long>
{
    private ListOfProductsRepository listOfProductsRepository;
    private ListOfProducts listOfProducts = new ListOfProducts();

    public ListOfProductsService(ListOfProductsRepository listOfProductsRepository) {
        this.listOfProductsRepository = listOfProductsRepository;
    }

    @Override
    public List<ListOfProductsDTO> findAll() {
        List<ListOfProducts> listOfProductsList = listOfProductsRepository.findAll();
        List<ListOfProductsDTO> listOfProductDTOList = new ArrayList<>();

        for (ListOfProducts listOfProducts: listOfProductsList ) {
            ListOfProductsDTO listOfProductDTO = new ListOfProductsDTO();
            BeanUtils.copyProperties(listOfProducts , listOfProductDTO);
            listOfProductDTOList.add(listOfProductDTO);
        }
        return listOfProductDTOList;
    }

    @Override
    public ListOfProductsDTO findById(Long id) {
        ListOfProductsDTO listOfProductsDTO = new ListOfProductsDTO();
        BeanUtils.copyProperties(listOfProductsRepository.findById(id), listOfProductsDTO);
        return listOfProductsDTO;
    }

    @Override
    public ListOfProductsDTO save(ListOfProductsDTO object) {
        BeanUtils.copyProperties(object, this.listOfProducts);
        listOfProductsRepository.save(listOfProducts);
        return object;
    }

    //By now, will be using this method to update products inside the list, changing their quantities using RequestBody.
    //Should have a dedicated method with respective business logic.
    @Override
    public ListOfProductsDTO update(ListOfProductsDTO object) {
        BeanUtils.copyProperties(object, this.listOfProducts);
        listOfProductsRepository.save(listOfProducts);
        return object;
    }

    @Override
    public void delete(ListOfProductsDTO object) {
        BeanUtils.copyProperties(object, this.listOfProducts);
        listOfProductsRepository.delete(listOfProducts);
    }

    @Override
    public void deleteById(Long id) {
        listOfProductsRepository.deleteById(id);
    }
}
