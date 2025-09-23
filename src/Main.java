public class Main {
    public static void main(String[] args) {
        // Oppretter en Verden-objekt (omgivelsene)
        World todaysWorld = new World(122, false);

        // Opprett to Robot-objekter
        // med navn, f.eks. Dancatron 4000 og Spark-E
        // med botType "B-Bot" og "Toaster"
        // med forskjellig batterinivå
        // med forskjellig avstand til parken
        Robot r1 = new Robot("Dancatron 4000", 80.0,1500, "B-Bot");
        Robot r2 = new Robot("Spark-E", 40.0,500, "Toaster");

        // print ut statusen til begge robottene

        // Sjekk om robotene kan gå til danseklubben
        // Sjekk om robotene kan gå til parken
    }
}
