import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class FindMaxNumber {

    private static int[] readFileToArray(File file) {
        int[] result = new int[10000];
        try (Scanner s = new Scanner(file)) {
            int i = 0;
            while (s.hasNextInt()) {
                result[i++] = s.nextInt();
            }
        } catch (FileNotFoundException e) {
        }
        return result;
    }

    private static int countOfEven(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static LinkedHashMap<Integer, String> readInMapFromTwoColumn(File file) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                map.put(s.nextInt(), s.next().replace(",", ""));
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static long getYearOfLargestIncrase(LinkedHashMap<Integer, String> map) {
        long maximum = 0;
        int year = 1900;
        List<Integer> keys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            keys.add(key);
        }
        for (int i = 1; i < keys.size(); i++) {
            long increase = Long.parseLong(map.get(keys.get(i))) - Long.parseLong(map.get(keys.get(i - 1)));
            System.out.println(keys.get(i) + "---" + increase);
            if (increase > maximum) {
                maximum = increase;
                year = keys.get(i);
            }
        }
        System.out.println(year + " " + maximum);
        return year;
    }

    public static void main(String[] args) {
       /* File file = new File("C:\\Users\\Саша\\IdeaProjects\\HelloWorld\\dataset_91007.txt");
        File file2 = new File("C:\\Users\\Саша\\IdeaProjects\\HelloWorld\\dataset_91022.txt");
        File file3 = new File("C:\\Users\\Саша\\IdeaProjects\\HelloWorld\\dataset_91065.txt");
        File file4 = new File("C:\\Users\\Саша\\IdeaProjects\\HelloWorld\\dataset_91033.txt");
        File file5 = new File("C:\\Users\\Саша\\IdeaProjects\\HelloWorld\\dataset_91069.txt");*/
        File file = new File("./data", "dataset_91007.txt");
        File file2 = new File("./data", "dataset_91022.txt");
        File file3 = new File("./data", "dataset_91065.txt");
        File file4 = new File("./data", "dataset_91033.txt");
        File file5 = new File("./data", "dataset_91069.txt");
        int max = Arrays.stream(readFileToArray(file))
                .max()
                .getAsInt();
        long count = Arrays.stream(readFileToArray(file2))
                .filter(value -> value >= 9999)
                .count();
        long countOfEven = countOfEven(readFileToArray(file3));
        long sum = Arrays.stream(readFileToArray(file4))
                .sum();
        System.out.println(max);
        System.out.println(count);
        System.out.println(countOfEven);
        System.out.println(sum);
        readInMapFromTwoColumn(file5);
        getYearOfLargestIncrase(readInMapFromTwoColumn(file5));

    }
}
