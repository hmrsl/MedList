package hmr.med.dao;

import hmr.med.entity.Medicine;
import hmr.med.entity.Pharmacy;
import hmr.med.entity.Stock;
import hmr.med.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockDaoImpl implements StockDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Stock get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Stock.class, id);
    }

    @Override
    public List<Stock> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Stock> query = session.createQuery("FROM Stock ", Stock.class);
        return query.getResultList();

    }

    @Override
    public List<Stock> getAll(Pharmacy pharmacy) {
        Session session = sessionFactory.getCurrentSession();
        Query<Stock> query = session.createQuery("FROM Stock WHERE pharmacy=:id", Stock.class);
        query.setParameter("id", pharmacy.getId());

        return query.getResultList();

    }

    @Override
    public List<Stock> getAll(Medicine medicine) {
        Session session = sessionFactory.getCurrentSession();
        Query<Stock> query = session.createQuery("FROM Stock WHERE medicine=:id", Stock.class);
        query.setParameter("id", medicine.getId());

        return query.getResultList();

    }

    @Override
    public boolean remove(Stock stock) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.remove(stock);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Stock stock) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(stock);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean create(Medicine medicine, Pharmacy pharmacy, double price, int quantity) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Stock stock = new Stock(medicine.getId(), pharmacy.getId(), quantity, price);
            session.saveOrUpdate(stock);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<Stock> find(Medicine medicine, Pharmacy pharmacy, Double latitude, Double longitude, String city, String district) {

        Session session = sessionFactory.getCurrentSession();

        Query<Stock> stocks = session.createQuery("FROM Stock stock WHERE stock.medicine=:m " +
                (pharmacy != null? "AND stock.pharmacy=:p ": " ") +
                (city != null? "AND stock.pharmacyByPharmacy.city=:c ": " ")+
                (district != null? "AND stock.pharmacyByPharmacy.district=:d ": " ")+
                (latitude != null && longitude != null? " ORDER BY sqrt(" +
                        "abs(stock.pharmacyByPharmacy.latitude - :lat)*abs(stock.pharmacyByPharmacy.latitude - :lat) + abs(stock.pharmacyByPharmacy.longitude - :lon)*abs(stock.pharmacyByPharmacy.longitude - :lon)" +
                        ")": " ")
                , Stock.class);

        stocks.setParameter("m", medicine.getId());
        if (pharmacy != null) stocks.setParameter("p", pharmacy.getId());
        if (city != null) stocks.setParameter("c", city);
        if (district != null) stocks.setParameter("d", city);
        if (latitude != null && longitude != null) {
            stocks.setParameter("lat", latitude);
            stocks.setParameter("lon", longitude);
        }

        List<Stock> results = stocks.getResultList();
        if (results.size() == 0) {
            return getAll();
        }

        return results;
    }
}
