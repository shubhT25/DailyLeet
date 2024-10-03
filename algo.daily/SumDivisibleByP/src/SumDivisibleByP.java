import java.util.HashMap;

/**
 Intuition and Approach
 Lets keep things simple :-

 first of all we have to find the sum of all numbers and its mod with P so that we will come to know what value we have to remove in the form of a sub array.
 for(int x : nums)
 sum = (sum + x)%p;
 ** mod = sum%p;**

 But bro, why are you doing like this? first get sum of all numbers and then use Mod with p, why in for loop for all values?

 great question, we can do that but bro, think if the numbers in the array are huge like [100000000000, 10000000000, 100000000000] and if you go for sum first => then this will lead to overflow as Integer can not park that huge value after sum...so lets make use of Modulous.

 ok, got it, next?
 next we will store the prefixMod of all the sum starting from 0 index in the given array in our HashMap.

 why? what is the reason behind this??
 ok lets undersatnd it in simple way

 forget about Mod sum for a while, just think we have only prefix sum stored in hashmap now at any point i lets say we have sum = SUMi , and suppose there is another sum at index j already = SUMj

 then sum between i and j index SUM-ij = (SUMi - SUMj)
 now if we find that this (SUM-ij)%p = mod (we calculated in start)
 that means we found at least one sub-array residing at (i till j index)

 so we can write at any index if our condition is mathing like this

 (SUMi - SUMj)%p = mod ( mod calculated in start)

 => SUMj%p = (SUMi%p- mod + p)%p
 => so the above two bold values are actually the prefixMod

 BUT BUT bro why you added p?
 because we don't want the negative remainder values that's why.

 can you gimme an example?
 sure, lets say, our mod = 7, p = 8 and at index i we found prefisSum mod = 3 in that case it would give us 3 -7 = -4 but if add p it will give us 3 - 7 + 8 = 4

 ok so next??
 so next is we are looking for prefixMod if already occured, like in above case if any prefix mod = 4 at index j, already recorded in hasmap, that means we got one answer of length (i - j)
 if we don't find such value we have to store current prefixSumMod and index i in hashMap.

 but we need smallest one, right?
 exactly, so we need to traverse through array and would look for min value till end.

 so finally our min value would be answer??

 not always bro, first of all if our mod = 0 => means array sum is already divisible so we return 0 itself in start.

 other case is we initialized our ans = n (length of array)
 now we were looking for min value

 ok so what??

 so if did't find any value in entire array our ans would still have untouched value ans = n ===> that means no value can satify our condition so return -1 other wise return ans

 return ans==n ? -1 : ans.
 **/
public class SumDivisibleByP {
    public static int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int x : nums)
            sum = (sum + x)%p;

        int mod = sum%p;
        if(mod==0)
            return 0;

        int ans = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int currSumMod = 0;
        for(int i=0; i<nums.length; i++)
        {
            currSumMod = (currSumMod+nums[i])%p;
            int neededMod = (currSumMod - mod + p)%p;
            if(hm.containsKey(neededMod))
                ans = Math.min(ans, i-hm.get(neededMod));
            hm.put(currSumMod, i);
        }
        return ans==nums.length ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3, 1, 4, 2},6));
    }
}
