## Attendance Taking Module - Android - Firebase

Attendance Taker is an android application which can be used to take and upload the attendance to a real-time database.
It integrates the benefit of taking attendance using an android device which will be connected to an cloud database hosted by Firebase.
When the user takes the attendance, it will be automatically updated in firebase by incrementing the attendance count.
Once the attendance is taken and submitted, it is not possible to modify the attendance of  any person.
Only the super user has the authority to edit or modify the attendance, via firebase or the webapp(see WEBAPP repository). 

## Motivation

A primary goal of this app is to eliminate pen-paper system of taking and maintaining attendance in schools and colleges using a smart phone.


## APIs

Uses RecyclerView for listing the student names
Uses Firebase for for cloud database(NoSQL)