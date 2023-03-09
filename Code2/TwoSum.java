import java.util.*;

public class TwoSum{


    // * ---------------------------------------------------------------------------------------------------

    //! solution 1
    //& Simple code, my solution
    //& O(n^2)
    //& itero 2 veces en el array y voy obteniendo la suma, si es igual al target lo saco si no nop

    public int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];
        
        for(int x = 0; x < nums.length - 1; x++){
            for(int y = x + 1; y< nums.length; y++){
                
                int result = nums[x] + nums[y];
                
                if(result == target){
                    resultArray[0] = x;
                    resultArray[1] = y;
                    return resultArray;
                }
            }
        }
        return resultArray;
    }

    // * ---------------------------------------------------------------------------------------------------
    //! lo mismo que el mio pero mas elegante, inicializa el array en el return
    //& aqui igual ya usa el complemento

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        //& In case there is no solution, we'll just return null
        return null;
    }

    // * ---------------------------------------------------------------------------------------------------

    //! solution 2
    //^ O(n)
    //^ using a map! and the complement!!!!
    //^ with the complement you can access to the number 
    //^ si buscas el target de 3 y tienes el 1 -> 1-3 = 2. buscas el 2 en el mapa y listo!!!

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //^ evalua que sea diferente de i porque en las instrucciones dice que no puedes usar el mismo numero 2 veces
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        //^ In case there is no solution, we'll just return null
        return null;
    }

    // * ---------------------------------------------------------------------------------------------------
    //!solution 4
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

}