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
John Tejeda, and Tyler Hill.

    ```


D. Getting help
---------------

Run the following commands.

    git help
    git help -ag
    git help init

1.  What does `git help` do?

    ```

git help returns a list of all the common commands used.	


    ```

2.  What does `-ag` cause `git help` to do?

    ```

“git help -ag” returns a list of all the commands available.

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
‘git status’ tells you when there are files or folders that are not tracked and which ones have not been committed yet.

    ```

2.  What does `git add names.txt` do?

    ```
‘git add names.txt’ adds the file to your local repo.

    ```

3.  What does `git commit -m "Add our names."` do?

    ```
‘git commit -m “Add our names.”’ commits the file so it can be pushed, and once its pushed there will be a message on your GitHub online repo that says “Add our names.”.

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
‘git add .’ adds all the files that need to be added at once as opposed to doing it one by one.

    ```

5.  What does `git commit` (without -m) do?

    ```

‘git commit’ without the -m allows for a multiline commit message

    ```

6.  If you want to write a more detailed commit message (which is
    good practice) what command would you use?

    ```
One would choose ‘git commit’ over ‘git commit -m’ because ‘git commit’ allows one to write multi-line text.

    ```

7.  What does `git log do`?

    ```
‘git log’ provides a list that contains the dates and times for each commit thats been done.

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

If I were to run ‘git commit’ then “names.txt” would be the file thats committed and both “foods.txt” and “movies.txt” won’t be since they are not staged.

    ```

2.  What command do you run to stage changes?

    ```
‘git add <file>…’ and ‘git checkout — <file>…’ would stage a file so it could be committed.

    ```

3.  What command do you run to unstage changes?

    ```
‘git reset HEAD <file>…’ would be used to unstage a file.

    ```

Run the following commands:

    git diff
    git diff --cached

1.  What does `git diff` display?

    ```
‘git diff’ shows the changes made to the unstaged file with what was there before and what is there now.

    ```

2.  What does `git diff --cached` display?

    ```
‘git diff —cached’ shows the changes made to the staged file with what was there before and what is there currently.

    ```

3.  Formulate a sequence of commands to unstage changes to `names.txt`,
    and stage the changes to `movies.txt`. Execute your commands and
    confirm they worked.

    ```
List of commands used:
	‘git reset HEAD names.txt’
	‘git add movies.txt’
	‘git status’

After performing ‘git status’ we see that “movies.txt” is now staged and “names.txt” is unstaged.

    ```

4.  Edit `movies.txt`, change any one of the movies, and save it. Then
    run `git status`. What do you observe? Explain what you think is
    going on.

    ```



    ```

5.  Delete `names.txt`. Then run `git status`. What do you observe?
    Explain what you think is going on.

    ```
We see that there is a “movies.txt” that is staged and one that is unstaged. What we believe is going on is that the changes made to the file need to be added so that why there is only one “movies.txt” thats shows up.

    ```

6.  Rename `movies.txt` to `last-movies`. Run `git status`. Observe
    and explain.

    ```
We see that “movies.txt” is marked as deleted in the unstaged section but still shows up in the staged section. Also, “last-movies.txt” is an untracked file.

    ```

7.  Formulate a sequence of commands to stage all changes including the
    untracked file and commit (with any reasonable message you like).
    Execute them.

    ```
List of commands:
	‘git add .’
	‘git commit’
	‘git status’

After performing ‘git status’ we get the message that the working tree is clean.

    ```

8.  In git vernacular, `index`, `cache`, and `stage` all refer to the
    same thing. What does it hold?

    ```
The ‘stage’ / ‘index’ holds a list of paths and their object names.

    ```

9.  Why have a `stage`? Why not just commit all changes since the last
    commit?

    ```
A ‘stage’ is important to have because it allows for the file to be held in a spot before committing, this allows commits to be able to change.

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
It seems that `git reset --soft ``"HEAD^”’ undoes any commits that were previously made.

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
It seems `git reset --hard ``"HEAD^"` sets the head to be the most recent commit message and throws away all other committed changes made.

    ```

2.  What is the difference between `--hard` and `--soft`?

    ```
When calling ‘— soft’ the commit is undone. When calling ‘— hard’ the commit is thrown away.

    ```

3.  What do you think `HEAD` means?

    ```
We think ‘HEAD’ means the reference to the current commit made.

    ```

4.  What do you think `HEAD^` means?

    ```
We think ‘HEAD^’ means the reference to the commit before the current one.

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
