package org.example.goods;


public class packedGoodsWeighted
        //TODO: Класс «Упакованный весовой товар» содержит
        // упаковку и некоторое количество весового товара (в кг).
{
    final goodsWeighted default_goodsWeighted;
    private final packagingOfGoods default_packagingOfGoods;

    public packedGoodsWeighted(goodsWeighted user_goodsWeighted, packagingOfGoods user_packagingOfGoods) {
        if (user_goodsWeighted == null) {
            throw new IllegalArgumentException("Весовой товар не может быть null.");
        }
        if (user_packagingOfGoods == null) {
            throw new IllegalArgumentException("Упаковка не может быть null.");
        }
        if (user_goodsWeighted.getWeight() <= 0) {
            throw new IllegalArgumentException("Вес товара должен быть положительным.");
        }
        if (user_packagingOfGoods.getMass_pack() < 0) {
            throw new IllegalArgumentException("Масса упаковки не может быть отрицательной.");
        }

        this.default_goodsWeighted = user_goodsWeighted;
        this.default_packagingOfGoods = user_packagingOfGoods;
    }

    public double getMassNet() {
        return default_goodsWeighted.getWeight();
    }

    public double getMassGross() {
        return getMassNet() + default_packagingOfGoods.getMass_pack();
    }



    @Override
    public String toString() {
        return " Наименование товара:'" + default_goodsWeighted.getName_goods() + '\'' + '\n' +
                " Описание товара:'" + default_goodsWeighted.getOptions_goods() + '\'' + '\n' +
                " Масса нетто:'" + getMassNet() + '\'' + '\n' +
                " Масса брутто:'" + getMassGross() + '\'' + '\n' +
                " Наименование упаковки:'" + default_packagingOfGoods.getName_pack() + '\'';
    }
}
