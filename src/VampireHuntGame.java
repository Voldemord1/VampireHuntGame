////////////////////////////////////////////
//
//  Objected-oriented version of vampire hunt game
//
////////////////////////////////////////////

import java.util.Scanner;
public class VampireHuntGame {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        char [][] grid = new char [10][10];

        // initialize vampire
        System.out.print("Enter (i, j) for vampire: ");
        int newI = input.nextInt();
        int newJ = input.nextInt();
        Creature vampire = new Creature('V', newI, newJ);

        // initialize human
        System.out.print("Enter (i, j) for human: ");
        int newX = input.nextInt();
        int newY = input.nextInt();
        Creature human = new Creature('H', newX, newY);

        // check whether human can move
        System.out.print("Would you like human to move? (0: no, 1: yes): ");
        int isMove = input.nextInt();
        human.setMoving(isMove);

        // update and display grid
        clearGrid(grid);
        vampire.display(grid);
        human.display(grid);
        drawGrid(grid);
        System.out.println("Vampire at: " + vampire.getI() +
                " " + vampire.getJ());

        System.out.println("Human at: " + human.getI() +
                " " + human.getJ());

        // get next user command
        System.out.print("Enter command (0 to quit): ");
        int command = input.nextInt();

        while (command != 0) { // while not quit
            clearGrid(grid);
            vampire.update(command);
            vampire.display(grid);

            // if vampire and human are on same square,
            // vampire bites human, game ends
            int oldI = human.getI();
            int oldJ = human.getJ();

                if (sameSquare(vampire, human)) {
                    System.out.println("You bit the human!");
                    break;
                }else {
                    try {
                        human.update();
                        human.display(grid);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Invalid position change; position set to ("+oldI+","+oldJ+")");
                        human.setIJ(oldI, oldJ);
                        human.display(grid);
                    }
                }
                if (sameSquare(human, vampire)){
                    System.out.println("Human sacrificed himself!");
                    break;
                }
            // if game does not end
            // human makes random move
            // display human on grid
            // if vampire and human are on same square,
            // human sacrificed himself, game ends

            drawGrid(grid);
            System.out.println("Vampire at: " + vampire.getI() +
                    " " + vampire.getJ());
            System.out.println("Human at: " + human.getI() +
                    " " + human.getJ());
            System.out.print("Enter command (0 to quit): ");
            command = input.nextInt();

        } // while (command != 0)

    }
    public static void clearGrid(char [][] g) {
        for (int i=0; i<g.length; i++) {
            for (int j=0; j<g.length; j++) {
                g[i][j] = '.';
            }
        }
    }
    public static void drawGrid(char [][] g) {
        System.out.println("0123456789");
        for (int i=0; i<g.length; i++) {
            for (int j=0; j<g.length; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println(i);
        }
    }

    public static boolean sameSquare(Creature c1, Creature c2) {
        // if c1 and c2 have identical (i, j) coordinates, return true
        // else return false
        if (c1.getI()==c2.getI() && c1.getJ()==c2.getJ()){
            return true;
        }else return false;
    }

}

class Creature {
    // display character for creature
    private char pic;

    // (i, j) coordinates for creature
    private int i = 0;
    private int j = 0;

    private boolean canMove = true; // can creature move?


    Creature(char c, int nI, int nJ) {
        // set display character to c
        pic = c;
        // set position to (nI, nJ)
        setIJ(nI,nJ);

    }

    public void setIJ(int nI, int nJ) {
        // set (i, j) coordinates for creature
        // if new coordinates are invalid, leave current position unchanged
            this.i = nI;
            this.j = nJ;

    }

    public void setMoving(int n) {
        if (n == 0)
            canMove = false;
        else
            canMove = true;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void update() {
        // random position update; call update with random argument 1-4
        int c = (int)( Math.random() * 4 + 1);
        if (canMove) {
            switch (c) {
                case 1:j--;break;
                case 2:i++;break;
                case 3:i--;break;
                case 4:j++;break;
            }
        }

    }

    public void update(int c) {
        // if canMove, update position according to user command c
        // 1: j-- (left)
        // 2: i++ (down)
        // 3: i-- (up)
        // 4: j++ (right)
        if (canMove) {
            switch (c) {
                case 1:j--;break;
                case 2:i++;break;
                case 3:i--;break;
                case 4:j++;break;
            }
        }
    }

    public void display(char [][] g) {
        g[i][j] = pic;
    }

}
