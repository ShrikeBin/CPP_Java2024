all: build run

build:
	javac --module-path ./lib --add-modules javafx.controls FXBorderPane.java

run:
	java --module-path ./lib --add-modules javafx.controls FXBorderPane

clean:
	rm -rf *.class