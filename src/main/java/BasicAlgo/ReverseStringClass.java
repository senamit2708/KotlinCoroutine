package BasicAlgo;

public class ReverseStringClass {

    private static void funReverseOne(String name) {
        char[] charArray = name.toCharArray();
        for (int i= name.length()-1; i>=0; i--){
            System.out.print(charArray[i]);
        }
    }

    private static void funReverseTwo(String name) {
        char[] charArray = name.toCharArray();
        for (int i= 0; i<name.length()/2; i++){
            char c = charArray[i];
            charArray[i] = charArray[name.length()-1-i];
            charArray[name.length()-1-i] = c;
        }
        System.out.println(charArray);
    }

    private static void funReverseThree(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    public static void main(String args[]){
        String name = "amitsen";
//        funReverseOne(name);
//        funReverseTwo(name);
        funReverseThree(name);
    }


}
