import java.util.Scanner;

public class Game {
    private Scanner inp = new Scanner(System.in);

    public void start(){

        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.println("Lütfen Bir İsim giriniz : ");
        String playerName = inp.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Adaya Hoşgeldiniz !");
        System.out.println(" Lütfen Bir Karakter Seçin! ");
        System.out.println("--------------------------------------------------");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("Bölgeler");
            System.out.println();
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Dükkan --> Silah veya Zırh satın alabilirsiniz!");
            System.out.println("3 - Mağara --> Ödül <Yemek> , Dikkatli ol karşına Zombi çıkabilir !!");
            System.out.println("4 - Orman --> Ödül <Odun> , Dikkatli ol karşına Vampir çıkabilir !!");
            System.out.println("5 - Nehir --> Ödül <Su> , Dikkatli ol karşına Ayı çıkabilir !!");
            System.out.println("0 - Çıkış Yap --> Oyunu Sonlandır.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = inp.nextInt();
            switch (selectLoc){
                case 0 :
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }
            if (location == null){
                System.out.println("Oyun Bitti,Hoşçakalın !");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;

            }


        }





    }
}
