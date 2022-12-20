package br.com.supermarketapi.webcontrollers;

import br.com.supermarketapi.dtos.ListOfProductDTO;
import br.com.supermarketapi.services.ListOfProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/client")
@Controller
public class ClientWebController {
    private final ListOfProductsService listOfProductsService;

    public ClientWebController(ListOfProductsService listOfProductsService) {
        this.listOfProductsService = listOfProductsService;
    }
    @RequestMapping({"","/","index","/index.html"})
    public String getIndex(){
        return "client/index.html";
    }
//    @RequestMapping("/shoplists")
//    public String listShoplist(Model model){
//        model.addAttribute("shoplists", listOfProductsService.findAll());
//        model.addAttribute("products", listOfProductsService.findAll()
//                .stream()
//                .map(ListOfProductDTO::getShoplist));
//        return "client/shoplist";
//    }
}
