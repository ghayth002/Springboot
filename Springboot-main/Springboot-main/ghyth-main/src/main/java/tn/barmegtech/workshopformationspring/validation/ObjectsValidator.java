package tn.barmegtech.workshopformationspring.validation;





import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import tn.barmegtech.workshopformationspring.exception.ObjectValidationException;



import java.util.Set;
import java.util.stream.Collectors;
@Component
public class ObjectsValidator <T>{
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectValidateReference){
        Set<ConstraintViolation<T>> violations = validator.validate(objectValidateReference);
        if(!violations.isEmpty()){
            Set<String> errorMessages = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            throw new ObjectValidationException(errorMessages,objectValidateReference.getClass().getSimpleName());
        }
    }
}
