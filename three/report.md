# Distributed Computing Assignment 3 Report
By: Kalev Kalda Sikes  
Id: 100425828  

Permalink: [link](https://github.com/kiwistrongis/distributed-assign/blob/master/three/report.md)

## Question One
One can run the version with bad syncronization with either `make run-bad` or `java -cp bin BadCounting`, and the version with good syncronization with either `make run-good` or `java -cp bin GoodCounting`.

## Question Two
Assumptions:  
 - CPU time is evenly distributed across threads. For example, if two threads on the same core both begin executing a 1 ms section at the same time, they will both finish simultaneously 2 ms later.
 - Disk I/O is blocking.
 - I'm not intended to do the discrete math to exactly determine the answers.

States ( of the two-threaded cases ):  
 - State 0,0 - both threads are ready to serve a request
 - State 0,1 - one thread is ready, the other is about to do a disk lookup
 - State 0,2 - one thread is ready, the other is 5 ms into a disk lookup
 - State 0,3 - one thread is ready, the other is 10 ms into a disk lookup
 - State 1,1 - both threads are about to do a disk lookup
 - State 1,2 - one thread is 5 ms into a disk lookup, the other is waiting for its turn
 - State 1,3 - one thread is 10 ms into a disk lookup, the other is waiting for its turn

### i)
A given request will take on average `0.8*5 + 0.2*20 = 8` ms. Therefore, the throughput will be approximately `1000/8 = 125` requests per second.

### ii), iii)
Instead of doing the annoying discrete math in my head, I wrote a little program ( src/q2sim.rs ) to simulate each of the cases, and outputs the average amount of requests served per second.
```
$ bin/q2sim
case ii result: 175.72
case iii result: 230.06
```

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
