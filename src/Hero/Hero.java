package Hero;

public abstract class Hero {
    public int healthPoint;
    public int energy;
    public int energyRegen;
    public int energyLimit;
    public double damageModifier;
    public double armorModifier;
    public int[] heroCards = new int[3];
    public Hero(int hp,int energy, int dmgMod, int armorMod, int energyLimit, int energyRegen){
        setHealthPoint(hp);
        setEnergyLimit(energyLimit);
        setEnergyRegen(energyRegen);
        setEnergy(energy);
        setDamageModifier(dmgMod);
        setArmorModifier(armorMod);

    }

    public  int getHealthPoint() {
        return healthPoint;
    }
    public  int getEnergy() {
        return energy;
    }
    public double getDamageModifier() {
        return damageModifier;
    }
    public double getArmorModifier() {
        return armorModifier;
    }
    public  void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
        if(getHealthPoint()<0){
            this.healthPoint = 0;
        }
    }
    public  void setEnergy(int energyDifference) {
        this.energy += energyDifference;
        if(this.energy>this.getEnergyLimit()){
            this.energy = this.getEnergyLimit();
        }
    }
    public  void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }
    public  void setArmorModifier(double armorModifier) {
        this.armorModifier += armorModifier;
        if(this.armorModifier>80){
            this.armorModifier=80;
        }
        else if (this.armorModifier<-200){
            this.armorModifier=200;
        }
    }
    public void setHeroCards(int[] heroCards) {
        this.heroCards = heroCards;
    }
    public int[] getHeroCards() {
        return heroCards;
    }
    public void setEnergyRegen(int energyRegen) {
        this.energyRegen = energyRegen;
    }
    public int getEnergyRegen() {
        return energyRegen;
    }
    public void setEnergyLimit(int energyLimit) {
        this.energyLimit = energyLimit;
    }
    public int getEnergyLimit() {
        return energyLimit;
    }
}