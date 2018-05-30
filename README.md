# Java-Machine-Task
### Simulating real world scenario with dynamic decision trees. 
### Problem Statement:
Let a hypothetical ongoing cricket game in which Jaspreet Bumrah is on strike and MS Dhoni is on Non strike. 

Next line up of batting is - 

1. Virat Kohli, 
2. Siddharth Kaul, 
3. Hardik Pandya, 
4. Bubhneshwar Kumar. 

You have to develop a program which takes an initial odds value for the ongoing game and must calculate the odds of all the possible events that will happen on the next ball. The duration of program will be for 6 balls, i.e. 1 over only and tester can also put his predictions for the next ball to see his chance of winning in the ongoing game. The odds must be calculated dynamically for each possible event and must not be hardcoded into the software.

### Solution

1. Segregate all possible events in logical groups.
2. Get a random event trigger(1-100).
3. Create a decision tree for any given random event trigger.
4. Process decisions based on event processsing logic. 

### Execution
1. For building JAR  
```mvn package```
2. Go to Target Folder.  
3. For Executing JAR   
``` java -cp EbCricketSimulationTask-1.0-SNAPSHOT.jar main.EbCricketSimulationTask```
