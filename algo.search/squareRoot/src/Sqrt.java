public class Sqrt {
//    Use Binary Search to find the number whose square is less than x. Then search for result using the difference of squares formula
    public static int mySqrt(int x) {
        if(x==0 || x==1) {
            return x;
        }
        int y = x;
        // Find the number which square less than x.
        while(true) {
            y = y /2;
            System.out.println("y = " + y);
            if(x/y >= y) {
                break;
            }
        }

        // Result found.
        if(y*y == x) {
            return y;
        }

        // Search for result using difference of squares formula.
        while(true) {
            int j = x - (y*y);
            System.out.println(j + " " + x + " " + y);
            if(j>=0) {
                y = y + 1;
            } else{
                break;
            }
        }
        return y-1;
    }

    public static void main(String[] args) {
        System.out.println("Square Root: " + mySqrt(23));
    }
}
