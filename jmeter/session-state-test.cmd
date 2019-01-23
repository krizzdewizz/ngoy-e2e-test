@echo off
setlocal
set _jm=d:\prg\jmeter\bin\

del out\*.log
del out\*.txt
call %_jm%\jmeter -n -t session-state.jmx -j out\session-state.log

echo number of failures:
type out\assertion-results.txt | find /c "false"