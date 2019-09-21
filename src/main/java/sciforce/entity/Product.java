package sciforce.entity;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = {"productUuid"})
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private String productUuid;
    private String productName;
    private int amount;
}
