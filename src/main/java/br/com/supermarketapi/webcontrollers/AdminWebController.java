package br.com.supermarketapi.webcontrollers;

import br.com.supermarketapi.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/admin")
@Controller
public class AdminWebController {
    private ProductService productService;
    public AdminWebController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"", "/", "/index.html"})
    public String getIndex(){
        String message = "admin/index.html";
        return message;
    }

    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "admin/listProducts";
    }

    @RequestMapping("/product/{id}")
    public String listProductById(Model model, @PathVariable("id")Long id){
        model.addAttribute("products", productService.findById(id));
        return "admin/listProducts";
    }
}
