package pl.sdacademy.ju4practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {

    private String name;
    private Integer baseDamage;
    private Integer bonusDamage;
    private AmmoType ammoType;
    private List<ArmorType> goodAgainst;
    private List<ArmorType> badAgainst;
    private List<ArmorType> neutralAgainst;
}
