all: driver.class
	@echo Compling pAscii
driver.class: driver.java pAscii.class
	@javac driver.java
pAscii.class: pAscii.java
	@javac pAscii.java
run:
	@java driver
clean:
	@rm -f *.class
