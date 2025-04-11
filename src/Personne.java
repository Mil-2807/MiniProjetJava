public class Personne {
    private String identifiant;
    private String nom;
    private String adresse;
    private String contact;

    public Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void obtenirInfos() {
        System.out.println("Identifiant: " + this.identifiant);
        System.out.println("Nom: " + this.nom);
        System.out.println("Adresse: " + this.adresse);
        System.out.println("Contact: " + this.contact);
    }


}
