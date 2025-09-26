import java.sql.SQLOutput;

public class Robot {
    // gi robotten 4 attributter: name, batteryLevel, distancetoPark og botType
    private String name;
    private double batteryLevel; //prosenter i batterinivå
    private int distancetoPark; //avstand til parken i meter
    private String botType; //type til robot

    //contructor ved klassen
    public Robot(String name, double batteryLevel, int distancetoPark, String botType) {
        this.name = name;
        this.batteryLevel = Math.max(0, Math.min(100,batteryLevel));//Math.max(0,...), Math.min(0,...)gjør at batteriet alltid mellom 0 og 100.
        this.distancetoPark = Math.max(0,distancetoPark);//Math.max(0,...) her gjør at avstand ikke kan være negativ
        this.botType = botType;
    }

    //Statusrapport
    public String reportStatus() {
        // Metode for å rapportere statusen til robotten
        // Endre metoden slik at den retunerer en tekst streng som forklarer statusen til roboten
        // eksempela: Dette er bot Dancatron 4000 av type B-Bot.
        // Denne enheten har 80.0 batterikapasitet igjen og bor 1500 meter fra parken.
        return "Dette er bot" + name + " av type " + botType + ".\n"
                + "Denne enheten har" + String.format("%.1f", batteryLevel) //her betyr at vi skriver batteriet med en desimal feks. 80.0
                + "% batteri igjen" + "og bor " + distancetoPark + "meter unna parken."; //returnerer en tekst som beskriver robotens navn, batteri og avstand til parken.
    }

    //Sjekk om roboten kan gå til parken
    public boolean canWalkToThePark(World world) {
        // Metode for å sjekke om roboten kan gå til parken basert på omgivelsene
        // System.out.println(navn + " sjekker om det er mulig å gå til parken...");
        System.out.println(name + ": sjekker om det er mulig å gå til parken...");

        // Sjekk om det regner
        if (world.getIsRaining()) {
            // skriv ut hvorfor boten ikke kan gå i parken med System.out.println
            System.out.println(name + ": Nei,det regner.");
            return false; //hvis det regner, kan roboten ikke gå.
        }

        // Sjekk om det er søndag. Kan bare gå i parken på søndager. ! betyr ikke
        if (!world.isSunday()) {
            System.out.println(name + ": Nei, det er ikke søndag.");
            return false; //roboten kan bare gå til parken på søndag.
        }

        // Sjekk batterinivå. En bot trenger 1% batterinivå per 100 meter for å gå til parken.
        double neededBattery = distancetoPark / 100.0; //1% per 100 meter
        if (batteryLevel < neededBattery) {
            System.out.println(name + ": Nei, har for lite batteri. Trenger "
            + String.format("%.1f", neededBattery) + "% har "
            + String.format("%.1f", batteryLevel) + "%.");
            return false; //hvis den ikke har nok batteri ->returnerer false.
        }

        System.out.println(name + ": Ja, roboten kan gå til parken!");
        return true; //hvis alle sjekker er ok ->den kan gå til parken.
    }


    // lag en metode som heter canDanceAtClub, som sjekker om boten kan være med på danseklubben
    public boolean canDanceAtClub (World world) {
        System.out.println(name + ": Sjekker om boten kan være med på danseklubben...");

        // bottypen må være av type B-Bot (hint .equals)
        if (!"B-Bot".equals(botType)) {
            System.out.println(name + ": Nei, jeg er ikke en B-Bot.");
            return false;
        }

        // En bot trenger minimum 50% batterikapasitet for å være med
        if (batteryLevel < 50.0){
            System.out.println(name + ": Nei, for lite batteri. Har bare "
            + String.format("%.1f", batteryLevel) + "%.");
            return false;
        }

        // Det kan ikke være mandag. Da er danseklubben stengt.
        if (world.getDay() % 7 == 1) {
            System.out.println(name + ": Nei, klubben er stengt på mandager."); //Vi bruker world.getDay() % 7 == 1 fordi dag 1, 8, 15, … skal være mandag.
            return false; //klubben er stengt på mandager (dag % 7 == 1).
        }

        System.out.println(name + ": Ja, boten kan være med på danseklubben.");
        return true; // Hvis alle tidligere sjekker har gått bra (roboten er en B-Bot, har minst 50 % batteri og det er ikke mandag), så skriver den en positiv melding og returnerer true.

    }



}

