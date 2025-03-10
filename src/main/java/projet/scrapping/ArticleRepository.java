package projet.scrapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository  extends JpaRepository<Article,Integer> {
   List<Article> findByUtilisateur(Utilisateur utilisateur);
   List<Article> findAll();

}
