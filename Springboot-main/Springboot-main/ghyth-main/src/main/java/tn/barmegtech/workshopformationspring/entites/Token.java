package tn.barmegtech.workshopformationspring.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {


 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 public Integer id;



 @Column(unique = true,length = 400)
 public String token;


 @Enumerated(EnumType.STRING)
 public TokenType tokenType = TokenType.BEARER;


 public boolean revoked;


 public boolean expired;


 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "user_id")
 public User user;
}

