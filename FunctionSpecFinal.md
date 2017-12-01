# **Table of Contents**

Table of Contents					     Page 1

**1. Introduction**		                 Page 2
1.1 Overview						     Page 2
1.2 Description					         Page 2
1.2 Business Context				     Page 3
1.3 Glossary						     Page 3

**2.General Description**				Page 4
2.1 Product/System Functions 			Page 4
2.2 User Characteristics and Objectives		Page 5
2.3 Operational Scenarios 				Page 6-7
2.4 Constraints					Page 8

**3.Functional Requirements**			Page 9
3.1 User Interface/Gameplay Graphics		Page 9
3.2 Gameplay Accuracy				Page 10
3.3 Game Reliability/Performance			Page 11

**4.System Architecture**				Page 12
System Architecture diagram			Page 12

**5.High-Level Design** 				Page 13
5.1Context diagram					Page 13
5.2 Application life-cycle				Page 13
5.3 Data flow diagram				Page 14

**6.Preliminary Schedule**				Page 15
6.1 Overview of Preliminary Schedule		Page 15
6.2 Task List						Page 15
6.3 Gantt chart					Page 16

**7.Appendixes**					Page 17
7.1 Websites						Page 17
7.2 videos						Page 17

---
# **1 Introduction**

**1.1 Overview:**
The idea for this project came from both members having an interest in game development. We decided to create our own version of the infamous block breaker game where you control a paddle moving left and right and it is used to deflect a bouncing ball upwards onto static bricks which are placed throughout the screen.

The game will allow us to be creative in the different features (detailed below) we plan on implementing, as well as giving us the opportunity to show off the skills we have learned so far in Computer applications. Our version of the game is called BlockBreaker.
Block breaker will be played and tested on a windows pc.

**1.2 Description:**
The game begins by asking the user to choose between ‘Play Game’, ‘High scores’ and ‘How to play’ upon launch of the game.
‘How to play’ would just contain the user manual and text explaining to the user the rules of the game and how to play. 
‘High Scores’ will show the top 5/10 scores achieved by users worldwide.  
By clicking ‘Play game’ the user begins the game by choosing which difficulty they would like to play the game in between Easy, Intermediate and Hard. We believe giving the player the option to choose their desired level of difficulty is a feature which will be appreciated by the player.
The goal of the game is to try and achieve the highest score possible by destroying all the bricks in all levels in as little time as possible and with the least amount of lives lost
Some of the features we would like to include in our project would be 
-	Blocks moving side to side to make it more difficult for the player to hit 
-	Blocks changing colour from white to red where they can only be destroyed when white.
-	Speed of the ball & size of paddle will change depending on difficulty chosen.
-	Good user interface along with easy on the eye graphics.
---

**1.3 Business Context**
The game will be built to be played on a PC. It can be placed on a server online and played by millions of people. Advertising can get a lot of money by placing ads around the game. The game would be free which would achieve more money from advertising. 

The game can also be sold to a gaming website in which they could add it to their existing website along with the rest of their games. New owners can then decide to make it free and place advertising.


**1.4 Glossary:**
XML: Extensible Markup Language (XML) is used to describe data. The XML standard is a flexible way to create information formats and electronically share structured data via the public Internet, as well as via corporate networks.

---
# **2 General Description**

**2.1 Product and Systems functions:**
Block breaker is a sub class of the “bat-and-ball genre”. The purpose of the game is to get the user to react quickly to the moving ball to destroy all the blocks to achieve victory.

Before starting the game, we will give the user the choice of what difficulty they would like to play the game on. By doing this we accommodate for users of all levels of expertise. The higher the level the user chooses, the more points available for them to achieve, i.e. If the user chooses ‘easy’ as their difficulty they will get 50 points for destroying a block but if they choose ‘hard’ they will get 100 points.

Blocks in the different levels will have different abilities. This is something we want to add to our version of the game to make it unique from all the others out there. Some examples of these different features would be blocks moving side to side. This makes it more difficult for a user to destroy it and requires the user to time when to hit the block and in what direction. Another possible feature we would like to add is ‘flashing blocks’, this basically means the block will change colour from white to red, if the block is red and is hit by the ball no damage will be done. This is just another unique feature we want to add to make our game a little different.

