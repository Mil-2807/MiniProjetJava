import java.util.Date;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;

    public Vol(String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }
    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void planifierVol() {
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void annulerVol() {
        etat = "Annulé";
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void modifierVol() {
        etat = "Modifié";
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void ListingVol() {
        System.out.println(" --- Vol --- ");
    }
}
