# coursework-project-
Feedback Submission System - Alchemy of Souls

Student Name:

[Your Name Here]

Description:

The Feedback Submission System is a command-line Java application developed to collect and manage feedback from viewers of the K-Drama Alchemy of Souls. The system allows users to submit feedback including their name, email, rating (1–5), and a short comment. Users can view, update, delete, and export feedback, with all data stored persistently in a CSV file.

Objectives:

To implement CRUD operations using Java with a command-line interface.

To practice file handling and data persistence.

To validate user inputs such as emails and ratings.

To generate feedback reports including total submissions and average ratings.

To provide import/export functionality with CSV format.

Project Requirement List:

CRUD Operations – Create, Read, Update, and Delete feedback.

Command Line Interface – Easy-to-use terminal-based interface.

Input Validation – Validates empty fields and email format.

Data Persistence – Feedback data saved to alchemy_feedback.csv.

Modular Design – Code organized into classes (Feedback, FeedbackManager).

Error Handling – Graceful error messages for invalid input or missing files.

Feedback Reports – Displays total feedbacks and average rating.

Export Function – Saves feedback in CSV format.

Import Functionality – Reads from CSV on program startup.

Presentation Ready – Simple structure and clean logic for demonstration.

Documentation:

Key Classes:

Feedback: Holds details like id, name, email, rating, and comment.

FeedbackManager: Handles feedback list and performs file read/write.

FeedbackSystem: Main menu loop and CLI interaction logic.

Algorithms:

Basic linear search used to find feedback by ID.

Iteration over feedback list for report generation.

Input checked with simple validation (@ in email, non-empty fields).

Data Structures:

ArrayList<Feedback> used to manage feedback entries in memory.

Challenges Faced:

Handling commas in feedback comments during CSV parsing (solved by limiting split count).

Preventing data loss with reliable file read/write.

Designing simple yet functional CLI flow.

Test Cases and Outputs:

Test Case 1: Submit Valid Feedback

Input:

Name: Mina

Email: mina@example.com

Rating: 5

Comment: Loved the magic and character arcs!

Output:

Feedback submitted. Thank you!

Test Case 2: View All Feedback

Output:



Mina (mina@example.com) - Rating: 5
Comment: Loved the magic and character arcs!

Test Case 3: Invalid Email

Input: Email: minaexample.com

Output: Invalid input. Name, email, and comment are required.

Test Case 4: Delete Feedback ID Not Found

Input: ID = 999

Output: Feedback not found.

Test Case 5: Generate Report

Output:

Total Feedbacks: 2

Average Rating: 4.50/5

Output Samples:

(Screenshots should be taken of the console during Create, Read, Update, Delete, and Report operations.)

Suggested Presentation Structure:

Introduction to the project and the K-Drama context

Demonstration of each feature (submit, view, update, delete, report, export)

Discuss code structure and error handling

Answer questions

Add new feature live (e.g., filter feedback by rating or keyword)

Bonus Suggestions:

Live Feature Addition: Add search by rating (e.g., show all 5-star feedback).

Authentication/Role Based (Optional): Add admin-only access to delete/update.

GUI Upgrade (Optional): Implement in JavaFX with input forms and a table view.

File Used:

alchemy_feedback.csv – Stores all feedback records in CSV format

Export/Import Support:

On startup, app imports feedback from CSV file

Export option saves current session back to the file

Final Note:

This project provides a hands-on implementation of file-handling, OOP, input validation, and user interaction in Java while being contextually engaging for fans of Alchemy of Souls.

