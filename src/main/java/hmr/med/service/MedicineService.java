package hmr.med.service;

import hmr.med.entity.Medicine;

import java.util.List;

public interface MedicineService {

    Medicine get(int id);
    Medicine getEnglish(String english_name);
    Medicine getSinhala(String sinhala_name);
    List<Medicine> getAll();
    boolean remove(Medicine medicine);
    boolean update(Medicine medicine);
    boolean create(String english_name, String sinhala_name);

}
