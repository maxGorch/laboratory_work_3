package org.example.goods;

import org.example.filter.Filter;

public class goodsService {
/*
    public static void main(String[] args) {
        packagingOfGoods packaging1 = new packagingOfGoods("Упаковка 1", 500); // 500 грамм упаковки
        packagingOfGoods packaging2 = new packagingOfGoods("Упаковка 2", 300); // 300 грамм упаковки
        goodPiece goodPiece1 = new goodPiece("124435", "Описание 1", 1.5); // 1.5 кг штучного товара
        goodPiece goodPiece2 = new goodPiece("51234255345", "Описание 2", 0.8); // 0.8 кг штучного товара
        goodsWeighted goodsWeighted1 = new goodsWeighted("Весовой товар 1", "Описание весового товара 1", 2.0); // 2 кг весового товара

            // Создаем упакованные товары
            packedGoodsPiece packedPiece1 = new packedGoodsPiece(packaging1, goodPiece1, 3); // 3 штучных товара
            packedGoodsPiece packedPiece2 = new packedGoodsPiece(packaging2, goodPiece2, 5); // 5 штучных товаров
            packedGoodsWeighted packedWeighted1 = new packedGoodsWeighted(goodsWeighted1, packaging1); // 1 весовой товар

            // Создаем партию товаров с данными товарами
            goodsBatch batch = new goodsBatch("Партия 1",
                    Arrays.asList(packedPiece1, packedPiece2),
                    List.of(packedWeighted1));
        // Создание фильтра
        Filter filter = new beginStringFilter("12");

        // Создание экземпляра GoodsService
        goodsService service = new goodsService();

        // Применяем фильтр и выводим результат
        int result = service.countByFilter(batch, filter);
        System.out.println("Количество товаров, соответствующих фильтру: " + result);
    }
*/

    // Метод для подсчета товаров, удовлетворяющих фильтру
    public int countByFilter(goodsBatch batch, Filter filter) {
        int count = 0;

        // Перебираем все товары в партии
        for (Object item : batch.getPackedGoodsWeighted()) {
            String itemName = null;

            if (item instanceof packedGoodsWeighted) {
                itemName = ((packedGoodsWeighted) item).default_goodsWeighted.getName_goods();
            }
            // Если товар просто товар (goods)
            else if (item instanceof goods) {
                itemName = ((goods) item).getName_goods();
            }
            // Если имя товара не пустое и фильтр удовлетворяет условию, увеличиваем счетчик
            if (itemName != null && filter.apply(itemName)) {
                count++;
            }
        }
        for (packedGoodsPiece item : batch.getPackedGoodsPieces()) {
            String itemName = null;

            if (item != null) {
                itemName = item.default_good_piece.getName_goods();
            }
            // Если имя товара не пустое и фильтр удовлетворяет условию, увеличиваем счетчик
            if (itemName != null && filter.apply(itemName)) {
                count++;
            }
        }

        return count;
    }
}
