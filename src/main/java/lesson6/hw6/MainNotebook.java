package lesson6.hw6;

import java.util.List;
import java.util.Scanner;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook AcerAspireA114 = new Notebook("Acer Aspire", "A114", "Silver", 14, "TN", "Intel Pentium Silver N6000 1.1 ГГц", "Intel UHD Graphics", 8, 128, "eShell");
        Notebook MSIModern14 = new Notebook("MSI", "Modern 14", "Black", 14, "IPS", "AMD Ryzen 5 5625U 2.3 ГГц", "AMD Radeon", 16, 512, "Windows 11");
        Notebook SonyNE15V2IN069P = new Notebook("Sony", "NE15V2IN069P", "Blue", 15.6, "IPS", "AMD Ryzen 3 3200U 2.6 ГГц", "Radeon RX Vega 3", 8, 512, "Windows 11");
        Notebook AppleMacBookPro14 = new Notebook("Apple", "MacBook Pro 14", "Grey", 14.2, "Retina XDR", "Apple M2 Pro", "Apple", 16, 512, "macOS");
        Notebook ASUSA516JP = new Notebook("ASUS", "A516JP", "Silver", 15.6, "TN", "Intel Core i7 1065G7 1.3 ГГц", "NVIDIA GeForce MX330", 16, 1024, "eShell");

        List<Notebook> notebooks = List.of(AcerAspireA114, MSIModern14, SonyNE15V2IN069P, AppleMacBookPro14, ASUSA516JP);

        Scanner scannerUser = new Scanner(System.in);
        System.out.println("Выберите параметр для поиска, где:\n1 - по цвету\n2 - по бренду\n3 - по операционной системе");
        int choiceUserSearch = scannerUser.nextInt();
        Scanner scannerRequestUserForSearch = new Scanner(System.in);
        String requestUserForSearch = scannerRequestUserForSearch.nextLine();

        if (choiceUserSearch == 1)  {
            for (Notebook color : notebooks) {
                if (color.getColor().equalsIgnoreCase(requestUserForSearch)) {
                    System.out.println(color.printInfo());
                }
            }

        } else if (choiceUserSearch == 2){
            for (Notebook brand : notebooks) {
                if (brand.getBrand().equalsIgnoreCase(requestUserForSearch)) {
                    System.out.println(brand.printInfo());
                }
            }

        } else if (choiceUserSearch == 3){
            for (Notebook os : notebooks) {
                if (os.getOs().equalsIgnoreCase(requestUserForSearch)) {
                    System.out.println(os.printInfo());
                }
            }
        } else {
            System.out.println("Ошибка.\nВыберите параметр для поиска, где:\n1 - по цвету\n2 - по бренду\n3 - по операционной системе");
        }

        scannerUser.close();
    }
}