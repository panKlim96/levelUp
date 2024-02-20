import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson1 {
    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 4, 7, 7, 5, 10, 9};
        //Arrays.stream(removeDuplicates(array, 44)).forEach(i -> System.out.print(i + " "));
        System.out.println("NUM: " + unitsNumber(4528997));
    }

    int mediana(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);

        return a + b + c - min - max;
    }

    /**
     * [44, 34, 22, 1, 44, 44, 56, 32] найти вхождения 44
     * 1 итерация [44, 34, 22, 1, 44, 44, 56, 32]
     * 2 итерация [34, 22, 22, 1, 44, 44, 56, 32]
     * 3 итерация [34, 22, 1, 1, 44, 44, 56, 32]
     * 4 итерация [34, 22, 1, 1, 44, 44, 56, 32]
     * */
    static int[] removeDuplicates(int[] array, int targetNumber) {
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] != targetNumber) {
                array[j] = array[i];
                ++j;
            }
        }
        return array;
    }

    /**
     *  num = 3459
     *  first = 3459 % 10 = 9
     *  num = (3459 - 9) / 10 = 345
     *  second = 345 % 10 = 5
     *  num = (345 - 5) / 10 = 34
     *  third = 34 % 10 = 4
     *  num = (34 - 4) / 10 = 3
     *  fourth = 3 % 10 = 3
     *  num = 3 - 3
     */
    static int reverseNumber(int num) {
        int result = 0;
        List<Integer> numbers = new ArrayList<>();

        while (num != 0) {
            int curNum = num % 10;
            numbers.add(curNum);
            num = (num - curNum) / 10;
        }

        for (int i = 0; i < numbers.size(); i++) {
            result= (int) (result + numbers.get(i) * Math.pow(10 , (numbers.size() - 1 - i)));
        }

        return result;
    }

    static int equalFromMaxAndMin(int[] array) {
      IntSummaryStatistics intSummaryStatistics = Arrays.stream(array).summaryStatistics();
      int min = intSummaryStatistics.getMin();
      int max = intSummaryStatistics.getMax();
      int middle = (min + max) / 2;
        int previous = Integer.MAX_VALUE;
      int result = 0;

      for(int i = 0; i < array.length; i++) {
          if (min < array[i] && array[i] < max) {
              if (Math.abs(middle - array[i]) < previous
             ) {
                  previous = Math.abs(middle - array[i]);
                  result = array[i];
              }
          }
      }
      return result;
    }

    static int unitsNumber(int num) {
        int count = 0;
        while(num != 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }

        return count;
    }



}
