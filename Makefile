## Simple and dirty java make file by Bilel
## Sould used com.***** as a package name for the main

JFLAGS = -g -d .
JC = javac
JR = java
DECK = test.txt
.SUFFIXES: .java .class
.java.class:
	$(info compiling your software)
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        ./src/HuffmanNode.java \
        ./src/HuffmanComparator.java \
        ./src/Huffman.java \
        ./src/Main.java


default: classes

classes: $(CLASSES:.java=.class)
	$(info =========================================================)
	$(info To run the Huffman compression run the following command:)
	$(info 		make run DATA=<deck_file_name.txt>)
	$(info =========================================================)


PACKAGE_NAME = com.xobx
MAIN_CLASS= Main

run: 
	$(info running your app)
	$(JR) $(PACKAGE_NAME).$(MAIN_CLASS) $(DATA)
	

clean:
	$(info Deleting the sources)
	$(RM) -r com