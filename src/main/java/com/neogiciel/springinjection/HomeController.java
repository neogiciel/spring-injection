package com.neogiciel.springinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neogiciel.springinjection.normal.A;
import com.neogiciel.springinjection.util.Trace;



@RestController
public class HomeController {
    
    /*Classe A */
    @Autowired
    A a;

    @GetMapping
    @RequestMapping("/")
    public String home() {
        Trace.info("[HomeController] appel /");
        return "index";
    }

    @GetMapping
    @RequestMapping("/test")
    public String test() {
        Trace.info("[HomeController] appel /test");
        String display = a.get();
        return "test = "+display;
        
    }


}


