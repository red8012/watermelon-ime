# Watermelon IME

### TODO

1. reorganize dict (s1, s2, s3, …)
2. hide first candidate right
3. candidate first line height

### Benchmark Result

``` python
Time    Allocations  Size
2,242   58,985       2,592,138    original engine

   33      229           5,520    no engine
```

``` python
wrong  total  ratio
70     202    0.34653  (w/o characterLock)
25     202    0.12376  (w/ characterLock)
```

``` python
date  cold start   warm start  comment
GOAL    1000          500
2/3     3064         2063
2/3     2159         1816      THREAD_PRIORITY_URGENT_AUDIO*
2/3     2946         2074      THREAD_PRIORITY_BACKGROUND

2/13    6181         3771      Corrected character lock
2/13    4034         2374      THREAD_PRIORITY_URGENT_AUDIO
2/13    4335         3015      Warm up database
2/13    4239         2219      setMaxSqlCacheSize(SQLiteDatabase.MAX_SQL_CACHE_SIZE)
2/13    4829         2859      PRAGMA synchronous = OFF;
2/13    3972         2130      Turn off C.debug
2/13    4082         2105      Put Android Studio to background
2/13    3867         2039      no PRAGMA synchronous = OFF;
2/13    4005         2006      PRAGMA temp_store = MEMORY;
2/13    4043         2007      PRAGMA journal_mode = OFF;
2/13   [3763]       [1875]     PRAGMA locking_mode = EXCLUSIVE; [GOOD]
2/13    4194         2364      remove temp_store = MEMORY; and journal_mode = OFF;
2/13    4012         1925      put back temp_store = MEMORY; and journal_mode = OFF;
2/13    3966         3099      PRAGMA mmap_size=64000000;
2/13    4338         2288      remove PRAGMA mmap_size=64000000;
2/13    4037         2117      test again
```



### Performance TODO

1. [OK] benchmark
2. [OK] database warm up
3. [OK] drop index + vacuum and create index after first run (38% space saving)
4. [OK] drop unused columns
5. [TODO] use covering index (expected ~2X faster)
6. [TODO] in memory database
7. [OK] PRAGMA automatic_index; default on 3.7.17
8. [—] PRAGMA schema.integrity_check
9. [oh~~] PRAGMA schema.synchronous = 0 | OFF
10. [oh~~] PRAGMA schema.locking_mode = EXCLUSIVE
11. [OK] PRAGMA temp_store = 2 | MEMORY
12. [OK] PRAGMA mmap_size=268435456;
13. [OK] ATTACH DATABASE ':memory:' AS aux1; —> 2.5 s can query during copy [OK] 30%~100% improvement
14. [—] raw query bind variable
15. [OK] set thread priority

``` 
ATTACH DATABASE 'file::memory:?cache=shared' AS m KEY '';
```

``` 
//        System.out.println(output);
//        int correct = 0, all = 0;
//        for (int i = 0; i < groundTruth[0].length(); i++) {
//            char tt = output.charAt(i);
//            char gt = groundTruth[0].charAt(i);
//            if (tt == '。') continue;
//            if (tt == gt) correct++;
//            all++;
//        }
//        System.out.println("Correct Ratio = " + correct + " / " + all + " = " + (float) correct / all);
```

