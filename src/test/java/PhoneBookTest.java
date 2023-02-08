import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Leonid Zulin
 * @date 04.02.2023 15:08
 */
public class PhoneBookTest {
    @Test
    public void testAdd1() {
        // проверка что у нас один контакт
        PhoneBook phoneBook = new PhoneBook();
        int expected = phoneBook.add("Лилия", "89090123763");
        int actual = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // проверка что у нас два контакта
    public void testAdd2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        int expected = phoneBook.add("Мария Тундра", "89119991158");
        int actual = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // проверка что у нас по прежнему два контакта, точнее результат не равен трём
    public void testAdd3() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        int expected = phoneBook.add("Мария Тундра", "88927622383");
        int actual = 3;
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    // проверка что у нас по прежнему точно только два контакта
    public void testAdd4() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        phoneBook.add("Лилия", "84445550926");
        int expected = phoneBook.add("Мария Тундра", "88927622383");
        int actual = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // Проверка что метод правильно возвращает имя по номеру телефона
    public void testFindByNumber1() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        phoneBook.add("Анатолий Касперчак", "89237637878");
        phoneBook.add("Ксения Мировая", "80909008651");
        phoneBook.add("Инопланетянин Кеша", "++K90233LF");
        String expected = phoneBook.findByNumber("80909008651");
        String actual = "Ксения Мировая";
        Assertions.assertSame(expected, actual);
    }

    @Test
    // Проверка что метод не вернёт нуль, если номер существует
    public void testFindByNumber2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        phoneBook.add("Анатолий Касперчак", "89237637878");
        phoneBook.add("Ксения Мировая", "80909008651");
        phoneBook.add("Инопланетянин Кеша", "++K90233LF");
        String expected = phoneBook.findByNumber("89237637878");
        String actual = null;
        Assertions.assertNotSame(expected, actual);
    }

    @Test
    // проверка поиска по имени, несоответсвие
    public void testFindByName1() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        phoneBook.add("Анатолий Касперчак", "89237637878");
        phoneBook.add("Ксения Мировая", "80909008651");
        phoneBook.add("Инопланетянин Кеша", "++K90233LF");
        phoneBook.add("Феликс Романовский", "89057638123");
        String expected = phoneBook.findByName("Феликс Романовский");
        String actual = "80909008651";
        Assertions.assertNotSame(expected, actual);
    }

    @Test
    // проверка поиска по имени
    public void testFindByName2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лилия", "89090123763");
        phoneBook.add("Мария Тундра", "89119991158");
        phoneBook.add("Анатолий Касперчак", "89237637878");
        phoneBook.add("Ксения Мировая", "80909008651");
        phoneBook.add("Инопланетянин Кеша", "++K90233LF");
        phoneBook.add("Феликс Романовский", "89057638123");
        String expected = phoneBook.findByName("Инопланетянин Кеша");
        String actual = "++K90233LF";
        Assertions.assertSame(expected, actual);
    }

}
