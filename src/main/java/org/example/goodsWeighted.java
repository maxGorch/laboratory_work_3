package org.example;

import java.util.Objects;

public class goodsWeighted extends goods
        //TODO:Класс «Весовой товар».
        // Весовой товар хранит название и описание.
{
    double weight;

    public goodsWeighted(String user_name_goods, String user_option_goods, double user_weight) {
        super(user_name_goods, user_option_goods);
        if(weight < 0 )
        {
            throw new IllegalArgumentException("Масса должна быть положительной");
        } else this.weight = user_weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof goodsWeighted that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight(), that.getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight());
    }


    @Override
    public String toString() {
        return "Товар: '" + name_goods + '\'' + '\n' +
                "Описание товара: '" + options_goods + '\'' + '\n' +
                "Вес товара: '" + weight + '\'';
    }
}
