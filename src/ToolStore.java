public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("----- Mağazaya Hoş Geldiniz ! -----");
        boolean showMenu = true ;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.print("Seçiminiz : ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 && selectCase > 3){
                System.out.print("Geçersiz değer,Tekrar giriniz! : ");
                selectCase = input.nextInt();

            }
            switch (selectCase){
                case 1 :
                    printWeapon();
                    buyWeapon();
                    break;
                case 2 :
                    printArmor();
                    buyArmor();
                    break;
                case 3 :
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;


            }

        }
        return true;


    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " <Para : " + w.getPrice() + ", Hasar : " + w.getDamage() + ">" );
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.println("Bir Silah Seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 && selectWeaponID > Weapon.weapons().length){
            System.out.print("Geçersiz değer,Tekrar giriniz! : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                }else {
                    System.out.println(selectedWeapon.getName() + "silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız :" + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }

            }

        }

    }
    public void printArmor(){
        System.out.println("----- Zırhlar -----");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() +"< Para :" +
                               a.getPrice() +", Zırh : " + a.getBlock() + ">" );
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor(){
        System.out.println("Bir Zırh Seçiniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 && selectArmorID > Armor.armors().length){
            System.out.print("Geçersiz değer,Tekrar giriniz! : ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız Bulunmamaktadır!");

                }else {
                    System.out.println(selectedArmor.getName() + "Zırhı Satın Aldınız !" );
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız :" + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }

            }

        }

    }

}
