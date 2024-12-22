package goods;

import org.example.goods.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TestGoodsBatch {

    // Тестовые данные
    packagingOfGoods packaging1 = new packagingOfGoods("Упаковка 1", 500); // 500 грамм упаковки
    packagingOfGoods packaging2 = new packagingOfGoods("Упаковка 2", 300); // 300 грамм упаковки
    goodPiece goodPiece1 = new goodPiece("Товар 1", "Описание 1", 1.5); // 1.5 кг штучного товара
    goodPiece goodPiece2 = new goodPiece("Товар 2", "Описание 2", 0.8); // 0.8 кг штучного товара
    goodsWeighted goodsWeighted1 = new goodsWeighted("Весовой товар 1", "Описание весового товара 1", 2.0); // 2 кг весового товара

    @Test
    public void testBatchOfGoods() {
        // Создаем упакованные товары
        packedGoodsPiece packedPiece1 = new packedGoodsPiece(packaging1, goodPiece1, 3); // 3 штучных товара
        packedGoodsPiece packedPiece2 = new packedGoodsPiece(packaging2, goodPiece2, 5); // 5 штучных товаров
        packedGoodsWeighted packedWeighted1 = new packedGoodsWeighted(goodsWeighted1, packaging1); // 1 весовой товар

        // Создаем партию товаров с данными товарами
        goodsBatch batch = new goodsBatch("Партия 1",
                Arrays.asList(packedPiece1, packedPiece2),
                List.of(packedWeighted1));

        // Проверка метода getTotalGrossMass
        // Масса брутто:
        // 3 шт * (1.5 кг + 0.5 кг упаковка) = 6.0 кг
        // 5 шт * (0.8 кг + 0.3 кг упаковка) = 5.5 кг
        // 1 шт * (2.0 кг + 0.5 кг упаковка) = 2.5 кг
        // Сумма: 6.0 кг + 5.5 кг + 2.5 кг = 14.0 кг
        assertEquals(14.0, batch.getTotalGrossMass(), "Суммарная масса брутто должна быть 14.0 кг");

        // Проверка на пустое описание партии
        assertThrows(IllegalArgumentException.class, () ->
                        new goodsBatch("", List.of(packedPiece1), List.of(packedWeighted1)),
                "Описание партии не может быть пустым"
        );

        // Проверка на null в списке товаров
        assertThrows(NullPointerException.class, () ->
                        new goodsBatch("Партия 2", null, List.of(packedWeighted1)),
                "Список упакованных товаров не может быть null"
        );

        // Проверка на null упаковки товара
        assertThrows(NullPointerException.class, () ->
                        new goodsBatch("Партия 3", List.of(packedPiece1), null),
                "Список упакованных весовых товаров не может быть null"
        );
    }
}
