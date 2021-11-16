#!/bin/bash

mkdir -p /target/edu.school21.printer
javac --release 8 -d target/edu.school21.printer ./src/java/edu.school21.printer/logic/readBmp.java ./src/java/edu.school21.printer/app/readBmpProgram.java
java -cp target/edu.school21.printer readBmpProgram --white=. --black=0 ../../ex01/ImagesToChar/src/resources/it.bmp
rm -r ./target
