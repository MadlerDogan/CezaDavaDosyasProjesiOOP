import java.util.ArrayList;
import java.util.List;

public class Dosya {


    private List <Musteki> musteki = new ArrayList<>();
    private List <Sanik> sanik = new ArrayList<>();
    private List <Tanik>    tanik = new ArrayList<>();
    private List <Suc>    suc = new ArrayList<>();


    public Dosya(List<Musteki> musteki, List<Sanik> sanik, List<Tanik> tanik,List <Suc>    suc) {

        this.musteki = musteki;
        this.sanik = sanik;
        this.tanik = tanik;
        this.suc = suc;
    }


    public Dosya() {
    }



    public List<Musteki> getMusteki() {
        return musteki;
    }

    public void setMusteki(List<Musteki> musteki) {
        this.musteki = musteki;
    }

    public List<Sanik> getSanik() {
        return sanik;
    }

    public void setSanik(List<Sanik> sanik) {
        this.sanik = sanik;
    }

    public List<Tanik> getTanik() {
        return tanik;
    }

    public void setTanik(List<Tanik> tanik) {
        this.tanik = tanik;
    }

    public List<Suc> getSuc() {
        return suc;
    }
    public void setSuc(List<Suc> suc) {
        this.suc = suc;
    }

    @Override
    public String toString() {
        return "Dosya{" +
                "musteki=" + musteki +
                ", sanik=" + sanik +
                ", tanik=" + tanik +
                ", suc=" + suc +
                '}';
    }
}

