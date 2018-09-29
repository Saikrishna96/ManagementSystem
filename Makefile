killAndRun: kill install exec

kill:
	kill $$(lsof -t -i:8080)
install:
	mvn clean install
exec:
	java -jar target/*jar &
run: install exec