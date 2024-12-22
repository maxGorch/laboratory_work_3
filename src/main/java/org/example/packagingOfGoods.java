package org.example;

import java.util.Objects;

public class packagingOfGoods
        //TODO:Класс «Упаковка товара»
        // Упаковка имеет название и массу в кг (собственная масса упаковки).
{
    String name_pack;
    int mass_pack;

    public packagingOfGoods(String user_name_pack, int user_mass_pack) {
        if(user_name_pack == null || user_name_pack.isEmpty())
        {
            throw  new NullPointerException("Должна быть строка, а не null!");
        }else this.name_pack = user_name_pack;
        if(user_mass_pack < 0)
        {
            throw new IllegalArgumentException("Масса должна быть положительной!");
        }else this.mass_pack = user_mass_pack;
    }

    public String getName_pack() {
        return name_pack;
    }

    public int getMass_pack() {
        return mass_pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}// Проверка на идентичность ссылок
        if (o == null || getClass() != o.getClass()) {return false;}// Тип проверки
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