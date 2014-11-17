# Distributed Computing Assignment 3 Report
By: Kalev Kalda Sikes  
Id: 100425828  

## Question One
Asdf.

## Question Two
### i)
Asdf.

### ii)
Asdf.

### iii)
Asdf.

## Question Three
Asdf.

## Question Four
See img/q4.png.

## Question Five
Given that a process wants to use a critical section `k` times and there are `N` many nodes in the system, Ricart and Agrawala's algorthim mandates `2*k*( N-1)` messages. If instead, the process could request up to `m` uses of a critical section, the algoritm would mandate `2*ceil( k/m)*( N-1) messages, reducing the overhead by up to `m` many times. This adaptation still fulfills the liveness condition, since it does not change the message structure.
