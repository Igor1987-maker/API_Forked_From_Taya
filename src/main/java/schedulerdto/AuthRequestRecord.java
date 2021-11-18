package schedulerdto;
/*
 "email": "string",
         "password": "string"*/
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AuthRequestRecord {
    String email;
    String password;

}
