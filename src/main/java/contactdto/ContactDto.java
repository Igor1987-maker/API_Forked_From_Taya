package contactdto;
//"address": "string",
//        "description": "string",
//        "email": "string",
//        "id": 0,
//        "lastName": "string",
//        "name": "string",
//        "phone": "string"

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ContactDto {
    String address;
    String description;
    String email;
    int id;
    String lastName;
    String name;
    String phone;



}
