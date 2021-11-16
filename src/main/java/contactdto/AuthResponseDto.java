package contactdto;

import lombok.*;

//{
//        "token": "string"
//        }
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AuthResponseDto {
    String token;
}
