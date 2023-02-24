package hmr.med.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    public Home() {

    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getHome(){
        return "index.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getAdmin(){
        return "admin/index.jsp";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getLogin(){
        return "admin/login.jsp";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String getTest(){
        return "homepage.jsp";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String getSearch(){
        return "search.jsp";
    }




}
