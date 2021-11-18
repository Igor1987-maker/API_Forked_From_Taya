package schedulerdto;

import lombok.*;

/*"monthFrom": 0,
        "monthTo": 0,
        "yearFrom": 0,
        "yearTo": 0*/

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class BodyDto {

    int monthFrom;
    int monthTo;
    int yearFrom;
    int yearTo;


}

