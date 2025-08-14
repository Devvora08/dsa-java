public class EvenDigits {
    public static void main(String[] args){
        int[] arr = {12,345,24,1245,342,19345};
        int numCount = isEven(arr);

        System.out.println("Number of even elements in Array is :"+ numCount);
    }

    static int isEven(int[] array){

        int counter = 0;

        for(int i = 0; i<array.length; i++){
            String individualElement = "";
            individualElement += array[i];
            if(individualElement.length()%2 == 0){
                counter += 1;
            }
        }

        return counter;
    }

}
