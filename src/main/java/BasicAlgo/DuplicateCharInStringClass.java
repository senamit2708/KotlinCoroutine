package BasicAlgo;

import java.util.HashMap;
import java.util.Map;

//finding duplicate character in a string
public class DuplicateCharInStringClass {

    private static void funDuplicateCharOne(String name) {
        Map<Character, Integer> map = new HashMap<>();
        char[] nameChar = name.toCharArray();
        for (int i=0; i<nameChar.length; i++){
            if (map.containsKey(nameChar[i])){
                int count = map.get(nameChar[i]);
                map.put(nameChar[i], ++count);
            }else {
                map.put(nameChar[i],1);
            }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (entry.getValue()>1){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }

    public static void main(String args[]){
        String name = "somnaliakumari";
        funDuplicateCharOne(name);
    }

}
