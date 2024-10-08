public class FirstBadVersion {
    static int bad;
    public static boolean isBadVersion(int n) {
        return n == bad;
    }
    //fisrt number returning bad
    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l<=r) {
            int m = l + (r - l)/2;
            if(isBadVersion(m)) {
                r=m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        bad = 4;
        System.out.println(firstBadVersion(5));
    }
}
