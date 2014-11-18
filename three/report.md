# Distributed Computing Assignment 3 Report
By: Kalev Kalda Sikes  
Id: 100425828  

Permalink: [link](https://github.com/kiwistrongis/distributed-assign/blob/master/three/report.md)

## Question One
One can run the version with bad syncronization with either `make run-bad` or `java -cp bin BadCounting`, and the version with good syncronization with either `make run-good` or `java -cp bin GoodCounting`.

## Question Two
### i)
Asdf.

### ii)
Asdf.

### iii)
Asdf.

## Question Three
For eight seconds, reduce the clock speed by half so that every second the value of the clock is increased by half a second. After eight seconds, return to normal clock speed. Numerically, this would look somewhat like this:  
```
+01s : 10:27:54.5
+02s : 10:27:55.0
+03s : 10:27:55.5
+04s : 10:27:56.0
+05	s : 10:27:56.5
+06s : 10:27:57.0
+07s : 10:27:57.5
+08s : 10:27:58.0
+09s : 10:27:59.0
+10s : 10:27:60.0
```

## Question Four
```
        S00
           \
            S01
           /   \
        S11     S02
       /   \   /   \
    S21     S12     S03
   /   \   /   \   /
S31     S22     S13
   \   /   \   /
    S32     S23
   /   \   /
S42     S33
   \   /   \
    S43     S34
       \   /
        S44
```

## Question Five
Given that a process wants to use a critical section `k` times and there are `N` many nodes in the system, Ricart and Agrawala's algorthim mandates `2*k*( N-1)` messages. If instead, the process could request up to `m` uses of a critical section, the algoritm would mandate `2*ceil( k/m)*( N-1)` messages, reducing the overhead by up to `m` many times. This adaptation still fulfills the liveness condition, since it does not change the message structure.
