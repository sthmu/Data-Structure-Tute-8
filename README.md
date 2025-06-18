# Q2.java

## Overview
The `Q2.java` file demonstrates the use of custom data structures (`LinkedList` and `ContigousList`) to manage and manipulate a list of books. It includes functionalities such as sorting, sequential search, and binary search. The program uses a `Book` class to represent individual book entries.

## Features
- **LinkedList Implementation**: A custom linked list is used to store and manipulate book data.
- **ContigousList Implementation**: A custom contiguous list is used for binary search operations.
- **Sorting**: Books are sorted by year using selection sort.
- **Searching**:
  - Sequential search for books by year.
  - Binary search for books by year using the contiguous list.
- **Display**: Books are displayed in a tabular format.

## Classes
### `Book`
Represents a book with the following attributes:
- `bookId`: Unique identifier for the book.
- `bookName`: Title of the book.
- `authorName`: Author of the book.
- `year`: Year of publication.

Implements the `Comparable` interface to allow comparison based on the year of publication.

### `Q2`
The main class that:
1. Initializes a list of books.
2. Sorts the books by year.
3. Performs sequential and binary searches for books by year.
4. Displays the results.

## How to Run
1. Ensure all required files (`LinkedList`, `ContigousList`, `List`, etc.) are in the same project directory.
2. Compile and run the `Q2.java` file.
3. Follow the prompts to search for books by year.

## Example Output
```
bookId     Title                       Author               Year
------------------------------------------------------------------------
B001       Data Structures             S. Tanenbaum         2018
B002       Operating Systems           A. Silberschatz      2020
...

Sorting the books based on year using selection sort...

Sorted List of Books:
bookId     Title                       Author               Year
------------------------------------------------------------------------
B007       Discrete Mathematics        K. Rosen             2015
B006       Database Management         R. Elmasri           2016
...

Sequential search

Enter the year of the book to search: 2018
bookId     Title                       Author               Year
------------------------------------------------------------------------
B001       Data Structures             S. Tanenbaum         2018
B009       Software Engineering        I. Sommerville       2018

Binary search

Enter the year of the book to search: 2020
bookId     Title                       Author               Year
------------------------------------------------------------------------
B002       Operating Systems           A. Silberschatz      2020
```

## Dependencies
- `LinkedList`: Custom linked list implementation.
- `ContigousList`: Custom contiguous list implementation.
- `List`: Interface defining the structure of a list.

## Notes
- The program uses a custom `selectionSort` method for sorting.
- Binary search is implemented in the `ContigousList` class.
- Ensure the `Book` class implements `Comparable` for sorting and searching to work correctly.
