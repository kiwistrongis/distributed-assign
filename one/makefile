#globals
default: build
freshen: clean build
clean:
	rm -rf bin/*

#variables
cp = bin
dest = -d bin
warnings =

#includes
include deps.mk
include lists.mk

#compilation definitions
$(class_files): bin/%.class : src/%.java
	javac -cp $(cp) $(dest) $(warnings) $<

#commands
build: $(class_files)

#test commands

#test:

run-udp-conntest-server: bin/UDPConnTestServer.class
	java -cp $(cp) UDPConnTestServer
run-udp-conntest-client: bin/UDPConnTestClient.class
	java -cp $(cp) UDPConnTestClient localhost

run-tcp-conntest-server: bin/TCPConnTestServer.class
	java -cp $(cp) TCPConnTestServer
run-tcp-conntest-client: bin/TCPConnTestClient.class
	java -cp $(cp) TCPConnTestClient localhost

run-couple-receiver: bin/CoupleReceiver.class
	java -cp $(cp) CoupleReceiver
run-couple-sender: bin/CoupleSender.class
	java -cp $(cp) CoupleSender localhost
