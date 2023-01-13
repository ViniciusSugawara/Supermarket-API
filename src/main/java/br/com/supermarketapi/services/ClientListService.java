package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.input.ClientListDTO;
import br.com.supermarketapi.dtos.output.ClientListWithOrderID;
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
public class ClientListService implements CrudService<ClientListDTO, ClientListWithOrderID, Long> {
    private ClientListRepository clientListRepository;
    private ModelMapper mapper = new ModelMapper();

    public ClientListService(ClientListRepository clientListRepository) {
        this.clientListRepository = clientListRepository;
    }

    @Override
    public List<ClientListWithOrderID> findAll() {
        List<ClientList> allClientLists = clientListRepository.findAll();
        List<ClientListWithOrderID> allClientListWithOrderId = new ArrayList<>();

        for(ClientList clientList : allClientLists){
            ClientListWithOrderID target = mapper.map(clientList, ClientListWithOrderID.class);
            clientList.getOrderDetails()
                      .stream()
                      .forEach((order) -> target
                                          .getOrderDetails_id()
                                          .add(order.getId())
                      );
            allClientListWithOrderId.add(target);
        }
        return allClientListWithOrderId;
    }

    @Override
    public ClientListWithOrderID findById(Long id) {
        ClientList clientList = clientListRepository.findById(id).orElse(null);
        ClientListWithOrderID clientListWithOrderID = mapper.map(clientList, ClientListWithOrderID.class);

        for(OrderDetails order : clientList.getOrderDetails()){
            clientListWithOrderID.getOrderDetails_id().add(order.getId());
        }

        return clientListWithOrderID;
        //return mapper.map(clientListRepository.findById(id).orElse(null), ClientListDTO.class);
    }

    @Override
    public ClientListDTO save(ClientListDTO object) {
        clientListRepository.save(mapper.map(object, ClientList.class));
        return object;
    }


    @Override
    public ClientListDTO update(ClientListDTO object) {
        clientListRepository.save(mapper.map(object, ClientList.class));
        return object;
    }

    @Override
    public void delete(ClientListDTO object) {
        clientListRepository.delete(mapper.map(object, ClientList.class));
    }

    @Override
    public void deleteById(Long id) {
        clientListRepository.deleteById(id);
    }
}
