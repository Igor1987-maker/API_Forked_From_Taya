package schedulerdto;

/*"registration": true,
        "status": "string",
        "token": "string"*/
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class AuthResponseRecord {

    Boolean registration;
    String status;
    String token;


}
