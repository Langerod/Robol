BRUKER = $(USER)

Cflat.jar: ALWAYS
	javac *.java
	jar cmf manifest.txt Robol.jar *.class

delivery:
	tar cf 'INF3110-$(BRUKER).tar' no

clean:
	rm -f *.jar
	rm -f *.*~
	rm -f *~
	rm -f *.class

run:
	java -jar Robol.jar

ALWAYS:
