package hmr.med.controller.api;

import com.google.gson.Gson;
import hmr.med.entity.Medicine;
import hmr.med.entity.Pharmacy;
import hmr.med.entity.Stock;
import hmr.med.service.MedicineService;
import hmr.med.service.PharmacyService;
import hmr.med.service.StockService;
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
@RequestMapping("/api/stock")
public class StockController {

    StockService stockService;

    @Autowired
    MedicineService medicineService;
    @Autowired
    PharmacyService pharmacyService;
    Gson gson;

    public StockController(StockService stockService) {
        this.stockService = stockService;
        gson = new Gson();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam MultiValueMap<String, String> data){
        String id = data.getFirst("id");
        Stock pharmacy;

        if (id != null) {
            pharmacy = stockService.get(Integer.parseInt(id));
        }else {
            return "";
        }

        return gson.toJson(new hmr.med.json.Stock(pharmacy));

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(@RequestParam(value = "medicine", defaultValue = "0") int medicine,
                         @RequestParam(value = "pharmacy", defaultValue = "0") int pharmacy){
        List<Stock> stocks = null;

        if (medicine != 0){
            Medicine m = medicineService.get(medicine);
            if (m != null) stocks = stockService.getAll(m);
        }

        if (pharmacy != 0){
            Pharmacy m = pharmacyService.get(pharmacy);
            if (m != null) stocks = stockService.getAll(m);
        }

        if (stocks == null) stocks = stockService.getAll();


        List<hmr.med.json.Stock> r = new ArrayList<>();
        for (Stock stock : stocks) {
            r.add(new hmr.med.json.Stock(stock));
        }
        return gson.toJson(r);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String find(@RequestParam MultiValueMap<String, String> data){
        List<Stock> stocks;

        String medicine = data.getFirst("medicine");
        String pharmacy = data.getFirst("pharmacy");
        String latitude = data.getFirst("latitude");
        String longitude = data.getFirst("longitude");
        String city = data.getFirst("city");
        String district = data.getFirst("district");

        stocks = stockService.find(medicineService.getEnglish(medicine), pharmacyService.get(pharmacy),
                latitude != null ? Double.parseDouble(latitude) : null,
                longitude != null ? Double.parseDouble(longitude) : null,
                city,
                district
        );

        if (stocks == null) stocks = stockService.getAll();


        List<hmr.med.json.Stock> r = new ArrayList<>();
        for (Stock stock : stocks) {
            r.add(new hmr.med.json.Stock(stock));
        }
        return gson.toJson(r);
    }


    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@RequestParam(name = "id") int id){
        Stock medicine = stockService.get(id);
        return gson.toJson(stockService.remove(medicine));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PATCH)
    @ResponseBody
    public String update(@RequestParam(name = "id") int id, @RequestParam MultiValueMap<String, String> data){
        Stock stock = stockService.get(id);

        String price = data.getFirst("price");
        String quantity = data.getFirst("quantity");


        if (price != null) stock.setPrice(Double.parseDouble(price));
        if (quantity != null) stock.setQuantity(Integer.parseInt(quantity));


        return gson.toJson(stockService.update(stock));
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.PUT)
    @ResponseBody
    public String create(@RequestParam MultiValueMap<String, String> data){

        String price = data.getFirst("price");
        String quantity = data.getFirst("quantity");
        String medicine = data.getFirst("medicine");
        String pharmacy = data.getFirst("pharmacy");

        return gson.toJson(stockService.create(medicineService.get(Integer.parseInt(medicine)), pharmacyService.get(Integer.parseInt(pharmacy)), Double.parseDouble(price), Integer.parseInt(quantity)));
    }


}
