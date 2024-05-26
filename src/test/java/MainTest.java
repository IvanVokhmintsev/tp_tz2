import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findMin() {
        ArrayList<Long> list = getRandomList(100);
        long min = Main.findMin(list);
        assertEquals(1, min);
    }

    @Test
    void findMax() {
        ArrayList<Long> list = getRandomList(100);
        long max = Main.findMax(list);
        assertEquals(100, max);
    }

    @Test
    void findSum() {
        ArrayList<Long> list = getRandomList(100);
        long sum = Main.findSum(list);
        assertEquals(5050, sum);
    }

    @Test
    void findProduct() {
        ArrayList<Long> list = getRandomList(10);
        long product = Main.findProduct(list);
        assertEquals(3628800, product);
    }

    ArrayList<Long> getRandomList(int n) {
        ArrayList<Long> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add((long) i);
        }
        Collections.shuffle(list);

        return list;
    }

    @Test
    void readFile() throws IOException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        ArrayList<Long> got = Main.readFile("src/test/java/input.txt");
        ArrayList<Long> expected = new ArrayList<>(Arrays.asList(1L, 9L, 7L, 8L, 4L, 28L));

        assertArrayEquals(got.toArray(), expected.toArray());
    }

}