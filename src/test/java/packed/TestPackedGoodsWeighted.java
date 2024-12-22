package packed;

import org.example.goods.goodsWeighted;
import org.example.goods.packagingOfGoods;
import org.example.goods.packedGoodsWeighted;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPackedGoodsWeighted {

    @Test
    public void testPackedGoodsWeighted() {
        // Создание тестовых объектов
        goodsWeighted testGoods = new goodsWeighted("Товар", "Описание товара", 2.5);
        packagingOfGoods testPackaging = new packagingOfGoods("Коробка", 1);

        // Создание объекта packedGoodsWeighted
        packedGoodsWeighted packedGoods = new packedGoodsWeighted(testGoods, testPackaging);

        // Проверка расчета массы нетто
        assertEquals(2.5, packedGoods.getMassNet(), "Масса нетто должна быть равна весу товара.");

        // Проверка расчета массы брутто
        assertEquals(3.5, packedGoods.getMassGross(), "Масса брутто должна быть равна сумме массы упаковки и веса товара.");

        // Проверка метода toString
        String expectedString = " Наименование товара:'Товар'\n" +
                " Описание товара:'Описание товара'\n" +
                " Масса нетто:'2.5'\n" +
                " Масса брутто:'3.5'\n" +
                " Наименование упаковки:'Коробка'";
        assertEquals(expectedString, packedGoods.toString(), "Метод toString() должен возвращать корректное описание объекта.");

        // Проверка выброса исключений
        assertThrows(IllegalArgumentException.class, () ->
                new packedGoodsWeighted(null, testPackaging), "Ожидается исключение, если товар равен null.");

        assertThrows(IllegalArgumentException.class, () ->
                new packedGoodsWeighted(testGoods, null), "Ожидается исключение, если упаковка равна null.");

        assertThrows(IllegalArgumentException.class, () ->
                new packedGoodsWeighted(new goodsWeighted("Товар", "Описание", -1), testPackaging), "Ожидается исключение, если вес товара отрицательный.");

        assertThrows(IllegalArgumentException.class, () ->
                new packagingOfGoods("Пакет", -1), "Ожидается исключение, если масса упаковки отрицательная.");
    }
}
