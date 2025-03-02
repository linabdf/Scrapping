/*package projet.scrapping;

import jakarta.persistence.*;

@Entity
@Table(name="Site")
public class Site {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String numS;
    @Column(name="urlarticle")
    private String urlArticle;
    @Column(name="nomSite")
    private String nomSite;
    @ManyToOne
    @JoinColumn(name = "numA",referencedColumnName = "numA")
    private Article  Article ;
    public  Site(String urlArticle,String nomSite,Article Article ){
         this.urlArticle=urlArticle;
         this.nomSite=nomSite;
         this.Article=Article;
    }
    public String getNumS(){
         return numS;
    }
    public void setNumS(String numS){
         this.numS=numS;
    }
}*/
