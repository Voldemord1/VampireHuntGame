# VampireHuntGame
For this project, you will revisit the Vampire Hunt game, rewriting it in an object-oriented style, as we discussed in lecture. A skeleton program (haha) is available on libra.sfsu.edu; you have to fill in code in various places in the file. If you follow the instructions in this handout, this will be a fairly straightforward project. Otherwise, you may spend lots of time working on unnecessary tasks.

The action takes place on a 10 x 10 display grid, similar to the one you used for the Game of Life project. When the game begins, the user is prompted for the (i, j) coordinates of the vampire, and the (i, j) coordinates of the human. i and j are the row and column numbers of the position of an element in a 2-dimensional array; hence, the order is reversed from the usual (x, y) coordinates.

Then the user is asked if s/he would like the human to move. (It’s easier to specify that the human does not move, for testing the program; normally we would have the human move, of course!)

The user types in commands to move the vampire. There are four commands:

	1 means go left (j--)
	2 means go down (i++)
	3 means go up (i--)
	4 means go right (j++)

The vampire is not allowed to move outside the grid. You (the vampire) will try to catch the human. The human makes random moves, chosen from the ones corresponding to the four user commands. The game ends when the vampire moves onto the human’s grid point and bites the human, or when the human accidentally moves onto the vampire’s grid point and sacrifices himself.

A sample run:

libra% java V2
Enter (i, j) for vampire: 5 2
Enter (i, j) for human: 4 1
Would you like human to move? (0: no, 1: yes): 1
0123456789
..........0
..........1
..........2
..........3
.H........4
..V.......5
..........6
..........7
..........8
..........9
Vampire at: 5 2
Human at: 4 1
Enter command (0 to quit): 1
0123456789
..........0
..........1
..........2
.H........3
..........4
.V........5
..........6
..........7
..........8
..........9
Vampire at: 5 1
Human at: 3 1
Enter command (0 to quit): 3
0123456789
..........0
..........1
..........2
H.........3
.V........4
..........5
..........6
..........7
..........8
..........9
Vampire at: 4 1
Human at: 3 0
Enter command (0 to quit): 3
Invalid position change; position set to (3, 0)
0123456789
..........0
..........1
..........2
HV........3
..........4
..........5
..........6
..........7
..........8
..........9
Vampire at: 3 1
Human at: 3 0
Enter command (0 to quit): 1
You bit the human!

Each Creature has a position indicated by its i and j private instance variables, a pic variable which contains the character to be displayed, and a boolean canMove variable, which indicates whether the Creature is allowed to move. Follow the steps to add to the program.

Step 1: allow a Creature to be placed in the requested position on the grid. In the Creature class, you have to fill in the setIJ() method, and also the constructor method Creature(); the constructor method which will use setIJ().

After Step 1, the vampire will be placed at the requested position in the grid.

Step 2: enable a Creature to move, based on the user commands 1 to 4 described above. In the Creature class, you have to fill in the method

	public void update(int c) 

After Step 2, the vampire will move around the grid, following the user command.

Step 3: declare and initialize a new Creature, the human, in the main method of the public class. Allow the user to enter the human’s position (see sample run). Add code (where appropriate, in the main method) to display the human.

After Step 3, the human will be displayed in the grid.

Step 4: enable a Creature to make random moves, using the method

	public void update()

This overloaded update() method simply calls the earlier update() method, with a random integer 1-4 as the argument. The human will call this update method to move itself.

Step 5: after each move by the vampire and the human, check whether they are on the same square. In the public class, you have to fill in the method

public static boolean sameSquare(Creature c1, Creature c2) 

The sameSquare() method returns true if the two creatures are on the same square, false if they are not on the same square. Use the sameSquare() method to determine whether the vampire and the human are on the same square; if they are, then the game is over.

Your program should generate almost identical output to the sample runs (allowing for different user input and random moves, of course). If your program behaves fairly differently, you should check with me to make sure it’s ok; otherwise points may be deducted.
