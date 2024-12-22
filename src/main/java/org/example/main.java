package org.example;

import org.example.filter.beginStringFilter;
import org.example.goods.*;

public class main {
    //    public static void main(String[] args) {
//        String str = "Мама мыла раму";
//
//        beginStringFilter filter1 = new beginStringFilter("Мама");
//        beginStringFilter filter2 = new beginStringFilter("мыла");
//
//        boolean res1 = filter1.apply(str); // true
//        boolean res2 = filter2.apply(str); // false
//
//        System.out.println(res1); // true
//        System.out.println(res2); // false
//    }
    public static void main(String[] args) {
        packagingOfGoods packaging1 = new packagingOfGoods("Упаковка 1", 500); // 500 грамм упаковки
        packagingOfGoods packaging2 = new packagingOfGoods("Упаковка 2", 300); // 300 грамм упаковки
        goodPiece goodPiece1 = new goodPiece("Товар 1", "Описание 1", 1.5); // 1.5 кг штучного товара
        goodPiece goodPiece2 = new goodPiece("Товар 2", "Описание 2", 0.8); // 0.8 кг штучного товара
        goodsWeighted goodsWeighted1 = new goodsWeighted("Весовой товар 1", "Описание весового товара 1", 2.0); // 2 кг весового товара

        // Создаем упакованные товары
        packedGoodsPiece packedPiece1 = new packedGoodsPiece(packaging1, goodPiece1, 3); // 3 штучных товара
        packedGoodsPiece packedPiece2 = new packedGoodsPiece(packaging2, goodPiece2, 5); // 5 штучных товаров
        packedGoodsWeighted packedWeighted1 = new packedGoodsWeighted(goodsWeighted1, packaging1);

        System.out.println(packedPiece1);
        System.out.println("========================================");
        System.out.println(packedPiece2);
        System.out.println("========================================");
        System.out.println(packedWeighted1);
    }
}

