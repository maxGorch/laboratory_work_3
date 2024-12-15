package org.example;

import java.util.Objects;

public class packagingOfGoods
{
    String name_pack;
    int mass_pack;
    public packagingOfGoods(String user_name_pack, int user_mass_pack)
    {
        this.name_pack = user_name_pack;
        this.mass_pack = user_mass_pack;
    }

    public String getName_pack() {
        return name_pack;
    }

    public int getMass_pack() {
        return mass_pack;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof packagingOfGoods that)) return false;
        return getMass_pack() == that.getMass_pack() && Objects.equals(getName_pack(), that.getName_pack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName_pack(), getMass_pack());
    }

    @Override
    public String toString() {
        return "Наименование упаковки:'" + name_pack + '\'' +
                ", масса упаковки:" + mass_pack;
    }
}