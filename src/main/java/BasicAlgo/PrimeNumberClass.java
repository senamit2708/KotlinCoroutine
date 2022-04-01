package BasicAlgo;

public class PrimeNumberClass {

    private void checkPrimeNumber(int number) {
        if (number==0 || number==1){
            System.out.println("Not a prime number");
        }else {
            boolean primeFlag = true;
            for (int i=2; i<number/2; i++){
                if (number%i==0){
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag){
                System.out.println("its a prime number");
            }else {
                System.out.println("its not a prime number");
            }
        }

    }

    public static void main(String args[]){
        PrimeNumberClass primeNumberClass = new PrimeNumberClass();
        int number = 200;
        primeNumberClass.checkPrimeNumber(number);
    }
}
