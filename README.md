# Data Structures Projects and Labs
A collection of CSC150 projects and labs completed in Winter 2015.

## Project 1 - Looking out for Number One
**Assignement**

Create a program that takes a file of statistics as input, computes how many of the numbers have
x as a leading digit for all x 1-9, and then plots a bar graph showing the relative frequency of
each of the digits when they lead off a number. The output of your program should look
something like this:

File:
"sunspot_data.txt"
frequency of the lead digit

1: *****************************************************************

2: **********************************************

3: ****************************************

4: ********************************

5: *************************

6: **********************

7: ********************

8: ********************

9: *****************

## Project 2 - Unfair Solitaire?
**Assignement**

Create a program that simulates playing solitaire. Remember, you're not
building a game to be played by a user. You're simply building a program that will play the game
internally. The output of your program should be the number of times that the computer wins out
of 1000 simulated games. Include the win-rate as a percentage. Then repeat the experiment for
2000 games, 3000 games, and so on up to 10000 games. Thus your program's output will look
something like this (with the questions marks replaced by real numbers):

?/1000 games won = ?%

?/2000 games won = ?%

?/3000 games won = ?%

?/4000 games won = ?%

?/5000 games won = ?%

?/6000 games won = ?%

?/7000 games won = ?%

?/8000 games won = ?%

?/9000 games won = ?%

?/10000 games won = ?%

## Project 3 - Figure Eight
**Assignement**

Create a program that allows 2 or more humans to play Crazy Eights via keyboard input and
System.out for output. 

The game should announce when any player has exactly one card remaining (as a warning to the
other players). The game will end when the computer announces a winner.

## Project 4 - Get in Line, Part I
**Assignement**

Your assignment is to create the public **Sequence** class that will allow you to construct and use
sequence containers. Your **Sequence** class will be limited to storing Strings (your book discusses
how to implement a sequence that can store doubles). I want you to implement your **Sequence**
class using arrays. That is, each instance of a Sequence object should have its own array for
storing the data contained in the sequence. Chapter 3 of your book provides a nice discussion of
the design of a sequence ADT. In particular, it gives a suggested **invariant** for the ADT that
should help you get started. You should feel free to implement according to the book's suggested
invariant, or make your own. In any case, **include the invariant of your ADT in a comment**
near the top of your class in Sequence.java.

To help get you started, you can download the skeleton of the Sequence class from Nexus. **Your
implementation must have *exactly* these methods with *exactly* these method signatures.**
**You are not allowed to change the signatures of the Sequence methods in any way. In
addition, your toString method should return a string that uses sexactly the format
specified in the comments.** You are also not allowed to use any of Java's built-in containers for
this project, like **ArrayList** or **Vector**. You are, however, encouraged to build private helper
methods if you wish. It is your job to figure out what instance variables are appropriate. 

## Project 5 - Get in Line, Part II
**Assignement**

Redo Project 4 in its entirety, but this time, use a linked list to hold the data members of a
sequence instead of an array. You must keep the exact same public interface that was given in
Project 4. See Project 4 for the interface and testing code. 