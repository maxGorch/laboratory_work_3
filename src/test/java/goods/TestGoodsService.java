package goods;

import org.example.filter.*;
import org.example.goods.*;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGoodsService {

    @Test
    public void testCountByFilter() {
        // Создание партии товаров
        goodsBatch batchOfGoods = getGoodsBatch();

        // Создание сервиса товаров
        goodsService goodsService = new goodsService();

        // Применение фильтра, который проверяет, что имя товара начинается с "Товар"
        beginStringFilter beginFilter = new beginStringFilter("Товар");
        int result1 = goodsService.countByFilter(batchOfGoods, beginFilter);
        assertEquals(1, result1, "Количество товаров, начинающихся с 'Товар', должно быть 1");

        // Применение фильтра, который проверяет, что имя товара содержит подстроку "Special"
        containsStringFilter containsFilter = new containsStringFilter("Special");
        int result2 = goodsService.countByFilter(batchOfGoods, containsFilter);
        assertEquals(1, result2, "Количество товаров, содержащих 'Special', должно быть 1");

        // Применение фильтра, который проверяет, что имя товара заканчивается на "2"
        endStringFilter endFilter = new endStringFilter("2");
        int result3 = goodsService.countByFilter(batchOfGoods, endFilter);
        assertEquals(1, result3, "Количество товаров, заканчивающихся на '2', должно быть 1");

        // Проверка, что метод возвращает 0 для пустого фильтра (например, товары, которых нет)
        beginStringFilter emptyFilter = new beginStringFilter("НеСуществует");
        int result4 = goodsService.countByFilter(batchOfGoods, emptyFilter);
        assertEquals(0, result4, "Количество товаров, начинающихся с 'НеСуществует', должно быть 0");
    }

    private static goodsBatch getGoodsBatch() {
        packagingOfGoods packaging1 = new packagingOfGoods("Коробка", 0.5);
        goodPiece goodPiece1 = new goodPiece("Special Штучный товар", "Описание штучного товара", 1);
        packedGoodsPiece pieceGoods = new packedGoodsPiece(packaging1, goodPiece1, 3);

        goodsWeighted weightedGoods1 = new goodsWeighted("Товар весовой2", "Описание весового товара", 5);
        return getGoodsBatch(weightedGoods1, pieceGoods);
    }

    private static goodsBatch getGoodsBatch(goodsWeighted weightedGoods1, packedGoodsPiece pieceGoods) {
        packagingOfGoods packaging2 = new packagingOfGoods("Пакет", 0.3);
        packedGoodsWeighted weightedGoods = new packedGoodsWeighted(weightedGoods1, packaging2);

        // Создание списка упакованных товаров
        List<packedGoodsPiece> packedGoodsPieces = List.of(pieceGoods);
        List<packedGoodsWeighted> packedGoodsWeighted = List.of(weightedGoods);

        // Создание партии товаров
        return new goodsBatch("Партия товаров", packedGoodsPieces, packedGoodsWeighted);
    }

    // Дополнительный тест на исключения
    @Test
    public void testInvalidFilter() {
        assertThrows(IllegalArgumentException.class, () ->
                new beginStringFilter(null), "Filter pattern не может быть null");
    }
}
