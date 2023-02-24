package hmr.med.service;

import hmr.med.dao.MedicineDao;
import hmr.med.dao.StockDao;
import hmr.med.entity.Medicine;
import hmr.med.entity.Pharmacy;
import hmr.med.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockDao stockDao;


    @Override    @Transactional
    public Stock get(int id) {
        return stockDao.get(id);
    }

    @Override    @Transactional
    public List<Stock> getAll() {
        return stockDao.getAll();
    }

    @Override    @Transactional
    public List<Stock> getAll(Pharmacy pharmacy) {
        return stockDao.getAll(pharmacy);
    }

    @Override    @Transactional
    public List<Stock> getAll(Medicine medicine) {
        return stockDao.getAll(medicine);
    }

    @Override    @Transactional
    public boolean remove(Stock stock) {
        return stockDao.remove(stock);
    }

    @Override    @Transactional
    public boolean update(Stock stock) {
        return stockDao.update(stock);
    }

    @Override    @Transactional
    public boolean create(Medicine medicine, Pharmacy pharmacy, double price, int quantity) {
        return stockDao.create(medicine, pharmacy, price, quantity);
    }

    @Override @Transactional
    public List<Stock> find(Medicine medicine, Pharmacy pharmacy, Double latitude, Double longitude, String city, String district) {
        return stockDao.find(medicine, pharmacy,
                latitude, longitude,
                city, district
        );
    }
}
