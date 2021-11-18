package schedulerdto;
//         dayOfMonth": 0,
//        "dayOfWeek": "string",
//        "month": 0,
//        "year": 0


import lombok.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class DateDto {

    int dayOfMonth;
    String dayOfWeek;
    int month;
    int year;

  /*  public DateDto(int dayOfMonth, String dayOfWeek, int month, int year) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
    }

    public DateDto(List<DateDto> date) {
    }*/

    /*public void DateDto(List<DateDto> date) {
        for (DateDto dt:date) {
            
        }*/
        
        
    }

