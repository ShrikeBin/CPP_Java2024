all: build run

build:
	javac --module-path ../javaFX/lib --add-modules javafx.controls StirlingApp.java

run:
	java --module-path ../javaFX/lib --add-modules javafx.controls StirlingApp

clean:
	rm -rf *.class
	rm log.txt