public class Musteki {

    private String isim;
    private String soyIsim;
    private String adres;

    public Musteki(String isim, String soyIsim, String adres) {
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.adres = adres;
    }

    public Musteki() {
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Musteki{" +
                "isim='" + isim + '\'' +
                ", soyIsim='" + soyIsim + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }


}





