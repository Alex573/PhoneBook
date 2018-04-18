package phone;

import java.util.*;

public class PhoneBook {
    private static Map<String, ArrayList<String>> map = new HashMap<>();

    static {
        map.put("Иванов И.И.", new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 200 600")));
        map.put("Петров П.П.", new ArrayList<>(Arrays.asList("+8 800 2000 700")));
        map.put("Сидоров С.С.", new ArrayList<>(Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000")));
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Enter Full name: ");
        String name = scanner.nextLine();

        printPhone(name);

    }

    private static void printPhone(String name){

        if (map.containsKey(name)) {
            final int[] count = {1};
            map.get(name).forEach(number -> System.out.println((count[0]++) + ". " + number));

        } else {
            System.out.println("Full name not exist");
        }
    }
}
