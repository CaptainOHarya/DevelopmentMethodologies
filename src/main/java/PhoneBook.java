import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Leonid Zulin
 * @date 04.02.2023 15:08
 */
public class PhoneBook {
    private Map<String, String> phoneGuide = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Введите имя и через запятую его номер (для завершения ввода введите 'нет')");
            String input = scanner.nextLine();
            if (input.equals("нет"))
                break;
            String[] contactData = input.split(",\\s+");
            count = phoneBook.add(contactData[0], contactData[1]);
            System.out.println(count);
        }

        while (true) {
            System.out.println("Введите номер, чьё имя хотите найти (для завершения ввода введите 'нет')");
            String input = scanner.nextLine();
            if (input.equals("нет"))
                break;
            String number = phoneBook.findByNumber(input);
            System.out.println(number);
        }

        while (true) {
            System.out.println("Введите имя чей номер хотите найти (для завершения ввода введите 'нет')");
            String input = scanner.nextLine();
            if (input.equals("нет"))
                break;
            String name = phoneBook.findByName(input);
            System.out.println(name);
        }
        scanner.close();
        System.out.println(phoneBook.printAllNames());

    }

    public int add(String name, String number) {
        phoneGuide.put(name, number);
        return phoneGuide.size();
    }

    public String findByNumber(String number) {
        for (Map.Entry<String, String> entry : phoneGuide.entrySet()) {
            if (entry.getValue().equals(number))
                return entry.getKey();
        }
        return null;
    }

    public String findByName(String name) {
        return phoneGuide.get(name);
    }

    public Object[] printAllNames() {
        Object[] arrayName = phoneGuide.keySet().toArray();
        return arrayName;
    }
}
