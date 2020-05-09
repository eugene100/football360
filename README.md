# football360

Football application calculates final scores of teams.

Requirements for the application described [here](doc/task.md)

## Run the project

- Make sure to be in the root directory
- Clean and build the project, run the command:
```bash
mvn install
```
- Run the Football method in Football.java by running:
```bash
mvn exec:java -Dexec.args=src/test/data/test_data.csv
```

## Run application

- Make sure to be in the target application directory
```bash
java -jar football-<version>.jar <CSV file>
```

## Example of output:
```
1: Tarantulas 4
2: Lions 4
3: FCAwesome 1
4: Snakes 1
5: Grouches 0
```

## Existant bugs
Team name shouldn't contain spaces.
