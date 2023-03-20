package hello.springmvc.basic;

import lombok.Data;

@Data  // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiedArgsConstructor를 자동으로 적용해준다.
public class HelloData {

    private String username;
    private int age;
}
