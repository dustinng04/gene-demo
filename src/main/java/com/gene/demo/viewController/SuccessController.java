package com.gene.demo.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {
    @GetMapping("/success")
    public String successInfo() {
        return "success";
    }
}
