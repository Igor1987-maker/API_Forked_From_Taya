package contactdto;

import lombok.*;

//{
//        "code": 0,
//        "details": "string",
//        "message": "string",
//        "timestamp": "2021-11-16T17:22:59.925Z"
//        }
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ErrorDto {
    int code;
    String details;
    String message;


}
