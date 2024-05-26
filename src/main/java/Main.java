import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    // Here
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IOException();
        }

        String filePath = args[0];
        String operation = args[1];

        try {
            ArrayList<Long> numbers = readFile(filePath);

            long result = switch (operation) {
                case "min" -> findMin(numbers);
                case "max" -> findMax(numbers);
                case "sum" -> findSum(numbers);
                case "product" -> findProduct(numbers);
                default -> throw new IOException();
            };

            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Run this program with 2 arguments: filepath and operation (min, max, sum, product)");
        }
    }

    static ArrayList<Long> readFile(String pathname) throws IOException {
        File file = new File(pathname);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<Long> numbers = Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toCollection(ArrayList::new));

        reader.close();

        return numbers;
    }

    static long findMin(ArrayList<Long> numbers) {
        return Collections.min(numbers);
    }

    static long findMax(ArrayList<Long> numbers) {
        return Collections.max(numbers);
    }

    static long findSum(ArrayList<Long> numbers) {
        return numbers.stream().mapToLong(Long::longValue).sum();
    }

    static long findProduct(ArrayList<Long> numbers) {
        return numbers.stream().reduce(1L, (a, b) -> a * b);
    }
}