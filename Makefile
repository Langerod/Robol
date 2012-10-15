BRUKER = $(USER)

Cflat.jar: ALWAYS
	javac *.java
	jar cmf manifest.txt Robol.jar *.class

delivery:
	zip 'INF3110 Oblig1_<$(BRUKER)>.zip' Robol.jar *.pdf

clean:
	rm -f *.jar
	rm -f *.*~
	rm -f *~
	rm -f *.class

run:
	java -jar Robol.jar

ALWAYS:
