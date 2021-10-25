@echo off

cd src
javac -d ../bin Main.java

cd ../bin
java Main ../tests/src.be ../tests/out.bf
