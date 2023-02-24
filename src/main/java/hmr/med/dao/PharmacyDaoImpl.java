package hmr.med.dao;

import hmr.med.entity.Pharmacy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PharmacyDaoImpl implements  PharmacyDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Pharmacy get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pharmacy.class, id);
    }

    @Override
    public Pharmacy get(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Pharmacy> query = session.createQuery("FROM Pharmacy WHERE name=:name", Pharmacy.class);
        query.setParameter("name", name);
        try {
            return query.getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Pharmacy> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Pharmacy> query = session.createQuery("FROM Pharmacy ", Pharmacy.class);
        return query.getResultList();

    }

    @Override
    public boolean remove(Pharmacy pharmacy) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.remove(pharmacy);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean update(Pharmacy pharmacy) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(pharmacy);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean create(String name, double latitude, double longitude, String city, String phone, String email, String district) {
        Pharmacy pharmacy = new Pharmacy(name, latitude, longitude, city, phone, email, district);

        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(pharmacy);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
