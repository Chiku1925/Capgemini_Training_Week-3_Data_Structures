public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {102, 45, 101, 67, 89};
        insertionSort(employeeIDs);
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
