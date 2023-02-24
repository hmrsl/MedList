package hmr.med.dao;

import hmr.med.entity.Medicine;
import hmr.med.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineDaoImpl implements  MedicineDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Medicine get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Medicine.class, id);
    }

    @Override
    public Medicine getEnglish(String english_name) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query<Medicine> query = session.createQuery("FROM Medicine WHERE englishName=:e", Medicine.class);
            query.setParameter("e", english_name);
            return query.getResultList().get(0);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public Medicine getSinhala(String sinhala_name) {
        return null;
    }

    @Override
    public List<Medicine> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Medicine> query = session.createQuery("FROM Medicine", Medicine.class);
        return query.getResultList();

    }

    @Override
    public boolean remove(Medicine medicine) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.remove(medicine);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean update(Medicine medicine) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(medicine);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean create(String english_name, String sinhala_name) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.saveOrUpdate(new Medicine(english_name, sinhala_name));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
