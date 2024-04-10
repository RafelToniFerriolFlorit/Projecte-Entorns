package Refactor;

public class GestorDeLloguersLite {
    public static void main(String[] args) {
        Client c = new Client("12345678A", "Pepito", "666666666");
        Vehicle v = new Vehicle("Ibiza", "Seat", Vehicle.BASIC);
        Lloguer l = new Lloguer("01/01/2020", 5, v);
        c.afegirLloguer(l);
        // System.out.println(c.informe());
    }
}
