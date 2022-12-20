package br.com.supermarketapi.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"","/", "/index.html","index"})
    public String getIndex(){ return "index.html"; }
}
