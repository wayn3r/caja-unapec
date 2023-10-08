package com.unapec.cajaunapec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", ""})
public class HomeController {

    @GetMapping({"/", ""})
    public String mostrarIndex() {
       return "index";
    }


}
