package hmr.med.controller.api;

import com.google.gson.Gson;
import hmr.med.entity.User;
import hmr.med.service.UserService;
import hmr.med.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    UserService userService;
    Gson gson;

    public UserController(UserService userService) {
        this.userService = userService;
        gson = new Gson();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam MultiValueMap<String, String> data){
        String id = data.getFirst("id");
        String name = data.getFirst("name");
        User user;

        if (id != null) {
            user = userService.get(Integer.parseInt(id));
        } else if (name != null) {
            user = userService.get(name);
        }else {
            return "";
        }

        return gson.toJson(new hmr.med.json.User(user));

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        List<User> all = userService.getAll();
        List<hmr.med.json.User> r = new ArrayList<>();
        for (User user : all) {
            r.add(new hmr.med.json.User(user));
        }
        return gson.toJson(r);
    }


    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@RequestParam(name = "id") int id){
        User user = userService.get(id);
        return gson.toJson(userService.remove(user));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PATCH)
    @ResponseBody
    public String update(@RequestParam(name = "id") int id, @RequestParam MultiValueMap<String, String> data){
        User user = userService.get(id);

        String name = data.getFirst("username");
        String password = data.getFirst("password");
        String type = data.getFirst("type");

        if (name != null) user.setUsername(name);
        if (password != null) user.setPassword(password);
        if (type != null) user.setType(type);

        return gson.toJson(userService.update(user));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PUT)
    @ResponseBody
    public String create(@RequestParam MultiValueMap<String, String> data){

        String name = data.getFirst("username");
        String password = data.getFirst("password");
        String type = data.getFirst("type");

        return gson.toJson(userService.create(name, password, type));
    }


}
