# Using gitflow

## Installation

*  install [Git for Windows](https://git-for-windows.github.io/)
*  find [gitflow repository](https://github.com/nvie/gitflow)
*  clone this repository to the user directory, e.g. `C:\Users\Andre`:

   > `git clone --recursive https://github.com/nvie/gitflow.git`

*  follow the installation procedure found in the [gitflow wiki](https://github.com/nvie/gitflow/wiki/windows)
*  add three extra files to Git installation folder `C:\Program Files\Git\bin`:
   *  `getopt.exe`
   *  `libiconv2.dll`
   *  `libintl3.dll`  

## Setting up the project
 
*  create a new folder `gitflow-demo`
*  start `git-bash` in this folder

   > `git init`
   > `git flow init`

*  create a new or use the existing git repository on `github` and copy its link
*  > `git remote add origin https://github.com/madrus/gitflow-demo.git`
*  > `git checkout master`
*  > `git push -u origin master`
*  > `git checkout develop`
*  > `git push -u origin develop`
*  go on and develop your code; when you finish, push the code:

   > `git push -u origin develop`  

## Start and publish feature branch

*  Suppose another user Dan wants to create a feature branch.
*  First he has to clone the repository to his own folder:

   > `git clone https://github.com/madrus/gitflow-demo.git .`  
   
   Note the dot at the end in order not to create a new subdirectory.
*  Dan has to initialize `gitflow` on his machine:

   > `git flow init`

*  This will clone the master branch to his folder.
*  Next he swiches to the `develop` branch:

   > `git checkout develop`

*  Now suppose somebody has created an issue on the github and note its number.
   Let us suppose it got number 20.
*  Start a feature branch:

   > `git flow feature start 20-UsersCanAccessSingleEntries`

*  Make your changes and then add and commit:

   > `git add .`
   > `git commit -am "Added code to get single entry"`

*  Now, he can publish his feature to the central repository for 
   collaboration or review:

   > `git flow feature publish 20-UsersCanAccessSingleEntries`
   
   This will create a remote feature branch, push the local changes to it and 
   start tracking the remote feature branch.

## Collaborate on the feature branch of someone else

*  First she has to initialize `gitflow` and `add remote`:

   > `git flow init`
   > `git remote add origin https://github.com/madrus/gitflow-demo.git`
   
*  If she forgot the next command, she can use `gitflow` help:

   > `git flow feature help`

*  Rachael does not need to pull the feature branch as it will not be
   tracking the changes. What she needs to do is track it. This will
   pull the feature branch and start tracking it.
*  Next, Rachael has to clone the feature branch of Dan to her own folder:

   > `git flow feature track 20-UsersCanAccessSingleEntries` 

*  Now, she can go ahead and make some changes.