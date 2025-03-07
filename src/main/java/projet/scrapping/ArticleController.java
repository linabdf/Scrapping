package projet.scrapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.scrapping.ArticleService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService ArticleService;
    private final JwtUtil JwtUtil;
    private final UtilisateurRepository UtilisateurRepository;

    @Autowired
    public ArticleController(ArticleService ArticleService, JwtUtil JwtUtil, UtilisateurRepository UtilisateurRepository) {
        this.ArticleService = ArticleService;
        this.JwtUtil = JwtUtil;
        this.UtilisateurRepository = UtilisateurRepository;
    }


    @PostMapping("/addArticle")
    public ResponseEntity<Map<String, String>> addArticle(@RequestBody Article article,
                                                          @RequestHeader("Authorization") String token) {
        Map<String, String> response = new HashMap<>();

        try {
            // Extraire le token du header "Authorization"
            String tokenStr = token.replace("Bearer ", "");

            // Extraire l'email du token
            String email = JwtUtil.extractEmail(tokenStr);
            System.out.println("EMAIL extrait : " + email);

            if (email != null) {
                // Trouver l'utilisateur par email
                Utilisateur utilisateur = UtilisateurRepository.findByEmail(email);

                if (utilisateur != null) {
                    // Récupérer le numU de l'utilisateur
                     Long numU = Long.valueOf(utilisateur.getNumU());
                    System.out.println("numU de l'utilisateur : " + numU);

                    // Ajouter l'article et associer numU à l'article
                  //  article.setNumU(numU); // Associer l'ID utilisateur à l'article
                    //Article savedArticle = ArticleService.addArticle(article);

                    System.out.println("JSJJSK");
                    System.out.println("JSJJSK");
                    article.setUtilisateur(utilisateur);
                    System.out.println("JSJJSK");
                    ArticleService.insererArticle(article.getNomA(), article.getSeuil(), utilisateur,article.getNotif(),article.getFrequence());
                  System.out.println("INSERTRION");
                    response.put("message", "Article ajouté avec succès.");
                    //response.put("articleId", String.valueOf(savedArticle.getId()));
                    return ResponseEntity.ok(response);
                } else {
                    response.put("message", "Utilisateur non trouvé.");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                }
            } else {
                response.put("message", "Token invalide.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Erreur lors de l'ajout de l'article.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}