public class Obstacle {
    private int id ;
    private String name ;
    private int damage ;
    private int healt ;
    private int award ;
    private int originalHealth;


    public Obstacle(int id, String name, int damage, int healt, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.originalHealth = healt;
        this.award = award ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        if(healt < 0 ){
            healt = 0 ;
        }
        this.healt = healt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
