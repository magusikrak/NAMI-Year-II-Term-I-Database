package sugamkarki;
import java.util.Scanner;
public class ArrayOperations {
    public static void main(String[] args) {
        // declares array
        int[] arr=new int[10];
        // asks to input numbers
        System.out.println("enter 10 numbers");
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=scan.nextInt();
        }
        // /asks search value
        System.out.println("enter a search value:");
        Scanner scan1=new Scanner(System.in);
        int searchVal=scan1.nextInt();
        int occurance=countOccurences(arr,searchVal);
        // prints occutances
        System.out.println("The number "+searchVal+" occurs "+occurance+" times in the array");
        int lastIndex=searchIndex(arr,searchVal);
        // prints index
        System.out.println("The last occurance of the number "+searchVal+" is at the index "+lastIndex);
        int sum=sumWithoutSmallest(arr);
        // prints sum without smallest
        System.out.println("the sum of array except the smallest is "+"\n"+sum);
    }

    private static int sumWithoutSmallest(int[] arr) {
        // 
        int total=0;
        int smallest=arr[0];
        // gets smallest
        for(int i=0;i<arr.length;i++)
        {
            if(smallest>arr[i])
            {
                smallest=arr[i];
            }
        }
        // adds the values
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]==smallest)
            {
                continue;
            }
            else
            {
                total+=arr[j];
            }
        }
        return total;
    }

    private static int searchIndex(int[] arr, int searchVal) {
        int index=0;
        // gets the last value of index
        for(int i= arr.length-1;i>=0;i--)
        {
            if(arr[i]==searchVal)
            {
                index=i;
                return i;
            }
        }
        if(index==0)
        {
            return -1;
        }
        // returns the index
        return index;

    }

    private static int countOccurences(int[] arr,int index) {
        int total=0;
        // counts the occurances
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==index)
            {
                total++;
            }
        }
        return total;
    }
}
