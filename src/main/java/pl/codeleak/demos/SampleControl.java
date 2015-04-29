package pl.codeleak.demos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController {

    @RequestMapping("/")
    public  String index (){
        return  "index" ;
    }
}