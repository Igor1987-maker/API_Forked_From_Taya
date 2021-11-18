package schedulerdto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

//         "breaks": 0,
//        "currency": "string",
//        "date": {
//        "dayOfMonth": 0,
//        "dayOfWeek": "string",
//        "month": 0,
//        "year": 0
//        },
//        "hours": 0,
//        "id": 0,
//        "timeFrom": "string",
//        "timeTo": "string",
//        "title": "string",
//        "totalSalary": 0,
//        "type": "string",
//        "wage": 0

@Setter
@Getter
@ToString
@Builder
public class RecordDto {

    int breaks;
    String currency;
    DateDto date;
    double hours;
    int id;
    String timeFrom;
    String timeTo;
    String title;
    double totalSalary;
    String type;
    int wage;

}
