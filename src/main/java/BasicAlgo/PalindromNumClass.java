package BasicAlgo;

public class PalindromNumClass{

    private void funCheckPalindrom(String name) {
        char[] charArray = name.toCharArray();
        boolean flag = true;
        for (int i=0; i<name.length()/2; i++){
            if (charArray[i]!= charArray[name.length()-1-i]){
                flag = false;
                break;
            }
        }

        if (flag){
            System.out.print(name+" is a palindrom number");
        }else {
            System.out.print(name+" is not a palindrom number");
        }
    }

    public static void main(String args[]){
        PalindromNumClass palindromNumClass = new PalindromNumClass();
        String name = "145676541";
        palindromNumClass.funCheckPalindrom(name);
    }


}
