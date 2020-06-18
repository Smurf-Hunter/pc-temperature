package com.smurf.temperaturedekhlofraands.controller;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.smurf.temperaturedekhlofraands.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public ModelAndView help(){
        Components components = JSensors.get.components();
        return mainService.main(components);
    }

    @GetMapping("/cpu")
    public ModelAndView cpu(){
        Components components = JSensors.get.components();
        return mainService.cpu(components);
    }

    @GetMapping("/gpu")
    public ModelAndView gpu(){
        Components components = JSensors.get.components();
        return mainService.gpu(components);
    }

    @GetMapping("/exit")
    public void exit(){
        System.exit(0);
    }

}
