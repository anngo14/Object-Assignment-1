1. Creator
The Game Class is a prime example of this GRASP principle as it creates new instances of Deck, RuleSet, PlayingCard, 
and Player. These objects are required in game as it records the information of these objects into private instance variables
that are to be used to make the Game run. In addition to recording these instance variables, the Game class also contains
these objects as private instance variables as attributes.
 
2.High Cohesion
The PlayingCard class demonstrates high cohesion as every method in this class contains at least one instance variable within
it. These instance variables are either being modified or being returned. 

3. Polymorphism
The ThreePlayerRules class uses polymorphism in order to implement its own tieBreaker() method. The ThreePlayerRules class
extends the RuleSet class which has a defined tieBreaker() method that both the StandardRules and ScoreRules class use.The 
defined tieBreaker() method does not work as it is defined in the RuleSet class for what needs to be done in the 
ThreePlayerRules class and as such, the tieBreaker() method is redefined in the ThreePlayerRules class.

4. Low Coupling
The Player class shows low coupling as it has methods that return each of its information attributes. Using these methods
information can be stored in one variable to be used in other methods throught the program.