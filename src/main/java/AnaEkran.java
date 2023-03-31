import java.util.Scanner;

public class AnaEkran {
    Scanner input = new Scanner(System.in);
    MustekiIslemler mustekiIslemler = new MustekiIslemler();
    SanikIslemler sanikIslemler = new SanikIslemler();
    TanikIslemler tanikIslemler = new TanikIslemler();
    SucIslemler sucIslemler = new SucIslemler();
    DosyaIslemler dosyaIslemler = new DosyaIslemler();

    public void anaEkran() {
        dosyaIslemler.dosyaDepo();

        String tercih = "0";
        do {
            System.out.println("================================================================");
            System.out.println(" Avukat dosya sistemi ana ekrana hoşgeldiniz" +
                    "\n 1- Dosya oluşturma" +
                    "\n 2-Dosya Ara" +
                    "\n 3-Dosya sil" +
                    "\n 4-Taraf islemleri" +
                    "\n 0-Cıkıs"
            );
            System.out.println("Tercihiniz : ");
            tercih = input.next();

            switch (tercih) {
                case "1":
                    dosyaIslemler.dosyaOlusturma();
                    break;
                case "2":
                    dosyaIslemler.taraflariYazdir();
                    break;
                case "3":
                    dosyaIslemler.dosyaSil();
                    break;
                case "4":
                    tarafIslemleri();
                    break;
                case "0":
                    System.out.println("Sistemden çıktınız");
                    break;
                default:
                    System.out.println("Hatali giris");
            }
        } while (!tercih.equals("0"));
    }


    public void tarafIslemleri() {

        System.out.println("" +

                "\t\t\nTaraf Islemleri Menusune hosgeldiniz" +
                "\t\t\nSanık ekranı icin    1" +
                "\t\t\nMusteki ekranı icin  2" +
                "\t\t\nTanik ekrani icin    3" +
                "\t\t\nSuc ekrani icin      4" +
                "\t\t\nAnasa sayfa icin     0" +
                "\t\t\nTercihiniz....");

        String tercih = input.next();

        switch (tercih) {
            case "1":
                System.out.println("Sanık Ekranı");
                sanikIslemler.ekran();
                break;
            case "2":
                System.out.println("Musteki Ekranı");
                mustekiIslemler.ekran();
                break;
            case "3":
                System.out.println("Tanik Ekranı");
                tanikIslemler.ekran();
                break;
            case "4":
                System.out.println("Suç Ekranı");
                sucIslemler.ekran();
                break;
            case "0":
                System.out.println("Ana sayfaya yönlendiriliyorsunuz");
                break;
            default:
                System.out.println("Hatali giris");

        }

    }


}
