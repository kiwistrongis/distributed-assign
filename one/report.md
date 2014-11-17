# Distributed Computing Assignment 1 Report
By: Kalev Kalda Sikes
Id: 100425828

## Question One
### Heterogeneity
The systems that serve and browse the web are implemented on various platforms, but must ( and do ) all work harmoniously.

### Openess
The web is completely open. The standards that drive its operation are freely published, and anyone is free to build upon it, or re-implement it as they see fit. 

### Security
Since various sensitive transactions take place on the web, it is critically important these transactions are secured properly. The web's typical answer to this problem is ssl sessions and user/password authentication. While these systems are imperfect, they are generally acceptable for most use cases.

### Scalability
The architecture of the web makes it almost infinitely scalable. The relationship between the amound of data that must be stored or served, or the number of simultaneous clients that must be served is fairly linear with the cost of the hardware involved. There are also plenty of software techniques that reduce the problems of scalability. Scalability of the web is a concern of the past.

### Failure Handling
The web is fairly fault-tolerant, with a few exceptions mainly pertaining to the way in which it's used. These exceptions include domain and resource migration. When the URL for a resource changes, any pages linking to that resource are left with dangling links.

### Concurrency
Web servers typically handle numbers of simultaneous clients in the order of tens of thousands or more. In order to handle more clients than there are processors in the server, multi-threading is an absolute must.

### Transparency
Web servers generally appear to be a single machine, although they are almost universally large clusters of machines. This is hidden from the typical user.

### Quality of Service
Web services, especially those serving financial interests, attempt to achieve 100% uptime. This is typically done by distributing any critical task across multiple redundant machines. This practice reduces the possible points of failure mainly to human error.

## Question Two

### UDP Throroughput
Relevant part of output from running test against small server approximately 30 ms away:
```
java -cp bin UDPConnTestClient whitebox
...
result for test id: 00 mps: 0128, msize: 05000 :: 1021 / 1024 ( 099.71 % )
result for test id: 01 mps: 0128, msize: 10000 :: 1024 / 1024 ( 100.00 % )
result for test id: 02 mps: 0128, msize: 15000 :: 0228 / 1024 ( 022.27 % )
result for test id: 03 mps: 0128, msize: 20000 :: 0060 / 1024 ( 005.86 % )
result for test id: 04 mps: 0128, msize: 25000 :: 0014 / 1024 ( 001.37 % )
result for test id: 05 mps: 0128, msize: 30000 :: 0010 / 1024 ( 000.98 % )
result for test id: 06 mps: 0128, msize: 35000 :: 0008 / 1024 ( 000.78 % )
```

Results in a slightly better format:  
 Packet Size | Throroughput
------------------------------
  5000 Bits  |  638125 Bits/s
 15000 Bits  | 1280000 Bits/s
 15000 Bits  |  427500 Bits/s
 20000 Bits  |  150000 Bits/s
 25000 Bits  |   43750 Bits/s
 30000 Bits  |   37500 Bits/s
 35000 Bits  |   35000 Bits/s

### TCP Throroughput



### Comparison


## Question Three
The serialized form of the given class would look something like this:  
 1. Magic numbers for identification of serialized data.
 2. A description of 'Couple' class, consisting mainly of the fields 'one' and 'two' and their class' name.
 3. A description of the 'Person' class.
 4. Data associated with the 'one' field.
 4. Data associated with the 'two' field.

## Question Four
Log of output from client:
```
java -cp bin CoupleSender localhost
connecting...
presend: one: Sally, other: null
sending couple
receiving couple
postreceive: one: Sally, other: Joffrey
closing connection
```

Log of output from server:
```
java -cp bin CoupleReceiver
client connected
sending back edited couple: one: Sally, other: Joffrey
closing connection to client
```

## Question Five

The architecture of skype's network has three main components: nodes, super-nodes, and the login server. Nodes are defined as the machines and the software that normal users use to connect to skype. Nodes assist in forming skype's overlay network. Super nodes are class of nodes that have elevated responsibilities in the network. Finally, the login server handles the registration of new users, authentication of logins, and likely the dispersion of new user information.

### Node Handling
Any skype client that has logged into the network is considered a node. These nodes, in addition to normal VoIP functions, assists in the decentralized distribution of logged-in user information. Any node that meets sufficient processor and network speed requirements may be upgraded to the class of super-node. These super-nodes are a critical component of skype's architecture, as they remove the need for costly servers, dramatically reduce peer discovery time, and improve call routing and establishment, all at no cost to Skype.

### Initial Connection (Login)
Skype clients attempting to connect to the network go through a few basic steps. First, the client attempts to make a connection to a super-node. If the client cannot establish a connection to a super-node, it continues to retry ad infinity. Once a super-node connection is established, the client next attempts to connect to skype's login servers, in order to authenticate the client and load 'friend' information.

### Peer Discovery
Skype claims to be able to quickly and accurately locate any user that has logged into the network within a 72 hour time-span. This is (likely) done in two different ways. When on public, un-restricted networks, the client simply queries their super-node for other nodes to ask for the location of the target. When on private, NAT'd and udp-restricted networks, it appears that the super-node simply performs the search for the client.

### Peer Connection
Skype is capable of establishing calls even when some or all of the nodes involved are on heavily restricted networks. Call establishment when both nodes are on unrestricted networks is quite boring and straightforward. In this scenario, the two clients appear to establish an encrypted call through a challenge-response mechanism that is distrubuted accross multiple nodes. When a client is on a restricted network, the same process appears to occur, with its end of the process is routed through another, unrelated node on the network.
