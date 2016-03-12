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
*  > `git init`
*  > `git flow init`
*  create a new or use the existing git repository on `github` and copy its link
*  > `git remote add origin https://github.com/madrus/gitflow-demo.git`
*  > `git checkout master`
*  > `git push -u origin master`
*  > `git checkout develop`
*  > `git push -u origin develop`
*  go on and develop your code; when you finish, push the code:
   > `git push -u origin develop`  

## Feature branch

*  Suppose another user Dan wants to create a feature branch
*  First he has to clone the repository to his own folder:
   > `git clone https://github.com/madrus/gitflow-demo.git .`  
   
   Note the dot at the end in order not to create a new subdirectory.
*  
   