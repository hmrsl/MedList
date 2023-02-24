package hmr.med.controller.api;

import com.google.gson.Gson;
import hmr.med.entity.Medicine;
import hmr.med.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/medicine")
public class MedicineController {

    MedicineService medicineService;
    Gson gson;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
        gson = new Gson();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam MultiValueMap<String, String> data){
        String id = data.getFirst("id");
        String name = data.getFirst("name");
        Medicine medicine;

        if (id != null) {
            medicine = medicineService.get(Integer.parseInt(id));
        } else if (name != null) {
            medicine = medicineService.getEnglish(name);
        }else {
            return "";
        }

        return gson.toJson(new hmr.med.json.Medicine(medicine));

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        List<Medicine> all = medicineService.getAll();
        List<hmr.med.json.Medicine> r = new ArrayList<>();
        for (Medicine medicine : all) {
            r.add(new hmr.med.json.Medicine(medicine));
        }
        return gson.toJson(r);
    }


    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@RequestParam(name = "id") int id){
        Medicine medicine = medicineService.get(id);
        return gson.toJson(medicineService.remove(medicine));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PATCH)
    @ResponseBody
    public String update(@RequestParam(name = "id") int id, @RequestParam MultiValueMap<String, String> data){
        Medicine medicine = medicineService.get(id);

        String english_name = data.getFirst("english");
        String sinhala_name = data.getFirst("sinhala");
        if (english_name != null) medicine.setEnglishName(english_name);
        if (sinhala_name != null) medicine.setSinhalaName(sinhala_name);

        return gson.toJson(medicineService.update(medicine));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PUT)
    @ResponseBody
    public String create(@RequestParam MultiValueMap<String, String> data){

        String english_name = data.getFirst("english");
        String sinhala_name = data.getFirst("sinhala");

        return gson.toJson(medicineService.create(english_name, sinhala_name));
    }


}
