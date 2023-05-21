// Heap
// Time Complexity: O(N(Log(N))) 
// Space Complexity: N


import java.util.ArrayList;

public class MergeKSortedArrays extends Heap {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sortedArray = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);

        arr2.add(1);
        arr2.add(3);
        arr2.add(5);
        arr2.add(7);
        arr2.add(9);

        sortedArray.add(arr1);
        sortedArray.add(arr2);

        ArrayList<Integer> arr3 = new ArrayList<>();
        ArrayList<Integer> arr4 = new ArrayList<>();
        ArrayList<Integer> arr5 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sortedArray1 = new ArrayList<>();
        arr3.add(1);
        arr3.add(4);
        arr3.add(7);
        arr3.add(9);
        
        arr4.add(2);
        arr4.add(6);
        arr4.add(7);
        arr4.add(10);
        arr4.add(11);
        arr4.add(13);
        arr4.add(15);

        arr5.add(3);
        arr5.add(8);
        arr5.add(12);
        arr5.add(13);
        arr5.add(16);

        sortedArray1.add(arr3);
        sortedArray1.add(arr4);
        sortedArray1.add(arr5);

        MergeKSortedArrays m = new MergeKSortedArrays();
        System.out.println(m.mergeK(2, sortedArray));
        System.out.println(m.mergeK(3, sortedArray1));
    }

    public ArrayList<Integer> mergeK(int k, ArrayList<ArrayList<Integer>> sortedArray) {
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> currArray = sortedArray.get(i);
            for (int j = 0; j < currArray.size(); j++) {
                this.insert(currArray.get(j));
            }
        }
        ArrayList<Integer> finalArray = new ArrayList<>();
        
        while (this.getSize() > 0) {
            int smallest = this.top();
            this.remove();
            finalArray.add(smallest);
        }

        return finalArray;
    }
    
}

// I spent 40 minutes on this problem.