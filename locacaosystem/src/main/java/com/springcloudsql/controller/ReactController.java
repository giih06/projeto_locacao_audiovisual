package com.springcloudsql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactController {
    @GetMapping("/")
    public String index() {
        return "index"; // Isso corresponde ao nome do arquivo HTML da sua página React
    }
}
