Git Intro Activity
==================

A. Form teams
-------------

Form a 2-person team. Try to find someone who uses the same platform as you (e.g., Windows, Linux, etc.). If you can't, that's fine. If you are the odd-person-out, join a team of 2.

Complete the exercises below, and fill in your answers in the spaces provided below each question.
Once you have completed all the exercises and filled in this file with your answers, 
add this file to your Lab 9 directory (which you will create in section G) and push it to your team repo.
This file is the deliverable for this lab, so make sure you do not forget to push it at the end!

1.  List your team members below.

    ```
	Stephen Lu
	Devarshi Patel


    ```


D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```
	Git help shows all of the different commands that can be used in various situations.

    ```

2.  What does `-ag` cause `git help` to do?

    ```

	-ag prints a list of all useful guides of the available commands

    ```

G. Basic commands
-----------------

Open the terminal. Navigate to your team’s repository directory.

Create a directory inside of your team repository which will act as your submission directory for this lab.
The directory should be named according to the last names of your team members following the format below.

    <member1LastName>_<member2LastName>_Lab9

Use a plain text editor to create `names.txt` inside the directory you just created.
Put the names of your team in the file. Save and exit.

Run `git status` before and after each of these commands.

    git add names.txt
    git commit –m “Add our names.”
    git log

1.  What kind of information does `git status` report?

    ```

	Shows modified files in working directory, staged for the next commit.

    ```

2.  What does `git add names.txt` do?

    ```
	It adds the file to our local repository. 


    ```

3.  What does `git commit -m "Add our names."` do?

    ```
	It commits the file so it can be pushed. When it gets pushed, the message “Add our names” will appear in the 	repository. 


    ```

Use a plain text editor to create the following files:

-   `birthdays.txt` - Put your birthdays in this file. (you are not obligated to use real information here)

-   `movies.txt` - Put the last movie each of you watched in alphabetical order.

Run `git status` before and after each of these commands.

    git add .
    git commit		Note:  Commit will open the vim editor; write a multi-line commit
						   message, save and quit (press esc and then type :wq).
    git log

4.  What does `git add .` do? What do you think `.` means?

    ```
	It adds all the files at once. 


    ```

5.  What does `git commit` (without -m) do?

    ```
	Without the ‘-m’ allows for a multiline message.


    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
	‘git commit’ would be better than ‘git commit -m’ because it allows for a multiline message. 


    ```

7.  What does `git log do`?

    ```
	It shows a list of previous commits with their dates and times. 


    ```


H. Stage/Cache/Index
--------------------

Do the following:

-   Modify `names.txt` so that names are listed in *Last, First* format,
    one per line.

-   Modify `movies.txt` so they are in reverse alphabetical order
    by title.

-   Create a new file `foods.txt` that contains your favorite foods (one
    for each team member).

Run the following commands:

    git add names.txt
    git status

1.  Below write each file name under the state that its changes are
    currently in. Compose a definition for each state.

    **Staged**

    ```
	names.txt

	
    ```

    **Unstaged**

    ```
	movies.txt


    ```

    **Untracked**

    ```

	foods.txt

    ```

1.  If you run `git commit` what changes will be committed (***DON’T DO IT***)?

    ```
	‘names.txt’ would be committed and ‘foods.txt’ and ‘movies.txt’ would not be committed since they were not 	stages.
	

    ```

2.  What command do you run to stage changes?

    ```
	‘git add <file>…’ and ‘git checkout — <file>…’ 


    ```

3.  What command do you run to unstage changes?

    ```
	‘git reset HEAD <file>…’ would be used.


    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
	Shows changes made to an unstaged file. It shows what was in before and what there is currently.


    ```

2.  What does `git diff --cached` display?

    ```

	Shows what was in before and what there is currently. It shows the changes made to a staged file.

    ```

3.  Formulate a sequence of commands to unstage changes to `names.txt`,
    and stage the changes to `movies.txt`. Execute your commands and
    confirm they worked.

    ```
	git reset HEAD names.txt
	git add movies.txt
	git status


    ```

4.  Edit `movies.txt`, change any one of the movies, and save it. Then
    run `git status`. What do you observe? Explain what you think is
    going on.

    ```

    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
	We think the changes made to the file need to be added.
	

    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
	“movies.txt” is marked as deleted in the unstated section but appears in the staged section. The “last-		movies.txt” is an untracked file. 


    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```
	git add .
	git commit
	git status
	

    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?

    ```
	It holds a list of paths and their given object names.


    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
	Stage is important because lets a file hold a spot before committing. This lets commits to be able to change.


    ```

I. Undo
-------

Run the following commands:

    git log
    git status
    git reset --soft "HEAD^"
    git log
    git status

1.  What does `git reset --soft ``"HEAD^" `do?

    ```
	This command undo’s any previous commits that were made.


    ```

Run the following commands:

    git commit –m "Redo."
    git log
    git status
    git reset --hard "HEAD^"
    git log
    git status

1.  What does `git reset --hard ``"HEAD^"`` `do?

    ```
	This command sets the ‘head’ to be the most recent commit message and throws away any other committed changes 	made.


    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
	--soft: commit is undone
	-—hard: commit is thrown away


    ```

3.  What do you think `HEAD` means?

    ```
	‘HEAD’ may refer to the current commit made.

    ```

4.  What do you think `HEAD^` means?

    ```
	‘HEAD^’ might mean the reference to the commit before the current commit.

    ```

J. Helpful resources
--------------------

-   <https://git-scm.com/doc>

-   <https://www.atlassian.com/git/tutorials/>

-   <https://training.github.com/kit/downloads/github-git-cheat-sheet.pdf>

K. Copyright and Licensing
--------------------------

Copyright 2016, Darci Burdge and Stoney Jackson SOME RIGHTS RESERVED

This work is licensed under the Creative Commons Attribution-ShareAlike
4.0 International License. To view a copy of this license, visit
<http://creativecommons.org/licenses/by-sa/4.0/> .
