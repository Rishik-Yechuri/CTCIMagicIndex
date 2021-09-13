public class CTCIMagicIndex {
    public static void main(String[] args) {
        try
        {
            CTCIMagicIndex obj = new CTCIMagicIndex ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
    public void run(String[] args){
        //Create arrays for testing
        int[] arrayWithValues = new int[]{-2,-1,0,1,2,3,5,6,8,10,11,13};
        int[] arrayWithRepeats = new int[]{0,4,4,4,6,8,8,8,9,10,11,11};
        //Calls 'findMagicIndex'
        System.out.println(findMagicIndex(arrayWithValues));
        //Calls 'findIndexNonDistinctive'
        System.out.println(findIndexNonDistinctive(arrayWithRepeats,-1,arrayWithRepeats.length));
    }
    public int findMagicIndex(int[] sortedArray){
        int low = 0;
        int high = sortedArray.length-1;
        boolean keepGoing  = true;
        while(keepGoing){
            int mid = (low+high)/2;
            if(mid == sortedArray[mid]){
                return mid;
            }
            if(sortedArray[mid] > mid){
                high = mid;
            }else{
                low = mid;
            }
            if(high - low <= 0){
                keepGoing = false;
            }
        }
        return -1;
    }
    public int findIndexNonDistinctive(int[] sortedArray,int low,int high){
        int indexOfMagic = -1;
        //System.out.println("Here 0:" + (low+high)/2);
        if(high-low <= 1){
            //indexOfMagic = -1;
            return indexOfMagic;
        }
        //System.out.println("Here 1");
        int currentIndex = (high+low)/2;
        if(sortedArray[currentIndex] == currentIndex){
            return currentIndex;
        }
        if(sortedArray[currentIndex] > currentIndex){
            int numToGoUp = sortedArray[currentIndex] - currentIndex;
            if(sortedArray[currentIndex+numToGoUp] == currentIndex+numToGoUp){
                return currentIndex+numToGoUp;
            }
        }
        if(sortedArray[currentIndex] < currentIndex){
            int numToGoDown = currentIndex - sortedArray[currentIndex];
            if(currentIndex-numToGoDown >= 0 && sortedArray[currentIndex-numToGoDown] == currentIndex-numToGoDown){
                return currentIndex-numToGoDown;
            }
        }
        if(indexOfMagic == -1){
            indexOfMagic = findIndexNonDistinctive(sortedArray,low,currentIndex);
        }
        if(indexOfMagic == -1){
            indexOfMagic = findIndexNonDistinctive(sortedArray,currentIndex,high);
        }
        return indexOfMagic;
        //return -1;
        //}
    }
}
