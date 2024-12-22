package org.example;

public class packedGoodsWeighted
        //TODO: Класс «Упакованный весовой товар» содержит
        // упаковку и некоторое количество весового товара (в кг).
{
    private final goodsWeighted default_goodsWeighted;
    private final packagingOfGoods default_packagingOfGoods;

    public packedGoodsWeighted(goodsWeighted user_goodsWeighted, packagingOfGoods user_packagingOfGoods) {
        this.default_goodsWeighted = user_goodsWeighted;
        this.default_packagingOfGoods = user_packagingOfGoods;
    }

    public double getMassNet() {
        return default_goodsWeighted.getWeight();
    }

    public double getMassGross() {
        return default_packagingOfGoods.getMass_pack() + default_goodsWeighted.getWeight();
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
