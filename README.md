# ArticleStash

## A convenient way to store articles you've read online. 

This application will serve as a system, in which a user can track the newspaper articles they've read online.
The application will show a log of previous read articles, and the user can add a note to describe the article in
order for better allocation. Perhaps, a review of the article, furthermore, the application will log when the user first
read the article. This application would be used by anyone that wants to track the articles that they read online, 
in particular, this application would be most useful to me as I have constantly found it annoying to track articles that
I have read online, yes the bookmarks/favourites option is possible, however, it often gets messy there and I would like
to leave a review of the articles I've read just as a way to remember my thoughts on the articles in the future.

## User Stories 

- As a user, I want to be able to add an article I've found to my logs of articles read.
- As a user, I want to be able to view all the articles I've added to my logs to this point.
- As a user, I want to be able to write a comment on the article I've logged.
- As a user, I want to be able to rate the article that I've read.
- As a user, I want to be able to add articles to a list of want to reads.
- As a user, I want to be able to remove an article from my logs.
- As a user, I want to be able to remove articles form the list of want to reads.
- As a user, I want to be able to see the statistics on how many articles I've read in the year and all-time.
- As a user, I want to be able to save the list of articles I've read so far if I want to.
- As a user, I want to be able to load up all the list of articles I've read so far if I want to.

## Instructions for Grader
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by pressing either 
- the Want To Read or Articles Read tab, then proceeding to Add Article, then from there there's an input panel that 
- pops up, and the user can input the article link, the article rating, and the comment that they have on the article.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by going to view 
- articles in whatever tab you're in Articles Read or Want To Read, then there'll be a pop up that asks the user
- if they want to view articles based on rating, then the user can input the specific rating they would like to filter 
- the articles based on. Then, there'll be a pop up of all the articles that the user has added thus far that fit the
- specific criterion.
- You can locate my visual component by seeing the newspaper cartoon that I have placed on the HomeTab.
- You can save the state of my application by pressing the Save button on the Home tab.
- You can reload the state of my application by pressing the Load button on the Home tab.

## Phase 4: Task 2
- As the project runs, as there is only the addition of adding an article to the UI from the last phase,
- the only expected event would be. This should be printed once the user clicks quit on the home menu, or 
- just simply closes the window.
- Date: Sat Apr 06 00:12:04 PDT 2024
  Description: Added this article:
  (article name)
  (article rating)
  Comments: (article comment)

## Phase 4: Task 3
- If I had more time and could work on further refactoring my project, I believe I would have worked 
- on the tab classes further. I think there's a lot of coupling, here, and repetitive code within the classes.
- I could have created an interface that all the tabs use as there's a lot of similarities between the A
- ArticlesWantToReadTab and the ArticlesReadTab, thus it leads to clustered code. Also, code that looks unprofessional.
- Otherwise, I could have made Tab more effective as an abstract class in that regards to de-cluster the other two 
- classes that I've mentioned. To implement this change, I would have made placeButtons a method in the Tab class that 
- does the same thing as it does now for each class, however, allow it to be implemented once in Tab then I wouldn't 
- have to continuously implement it in the two classes separately. As I look through the two classes, the only
- difference is within the NoOption and the YesOption methods, I could have overwritten these two in their respective
- classes, however everything else could have been abstracted into the Tab class, thus I believe that would have been
- much more efficient code. 
