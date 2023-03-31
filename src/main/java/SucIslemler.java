import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SucIslemler {

    Scanner input = new Scanner(System.in);

       public void ekran() {

        System.out.println("================================================================");
        System.out.println("Suç islem menusune hosgeldiniz" +
                "\n1-Suç ekle" +
                "\n2-Suç ara" +
                "\n3-Suç sil " +
                "\n0-Ana menu");
        System.out.println("================================================================");
        System.out.println("Tercihiniz...");
        String tercih = input.next();

        switch (tercih) {

            case "1":
                System.out.println("Dosyaya yeni suç ekleme ekranı");
                sucEkle();
                break;
            case "2":
                System.out.println("Suç arama ekranı");
                sucBul();
                break;
            case "3":
                System.out.println("Suç arama ekranı");
                sucSil();
                break;
            case "0":
                System.out.println("Ana menuye yönlendiriliyorsunuz");
                break;
            default:
                System.out.println("Hatali giris");
        }

    }

    public Suc sucOlusturma() {
        input.nextLine();//dummy
        System.out.println("Suc  olusturma ekranı");
        System.out.println("Suc adi : ");
        String sucAdi = input.nextLine();

        System.out.println("Kanun maddesi :");
        String kanunNo = input.nextLine();

        System.out.println("Suc yeri    :");
        String sucYeri = input.nextLine();

        System.out.println("Suc tarihi    :");
        String sucTarihi = input.nextLine();

        Suc suc = new Suc(sucAdi, kanunNo, sucYeri, sucTarihi);

        return suc;
    }


    public void sucBul() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList1 = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList1 != null && !dosyaList1.isEmpty()) {
            Dosya dosya = dosyaList1.get(0);
            List<Suc> sucList1 = dosya.getSuc();
            System.out.println("Aradığınız suçun adını giriniz:");
            String arananSuc = input.next();
            boolean sucBulundu1 = false;
            for (Suc suc : sucList1) {
                if (suc.getSucAdi().equals(arananSuc)) {
                    System.out.println("Suc adi  : " + suc.getSucAdi());
                    System.out.println("Kanun No : " + suc.getKanunNo());
                    sucBulundu1 = true;
                    break;
                }
            }
            if (!sucBulundu1) {
                System.out.println("Suc bulunamadı.");
            }
        }else {
            System.out.println("Hatalı dosya numarası girişi");

        }

    }


    public void sucEkle() {
        System.out.println("Dosya numarasını giriniz");
        String dosyaNo = input.next();

        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Suc> sucList = dosya.getSuc();
            List<Suc> yeniSucList = new ArrayList<>(sucList);
            Suc yeniSuc =  sucOlusturma();
            yeniSucList.add(yeniSuc);
            dosya.setSuc(yeniSucList);

            System.out.println("Yeni suc başarıyla eklendi.");
        } else {
            System.out.println("Hatalı dosya numarası girişi.");
        }
    }

    public void sucSil() {
        System.out.println("Dosya numarasını giriniz:");
        String dosyaNo = input.next();
        List<Dosya> dosyaList = DosyaIslemler.dosyaMap.get(dosyaNo);
        if (dosyaList != null && !dosyaList.isEmpty()) {
            Dosya dosya = dosyaList.get(0);
            List<Suc> sucList = dosya.getSuc();
            System.out.println("Silinecek suçun adını giriniz:");
            String silinecekSuc = input.next();
            boolean sucBulundu = false;
            for (Suc suc : sucList) {
                if (suc.getSucAdi().equals(silinecekSuc)) {
                    sucList.remove(suc);
                    sucBulundu = true;
                    System.out.println("Suc başarıyla silindi.");
                    break;
                }
            }
            if (!sucBulundu) {
                System.out.println("Suc bulunamadı.");
            }
        } else {
            System.out.println("Hatalı dosya numarası girişi");
        }
    }





}
