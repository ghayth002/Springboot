package tn.barmegtech.workshopformationspring.dto;


import lombok.Builder;
import lombok.Data;

//@Getter
//@Setter
@Data
@Builder
public class Response {
   private String responseMessage;
   private String email;
}

