package phone;

import java.util.*;

/**
 * Search the phone directory
 */

public class PhoneBook {
    private static Map<String, ArrayList<String>> map = new HashMap<>();

    static {
        map.put("Иванов И.И.", new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 200 600")));
        map.put("Петров П.П.", new ArrayList<>(Arrays.asList("+8 800 2000 700")));
        map.put("петров п.п.", new ArrayList<>(Arrays.asList("+8 800 2000 600")));
        map.put("Сидоров С.С.", new ArrayList<>(Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000")));
        map.put("Gets D.", new ArrayList<>(Arrays.asList("+4 200 2000 800", "+4 500 2000 000")));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "utf-8");
        System.out.println("Enter Full name: ");
        String name = scanner.nextLine();

        printPhoneIgnoreCase(name);

    }

    /**
     * Method prints all the numbers in the exact name
     * if it does not find prints an error message
     * @param name the name that is searched for in the directory
     */
    public static void printPhone(String name) {

        if (map.containsKey(name)) {
            final int[] count = {1};
            map.get(name).forEach(number -> System.out.println((count[0]++) + ". " + number));
        } else {
            System.out.println("Full name not found");
        }
    }

    /**
     * Method prints all numbers ignoredcase
     * if it does not find prints an error message
     *
     * @param name the name that is searched for in the directory
     */
    public static void printPhoneIgnoreCase(String name) {
        boolean flag = false;
        final int[] count = {1};
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                entry.getValue().forEach(number -> System.out.println((count[0]++) + ". " + number));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Full name not found");
        }
    }


}

