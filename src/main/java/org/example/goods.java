package org.example;

import java.util.Objects;

public class goods
        //TODO:Класс «Товар».
        // Товар имеет название и описание (строки).
{
    String name_goods;
    String options_goods;

    public goods(String user_name_goods, String user_options_goods) {
        if (user_options_goods == null || user_options_goods.isEmpty()) {
            throw new NullPointerException("Должна быть строка, а не null!");
        } else {
            this.options_goods = user_options_goods;
        }
        //(user_options_goods == null || user_options_goods.isEmpty())
        if (user_name_goods == null || user_name_goods.isEmpty()) {
            throw new NullPointerException("Должна быть строка, а не null!");
        } else {
            this.name_goods = user_name_goods;
        }
    }

    public String getName_goods() {
        return name_goods;
    }

    public String getOptions_goods() {
        return options_goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Проверка типов
        goods goods_test = (goods) o;
        return Objects.equals(name_goods, goods_test.name_goods) &&
                Objects.equals(options_goods, goods_test.options_goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName_goods(), getOptions_goods());
    }

    @Override
    public String toString() {
        return "Товар: '" + name_goods + '\'' + '\n' +
                "Описание товара: '" + options_goods + '\'';
    }
}