The difficulty the user chooses will impact the game greatly. What will change is the ball speed will increase when choosing a harder level of difficulty.  The paddle will also decrease in size when the user has chosen a harder level of difficulty.

The main goal of the game is to destroy all the blocks and move onto the next level. The user loses a life if they miss the ball and when the player loses all 3 lives the game is over.

By playing the game more and more the user will become more used to the ball speed and how to play the game in the best way possible. The idea would be to get the player hooked on the game and by adding the ‘high scores ‘feature we are giving the user the chance to play again and beat their previous best score.

---
**2.2 User Characteristics and objectives:**

As the Game will be hosted online, the product is accessible to anybody with a computer and access to the Internet. The target audience is anyone who has an interest in games, so the number of possible users is quite large.

While creating this game one thing we would like our game to be simple to use by anyone whether they are new to using computers or not. Nothing is more frustrating for a user than if they don’t understand exactly what needs to be done and how they should go about doing it.

Playing the game for the first time may be difficult for the user as they need to get used to the controls. For this reason, we will have a ‘how to play’ section which will walk the user through all the controls and the different types of blocks they will encounter while playing. 

There will be a certain amount of learning from experience on the user’s part. The difficulty they can play is something they will need to find out by themselves. The hope would be that after a while the user would be able to move up in difficulty and therefore have the chance to increase their old high score. 

---
**2.3 Operational scenarios.**

**2.3.1 User opens the application**

*Current System state:*

The current system state consists of no players as the user has not started the game yet. The game is waiting for the user to choose their difficulty.

*Informal scenario:*
The user chooses easy as their difficulty.

*Next Scenario:*
The game begins.

**2.3.2 User destroys block**

*Current System state:*

The system state consists of the ball moving at a low speed as the difficulty easy was chosen. The player wants to start destroying blocks.

*Informal scenario:*
The user hits the ball off the paddle in a way that the ball is going to hit a block. When the block is hit it will be destroyed.

*Next Scenario:*

The process is repeated until no more blocks are available to destroy.

**2.3.3 User loses a life**

*Current System state:*

The system state is the same as before. The user is still trying to defeat the level he/she is currently on.

*Informal scenario:*

The player was not concentrating enough and did not move his/her paddle in time and therefore lost one of three lives.

*Next Scenario:*

The players lives are decreased by one and the game is started once again from where it last left off.

**2.3.4 User finishes a level**

*Current System state:*

The user has now completed the first level. There are no blocks left for the user to destroy on this level.

*Informal scenario:*

The user now must prompt the application to begin the next level. The number of lives are not reset.

*Next Scenario:*
The next level begins, and the user must begin to destroy all the blocks.

---
**2.3.4 User loses all their lives**

*Current System state:*

The user has just lost the last of their three lives.

*Informal scenario:*

The user is brought back to the start page and they can choose to either play again or view previous high scores.

*Next Scenario*

The user begins the game again but chooses a lower difficulty.

**2.3.5 User completes the game** 

*Current System state:*

The game is now over as all levels have been complete.

*Informal scenario:*

The user has gotten a new high score and is now prompted to enter their name and their information is added to the high scores database.

*Next Scenario:*

The user is brought to the start page once again and this time chooses a harder difficulty to play on.

**2.3.6 User views high scores**

*Current System state:*

The user has completed the game and would like to see where they are ranked.

*Informal scenario:*

The user can now see what position they have come I the leader board. 

*Next Scenario:*

The user is brought to the start page once again and this time chooses a harder difficulty to play on.

---
**2.4 Constraints**

**Time:**
The amount of time we have to complete this project is small. We must have a working game, test that everything works perfectly, have a well-documented user manual and technical description by middle of March 2018. We will need to plan out the project so that we have time to do all the testing we want at the end.

**Graphics:**
Complex graphic packages can be expensive, so we will be limited in what type of graphics we will be able to use.

**Making our game unique:**
When presenting our proposal for this game we were told that our game could be compared to those that have been made before. Therefore, we must try to make ours as different as possible and show off where we can. This is where we hope our features will set us apart from other versions of the game that have been made by companies with more time and money to put into projects.

**Game physics**
When creating the game, we need to ensure that the physics of the game makes sense. This means that when the ball hits the paddle or a wall it will bounce back in a direction that makes sense. If we don’t do this the game wouldn’t be fun to play.

---
# 3 Functional Requirements

**3.1. User Interface/Graphics:** 

