public class Main {
    public static void main(String[] args) throws InterruptedException {
        //array declaration
        int size = 1000000;
        int[] mas = new int[size];

        //single thread sum calculation
        long singleThreadSum = 0;
        for (int i = 0; i < size; i++) {
            singleThreadSum += i;
            mas[i] = i;
        }
        System.out.println("Сума в однопоточному режимі:");
        System.out.println(singleThreadSum);

        //multi thread sum calculation
        int threadCount = 10;
        MainThread mainThread = new MainThread(mas, threadCount);
        mainThread.Start();
        System.out.println("Сума в багатопоточному режимі:");
        System.out.println(mainThread.getSum());
    }
}