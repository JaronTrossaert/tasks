package be.ucll.ip.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/403", method = { RequestMethod.GET, RequestMethod.POST })
    public String get403() {
        return "403";
    }
}
