## Regular Expression test.

* regex: java.util.regex (built-in)
* joni: org.joni.Regex

```
git clone https://github.com/hiroyuki-sato/regexp_test
cd regexp_test
./gradlew shadowJar
```

```
bzip2 -d dummy_log.txt.bz2 
```

```
java -jar build/libs/regexp_test-all.jar joni dummy_log.txt
java -jar build/libs/regexp_test-all.jar regex dummy_log.txt
```


| Regexp | time(ms)|
|--------|---------|
| joni   | 8,009   |
| regex  | 2,322   |

