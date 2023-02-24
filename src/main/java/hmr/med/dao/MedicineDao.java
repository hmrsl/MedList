package hmr.med.dao;

import hmr.med.entity.Medicine;
import hmr.med.entity.Pharmacy;

import java.util.List;

public interface MedicineDao {

    Medicine get(int id);
    Medicine getEnglish(String english_name);
    Medicine getSinhala(String sinhala_name);
    List<Medicine> getAll();
    boolean remove(Medicine medicine);
    boolean update(Medicine medicine);
    boolean create(String english_name, String sinhala_name);

}
