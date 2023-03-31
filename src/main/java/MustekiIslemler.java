import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MustekiIslemler implements Methodlar {

Musteki musteki = new Musteki();
Scanner input = new Scanner (System.in);




    @Override
    public void ekran() {

        System.out.println("================================================================");
        System.out.println("Musteki islem menusune hosgeldiniz" +
                "\n1-Musteki ekle" +
                "\n2-Musteki ara" +
                "\n3-Musteki sil " +
                "\n0-Ana menu");
        System.out.println("================================================================");
        System.out.println("Tercihiniz...");
        String tercih = input.next();

        switch (tercih) {

            case "1":
                System.out.println("Dosyaya yeni müşteki ekleme ekranı");
                tarafEkle();
                break;
            case "2":
                System.out.println("Musteki arama ekranı");
                tarafBul();
                break;
            case "3":
                System.out.println("Musteki arama ekranı");
                tarafSil();
                break;
            case "0":
                System.out.println("Ana menuye yönlendiriliyorsunuz");
                break;
            default:
                System.out.println("Hatali giris");
        }

    }

    public Musteki mustekiOlusturma() {
        input.nextLine();//dummy
        System.out.println("Musteki olusturma ekranı");
        System.out.println("İsim : ");

        String isim = input.nextLine();
        System.out.println("Soyisim :");

        String soyisim = input.nextLine();
        System.out.println("Adres :");

        String adres = input.nextLine();

        Musteki musteki = new Musteki(isim, soyisim, adres);

        return musteki ;
    }



    @Override
    public void tarafBul() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Musteki> mustekiList1 = dosya.getMusteki();
            System.out.println("Aradığınız müştekinin adını giriniz:");
            String arananIsim = input.next();
            boolean mustekiBulundu = false;
            for (Musteki musteki : mustekiList1) {
                if (musteki.getIsim().equals(arananIsim)) {
                    System.out.println("İsim Soyisim: " + musteki.getIsim() + " " + musteki.getSoyIsim());
                    System.out.println("Adres: " + musteki.getAdres());
                    mustekiBulundu = true;
                    break;
                }
            }
            if (!mustekiBulundu) {
                System.out.println("Müşteki bulunamadı.");
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
            List<Musteki> mustekiList = dosya.getMusteki();
            List<Musteki> yeniMustekiList = new ArrayList<>(mustekiList);

            Musteki yeniMusteki =  mustekiOlusturma();
            yeniMustekiList.add(yeniMusteki);
            dosya.setMusteki(yeniMustekiList);

            System.out.println("Yeni müşteki başarıyla eklendi.");
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
            List<Musteki> mustekiList = dosya.getMusteki();
            System.out.println("Silinecek müştekinin adını giriniz:");
            String silinecekIsim = input.next();
            boolean mustekiBulundu = false;
            for (Musteki musteki : mustekiList) {
                if (musteki.getIsim().equals(silinecekIsim)) {
                    mustekiList.remove(musteki);
                    mustekiBulundu = true;
                    System.out.println("Müşteki başarıyla silindi.");
                    break;
                }
            }
            if (!mustekiBulundu) {
                System.out.println("Müşteki bulunamadı.");
            }
        } else {
            System.out.println("Hatalı dosya numarası girişi");
        }
    }

}
