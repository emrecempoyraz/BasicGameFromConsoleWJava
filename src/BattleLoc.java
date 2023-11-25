import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle ;
    private String award ;
    private int maxObstacle ;

    public BattleLoc(Player player, String name, Obstacle obstacle , String award,int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award ;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şuan buradasınız :" + getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + "tane" + this.obstacle.getName() + " yaşıyor !!");
        System.out.print("<S>avaş veya <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")){
            System.out.println("Savaş başlıyor !!");
            if (combat(obsNumber)){
                System.out.println(this.getName() + "tüm düşmanları yendiniz !" );
                return true;

            }
        }

        if (this.getPlayer().getHealt() <= 0) {
            System.out.println("Öldünüz !!");
            return false;

        }
        return true;
    }

    public boolean combat (int obsNumber){
        for (int i = 1 ; i <= obsNumber ; i++){
            this.getObstacle().setHealt(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealt() > 0 && this.obstacle.getHealt() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz Vurdunuz !");
                    this.getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
                    afterhit();
                    if (this.getObstacle().getHealt() > 0){
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0 ){
                            obstacleDamage = 0 ;

                        }
                        this.getPlayer().setHealt(this.getPlayer().getHealt() - obstacleDamage);
                        afterhit();


                    }

                }else{
                    return false;
                }
            }

            if (this.getObstacle().getHealt() < this.getPlayer().getHealt()){
                System.out.println("Düşmanı Yendiniz !!");
                System.out.println(this.getObstacle().getAward() + "Para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız :" + this.getPlayer().getMoney());
            }else {
                return false;
            }

        }
        return true ;
    }

    public void afterhit(){
        System.out.println("Canınız :" + this.getPlayer().getHealt());
        System.out.println(this.getObstacle().getName() + "Canı :" + this.getObstacle().getHealt());
        System.out.println("--------------------------");
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık :" + this.getPlayer().getHealt());
        System.out.println("Silah :" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh :" + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama :" + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar :" + this.getPlayer().getTotalDamage());
        System.out.println("Para :" + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i){
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık :" + this.getObstacle().getHealt());
        System.out.println("Hasar :" + this.getObstacle().getDamage());
        System.out.println("Ödül :" + this.getObstacle().getAward());
        System.out.println();


    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1 ;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