**Description:**
This refers to the graphics of the game and the games ease of use in terms of seeing/ using the options on the board, paddle etc. We will give the user some options which will result in the correct changes for their desired choice e.g. clicking easy should result in an easy level.  Creating clear easy to see options will take some research into design of the app and colour usage so that the contrast of colours doesn’t provide difficulty for the user. Graphics also must be done in the best way to ensure user satisfaction and so that they don’t use competitor’s games.
**Criticality:**
User interface is always critical. If an app was not user friendly an easy to use and navigate then it would have little to no users. UI is critical also with our game, we need the user to know exactly what he/she must do and that it shows exactly what is meant to happen, very clearly. The actual functionality of our game is irrelevant if the app is not user friendly
**Technical issues:**
 With good preparation and planning we will have little technical issues when it comes to user interface. Especially with the fact that there are a lot of libraries to choose from to allow easy and simple yet effective UI/UX
**Dependencies with other requirements:**
The graphics only rely on what library we choose and how we implemented it within the code.

---
**3.2. Gameplay:** 

**Description:**
This refers to the physics of the game. Whether it is the ball bouncing back at an angle rather than a random pattern, or when you choose a difficulty the correct ball speed and paddle size is initiated etc. If these matters are not dealt with correctly then the game loses its meaning and just becomes obsolete
**Criticality:**
 Gameplay accuracy is critical in keeping the attention of the user. There is nothing more frustrating than getting an incorrect result from an option or losing the game because the ball just hit the side and fell back down. If the game doesn’t exactly do what it is meant to then no one would play the game and therefore would receive no revenue from advertising etc.
**Technical issues:**
 We will try our best to get no technical issues within our game. An Xml configuration file will help us keep in track of all levels and difficulties during gameplay. Operational scenarios will help go through the game step by step to make sure everything works as it should. Using these scenarios, we will conduct our testing ensuring these technical issues are dealt with.
**Dependencies with other requirements:**
The gameplay would not really rely on other requirements only our code itself.

---
**3.3. Game Reliability:**

**Description**
The game must function smoothly on the platform in which it is running. We will need to test it on different machines to with different specifications and different CPU Power systems. The game must not crash or freeze during gameplay.

**Criticality**
Very critical requirement because the game is not just going to be played on one machine or one type of machine. It needs to be configured the same across all PC systems being played on. Otherwise the game would receive bad reviews and users would not recommend the app to others. As well as that if the game freezes or crashes, a user will be put off returning and recommending 

**Technical Issues:**
Although it isn’t a huge issue, we still only have two operating systems available to us, windows and Linux. We would also need to test on iOS. Different CPU powers on different devices could be a problem with slower devices possibly not being able to handle the game. We would most likely complete the app on one machine and one operating system and then see what happens in the testing phase.

**Dependencies with other requirements**
Depends on the CPU power of the device being able to run the game smoothly and the operating system being to a certain level for it to run certain graphics features.

---

# 4 System Architecture

![](https://i.imgur.com/2uS8QxG.png)

---

# 5 High-level design

**5.1Context Diagram**

![](https://i.imgur.com/4HJeWHV.png)

**5.2 Application life-cycle**

![](https://i.imgur.com/QGioCjz.png)

---

**5.3 Data flow diagram**

![](https://i.imgur.com/pyT7bkF.png)

---

# 6 Preliminary Schedule 

**6.1 Overview of Schedule**

Below I have listed out many of that tasks that are essential to our third-year project and their estimated start and end dates. As it is still early we do expect some slight changes to this schedule, but we plan to stick to this timeline as best as possible

The Gannt chart below gives a visual representation to this timeline
**6.2 Task list**
![](https://i.imgur.com/JnComSD.png)

![](https://i.imgur.com/IEc8hLV.png)

---
**6.3 Gannt chart**

![](https://i.imgur.com/wxwmPLv.png)

---

# 7 Appendices:

**Websites:**
http://gamecodeschool.com/java-tutorials/

http://searchmicroservices.techtarget.com/definition/XML-Extensible-Markup-Language

http://www.gametutorial.net/

**Videos:**
https://www.youtube.com/watch?v=1gir2R7G9ws

**Book:**
Killer Game Programming in Java 1st Edition by Andrew Davison

**Game:**
https://www.kongregate.com/games/warrington/brick-breaker