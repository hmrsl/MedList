package hmr.med.service;

import hmr.med.entity.Medicine;
import hmr.med.entity.Pharmacy;
import hmr.med.entity.Stock;

import java.util.List;

public interface StockService {

    Stock get(int id);
    List<Stock> getAll();
    List<Stock> getAll(Pharmacy pharmacy);
    List<Stock> getAll(Medicine medicine);
    boolean remove(Stock stock);
    boolean update(Stock stock);
    boolean create(Medicine medicine, Pharmacy pharmacy, double price, int quantity);

    List<Stock> find(Medicine english, Pharmacy pharmacy,
                     Double latitude, Double longitude,
                     String city, String district);
}
