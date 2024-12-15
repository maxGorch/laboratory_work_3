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
        if (this == o) return true; // Проверка на идентичность ссылок
        if (o == null || getClass() != o.getClass()) return false; // Тип проверки
        packagingOfGoods that = (packagingOfGoods) o; // Приведение типов
        return mass_pack == that.mass_pack && Objects.equals(name_pack, that.name_pack);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName_pack(), getMass_pack());
    }
    @Override
    public String toString() {
        return "Наименование упаковки: '" + name_pack + '\'' + '\n' +
                "Масса упаковки: " + mass_pack + " г";
    }
}