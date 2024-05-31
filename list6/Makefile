all: build run

build:
	javac --module-path ../javaFX/lib --add-modules javafx.controls AppMain.java

run:
	java --module-path ../javaFX/lib --add-modules javafx.controls AppMain

clean:
	rm -rf *.class
	rm log.txt