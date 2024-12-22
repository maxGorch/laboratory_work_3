package org.example.goods;

public class packedGoodsPiece extends goodPiece
//TODO: Класс «Упакованный штучный товар» содержит упаковку и несколько единиц штучного товара. Методы:
// получить количество штук товара,
// получить массу нетто  (суммарный вес всех единиц товара)
// и массу брутто (упаковки и всех единиц товара  вместе).
{
    int amount_piece;
    packagingOfGoods default_packaging_of_good;
    goodPiece default_good_piece;

    public packedGoodsPiece(packagingOfGoods user_packaging_of_good, goodPiece user_good_piece, int amount_piece) {
        super(user_good_piece.getName_goods(), user_good_piece.getOptions_goods(), user_good_piece.getWeight_piece() * amount_piece);

        if (user_packaging_of_good == null) {
            throw new IllegalArgumentException("Упаковка не может быть null.");
        }
        if (amount_piece <= 0) {
            throw new IllegalArgumentException("Количество единиц товара должно быть больше нуля.");
        }

        this.default_packaging_of_good = user_packaging_of_good;
        this.default_good_piece = user_good_piece;
        this.amount_piece = amount_piece;
    }

    public double getAmountGoods() {
        return amount_piece;
    }

    public double getMassNet() {
        return default_good_piece.getWeight_piece() * amount_piece;
    }

    public double getMassGross() {
        return getMassNet() + default_packaging_of_good.getMass_pack()* amount_piece;
    }

    @Override
    public String toString() {
        return " Наименование товара:'" + default_good_piece.getName_goods() + '\'' + '\n' +
                " Описание товара:'" + default_good_piece.getOptions_goods() + '\'' + '\n' +
                " Масса нетто:'" + getMassNet() + '\'' + '\n' +
                " Масса брутто:'" + getMassGross() + '\'' + '\n' +
                " Наименование упаковки:'" + default_packaging_of_good.getName_pack() + '\'';
    }
}
