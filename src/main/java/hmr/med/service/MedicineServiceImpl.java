package hmr.med.service;

import hmr.med.dao.MedicineDao;
import hmr.med.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    MedicineDao medicineDao;


    @Override
    @Transactional
    public Medicine get(int id) {
        return medicineDao.get(id);
    }

    @Override    @Transactional
    public Medicine getEnglish(String english_name) {
        return medicineDao.getEnglish(english_name);
    }

    @Override    @Transactional
    public Medicine getSinhala(String sinhala_name) {
        return medicineDao.getSinhala(sinhala_name);
    }

    @Override    @Transactional
    public List<Medicine> getAll() {
        return medicineDao.getAll();
    }

    @Override    @Transactional
    public boolean remove(Medicine medicine) {
        return medicineDao.remove(medicine);
    }

    @Override    @Transactional
    public boolean update(Medicine medicine) {
        return medicineDao.update(medicine);
    }

    @Override    @Transactional
    public boolean create(String english_name, String sinhala_name) {
        return medicineDao.create(english_name, sinhala_name);
    }
}
