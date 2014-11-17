# Distributed Computing Assignment 1 Report
By: Kalev Kalda Sikes
Id: 100425828

Note: I don't bother with answering questions that are stupid or a waste of time.

## Question One
### Part A
When the sender casts a message, it attaches its own sender id and a message id that increments for each message. When a receiver notices a gap in message ids, they may choose to petition the responsible sender ( or other receivers nearby ) to retransmit the lost message.

### Part B
The presented solution does not differ significantly with reliable multicast ( with the exception of asking other recievers to retransmit lost messages ). This is because any solution to dropped messages in multicast is, by definition, reliable multicast.

## Question Two
### Request
Example: GPS tracker  
```
client:"update my current location to <position>"
```

Since the client is constantly updating its position, by the time a server could reply, there would already be a new position update request.

### Request, Reply
Example: Heartbeat signal  
```
client:"are you still there?: <message id>"  
server:"yes i am still here.: <message id>"  
```

Whether the server replies in this case gives the client all the information it wanted. If the client doesn't receive a reply, it could just ask again ( a few times ) to statistically determine the server isn't there. The server doesn't care if client misses a reply, because it will just ask again.

### Request, Reply, Acknowledgement
Example: Purchasing  
```
client:"i want to purchase expensive item <item id>."
server:"your purchase of item <item id> was successful."
client:"i have reported to the user that my purchace of item <item id> was successful."
```

Since the server wants to ensure a successful sale, it must make sure the client knows the sale was successful. Hence the client must acknowledge that it knows the purchase was successful, or the server may 'take back' the sale.

## Question Three
I implemented the election spec in rust for lab 2. I've just copied my work here.

## Question Four
This is stupid. Java RMI is bloated and useless. Nobody decently competant uses it anymore. So yeah, I'm not gonna implement a dumb pub/sub system on top of a bloated rmi library built on the bloated, slow, and horribly memory-inefficient reflection "features" of the JVM.

## Question Five
I would like to comment: This is a horrible use case for a distributed tuple data-store. The system isn't even using a tuple. This is basically an over-architected tcp-based broadcast system.

### Sequence Diagram
```
 [ Consumer ]             [ Alarm ]
      |                       |
  ( await() )                 |
      |                       |
      |                  ( raise() )
      |<-------"Fire!"<-------|
( await() returns )           |
      |                       |
  ( msg printed )             |
      |                       |
```
