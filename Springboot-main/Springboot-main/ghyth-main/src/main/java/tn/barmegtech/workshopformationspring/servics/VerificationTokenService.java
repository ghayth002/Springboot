package tn.barmegtech.workshopformationspring.servics;

import org.springframework.http.ResponseEntity;
import tn.barmegtech.workshopformationspring.dto.Response;
import tn.barmegtech.workshopformationspring.entites.User;
import tn.barmegtech.workshopformationspring.entites.VerificationToken;


public interface VerificationTokenService {
	
   void saveUserVerificationToken(User user, String token);
   String validateToken(String token);
   ResponseEntity<Response> verifyEmail(String token);
   VerificationToken generateNewVerificationToken(String oldToken);
}
