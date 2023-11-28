public class RPGCharacter {
    public String name;
    private int level;
    private int maxHP;
    private int maxMANA;
    private int Hp;
    private int Mana;
    private int Def;
    private int Atk;
    Sword equippedSword;
    Shield equippedShield;

    public RPGCharacter(String name, int level){
        this.name = name;
        this.level = level;
        this.maxHP = calculateHp();
        this.maxMANA = calculateMana();
        this.Hp = maxHP;
        this.Mana = maxMANA;
        this.Def = calculateDef();
        this.Atk = calculateAtk();
    }

    private int calculateHp(){
        return 100 + 10*level;
    }
    private int calculateMana(){
        return 50 + 2*level;
    }
    private int calculateDef(){
        return 20 + level;
    }
    private int calculateAtk(){
        return 50 + level/2;
    }

    public void levelUp(){
        level++;
        maxHP = calculateHp();
        Hp = maxHP;
        maxMANA = calculateMana();
        Mana = maxMANA;
        Def = calculateDef();
        Atk = calculateAtk();
    }

    public void equipSword(Sword sword){
        equippedSword = sword;
    }
    public void equipShield(Shield shield){
        equippedShield = shield;
    }
    public void takeDamage(int damage){
        damage -= Def;
        if(damage > 0){
            Hp -= damage;
        }
        if(Hp <= 0){
            Hp = 0;
        }
    }
    public int getHp(){
        return Hp;
    }
    public int getMana(){
        return Mana;
    }
}
class Sword {
    int atkUp;
    public Sword(int atkUp){
        this.atkUp = atkUp;
    }
    public int getSwordStat(){
        return atkUp;
    }
}
class Shield{
    int defUp;
    public Shield(int defUp){
        this.defUp = defUp;
    }
    public int getShieldStat(){
        return defUp;
    }
}