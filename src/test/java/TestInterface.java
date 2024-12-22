import org.example.filter.*;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestInterface {

    @Test
    public void testBeginStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки начала строки
        beginStringFilter beginFilter1 = new beginStringFilter("Мама");
        beginStringFilter beginFilter2 = new beginStringFilter("мыла");

        // Проверяем, что фильтр правильно работает
        assertTrue(beginFilter1.apply(str), "Строка должна начинаться с 'Мама'");
        assertFalse(beginFilter2.apply(str), "Строка не должна начинаться с 'мыла'");
    }

    @Test
    public void testEndStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки конца строки
        endStringFilter endFilter1 = new endStringFilter("раму");
        endStringFilter endFilter2 = new endStringFilter("мыла");

        // Проверяем, что фильтр правильно работает
        assertTrue(endFilter1.apply(str), "Строка должна заканчиваться на 'раму'");
        assertFalse(endFilter2.apply(str), "Строка не должна заканчиваться на 'мыла'");
    }

    @Test
    public void testContainsStringFilter() {
        String str = "Мама мыла раму";

        // Создаем фильтр для проверки наличия подстроки
        containsStringFilter containsFilter1 = new containsStringFilter("мыла");
        containsStringFilter containsFilter2 = new containsStringFilter("папа");

        // Проверяем, что фильтр правильно работает
        assertTrue(containsFilter1.apply(str), "Строка должна содержать 'мыла'");
        assertFalse(containsFilter2.apply(str), "Строка не должна содержать 'папа'");
    }

    @Test
    public void testFilterNullPattern() {
        // Проверяем, что при передаче null в конструктор фильтра выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> new beginStringFilter(null), "Pattern не может быть null");
        assertThrows(IllegalArgumentException.class, () -> new endStringFilter(null), "Pattern не может быть null");
        assertThrows(IllegalArgumentException.class, () -> new containsStringFilter(null), "Pattern не может быть null");
    }
}

