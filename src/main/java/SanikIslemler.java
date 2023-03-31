import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanikIslemler implements Methodlar {
    Scanner input = new Scanner(System.in);
    Sanik sanik = new Sanik();


    @Override
    public void ekran() {

        System.out.println("================================================================");
        System.out.println("Sanık islem menusune hosgeldiniz" +
                "\n1-Sanık ekle" +
                "\n2-Sanık ara" +
                "\n3-Sanık sil " +
                "\n0-Ana menu");
        System.out.println("================================================================");
        System.out.println("Tercihiniz...");
        String tercih = input.next();

        switch (tercih) {

            case "1":
                System.out.println("Ekleme");
                tarafEkle();
                break;
            case "2":
                System.out.println("Arama");
                tarafBul();
                break;
            case "3":
                System.out.println("Silme");
                tarafSil();
                break;
            case "0":
                System.out.println("Ana menuye yönlendiriliyorsunuz");
                break;
            default:
                System.out.println("Hatali giris");
        }

    }


    public Sanik sanikOlusturma() {
        input.nextLine();//dummy
        System.out.println("Sanık olusturma ekranı");
        System.out.println("İsim : ");
        sanik.setIsim(input.nextLine());

        System.out.println("Soy isim :");
        sanik.setSoyIsim(input.nextLine());

        System.out.println("Adres :");
        sanik.setAdres(input.nextLine());

        return sanik;

    }


    @Override
    public void tarafBul() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();

        List<Dosya> dosyaList1 = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList1 != null && !dosyaList1.isEmpty()) {
            Dosya dosya = dosyaList1.get(0);
            List<Sanik> sanikList1 = dosya.getSanik();
            System.out.println("Aradığınız sanığın adını giriniz:");
            String arananIsim = input.next();
            boolean sanikBulundu1 = false;
            for (Sanik sanik : sanikList1) {
                if (sanik.getIsim().equals(arananIsim)) {
                    System.out.println("İsim Soyisim: " + sanik.getIsim() + " " + sanik.getSoyIsim());
                    System.out.println("Adres: " + sanik.getAdres());
                    sanikBulundu1 = true;
                    break;
                }
            }
            if (!sanikBulundu1) {
                System.out.println("Aranan sanık bulunamadı.");
            }
        } else {
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
            List<Sanik> sanikList = dosya.getSanik();
            List<Sanik> yeniSanikList = new ArrayList<>(sanikList);

            Sanik yeniSanik = sanikOlusturma();
            yeniSanikList.add(yeniSanik);
            dosya.setSanik(yeniSanikList);

            System.out.println("Yeni müşteki başarıyla eklendi.");
        } else {
            System.out.println("Belirtilen dosya numarasına ait dosya bulunamadı.");
        }
    }

    @Override
    public void tarafSil() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Sanik> sanikList = dosya.getSanik();
            System.out.println("Silinecek sanığın adını giriniz:");
            String silinecekIsim = input.next();
            boolean sanikBulundu = false;
            for (Sanik sanik : sanikList) {
                if (sanik.getIsim().equals(silinecekIsim)) {
                    sanikList.remove(sanik);
                    sanikBulundu = true;
                    System.out.println("Sanik başarıyla silindi.");
                    break;
                }
            }
            if (!sanikBulundu) {
                System.out.println("Sanik bulunamadı.");
            }
        } else {
            System.out.println("Hatalı dosya numarası girişi");
        }
    }

}
