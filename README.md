# Feedback Submission System




Student who worked on the project- Berdibekova Zhasmina EEAIR24.




# Presentation





-------------------------------

# Overview

The **Feedback Submission System** project is for collecting and managing feedbacks, in my case I used feedback submission system specifically for the K-Drama "Alchemy of Souls".It provides an interactive menu-based interface where users can easily submit their opinions, rate the drama, and provide comments. All feedback entries are saved to a CSV file, allowing the application to retain data between runs.

The system supports full CRUD operations—allowing feedback to be created, viewed, edited, and deleted. It also includes input validation to ensure the accuracy of user input (such as valid email formatting and numeric ratings between 1 and 5). 


-----------------------------------------

# Objectives

1.Create a user-friendly CLI for feedback collection.

2.Store feedback in CSV files with data persistence between sessions.

3.Implement robust input validation and error handling.

4.Support full CRUD operations.

5.Generate summary reports for insights.



-----------------------------------

# Features and Requirements

1.**CRUD Operations:**   Create, Read, Update, and Delete feedback records.

2.**User-Friendly CLI(Java-based Command-Line Interface):**   Menu-driven interface with clear prompts.

3.**Input Validation:**   Validate email format, rating (1–5), and prevent empty inputs.

4.**Data Persistence:**   Store feedback in a CSV file to retain data.

5.**Modular Design:**   Separate methods for each operation (submit, view, update, delete).

6.**Error Handling:**   Graceful handling of invalid inputs or file errors.

7.**Unique IDs:**   Automatically generated IDs that increment starting from 1.

8.**Report Generation:**   Displays total feedbacks and rating distribution.

9.**CSV I/O:**   Feedback records are read from and written to a CSV file.

10.**Documentation:**   Includes a README file and in-code comments.


-------------------------------------------


# Functions and Methods

1.**submitFeedback()**

Prompts the user for name, email, comment, and rating. Validates inputs and saves to list and file.

2.**viewFeedback()**

Displays all submitted feedbacks with full details.

3.**updateFeedback()**

Updates feedback fields by ID after checking for valid input.

4.**deleteFeedback()**

Removes a feedback entry by its ID and updates the CSV file.

5.**generateReport()**

Prints total feedback count and frequency of each rating.

6.**exitApp()**

Exits the application and logs the activity.



-------------------------------------------

# Algorithms and Data Structures

1.**Data Structure – List (ArrayList)**

All feedback records are stored in an ArrayList<Feedback>, which allows dynamic resizing, easy iteration, and efficient CRUD operations. This list is loaded from the feedback.csv file at the start and written back to it on changes.

2.**Search Algorithm**

The findById() method performs a linear search to locate a feedback entry by its ID. Since the dataset is relatively small, this is sufficient and simple to implement.

3.**Sorting (for report generation)**

Feedback ratings are tallied using a HashMap<String, Integer> to efficiently count how many feedbacks each rating received. This allows constant-time lookups and updates during iteration.

4.**Validation**

Input validation is done using regular expressions (for email) and string matching (for ratings and non-empty fields). Repetitive prompts are implemented using do-while loops to ensure valid input is collected.

5.**Unique ID Algorithm**

The program determines the maximum existing ID in the feedback list and sets nextId to maxId + 1, ensuring all new feedback entries get a unique incremental ID starting from 1.

---------------------------------


# Challenges Faced

1.Handling invalid inputs and keeping the program running without crashing.

2.Ensuring feedback IDs remain unique even after deletions.

3.Parsing and storing structured data from CSV correctly.




-------------------------------------------------------

# Outputs and test cases

** Input:**


Name: Aidar
Email: aidar@example.com
Comment: Loved the acting and storyline!
Rating: 5


**Expected Output:**
✅ Feedback submitted successfully!


--------------------------------------

**➔ Test Case 2: View All Feedback**
**Expected Output:**

ID: 1
Name: Adilet
Email: adilet@example.com
Comment: Loved the acting and storyline!
Rating: 5

---------------------------------------

**➔ Test Case 3: Invalid Email Input**


**Input:**
Email: kimminexample.com


**Expected Output:**
⚠ Invalid email format. Try again.




![image](https://github.com/user-attachments/assets/f5a778a8-9c92-4fdc-9b2a-b90494084d0f)

![image](https://github.com/user-attachments/assets/266e7431-b4c1-400d-ba68-ebf4d08a4427)

![image](https://github.com/user-attachments/assets/dd9f438e-0a2e-40f9-8132-a79819fae3de)

![image](https://github.com/user-attachments/assets/8947a537-312c-4a8a-949a-133f35592943)

![image](https://github.com/user-attachments/assets/e1f9e6a4-bba6-4a22-ba84-dd8dcc17f2fb)

![image](https://github.com/user-attachments/assets/29a45aa1-eeb6-48d6-b970-ad4934c39130)

![image](https://github.com/user-attachments/assets/9bdd2b0e-be60-40c6-9cbe-58ff8c4aba14)

![image](https://github.com/user-attachments/assets/d5368fde-5f36-4f25-a037-24638dbfc81e)



--------------------------------------------------
# Output File

The application creates and maintains a **feedback.csv** file containing all user feedback data in comma-separated format.


--------------------------------------
# Presentation





