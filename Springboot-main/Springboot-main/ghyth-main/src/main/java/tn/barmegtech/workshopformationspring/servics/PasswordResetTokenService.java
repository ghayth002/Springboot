package tn.barmegtech.workshopformationspring.servics;


import org.springframework.http.ResponseEntity;
import tn.barmegtech.workshopformationspring.Email.ChangePasswordResetRequest;
import tn.barmegtech.workshopformationspring.dto.SteponeReset;
import tn.barmegtech.workshopformationspring.dto.Stepthreechp;
import tn.barmegtech.workshopformationspring.dto.SteptwoOtp;


public interface PasswordResetTokenService {
   ResponseEntity<String> verifyEmail(SteponeReset steponeReset);


   ResponseEntity<String> verifyOtp(SteptwoOtp steptwoOtp);


   ResponseEntity<String> changePasswordHandler(
           Stepthreechp stepthreechp
   );


}

