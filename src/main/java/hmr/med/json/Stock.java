package hmr.med.json;

import javax.persistence.*;

public class Stock {
    private int id;
    private Medicine medicine;
    private Pharmacy pharmacy;
    private int quantity;
    private double price;


    public Stock(hmr.med.entity.Stock stock) {
        this.id = stock.getId();
        this.medicine = new Medicine(stock.getMedicineByMedicine());
        this.pharmacy = new Pharmacy(stock.getPharmacyByPharmacy());
        this.quantity = stock.getQuantity();
        this.price = stock.getPrice();
    }

    public Stock() {
    }

    public Stock(Medicine medicine, Pharmacy pharmacy, int quantity, double price) {
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
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
        result = 31 * result + medicine.hashCode();
        result = 31 * result + pharmacy.hashCode();
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
