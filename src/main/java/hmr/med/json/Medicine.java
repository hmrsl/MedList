package hmr.med.json;

public class Medicine {
    private int id;
    private String englishName;
    private String sinhalaName;

    public Medicine() {
    }

    public Medicine(hmr.med.entity.Medicine medicine) {
        this.id = medicine.getId();
        this.englishName = medicine.getEnglishName();
        this.sinhalaName = medicine.getSinhalaName();
    }

    public Medicine(String englishName, String sinhalaName) {
        this.englishName = englishName;
        this.sinhalaName = sinhalaName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getSinhalaName() {
        return sinhalaName;
    }

    public void setSinhalaName(String sinhalaName) {
        this.sinhalaName = sinhalaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (englishName != null ? !englishName.equals(medicine.englishName) : medicine.englishName != null)
            return false;
        if (sinhalaName != null ? !sinhalaName.equals(medicine.sinhalaName) : medicine.sinhalaName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (englishName != null ? englishName.hashCode() : 0);
        result = 31 * result + (sinhalaName != null ? sinhalaName.hashCode() : 0);
        return result;
    }


}
