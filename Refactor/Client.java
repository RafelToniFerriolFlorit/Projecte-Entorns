package Refactor;
import java.util.Vector;

// Exercici 1. Codificant el Gestor de Lloguers
// A partir del diagrama anterior, fes una proposta de codificació de les classes que hi apareixen.
// Assegura't que les propietats que apareixen al diagrama de classes disposen d'accessors adequats. Considera el codi següent per la classe Client com a referència.

// Vehicle:
// - model: String
// - marca: String
// - categoria: String

// Lloguer:
// - data: Date
// - dies: int

// Client:
// - nif: String
// - nom: String
// - telefon: String

// ---------------

// + afegirLloguer(Lloguer): void
// + eliminarLloguer(Lloguer): void
// + conteLloguer(Lloguer): boolean
// + informe(): String

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers = new Vector<Lloguer>();

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void afegirLloguer(Lloguer lloguer) {
        if (!lloguers.contains(lloguer)) {
            lloguers.add(lloguer);
        }
    }

    public void eliminarLloguer(Lloguer lloguer) {
        if (lloguers.contains(lloguer)) {
            lloguers.remove(lloguer);
        }
    }

    public boolean conteLloguer(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        double total = 0;
        int bonificacions = 0;
        String resultat = "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
        for (Lloguer lloguer : lloguers) {
            double quantitat = 0;
            switch (lloguer.getVehicle().getCategoria()) {
                case Vehicle.BASIC:
                    quantitat += 3;
                    if (lloguer.getDies() > 3) {
                        quantitat += (lloguer.getDies() - 3) * 1.5;
                    }
                    break;
                case Vehicle.GENERAL:
                    quantitat += 4;
                    if (lloguer.getDies() > 2) {
                        quantitat += (lloguer.getDies() - 2) * 2.5;
                    }
                    break;
                case Vehicle.LUXE:
                    quantitat += lloguer.getDies() * 6 ;
                    break;
            }
            // afegeix lloguers freqüents
            bonificacions ++;
            // afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE && lloguer.getDies() > 1 ) {
                bonificacions ++;
            }
            // composa els resultats d'aquest lloguer
            resultat += "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": " + (quantitat * 30) + "€" + "\n";
            total += quantitat * 30;
        }

        // afegeix informació final
        resultat += "Import a pagar: " + total + "€\n";
        resultat += "Punts guanyats: " + bonificacions + "\n";
        return resultat;
    }



}

// Exercici 2. El Gestor de Lloguers lite
// Codifica la classe GestorLloguersLite que crei un client amb el teu nom, que disposi de un mínim de tres lloguers, un per cada tipus de vehicle.
// Considera el següent snippet com a pista per crear els vehicles i lloguers:


