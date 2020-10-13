package Search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        System.out.println(seqSearch(arr,11));
    }
    public static int seqSearch(int[] arr,int value){//顺序(线性)查找
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i+1;
            }
        }
        return 0;
    }
}
