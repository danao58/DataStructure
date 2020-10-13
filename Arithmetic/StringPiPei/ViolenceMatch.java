package StringPiPei;

public class ViolenceMatch {
    public static void main(String[] args) {
        String strl="硅硅谷尚硅谷你尚硅尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(strl, str2);
        System.out.println("index=" + index);
    }

    private static int violenceMatch(String strl, String str2) {

        char[] s1 = strl.toCharArray();
        char[] s2 = str2.toCharArray();

        int slLen = s1.length;
        int s2Len = s2.length;

        int i=0;//i索引指向sl
        int j=0;//j索引指向s2

        while (i < slLen && j< s2Len) {//保证匹配时，不越界.
            if (s1[i] == s2[j]) {//匹配ok
                i++;
                j++;
            } else {//没有匹配成功
                //如果失配(即str1[]!=str2[j])，令i=i-(-1), j=0。
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == s2Len){
            return  i - j;
        }else {
            return -1;
        }
    }

}
