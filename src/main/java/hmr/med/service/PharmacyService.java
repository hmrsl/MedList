package hmr.med.service;

import hmr.med.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {

    Pharmacy get(int id);
    Pharmacy get(String name);
    List<Pharmacy> getAll();
    boolean remove(Pharmacy pharmacy);
    boolean update(Pharmacy pharmacy);

    boolean create(String name, double latitude, double longitude, String city, String phone, String email, String district);
}
