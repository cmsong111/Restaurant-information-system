package Domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    @Setter(AccessLevel.NONE)
    int UPK;
    String ID;
    String PASSWORD;
    String name;
    int age;
    List<Store> myStore;
}
