all: build run

build:
	javac --module-path ../javaFX/lib --add-modules javafx.controls Test.java

run:
	java --module-path ../javaFX/lib --add-modules javafx.controls Test

clean:
	rm -rf *.class
	rm log.txt