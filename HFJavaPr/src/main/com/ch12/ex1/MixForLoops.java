package main.com.ch12.ex1;

import java.util.List;

public class MixForLoops {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5);
        String output = "";

        /*for(int i = 1; i < nums.size(); i++)
            output += nums.get(i) + " ";
        // 실행결과 : 2 3 4 5 */
        /*for(int num : nums)
            output += nums + " ";
        // 실행결과 : [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] */
        /*for(int i = 0; i <= nums.length; i++)
            output += nums.get(i) + " ";
            실행결과 : 컴파일러 오류 (존재하지 않는 메서드 호출)
            java: cannot find symbol
            symbol:   variable length
            location: variable nums of type java.util.List<java.lang.Integer>
            */
        /*for (int i = 0; i <= nums.size(); i++)
            output += nums.get(i) + " ";
            실행결과 : 예외 발생 (범위 초과)
            Exception in thread "main" java.lang.ArrayIndexOutOfBounds
            Exception: Index 5 out of bounds for length 5
	        at main.com.ch12.ex1.MixForLoops.main(MixForLoops.java:24)
	        at java.base/java.util.ImmutableCollections$ListN.get(ImmutableCollections.java:680)

            */

        System.out.println(output);
    }
}
