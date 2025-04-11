import java.util.Date;

public class Reservation {
    private String numeroReservation;
    private Date dateReservation;
    private String statut;

    public Reservation(String numeroReservation, Date dateReservation, String statut) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void confirmerReservation() {
        statut = "confirmée";
        System.out.println("Réservation " + numeroReservation + " est confirmée");
    }

    public void annulerReservation() {
        statut = "annulée";
        System.out.println("Réservation " + numeroReservation + " est annulée");
    }

    public void modiferReservation() {
        statut = "modifier";
        System.out.println("Réservation " + numeroReservation + "est modifiée");
    }
}
