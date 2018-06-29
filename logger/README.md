# Logger samples

## Marker and filter

slf4j logger marker filter sample

### run

```bash
$ # run sample main class: kr.leocat.test.sample.logger.MarkerFilterSample with logback-test.xml
$ ./gradlew run

> Task :run 
17:46:14.812 [main] DEBUG k.l.t.s.logger.MarkerFilterSample - [] ABCD
17:46:14.815 [main] DEBUG k.l.t.s.logger.MarkerFilterSample - [MESSAGE] EFGH
17:46:14.815 [main] DEBUG k.l.t.s.logger.MarkerFilterSample - [] IJKL


BUILD SUCCESSFUL in 1s
3 actionable tasks: 1 executed, 2 up-to-date

$ # change logback config: logback-test.xml to logback.xml
$ mv src/main/resources/logback-test.xml src/main/resources/logback-test.xml.old

$ # run with logback.xml
$ ./gradlew run

> Task :run 
17:46:19.463 [main] DEBUG k.l.t.s.logger.MarkerFilterSample - [] ABCD
17:46:19.465 [main] DEBUG k.l.t.s.logger.MarkerFilterSample - [] IJKL


BUILD SUCCESSFUL in 1s
3 actionable tasks: 2 executed, 1 up-to-date

```
