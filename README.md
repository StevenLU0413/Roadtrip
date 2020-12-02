# Roadtrip
There are two files I need to use, one for roads and one for attractions. Because we are producing the shortest route of users choice it is good to have ArrayList as the datatype.
Also because of  how easy it is to manipulate the size and the content. 

In the Roadtrip class I think I need three private instance variables. Two of them is the arraylist that we keep to track the content in the .csv file. And the other one will be the lists that consist of the attractions that users want to visit. 

I will have two other classes each for roads and attractions. And 

Since the list of users interest is listed with order, then all we need to do is find the route that matches with the attractions’s city name. 

The way I will design my route algorithms:
Since we have a list to keep track of the attraction that the user picked.We add the starting city to the result list.  We can start off by looping through the attraction lists. We can set the current city name to the index that we are tracking now. We can also have a local variable to keep track of the index of the attraction lists. If the current city name matches with the road city name then we add it into the final result. Then we add the endCity to the last of our lists. 
