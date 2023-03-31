public class Suc {
    private String sucAdi;
    private String kanunNo;
    private String sucYeri;
    private String sucTarihi;

    public Suc() {
    }

    public Suc(String sucAdi, String kanunNo, String sucYeri, String sucTarihi) {
        this.sucAdi = sucAdi;
        this.kanunNo = kanunNo;
        this.sucYeri = sucYeri;
        this.sucTarihi = sucTarihi;
    }

    public String getSucAdi() {
        return sucAdi;
    }

    public void setSucAdi(String sucAdi) {
        this.sucAdi = sucAdi;
    }

    public String getKanunNo() {
        return kanunNo;
    }

    public void setKanunNo(String kanunNo) {
        this.kanunNo = kanunNo;
    }

    public String getSucYeri() {
        return sucYeri;
    }

    public void setSucYeri(String sucYeri) {
        this.sucYeri = sucYeri;
    }

    public String getSucTarihi() {
        return sucTarihi;
    }

    public void setSucTarihi(String sucTarihi) {
        this.sucTarihi = sucTarihi;
    }

    @Override
    public String toString() {
        return "suc='" + sucAdi + '\'' +
                ", kanunNo='" + kanunNo + '\'' +
                ", sucYeri='" + sucYeri + '\'' +
                ", sucTarihi='" + sucTarihi; }

}
