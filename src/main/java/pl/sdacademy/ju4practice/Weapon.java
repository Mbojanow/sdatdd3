package pl.sdacademy.ju4practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Weapon {

    private String name;
    private String code;
    private Long version;
    private Double damage;
    private Integer shortsPerSecond;
    private Element element;
    private List<Element> strongAgainstElements;
    private List<Element> neutralElements;
    private List<Element> weakAgainstElements;
}
