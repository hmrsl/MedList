package hmr.med.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "medicine", nullable = false)
    private int medicine;
    @Basic
    @Column(name = "pharmacy", nullable = false)
    private int pharmacy;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicine", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Medicine medicineByMedicine;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pharmacy", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Pharmacy pharmacyByPharmacy;

    public Stock() {
    }

    public Stock(int medicine, int pharmacy, int quantity, double price) {
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(int pharmacy) {
        this.pharmacy = pharmacy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (medicine != stock.medicine) return false;
        if (pharmacy != stock.pharmacy) return false;
        if (quantity != stock.quantity) return false;
        if (Double.compare(stock.price, price) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + medicine;
        result = 31 * result + pharmacy;
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Medicine getMedicineByMedicine() {
        return medicineByMedicine;
    }

    public void setMedicineByMedicine(Medicine medicineByMedicine) {
        this.medicineByMedicine = medicineByMedicine;
    }

    public Pharmacy getPharmacyByPharmacy() {
        return pharmacyByPharmacy;
    }

    public void setPharmacyByPharmacy(Pharmacy pharmacyByPharmacy) {
        this.pharmacyByPharmacy = pharmacyByPharmacy;
    }
}
