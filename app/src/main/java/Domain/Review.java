package Domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Review {
    @Setter(AccessLevel.NONE)
    int RPK;
    @Setter(AccessLevel.NONE)
    int SPK;
    @Setter(AccessLevel.NONE)
    int UPK;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Setter(AccessLevel.NONE)
    Store store;    // TODO :하기 DB 입력시 확인
    @Setter(AccessLevel.NONE)
    User user;  // TODO :하기 DB 입력시 확인

}
