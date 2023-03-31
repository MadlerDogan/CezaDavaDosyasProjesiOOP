import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class DosyaIslemler  {
    Dosya dosya;

    TanikIslemler tanikIslemler = new TanikIslemler();
    SanikIslemler sanikIslemler = new SanikIslemler();
    MustekiIslemler mustekiIslemler = new MustekiIslemler();
    SucIslemler sucIslemler = new SucIslemler();


    List<Musteki> mustekiList = new ArrayList<>();
    List<Sanik> sanikList = new ArrayList<>();
    List<Tanik> tanikList = new ArrayList<>();
    List<Dosya> dosyaList = new ArrayList<>();

    public static TreeMap<String, List<Dosya>> dosyaMap = new TreeMap<>();
    Scanner input = new Scanner(System.in);

    public void dosyaOlusturma(){
        Dosya dosya = new Dosya();
        System.out.println("Dosya numarasını giriniz");
        String dosyaNo = input.next();
        dosyaMap.get(dosyaNo);
        if(dosyaMap.containsKey(dosyaNo)){
            System.out.println("Bu dosya numarası zaten kullanılıyor. Lütfen başka bir numara giriniz");

        }else {

            List<Musteki> mustekiList1 = new ArrayList<>();
            List<Sanik> sanikList1 = new ArrayList<>();
            List<Tanik> tanikList1 = new ArrayList<>();
            List<Suc> sucList1 = new ArrayList<>();

            List<Dosya> dosyaList1 = new ArrayList<>();

            mustekiList1.add(mustekiIslemler.mustekiOlusturma());
            sanikList1.add(sanikIslemler.sanikOlusturma());
            tanikList1.add(tanikIslemler.tanikOlusturma());
            sucList1.add(sucIslemler.sucOlusturma());

            dosya.setMusteki(mustekiList1);
            dosya.setSanik(sanikList1);
            dosya.setTanik(tanikList1);
            dosya.setSuc(sucList1);
            dosyaList1.add(dosya);

            dosyaMap.put(dosyaNo, dosyaList1);
        }

    }


    public void taraflariYazdir( ) {
        System.out.println("Lütfen dosya numarasını giriniz");
        String dosyaNum = input.next();
        List<Dosya> dosyaList = dosyaMap.get(dosyaNum);
         if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            System.out.println("Dosya numarasi : "+ dosyaNum);
            System.out.println("Müştekiler:");
            for (Musteki musteki : dosya.getMusteki()) {
                System.out.println("- " + musteki.getIsim() + " " + musteki.getSoyIsim());
            }
            System.out.println("Sanıklar:");
            for (Sanik sanik : dosya.getSanik()) {
                System.out.println("- " + sanik.getIsim() + " " + sanik.getSoyIsim());
            }
            System.out.println("Tanıklar:");
            for (Tanik tanik : dosya.getTanik()) {
                System.out.println("- " + tanik.getIsim() + " " + tanik.getSoyIsim());
            }
             System.out.println("Suç bilgisi :");
             for (Suc suc : dosya.getSuc()) {
                 System.out.println("- " + suc.getSucAdi()+ " " + suc.getKanunNo());
             }
        } else {
             System.out.println("Aradığınız dosya bulunamadı");
         }
    }


    public void dosyaSil() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList = dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            dosyaMap.remove(dosyaNo);
            System.out.println("Dosya başarıyla silindi.");
        } else {
            System.out.println("Dosya numarası bulunamadı.");
        }
    }



//    public DosyaIslemler() {
//        this.dosya = new Dosya();
//    }

    public void dosyaDepo(){
        Musteki musteki1 = new Musteki("Ali","Can","Kayseri");
        Musteki musteki2 = new Musteki("Veli","Han","Ankara");
        Musteki musteki3 = new Musteki("Salih","Kan","Tokat");
        Sanik sanik1 = new Sanik("Mehmet","Sol","İstanbul");
        Sanik sanik2 = new Sanik("Ahmet","Sağ","Adana");
        Sanik sanik3 = new Sanik("Ayse","İleri","Isparta");
        Tanik tanik1 = new Tanik("Niyazi","Görmez","Bursa");
        Tanik tanik2 = new Tanik("Aydın","Parlak","izmir");
        Tanik tanik3 = new Tanik("Mehmet","Gumus","Gumushane");
        Suc suc1 = new Suc("Yaralama","TCK 86","Ankara","2022-02-05");
        Suc suc2 = new Suc("Hırsızlık","TCK 141","İstanbul","2022-02-07");
        Suc suc3 = new Suc("Tehdit","TCK 106","İzmir","2023-02-05");


        List<Musteki> mustekiList1 = new ArrayList<Musteki>();
        List<Musteki> mustekiList2 = new ArrayList<Musteki>();
        List<Musteki> mustekiList3 = new ArrayList<Musteki>();
        mustekiList1.add(musteki1);
        mustekiList2.add(musteki2);
        mustekiList3.add(musteki3);

        List<Sanik> sanikList1 = new ArrayList<>();
        List<Sanik> sanikList2 = new ArrayList<>();
        List<Sanik> sanikList3 = new ArrayList<>();
        sanikList1.add(sanik1);
        sanikList2.add(sanik2);
        sanikList3.add(sanik3);

        List<Tanik> tanikList1 = new ArrayList<>();
        List<Tanik> tanikList2 = new ArrayList<>();
        List<Tanik> tanikList3 = new ArrayList<>();
        tanikList1.add(tanik1);
        tanikList2.add(tanik2);
        tanikList3.add(tanik3);

        List<Suc> sucList1  = new ArrayList<>();
        List<Suc> sucList2  = new ArrayList<>();
        List<Suc> sucList3  = new ArrayList<>();
        sucList1.add(suc1);
        sucList2.add(suc2);
        sucList3.add(suc3);

        Dosya dosya1 = new Dosya(mustekiList1,sanikList1,tanikList1,sucList1);
        Dosya dosya2 = new Dosya(mustekiList2,sanikList2,tanikList2,sucList2);
        Dosya dosya3 = new Dosya(mustekiList3,sanikList3,tanikList3,sucList3);
        List<Dosya> dosyaList1 = new ArrayList<>();
        List<Dosya> dosyaList2 = new ArrayList<>();
        List<Dosya> dosyaList3 = new ArrayList<>();
        dosyaList1.add(dosya1);
        dosyaList2.add(dosya2);
        dosyaList3.add(dosya3);

        dosyaMap.put("111",dosyaList1);
        dosyaMap.put("222",dosyaList2);
        dosyaMap.put("333",dosyaList3);

    }









}
