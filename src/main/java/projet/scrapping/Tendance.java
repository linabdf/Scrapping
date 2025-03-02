/*package projet.scrapping;

import jakarta.persistence.*;

@Entity
@Table(name="Tendance")
public class Tendance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String numT;
    @Column(name="prix")
    private String prix;
    @Column(name="dateT")
    private String dateT;
    @ManyToOne
    @JoinColumn(name = "numS",referencedColumnName = "numS")
    private Site site ;
    public Tendance(String prix,String dateT,Site site){
        this.prix=prix;
        this.dateT=dateT;
        this.site=site;
    }

}
*/