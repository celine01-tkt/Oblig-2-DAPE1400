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

        // Sjekk om det regner
        if (world.getIsRaining()) {
            // skriv ut hvorfor boten ikke kan gå i parken med System.out.println
            return false;
        }

        // Sjekk om det er søndag. Kan bare gå i parken på søndager.

        // Sjekk batterinivå. En bot trenger 1% batterinivå per 100 meter for å gå til parken.

        return true;
    }


    // lag en metode som heter canDanceAtClub, som sjekker om boten kan være med på danseklubben
    // bottypen må være av type B-Bot (hint .equals)
    // En bot trenger minimum 50% batterikapasitet for å være med
    // Det kan ikke være mandag. Da er danseklubben stengt.
}

