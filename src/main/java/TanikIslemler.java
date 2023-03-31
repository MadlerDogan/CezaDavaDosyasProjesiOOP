import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TanikIslemler implements Methodlar {


    Scanner input = new Scanner(System.in);
     Tanik tanik = new Tanik();



    @Override
    public void ekran() {

        System.out.println("================================================================");
        System.out.println("Tanık islem menusune hosgeldiniz" +
                "\n1-Tanik ekle" +
                "\n2-Tanik ara" +
                "\n3-Tanik sil " +
                "\n0-Ana menu");
        System.out.println("================================================================");
        System.out.println("Tercihiniz...");
        String tercih = input.next();

        switch (tercih) {

            case "1":
                System.out.println("Dosyaya yeni tanik ekleme ekranı");
                tarafEkle();
                break;
            case "2":
                System.out.println("Tanik arama ekranı");
                tarafBul();

                break;
            case "3":
                tarafSil();
                break;

            case "0":
                System.out.println("Ana menuye yönlendiriliyorsunuz");
                break;
            default:
                System.out.println("Hatali giris");
        }

    }

    public Tanik tanikOlusturma() {
        input.nextLine();//dummy
        System.out.println("Tanık olusturma ekranı");

        System.out.println("İsim : ");
        tanik.setIsim(input.nextLine());

        System.out.println("Soy isim :");
        tanik.setSoyIsim(input.nextLine());

        System.out.println("Adres :");
        tanik.setAdres(input.nextLine());


        return tanik  ;


    }
    @Override
    public void tarafBul() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList1 = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList1 != null && !dosyaList1.isEmpty()) {
            Dosya dosya = dosyaList1.get(0);
            List<Tanik> tanikList1 = dosya.getTanik();
            System.out.println("Aradığınız tanığın adını giriniz:");
            String arananIsim = input.next();
            boolean tanikBulundu1 = false;
            for (Tanik tanik : tanikList1) {
                if (tanik.getIsim().equals(arananIsim)) {
                    System.out.println("İsim Soyisim: " + tanik.getIsim() + " " + tanik.getSoyIsim());
                    System.out.println("Adres: " + tanik.getAdres());
                    tanikBulundu1 = true;
                    break;
                }
            }
            if (!tanikBulundu1) {
                System.out.println("Tanik bulunamadı.");
            }
        }else {
            System.out.println("Hatalı dosya numarası girişi");

        }

    }


    @Override
    public void tarafEkle() {
        System.out.println("Dosya numarasını giriniz");
        String dosyaNo = input.next();

        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Tanik> tanikList = dosya.getTanik();
            List<Tanik> yeniTanikList = new ArrayList<>(tanikList);

            Tanik yeniTanik = tanikOlusturma();
            yeniTanikList.add(yeniTanik);
            dosya.setTanik(yeniTanikList);

            System.out.println("Yeni tanik başarıyla eklendi.");
        } else {
            System.out.println("Hatalı dosya numarası girişi.");
        }
    }

    @Override
    public void tarafSil() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Tanik> tanikList = dosya.getTanik();
            System.out.println("Silinecek tanığın adını giriniz:");
            String silinecekIsim = input.next();
            boolean tanikBulundu = false;

            for (Tanik tanik : tanikList) {
                if (tanik.getIsim().equals(silinecekIsim)) {
                    tanikList.remove(tanik);
                    tanikBulundu = true;
                    System.out.println("Tanik başarıyla silindi.");
                    break;
                }
            }
            if (!tanikBulundu) {
                System.out.println("Tanik bulunamadı.");
            }
        } else {
            System.out.println("Hatalı dosya numarası girişi");
        }
    }

}
