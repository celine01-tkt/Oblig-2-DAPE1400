public class World {
    private boolean isRaining;
    private int day;// 1 er Mandag, 2 er Tirsdag, ..., 7 for Søndag, 8 er Mandag...


    public World(int day, boolean isRaining) {
        this.day = day;
        this.isRaining = isRaining;
    }

    //sjekk om dagen er søndag
    public boolean isSunday() {
        // her endre jeg metoden slik at den returner true hvis det er søndag (hint: Modulo %)
        return (day % 7 == 0); //hvis "day" kan deles på 7 uten rest (feks.7, 14, 21...), så er det søndag
    }

    public boolean getIsRaining() {return this.isRaining;}
    public int getDay() {return this.day;}
}
