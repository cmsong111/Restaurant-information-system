package Domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Menu {
    @Setter(AccessLevel.NONE)
    int MPK;
    @Setter(AccessLevel.NONE)
    int SPK;
    String name;
    int price;

    // TODO : DB 저장시 어떻게 저장되는지 확인
    @Setter(AccessLevel.NONE)
    Store store;
}
