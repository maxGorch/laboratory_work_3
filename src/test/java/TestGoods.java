import org.example.goods;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGoods {
    String test_str_empty = "";
    String test_str_null = null;

    @Test
    public void testGoods() {
        goods test = new goods("Товар", "Описание товара");
        goods test_duplicate = new goods("Товар", "Описание товара");

        //Проверка на работоспособность класса
        assertEquals(
                new goods("Товар", "Описание товара"),
                test,
                "Полученный товар должен быть с названием и описание"
        );
        //Проверка equals()
        assertEquals(test, test_duplicate, "Полученный товар должен быть равен дублированному");
        //Проверка hashCode()
        assertEquals(test.hashCode(), test_duplicate.hashCode(),"Полученный товар должен быть равен дублированному");


        assertThrows(NullPointerException.class, () ->
                //Проверка на значение null первой строки
                new goods(test_str_null, test_str_empty), "Expected: Передаваемая строчка не null!");
        assertThrows(NullPointerException.class, () ->
                //Проверка на значение null второй строки
                new goods(test_str_empty, test_str_null), "Expected: Передаваемая строчка не null!");
    }

}
