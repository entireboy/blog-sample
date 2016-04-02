# Spring framework sample

1. [AOP] Ordering Aspect - sample of [[Spring] advice 순서 변경하기](http://blog.leocat.kr/post/142117390222)

> Run `test` to run ordering test
> ```shell
> $./gradlew --info test
> ```
> You'll see the result like this:
> ```shell
> kr.leocat.test.spring.aop.order.MyClassTest > test STANDARD_ERROR
>    [Test worker] INFO kr.leocat.test.spring.aop.order.myfirst.MyFirstAspect - my - Order(1) start
>    [Test worker] INFO kr.leocat.test.spring.aop.order.my.MyAspect - my - Order(2) start
>    [Test worker] INFO kr.leocat.test.spring.aop.order.your.YourAspect - your - not ordered start
>    [Test worker] INFO kr.leocat.test.spring.aop.order.MyClass - 잇힝~
>    [Test worker] INFO kr.leocat.test.spring.aop.order.your.YourAspect - your - not ordered end
>    [Test worker] INFO kr.leocat.test.spring.aop.order.my.MyAspect - my - Order(2) end
>    [Test worker] INFO kr.leocat.test.spring.aop.order.myfirst.MyFirstAspect - my - Order(1) end
> ```