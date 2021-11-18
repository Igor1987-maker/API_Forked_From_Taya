package schedulerdto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder


public class GetAllRecordsDto {
    List<RecordDto> records;
}
