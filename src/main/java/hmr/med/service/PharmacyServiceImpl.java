package hmr.med.service;

import hmr.med.dao.MedicineDao;
import hmr.med.dao.PharmacyDao;
import hmr.med.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService{

    @Autowired
    PharmacyDao pharmacyDao;


    @Override    @Transactional
    public Pharmacy get(int id) {
        return pharmacyDao.get(id);
    }

    @Override    @Transactional
    public Pharmacy get(String name) {
        return pharmacyDao.get(name);
    }

    @Override    @Transactional
    public List<Pharmacy> getAll() {
        return pharmacyDao.getAll();
    }

    @Override    @Transactional
    public boolean remove(Pharmacy pharmacy) {
        return pharmacyDao.remove(pharmacy);
    }

    @Override    @Transactional
    public boolean update(Pharmacy pharmacy) {
        return pharmacyDao.update(pharmacy);
    }

    @Override    @Transactional
    public boolean create(String name, double latitude, double longitude, String city, String phone, String email, String district) {
        return pharmacyDao.create(name, latitude, longitude, city, phone, email, district);
    }
}
