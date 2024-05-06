all: build run

build:
	javac --module-path ../../javaFX/lib --add-modules javafx.controls App.java

run:
	java --module-path ../../javaFX/lib --add-modules javafx.controls App

clean:
	rm -rf *.class
	rm log.txt