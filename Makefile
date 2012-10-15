BRUKER = $(USER)

Cflat.jar: ALWAYS
	javac *.java
	jar cmf manifest.txt Robol.jar *.class

delivery:
	zip 'INF3110 Oblig1_<$(BRUKER)>.zip' Robol.jar *.pdf *.java *.txt Makefile

clean:
	rm -f *.jar
	rm -f *.*~
	rm -f *~
	rm -f *.class

run:
	java -jar Robol.jar

test:
	java -jar Robol.jar test1.txt
	java -jar Robol.jar test2.txt	
	java -jar Robol.jar test3.txt
	java -jar Robol.jar test4.txt

ALWAYS:
