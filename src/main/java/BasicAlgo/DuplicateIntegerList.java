package BasicAlgo;

import java.util.HashMap;
import java.util.Map;

public class DuplicateIntegerList {

    private static void funFindDuplicate(int[] idList) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<idList.length; i++){
            if (map.containsKey(idList[i])){
                int count = map.get(idList[i]);
                map.put(idList[i], ++count);
            }else {
                map.put(idList[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue()>1){
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
        }


    }


    public static void main(String args[]){
        int[] idList = {2,4,6,3,4,2,9,6,6,7,4};
        funFindDuplicate(idList);
    }


}
