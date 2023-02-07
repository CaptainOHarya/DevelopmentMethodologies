import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Leonid Zulin
 * @date 04.02.2023 15:08
 */
public class PhoneBook {
    private Map<String, String> phoneGuide = new TreeMap<>();
    public int add(String name, String number) {
        phoneGuide.put(name, number);
        return phoneGuide.size();
    }
}
