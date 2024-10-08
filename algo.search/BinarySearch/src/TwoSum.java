public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] res = {0 , 0};
        while(start<=end){
            if((numbers[start] + numbers[end]) == target) {
                res[0] = start+1;
                res[1] = end+1;
                return res;
            } else {
                if((numbers[start] + numbers[end]) < target) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
