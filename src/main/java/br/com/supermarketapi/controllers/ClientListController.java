package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.input.ClientListDTO;
import br.com.supermarketapi.dtos.output.ClientListWithOrderID;
import br.com.supermarketapi.services.ClientListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientLists")
public class ClientListController extends AbsController<ClientListDTO, ClientListWithOrderID> {
    private ClientListService clientListService;

    public ClientListController(ClientListService clientListService) {
        this.clientListService = clientListService;
    }
    @Override
    public ResponseEntity<List<ClientListWithOrderID>> findAll(){
        return new ResponseEntity(clientListService.findAll(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ClientListWithOrderID> findById(@PathVariable("id")Long id){
        return new ResponseEntity(clientListService.findById(id),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ClientListDTO> save(@RequestBody ClientListDTO object){
        return new ResponseEntity(clientListService.save(object), HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<ClientListDTO> update(@RequestBody ClientListDTO object){
        return new ResponseEntity(clientListService.update(object),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity delete(@RequestBody ClientListDTO object){
        clientListService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Override
    public ResponseEntity deleteById(@PathVariable("id")Long id){
        this.clientListService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
