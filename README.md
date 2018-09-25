# GameOfLife
A simple object oriented code for solving the GameOfLife.

============== . PROBLEM STATEMENT =================

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells,
each of which is in one of two possible states, live or dead. Every cell interacts with its eight
neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At
each step in time, the following transitions occur:

1. Any live cell with fewer than two live neighbours dies, as if by loneliness.

2. Any live cell with more than three live neighbours dies, as if by overcrowding.

3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.

4. Any dead cell with exactly three live neighbours comes to life.

The initial pattern constitutes the 'seed' of the system. The first generation is created by applying
the above rules simultaneously to every cell in the seed — births and deaths happen
simultaneously, and the discrete moment at which this happens is sometimes called a tick. (In
other words, each generation is a pure function of the one before.) The rules continue to be
applied repeatedly to create further generations.


================================= . SOLUTION =====================================

Primarily focussed on TDD. The solution involves the tests followed by the necessary code.

STEPS:
1. Represent Cell and Grid model objects. The Cell would contain attributes such as its x-coordinate, y-coordinate and the current state [ALIVE / DEAD]

2. Represent Grid which would contain 2 dimensional array of Cells.

3. On start of game, the next state would be computed depending on the current state of every cell by invoking the ApplyTick method.
The necessary business logic is added into the respective classes.

