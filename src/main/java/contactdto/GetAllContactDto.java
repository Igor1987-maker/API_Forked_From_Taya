package contactdto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class GetAllContactDto {

    List<ContactDto> contacts;
}
