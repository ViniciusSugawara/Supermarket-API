package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.ClientListDTO;
import br.com.supermarketapi.models.ClientList;
import br.com.supermarketapi.models.OrderDetails;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.repositories.ClientListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("ListOfProducts")
public class ClientListService implements CrudService<ClientListDTO,Long> {
    private ClientListRepository clientListRepository;
    private ClientList clientList = new ClientList();
    private ModelMapper mapper = new ModelMapper();

    public ClientListService(ClientListRepository clientListRepository) {
        this.clientListRepository = clientListRepository;
    }

    @Override
    public List<ClientListDTO> findAll() {
        List<ClientList> listOfProductsList = clientListRepository.findAll();
        List<ClientListDTO> ClientListDTOList = new ArrayList<>();

        for (ClientList clientList : listOfProductsList ) {
            ClientListDTO clientListDTO = new ClientListDTO();
            BeanUtils.copyProperties(filterList(clientList), clientListDTO);
            ClientListDTOList.add(clientListDTO);
        }
        return ClientListDTOList;
    }

    @Override
    public ClientListDTO findById(Long id) {
        return mapper.map(clientListRepository.findById(id).orElse(null), ClientListDTO.class);
    }

    @Override
    public ClientListDTO save(ClientListDTO object) {
//        for(Product product : object.getProducts()){
//            this.listOfProducts.getProducts().add(product);
//        }
        BeanUtils.copyProperties(object, this.clientList);
        clientListRepository.save(this.clientList);
        return object;
    }

    //By now, will be using this method to update products inside the list, changing their quantities using RequestBody.
    //Should have a dedicated method with respective business logic.
    @Override
    public ClientListDTO update(ClientListDTO object) {
        BeanUtils.copyProperties(object, this.clientList);
        clientListRepository.save(clientList);
        return object;
    }

    @Override
    public void delete(ClientListDTO object) {
        BeanUtils.copyProperties(object, this.clientList);
        clientListRepository.delete(clientList);
    }

    @Override
    public void deleteById(Long id) {
        clientListRepository.deleteById(id);
    }

    private ClientListDTO filterList(ClientList clientList){
        List<Product> filteredProducts = new ArrayList<>();
        ClientListDTO clientListDTO = new ClientListDTO();
        BeanUtils.copyProperties(clientList, clientListDTO);

        for(OrderDetails order : clientList.getOrderDetails()){
            filteredProducts.add(filterListProducts(order.getProduct_order()));
        }
        clientListDTO.setOrderDetails(clientList.getOrderDetails());
        return clientListDTO;
    }
    private Product filterListProducts(Product product){
        Product prototype = new Product();
        BeanUtils.copyProperties(product, prototype , "productList");
        return prototype;
    }
}
