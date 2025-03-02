/*package projet.scrapping;

import jakarta.persistence.*;

@Entity
@Table(name="article")
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String numA;
    @Column(name="nomA")
    private String nomA;
    @Column(name="Description")
    private String Descrption;
    @Column(name="seuil")
    private String seuil;
    @ManyToOne
    @JoinColumn(name = "numU",referencedColumnName = "numU")
    private Utilisateur utilisateur;
    @Column(name="notif")
    private String notif;
    @Column(name="frequence")
    private Integer frequence;

    public Article(String numA, String nomA, String Description, double Seuil, Utilisateur utilisateur,String notif,Integer frequence){
        this.numA=numA;
        this.nomA=nomA;
        this.Descrption=Description;
        this.seuil= String.valueOf(Seuil);
        this.utilisateur=utilisateur;
        this.notif=notif;
        this.frequence=frequence;

    }

    public Article() {

    }


    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur= utilisateur;
    }

    public void setId(String id) {
        this.numA=id;
    }

    public void setTitre(String exempleTitre) {
        this.nomA=exempleTitre;
    }

    public void setContenu(String exempleContenu) {
        this.Descrption=exempleContenu;
    }

    public void setSeuil(double v) {
        this.seuil= String.valueOf(v);
    }
public  void setNotif(String notif){
        this.notif=notif;
}
    public void setNumu(String numuConstant) {
        if (this.utilisateur != null) {
            this.utilisateur.SetNumU(numuConstant);
        } else {
            throw new RuntimeException("L'utilisateur est null. Impossible de définir numU.");
        }
    }
}
*/