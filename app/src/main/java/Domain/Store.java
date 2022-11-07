package Domain;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Store {
    @Setter(AccessLevel.NONE)
    int SPK;
    String name;
    String call;
    String locationRegion;
    String locationCity;
    String locationAddress1;
    LocalTime endTime;
    LocalTime startTime;
    List<String> web;
    List<String> tag;
}
