package BasicAlgo;

public class ReverseListClass {
    private void funReverse(int[] numbers) {
        for (int i=0; i<numbers.length/2; i++){
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length-1-i];
            numbers[numbers.length-1-i] = temp;
        }
        for (int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]);
        }
    }
    public static void main(String args[]){
        ReverseListClass reverseListClass = new ReverseListClass();
        int[] numbers = {2,4,6,7,9};
        reverseListClass.funReverse(numbers);

    }
}
