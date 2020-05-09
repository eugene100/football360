# Football

## Task

Football (yours, not ours) scoring test:


The following are the scores from 5 football games.

Lions 3, Snakes 3<br>
Tarantulas 1, FC Awesome 0<br>
Lions 1, FC Awesome 1<br>
Tarantulas 3, Snakes 1<br>
Lions 4, Grouches 0<br>
The winning team gets 3 points<br>
The losing team gets 0 points<br>

Each team gets 1 point in a tie game <br>
Write Java code that will read the scores from a file.  It should print the rank and team names followed by their total score in descending order based on total score. If there is a tie, both teams get the same numerical ranking with the team names returned in alphabetical order.  In this case, there is a tie for 3rd place so there is not a 4th place.  If there was a 3 way tie for 3rd place, there would not be a 4th or 5th place, etc.

Approved Java package managers include Apache Maven and Gradle.  If you use a non-approved package manager, include instructions on how to install it.  You should spend no more than two hours writing your code.  We write unit tests and expect you to as well.  Your answer should include the amount of time taken to write your code as well as instructions to compile, test and execute your code.

Your output should look like the following:<br>
1: Tarantulas, 6 pts<br>
2: Lions, 5 pts<br>
3: FC Awesome, 1 pt<br>
3: Snakes, 1 pt<br>
5: Grouches, 0 pts<br>
