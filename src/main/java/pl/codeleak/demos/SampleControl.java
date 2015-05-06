package pl.codeleak.demos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
class HomeController {

    @Value("${application.message:Hello Word}")
    private String message = "a";

    @RequestMapping("/test")
    public  String test (Map<String, Object> model){
        model.put("user", "user2");
        model.put("message", this.message);

        List list =  new ArrayList();
        list.add(new Product("name1", 23423));
        list.add(new Product("name2", 3423443));
        list.add(new Product("name2", 343));
        list.add(new Product("name2", 3));
        list.add(new Product("name2", 34342));


        model.put("product",new Product("name3",234234.34f));
        model.put("animals",list) ;


        Map  m =  new HashMap() ;
        m.put("1","1") ;
        m.put("2","2") ;

        m.put("3","3") ;

        m.put("4","4") ;

        model.put("map",m) ;
        return  "test" ;
    }

    @RequestMapping("/")
    public  String index (Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", this.message);
        return  "index" ;
    }

    @RequestMapping("/base")
    public  String base (Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", this.message);
        return  "base" ;
    }

    @RequestMapping("/child")
    public  String child (Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", this.message);
        return  "child" ;
    }
}



