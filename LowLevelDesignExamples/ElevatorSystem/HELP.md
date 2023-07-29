Raj is constructing the 5 Star Hotel in Bangalore, He wanted to build the hotel, such a way that it
should be customer and employee-friendly. He wanted to handle the customer requests should
be handled with efficient time. So he analyzed what are the places where the customer might get
delay for their regular routines. He understood that there are 2 important places.
1. food requests and Elevator requests. So he decided to handle these 2 requests in an efficient
   manner.
   Now while construction of his hotel he wanted to design an efficient elevator system.
   So he called his engineer and informed him to design software for his elevator system within 1
   week, which will work efficiently, he average wait time for people should be minimum

Help him to develop a software which will allocate and handle the request efficiently .
Write a generic program to efficiently manipulate elevators. Assume there are N elevators that
can operate at the same time for an apartment having N floors.
a. Elevator works efficiently when it goes up and down.
b. The average wait time for people should be minimum
Input Format:
1st line of input is an integer indicates the number of floors
2nd line of input is an integer indicates the number of elevators
3rd line of input is an integer indicates the number of people
Next N lines indicates details of person having person_name,arriving_tine,from_floor,to_floor
Output Format:
The output consist of set of lines having details of lift name and person (Refer sample I/O for
the specifications )
The minimum possible total time required to drop the all the people who requested in the
rescpective floors.
Explanation:
Note :
1. Consider initally all the lifts in Oth floor (Ground floor ) and state is Idle.
2. Name the all the lifts Lift1, Lift2, Lift 3. so on.
3. If all the floor are idle pick the Lift 1 to carry the people.
4. Need to make use of lifts efficiently, which ever the lifts near to starting floor of the person.