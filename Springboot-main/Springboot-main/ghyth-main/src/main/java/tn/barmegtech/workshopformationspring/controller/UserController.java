package tn.barmegtech.workshopformationspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.barmegtech.workshopformationspring.Email.ChangePasswordResetRequest;
import tn.barmegtech.workshopformationspring.dto.SteponeReset;
import tn.barmegtech.workshopformationspring.dto.Stepthreechp;
import tn.barmegtech.workshopformationspring.dto.SteptwoOtp;
import tn.barmegtech.workshopformationspring.entites.User;
import tn.barmegtech.workshopformationspring.serviceimpl.UserService;
import tn.barmegtech.workshopformationspring.servics.PasswordResetTokenService;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService service;
    private final PasswordResetTokenService passwordResetTokenService;
  


    @GetMapping("/{email}")
    public User fetchUser(@PathVariable String email) {
        return service.fetchUser(email);
    }


    //send mail for email verification
    @PostMapping("/resetrequestpassword")
    public ResponseEntity<String> verifyEmail(@RequestBody SteponeReset steponeReset) {

        return passwordResetTokenService.verifyEmail(steponeReset);

    }


    @PostMapping ("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestBody SteptwoOtp steptwoOtp){
        return passwordResetTokenService.verifyOtp(steptwoOtp);
    }

    //Now User Can change the password

    @PostMapping("/resetPassword")
    public ResponseEntity<String> changePasswordHandler(
            @RequestBody Stepthreechp stepthreechp){
        return passwordResetTokenService.changePasswordHandler(stepthreechp);
    }

 
    
}

