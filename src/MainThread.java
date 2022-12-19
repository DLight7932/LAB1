public class MainThread {
    private long sum;
    private int threadCount;
    private int currThreadCount = 0;
    private int[] mas;

    MainThread(int[] mas_, int threadCount_)
    {
        mas = mas_;
        threadCount = threadCount_;
        sum = 0;
    }

    public long getSum()
    {
        return sum;
    }

    synchronized public void Start(){
        //variables preparation
        int[] firstElements = new int[threadCount];
        int[] lastElements = new int[threadCount];

        for (int i = 0; i < threadCount; i++)
            firstElements[i] = mas.length / threadCount * i;
        for (int i = 0; i < threadCount - 1; i++)
            lastElements[i] = firstElements[i + 1] - 1;

        lastElements[threadCount - 1] = mas.length - 1;

        //thread starting
        for (int i = 0; i < threadCount; i++)
            new Thread(new SumCalculatorWithInterface(this, mas, firstElements[i], lastElements[i])).start();

        //waiting for threads to finish
        while (currThreadCount < threadCount){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized public void setPartSum(long partSum){
        sum = sum + partSum;
        currThreadCount++;
        notify();
    }
}