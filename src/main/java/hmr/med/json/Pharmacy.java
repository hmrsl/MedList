package hmr.med.json;

import javax.persistence.*;
import java.util.Collection;

public class Pharmacy {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private String city;
    private String phone;
    private String email;
    private String district;

    public Pharmacy(hmr.med.entity.Pharmacy pharmacy) {
        this.id = pharmacy.getId();
        this.name = pharmacy.getName();
        this.latitude = pharmacy.getLatitude();
        this.longitude = pharmacy.getLongitude();
        this.city = pharmacy.getCity();
        this.phone = pharmacy.getPhone();
        this.email = pharmacy.getEmail();
        this.district = pharmacy.getDistrict();
    }

    public Pharmacy() {
    }

    public Pharmacy(String name, double latitude, double longitude, String city, String phone, String email, String district) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pharmacy pharmacy = (Pharmacy) o;

        if (id != pharmacy.id) return false;
        if (Double.compare(pharmacy.latitude, latitude) != 0) return false;
        if (Double.compare(pharmacy.longitude, longitude) != 0) return false;
        if (name != null ? !name.equals(pharmacy.name) : pharmacy.name != null) return false;
        if (city != null ? !city.equals(pharmacy.city) : pharmacy.city != null) return false;
        if (phone != null ? !phone.equals(pharmacy.phone) : pharmacy.phone != null) return false;
        if (email != null ? !email.equals(pharmacy.email) : pharmacy.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
