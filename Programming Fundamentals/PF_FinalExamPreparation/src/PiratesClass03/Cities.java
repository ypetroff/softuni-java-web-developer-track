package PiratesClass03;

public class Cities {
    public String name;
    public int population;
    public int gold;

    public Cities(String name, int population, int gold) {
        this.name = name;
        this.population = population;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getGold() {
        return gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void print() {
        System.out.printf("%s -> Population: %d citizens, Gold: %d kg", this.name, this.population, this.gold);
    }
}
