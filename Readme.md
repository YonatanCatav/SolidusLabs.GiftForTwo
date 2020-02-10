# Gift for Two

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

# Requirments
Write a program to find the best two items. It takes two inputs:
1. A filename with a list of sorted prices
2. The balance of your gift card
If no two items have a sum that is less than or equal to the balance on the gift card, print “Not
possible”. You don’t have to return every possible pair that is under the balance, just one
such pair.
# Complexity
The complexity of the solution is ![\pic](http://www.sciweavers.org/upload/Tex2Img_1581367872/render.png)
# Bonus
The following algorithm will achieve ![\pic ](http://www.sciweavers.org/upload/Tex2Img_1581367411/render.png) complexity solution:

  - Itearte on each item and substract it from the list of items 
  - run the algorithem on the remaining items and the amount in the card minus the price of the item that was substracted 
  -  choose the set of 3 items from the previous step that their sum is the closest to the amount in the card (the 3 items that their ![\pic](http://www.sciweavers.org/upload/Tex2Img_1581367734/render.png) value is the lowest).
  


