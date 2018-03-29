# ASCIIDraw
__Description__

This is a simple console drawing program in Java.

The program works as follows:
 1. Create a new canvas
 2. Draw on the canvas by issuing various commands
 3. Quit


|Command 		|Description|
|----|----|
|C w h          | Create a new canvas of width w and height h.|
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|
|               | horizontal or vertical lines are supported. Horizontal and vertical lines|
|               | will be drawn using the 'x' character.|
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|
|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|
|               | using the 'x' character.|
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The|
|               | behaviour of this is the same as that of the "bucket fill" tool in paint|
|               | programs.|
|Q              | Quit|

__Sample Run__

Below is a sample run of the program. User input is prefixed with `enter command: `
````text
enter command: C 20 4
--------------------
|                  |
|                  |
|                  |
|                  |
--------------------

enter command: L 1 2 6 2
--------------------
|                  |
|xxxxxx            |
|                  |
|                  |
--------------------

enter command: L 6 3 6 4
--------------------
|                  |
|xxxxxx            |
|     x            |
|     x            |
--------------------

enter command: R 14 1 18 3
--------------------
|             xxxxx|
|xxxxxx       x   x|
|     x       xxxxx|
|     x            |
--------------------

enter command: B 10 3 o
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xoooooooooooo|
--------------------

enter command: L 6 4 13 4
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xxxxxxxxooooo|
--------------------

enter command: B 1 2 .
--------------------
|oooooooooooooxxxxx|
|......ooooooox   x|
|     .oooooooxxxxx|
|     ........ooooo|
--------------------

enter command: Q
````


__Build__
To build the executable Jar, run the following maven command in the project root directory:
$ mvn clean package

It will create a jar ASCIIDraw.jar in <project root>/target directory.

__Run__
To run the program:
$ java -jar ASCIIDraw.jar
