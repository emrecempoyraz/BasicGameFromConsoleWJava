import java.util.Scanner;

public class Player {
    private int damage;
    private int healt ;
    private int originalHealth ;
    private int money ;
    private String name;
    private String charName ;

    private Scanner inp = new Scanner(System.in);
    private Inventory inventory ;

    Player(String name){
        this.name = name;
        this.inventory = new Inventory();

    }

    public void selectChar(){
        GameChar[] charlist = { new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler:");
        System.out.println("-------------------------------------------------");
        for (GameChar gameChar : charlist){

            System.out.println("ID : "+gameChar.getId() +
                    "\tKarakter: " + gameChar.getName() +
                    "\t Hasar:" + gameChar.getDamage() +
                    "\t Sağlık:" + gameChar.getHealth() +
                    "\t Para:"+ gameChar.getMoney());

        }
        System.out.println("--------------------------------------------------");
        System.out.println("Lütfen bir karakter seçiniz!");
        int selectChar = inp.nextInt();
        switch (selectChar){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter : " + this.getCharName() +
                           ",Hasar: " + this.getDamage() +
                           ",Sağlık: " +this.getHealt() +
                           ",Para: " + this.getMoney());


    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealt(gameChar.getHealth());
        this.setHealt(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }

    public void printInfo(){
        System.out.println("Silah :" + this.getInventory().getWeapon().getName() +
                           ",Zırh :" + this.getInventory().getArmor().getName() +
                           ",Bloklama :" + this.getInventory().getArmor().getBlock()+
                           ",Hasar :" + this.getTotalDamage() +
                           ",Sağlık : " +this.getHealt() +
                           ",Para : " + this.getMoney());

    }

    public int getTotalDamage (){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Weapon getWeapon(){
        return getInventory().getWeapon();
    }


}
