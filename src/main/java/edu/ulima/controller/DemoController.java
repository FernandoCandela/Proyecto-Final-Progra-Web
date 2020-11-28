
package edu.ulima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping(value = "/admin/gestionAlum")
    public String home() {
        return "adminGestCargAlum";
    }
}
