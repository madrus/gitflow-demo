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
*  let git remember your `github` password:

   > `git config --global credential.helper wincred`

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

## Collaborate on the feature branch

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

*  Now, she can go ahead and make some changes. After that add and commit them:

   > `git add .`
   > `git commit -am "blablabla"`
   
*  And push them back to the remote (note that we don't use any parameters):

   > `git push`
   
*  Now Dan can pull these changes to his own computer (again no parameters):

   > `git pull`
   
## Publishing to develop and finishing the feature branch to try it out

*  Create a pull request in `github` based on `develop branch` compaired
   with the `feature branch` but **don't merge the pull request!!!** 
   
   Because it is not up to us to merge but for the original developer
   when he is finished with the feature branch. 
   
   Press the `Close pull request` button. This closes the pull request with unmerged commits.
*  Now Dan can finish the feature branch:

   > `git flow finish 20-UsersCanAccessSingleEntries`
   
   This will merge all the changes to `develop` branch and push them 
   back to remote. This will also delete the feature branch both locally
   and on the remote. 
   
   Dan is now back on his `develop` branch.
   
*  All other collaborators on the feature branch like Rachael have to manually
   delete it locally:
   
   > `git checkout develop`  
   > `git branch -d feature/20-UsersCanAccessSingleEntries`  
   > `git branch` (to check that it has been successfully deleted)
   
## Creating a release branch

*  Release branch is created in order to prepair the new release and
   to pass it on to the QA, systest and acceptance test. We go back
   to Andrea who is responsible for this release.
   
   > It is important to remember that if any bugs are found in the `release`
   > branch, they should be fixed in it and then merged back to `develop`
   > and active `feature` branches.
   
*  > `git flow release start sprint1-release`

   This will create a release branch and only on Andrea's machine. 
   Therefore, it must be published for other people to be able to test it.

*  > `git flow release publish sprint1-release`

   Now, on `github` we can see this release branch
   
*  Dan can now test and debug this release:

   > `git flow release track sprint1-release` 

*  When he is finished, he can add and commit changes as usual and push it:

   > `git push`
   
*  But Dan has also to merge this change on the `develop` branch:

   > `git checkout develop`  
   > `git pull` (= to make sure there are no new changes)  
   > `git merge release/sprint1-release` (= merge `release` to `develop`)  
   > `git push` (= push the merged version back to remote `develop`)  
   
## Finishing the release
   
*  When everything is ready, Andrea can finish the release:

   > `git checkout release/sprint1-release`  
   > `git pull`  
   > `git flow release finish sprint1-release`   
   
   > This merges the `release` into `master` with `sprint1-release` tag.
   > The release is also merged back into `develop`. The release branch
   > `release/sprint1-release` has been deleted both locally and remotely.
   > And we are back on `develop` branch.
   
*