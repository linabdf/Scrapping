package projet.scrapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name="article")
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numA")
    private Integer  numA;
    @Column(name="nomA")
    @JsonProperty("nom")
    private String nomA;


    @Column(name="seuil")
    @JsonProperty("seuil")
    private double seuil;

    @ManyToOne
    @JoinColumn(name = "numU",referencedColumnName = "numU")
    private Utilisateur utilisateur;
    @Column(name="notif")
    @JsonProperty("notif")
    private String notif;
    @Column(name="frequence")
    @JsonProperty("frequence")
    private Integer frequence;
    @Column(name="Description")
    private String Description;
    @Column(name="urlImage")
    private  String urlImage;
    @Column(name="derniereupdate")
    private Timestamp derniereupdate;

    public Article( String nomA, double Seuil, Utilisateur utilisateur,String notif,Integer frequence){

        this.nomA=nomA;
        this.seuil= Seuil;
        this.utilisateur=utilisateur;
        this.notif=notif;
        this.frequence=frequence;

    }
    public Integer getNumA(){
        return numA;
    }
    public String getNomA(){
        return nomA;
    }
    public double getSeuil(){
        return seuil;
    }
    public int getFrequence(){
        return frequence ;
    }

    public String getNotif(){
        return notif ;
    }
    public Article() {

    }




    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur= utilisateur;
    }

    public void setTitre(String exempleTitre) {
        this.nomA=exempleTitre;
    }

    public void setContenu(String exempleContenu) {
        this.Description=exempleContenu;
    }

    public void setSeuil(double v) {
        this.seuil= v;
    }
   public  void setNotif(String notif){
        this.notif=notif;
    }
    public boolean setNumu(String numuConstant) {
        if (this.utilisateur != null) {
            this.utilisateur.SetNumU(Integer.valueOf(numuConstant));
        } else {
            throw new RuntimeException("L'utilisateur est null. Impossible de définir numU.");
        }
        return false;
    }
    // Méthode setter pour associer un utilisateur à l'article

}
