@echo off

cd /d "%~dp0"

rem Compile source files (optional—only if you change code)
rem javac -d bin src\*.java

java -cp bin Main
pause
