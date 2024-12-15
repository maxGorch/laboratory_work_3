package org.example;

import java.util.Objects;

public class goods
{
    String name_goods;
    String options_goods;

    public goods(String user_name_goods ,String user_options_goods)
    {
        this.options_goods = user_options_goods;
        this.name_goods = user_name_goods;
    }

    public String getName_goods() {
        return name_goods;
    }
    public String getOptions_goods() {
        return options_goods;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof goods goods)) return false;
        return Objects.equals(getName_goods(), goods.getName_goods()) && Objects.equals(getOptions_goods(), goods.getOptions_goods());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName_goods(), getOptions_goods());
    }
    @Override
    public String toString() {
        return "================Товар======================\n"+
                "Товар: '" + name_goods + '\'' +'\n' +
                "Описание товара: '" + options_goods + '\'';
    }
}
