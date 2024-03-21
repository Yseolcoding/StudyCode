package main.com.ch12.ex2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    p. 420 스트림에서 결과 가져오기
 */
public class LimitWithStream {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        long result = limit.count();
        System.out.println("result = " + result);

        Stream<String> stream1 = strings.stream();
        List<String> result1 = stream1.collect(Collectors.toList());
        System.out.println("result1 = " + result1);

        List<String> result2 = strings.stream()
                                      .limit(4)
                                      .collect(Collectors.toList());
        System.out.println("result2 = " + result2);
    }
}

/*
    발생했던 오류 1) Line 19
    Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
	at main.com.ch12.ex2.LimitWithStream.main(LimitWithStream.java:20)

	Java의 스트림 API를 사용할 때 주의해야 할 점 중 하나는 스트림이 소모성(consumable)이라는 것입니다.
	즉, 스트림은 한 번 사용되고 나면 다시 사용할 수 없습니다. 코드에서 limit 스트림에 대해 count() 연산을 수행한 후,
	동일한 limit 스트림에 다시 collect()를 호출하려고 하면 IllegalStateException이 발생합니다.
	이는 스트림이 이미 연산에 사용되어 닫혔다(closed)는 것을 의미합니다.
 */