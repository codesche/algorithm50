package sortalgoref;

// 힙 정렬
// 시간 복잡도 - O(N log N)
// 공간 복잡도 - O(1)
// 힙 자료구조 사용
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 최대 힙 구성
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n , i);
        }

        // 힙에서 하나씩 꺼내어 정렬
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 힙 재정렬
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }

    }

}
