package packed;

import org.example.goods.goodPiece;
import org.example.goods.packagingOfGoods;
import org.example.goods.packedGoodsPiece;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPackedGoodsPiece {
    @Test
    public void testPackedGoodsPiece() {
        // Создаем объекты для тестов
        packagingOfGoods test_packaging = new packagingOfGoods("Коробка", 1.5);
        goodPiece test_good = new goodPiece("Шоколад", "Молочный шоколад", 0.2);

        // Проверка корректной работы конструктора и методов
        packedGoodsPiece test = new packedGoodsPiece(test_packaging, test_good, 5);

        assertEquals(
                5,
                test.getAmountGoods(),
                "Количество товара должно совпадать с заданным"
        );

        assertEquals(
                1.0,
                test.getMassNet(),
                "Масса нетто должна быть равна суммарному весу всех единиц товара"
        );

        assertEquals(
                2.5,
                test.getMassGross(),
                "Масса брутто должна быть равна сумме массы нетто и упаковки"
        );

        // Проверка исключений
        assertThrows(IllegalArgumentException.class, () ->
                        new packedGoodsPiece(null, test_good, 5),
                "Expected: Упаковка не может быть null"
        );

        assertThrows(NullPointerException.class, () ->
                        new packedGoodsPiece(test_packaging, null, 5),
                "Expected: Товар не может быть null"
        );

        assertThrows(IllegalArgumentException.class, () ->
                        new packedGoodsPiece(test_packaging, test_good, 0),
                "Expected: Количество товара должно быть больше нуля"
        );

        assertThrows(IllegalArgumentException.class, () ->
                        new packedGoodsPiece(test_packaging, test_good, -1),
                "Expected: Количество товара должно быть больше нуля"
        );
    }
}
