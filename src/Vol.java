import java.util.Date;

public class Vol {
    private int numeroVol;
    private String origine;
    private String destination;
    private Date dateHeureDepart;
    private Date dateHeureArrivee;
    private String etat;

    public Vol(int numeroVol, String origine, String destination, Date dateHeureDepart, Date dateHeureArrivee, String etat) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
    }

    public int getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(int numeroVol) {
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

    public Date getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(Date dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public Date getDateHeureArrivee() {
        return dateHeureArrivee;
    }
    public void setDateHeureArrivee(Date dateHeureArrivee) {
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
