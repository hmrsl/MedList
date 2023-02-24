package hmr.med.controller.api;

import com.google.gson.Gson;
import hmr.med.entity.Pharmacy;
import hmr.med.entity.Pharmacy;
import hmr.med.service.PharmacyService;
import hmr.med.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/pharmacy")
public class PharmacyController {

    PharmacyService pharmacyService;
    Gson gson;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
        gson = new Gson();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam MultiValueMap<String, String> data){
        String id = data.getFirst("id");
        String name = data.getFirst("name");
        Pharmacy pharmacy;

        if (id != null) {
            pharmacy = pharmacyService.get(Integer.parseInt(id));
        } else if (name != null) {
            pharmacy = pharmacyService.get(name);
        }else {
            return "";
        }

        return gson.toJson(new hmr.med.json.Pharmacy(pharmacy));

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        List<Pharmacy> all = pharmacyService.getAll();
        List<hmr.med.json.Pharmacy> r = new ArrayList<>();
        for (Pharmacy medicine : all) {
            r.add(new hmr.med.json.Pharmacy(medicine));
        }
        return gson.toJson(r);
    }


    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@RequestParam(name = "id") int id){
        Pharmacy medicine = pharmacyService.get(id);
        return gson.toJson(pharmacyService.remove(medicine));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PATCH)
    @ResponseBody
    public String update(@RequestParam(name = "id") int id, @RequestParam MultiValueMap<String, String> data){
        Pharmacy pharmacy = pharmacyService.get(id);

        String name = data.getFirst("name");
        String latitude = data.getFirst("latitude");
        String longitude = data.getFirst("longitude");
        String city = data.getFirst("city");
        String phone = data.getFirst("phone");
        String email = data.getFirst("email");
        String district = data.getFirst("district");

        if (name != null) pharmacy.setName(name);
        if (latitude != null) pharmacy.setLatitude(Double.parseDouble(latitude));
        if (longitude != null) pharmacy.setLongitude(Double.parseDouble(longitude));
        if (city != null) pharmacy.setCity(city);
        if (phone != null) pharmacy.setPhone(phone);
        if (email != null) pharmacy.setEmail(email);
        if (district != null) pharmacy.setDistrict(district);


        return gson.toJson(pharmacyService.update(pharmacy));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PUT)
    @ResponseBody
    public String create(@RequestParam MultiValueMap<String, String> data){

        String name = data.getFirst("name");
        String latitude = data.getFirst("latitude");
        String longitude = data.getFirst("longitude");
        String city = data.getFirst("city");
        String phone = data.getFirst("phone");
        String email = data.getFirst("email");
        String district = data.getFirst("district");


        return gson.toJson(pharmacyService.create(name, Double.parseDouble(latitude), Double.parseDouble(longitude),city, phone, email, district));
    }


}
