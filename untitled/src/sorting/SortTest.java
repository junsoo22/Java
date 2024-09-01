package sorting;

import java.io.IOException;

public class SortTest {
    public static void main(String[] args) throws IOException {
        System.out.println("정렬 방식을 선택하세요.");
        System.out.println("B: BubbleSort ");
        System.out.println("H: HeapSort ");
        System.out.println("Q: QuickSort ");

        int ch = System.in.read();
        Sort sort = null;

        if (ch == 'B' || ch == 'b') {
            sort = new BubbleSort();
        }
        else if (ch == 'H' || ch == 'h') {
            sort = new HeapSort();
        }
        else if (ch == 'Q' || ch == 'q') {
            sort = new QuickSort();
        }
        else {
            System.out.println("지원되지 않는 기능입니다.");
            return;
        }

        //정렬 방식과 상관없이 Sort에 선언된 메서드 호출
        int[] arr = new int[10];
        sort.ascending(arr);
        sort.descending(arr);
        sort.description();
    }
}

class BubbleSort implements Sort{

    @Override
    public void ascending(int[] arr) {
        System.out.println("BubbleSort ascending");
    }

    @Override
    public void descending(int[] arr) {
        System.out.println("BubbleSort descending");

    }

    @Override
    public void description() {
        System.out.println("숫자를 정렬하는 알고리즘입니다.");
        System.out.println("BubbleSort입니다.");

    }
}

class HeapSort implements Sort{
    @Override
    public void ascending(int[] arr) {
        System.out.println("HeapSort ascending");
    }

    @Override
    public void descending(int[] arr) {
        System.out.println("HeapSort descending");

    }

    @Override
    public void description() {
        System.out.println("숫자를 정렬하는 알고리즘입니다.");
        System.out.println("HeapSort입니다.");

    }
}

class QuickSort implements Sort{
    @Override
    public void ascending(int[] arr) {
        System.out.println("QuickSort ascending");
    }

    @Override
    public void descending(int[] arr) {
        System.out.println("QuickSort descending");

    }

    @Override
    public void description() {
        System.out.println("숫자를 정렬하는 알고리즘입니다.");
        System.out.println("QuickSort입니다.");

    }
}
