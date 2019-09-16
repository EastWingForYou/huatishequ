package com.shequ.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myController {

    @GetMapping("/")
    public String toPages01(){
        return "index";
    }
}
