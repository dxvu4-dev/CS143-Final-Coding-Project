# Scholarship Search Engine & Tracker
This program receives user data and uses that information to match the user with eligible scholarship opportunities.  
This program also helps track accepted Scholarship opportunities made by the user.

## OOP Architecture 
    [Abstract Base Class: Scholarship] 
                 /         \ 
        [Subclass: User]  [Subclass: _Scholarship]          <---- Polymorphic behavior
               \                   /
            [Class: CompareScholarships]                    <---- Handles ArrayList<Scholarship> 
                        |
                  [Class: Main]                             <---- Encapsulates data with user input
  

## What Each Class Does
* **Scholarship** - This abstract class has the fields, accessor, and mutator methods for a scholarship object.
* **User** - Extended from Scholarship class due to field similarities.
* **Other Classes that Extend Scholarship** - We hard code scholarship values in these subclass constructors, the constructors do not take parameters. We call the constructor to fill a scholarships ArrayList.
* **CompareScholarships** - This class handles ArrayList<Scholarship>, comparing it, and returning sorted ArrayLists of eligible scholarships that matches the user.
* **Main** - Creates User class, calls CompareScholarships class, and provides info to user via a menu based interface.
## Explain how the work together to perform project task
1) Main prompts user for info to initialize user class.
2) compareScholarships method is called which takes user class as parameter. A compared ArrayList is returned.
3) Scholarships are displayed to user, user may choose to accept scholarships to track them.
## Project Members
Made by David Vu, Kevin Ho, Casey LaBay, and TT Truong.
