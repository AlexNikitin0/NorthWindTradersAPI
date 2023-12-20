package com.pluralsight.NorthWindTradersAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    //respond to local host:8080
    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(
            @RequestParam(required = false, defaultValue = "World") String country
    ){
        return "Hello " + country + "!";
    }

}
