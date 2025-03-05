package projet.scrapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> inscrireUtilisateur(@RequestBody Utilisateur utilisateurDTO) {
        Map<String, String> response = new HashMap<>();
        System.out.println("utilisateur"+utilisateurDTO);
        try {
            System.out.println("Nom reçu : " + utilisateurDTO.getNomU());
            System.out.println("Mot de passe reçu : " + utilisateurDTO.getMotDePasse());
            System.out.println("Email reçu : " + utilisateurDTO.getEmail());
            System.out.println("prenomU reçu : " + utilisateurDTO.getPrenom());
            utilisateurService.insererUtilisateur(
                    utilisateurDTO.getNomU(),
                    utilisateurDTO.getPrenom(),
                    utilisateurDTO.getEmail(),
                    utilisateurDTO.getMotDePasse()
            );
            response.put("message", "Utilisateur inscrit avec succès bravo ");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Erreur lors de l'inscription de l'utilisateur");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> connecterUtilisateur(@RequestBody Utilisateur utilisateurDTO) {
        Map<String, String> response = new HashMap<>();
        System.out.println("Utilisateur reçu : " + utilisateurDTO);
        System.out.println("Email reçu : " + utilisateurDTO.getEmail());
        System.out.println("Mot de passe reçu : " + utilisateurDTO.getMotDePasse());
        try {
            Map<String, String> utilisateur = utilisateurService.connecterUtilisateur(
                    utilisateurDTO.getEmail(),
                    utilisateurDTO.getMotDePasse()
            );
            if ("Connexion réussie.".equals(utilisateur.get("message"))) {

                return ResponseEntity.ok(utilisateur);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(utilisateur);
            }
        } catch (Exception e) {
            response.put("message", "Erreur lors de la connexion de l'utilisateur");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}


