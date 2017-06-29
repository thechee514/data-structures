/**
 * Be sure to test your code out with various different binary trees. A sample
 * of one is below.
 * 
 * @author Chris Fernandes, Linda Almstead, Aaron Cass
 * @version 11/8/2008
 */

public class Client
{
    public static void main(String[] args)
    {
        Client tester = new Client();

        tester.testHeap();
        tester.testSorter();
    }

    public void testHeap()
    {
        int[] anArray = { 9, 12, 5, 1, 23, 33, 9, 21, 14, 10 };

        System.out.println("before building heap:");
        printArray(anArray);

        Heap sample = new Heap(anArray);

        System.out.println("\nafter building heap:");
        System.out.println(sample);
        
        int[] oneElementArray = { 1 };
        
        System.out.println("before building heap:");
        printArray(oneElementArray);
        
        sample = new Heap(oneElementArray);

        System.out.println("\nafter building heap:");
        System.out.println(sample);
        
        int[] orderArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        System.out.println("before building heap:");
        printArray(orderArray);
        
        sample = new Heap(orderArray);

        System.out.println("\nafter building heap:");
        System.out.println(sample);
        
        int[] backwardsArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        
        System.out.println("before building heap:");
        printArray(backwardsArray);
        
        sample = new Heap(backwardsArray);

        System.out.println("\nafter building heap:");
        System.out.println(sample);
        

    }

    public void testSorter()
    {
        int[] anArray = { 9, 12, 5, 1, 23, 33, 9, 21, 14, 10 };

        System.out.println("\nbefore sorting:");
        printArray(anArray);

        Sorter mysorter = new Sorter();
        mysorter.priorityQueueSort(anArray);

        System.out.println("\nafter sorting:");
        System.out.println(mysorter);
        
        
        int[] oneElementArray = { 1 };
        
        System.out.println("\nbefore sorting:");
        printArray(oneElementArray);
        
        mysorter = new Sorter();
        mysorter.priorityQueueSort(oneElementArray);

        System.out.println("\nafter sorting:");
        System.out.println(mysorter);
        
        
        int[] orderArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        System.out.println("\nbefore sorting:");
        printArray(orderArray);

        mysorter = new Sorter();
        mysorter.priorityQueueSort(orderArray);

        System.out.println("\nafter sorting:");
        System.out.println(mysorter);
        
        
        int[] backwardsArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        
        System.out.println("\nbefore sorting:");
        printArray(backwardsArray);
        
        mysorter = new Sorter();
        mysorter.priorityQueueSort(backwardsArray);

        System.out.println("\nafter sorting:");
        System.out.println(mysorter);
    }

    private void printArray(int[] array)
    {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[len - 1]);
    }
}
