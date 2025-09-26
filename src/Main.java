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
        System.out.println("=== Statusrapporter ===");
        System.out.println(r1.reportStatus()); //reportStatus() returnerer en streng (tekst) som inneholder statusinformasjon.
        System.out.println(); //Dette er en «tom println». Den skriver bare et linjeskift (en blank linje).
        System.out.println(r2.reportStatus());
        System.out.println();


        // Sjekk om robotene kan gå til parken
        System.out.println("=== Kan robotene går til parken? ===");
        r1.canWalkToThePark(todaysWorld); //todaysWorld (objektet som holder på hvilken dag det er og om det regner).
        r2.canWalkToThePark(todaysWorld);
        System.out.println();

        // Sjekk om robotene kan gå til danseklubben
    }
}
