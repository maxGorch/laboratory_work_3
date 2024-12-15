package org.example;

import java.util.Objects;

public class goodPiece extends goods
//Штучный товар хранит название, описание и вес одной штуки товара (в кг).
// Должен быть конструктор по всем трем полям.
{
    double weight_piece ;
    public goodPiece(String user_name_goods, String user_options_goods, int user_weight_piece) {
        super(user_name_goods, user_options_goods);
        this.weight_piece = user_weight_piece;
    }

    public double getWeight_piece() {
        return weight_piece;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof goodPiece goodPiece)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getWeight_piece(), goodPiece.getWeight_piece()) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight_piece());
    }

    @Override
    public String toString() {
        return "================Весовой Товар==============\n"+
                "Товар: '" + name_goods + '\'' + '\n' +
                "Описание товара: '" + options_goods + '\'' + '\n'+
                "Вес товара: '" + weight_piece + '\'';
    }
}
