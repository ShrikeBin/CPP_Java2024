all: build run

build:
	javac --module-path ../javaFX/lib --add-modules javafx.controls TestCircle.java

run:
	java --module-path ../javaFX/lib --add-modules javafx.controls TestCircle

clean:
	rm -rf *.class
	rm log.txt