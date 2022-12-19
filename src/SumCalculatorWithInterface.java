public class SumCalculatorWithInterface implements Runnable {
    long partSum = 0;
    int[] mas;
    int begin, end;
    MainThread mainThread;

    SumCalculatorWithInterface(MainThread mainThread_, int[] mas, int partStart, int partEnd) {
        this.mas = mas;
        begin = partStart;
        end = partEnd;
        mainThread = mainThread_;
    }

    @Override
    public void run() {
        for (int i = begin; i <= end; i++) {
            partSum = partSum + mas[i];
        }
        mainThread.setPartSum(partSum);
    }
}