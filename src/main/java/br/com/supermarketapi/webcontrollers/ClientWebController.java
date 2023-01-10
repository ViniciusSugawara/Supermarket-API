package br.com.supermarketapi.webcontrollers;

import br.com.supermarketapi.services.ClientListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/client")
@Controller
public class ClientWebController {
    private final ClientListService clientListService;

    public ClientWebController(ClientListService clientListService) {
        this.clientListService = clientListService;
    }
    @RequestMapping({"","/","index","/index.html"})
    public String getIndex(){
        return "client/index.html";
    }

}
