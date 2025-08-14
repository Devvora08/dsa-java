public class NonZero {
    public static void main(String[] args) {
        int[] myArr = {1,0,3,0,10,11,0,0,15};
        myArr = twoPointer(myArr);
        for(int i = 0; i<myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    // this method partitions non zero and zero elements, doesnt preserve the order of non zero
    static int[] swapNonZero(int[] arr) {
        int p1 = 0;
        int p2 = arr.length-1; // 2 pointers 

        while(p1 < p2) {
            if(arr[p1] == 0) {
                // swap p1 with p2 if p2 is not a 0 already
                if(arr[p2] != 0) {
                    // swap here
                    int temp = arr[p2];
                    arr[p2] = arr[p1];
                    arr[p1] = temp;
                } else {
                    p2 --;
                }
            } else {
                p1 ++;
            }
        }

        return arr;
    }

    static int[] twoPointer(int[] arr) {
        int p1 = 0;
        for(int p2 = 0; p2< arr.length; p2++) {
            if(arr[p2] != 0) {
                if(p1 != p2 ) {
                    int temp = arr[p2];
                    arr[p2] = arr[p1];
                    arr[p1] = temp;
                } p1++;
            } 
        }
        return arr;
    }
}
