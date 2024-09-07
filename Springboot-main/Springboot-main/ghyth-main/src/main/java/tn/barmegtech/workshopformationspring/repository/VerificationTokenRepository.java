package tn.barmegtech.workshopformationspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.barmegtech.workshopformationspring.entites.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}

