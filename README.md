# B+-Tree-based-index-implementation
Implemented a B+tree based indexing to speed up searching in a relational database resulting in the reduction of search time to **log(n) with base d** where d is the degree of the B+tree and n is the number of index pages

## Workflow

1. Compile Client.java file present in the **src** folder.

![Screenshot from 2020-07-29 13-35-49](https://user-images.githubusercontent.com/46842087/88774321-e8448a80-d1a0-11ea-8fe5-773eeb16e08d.png)

2.  Run the Client file and **pass an empty folder** as an argument for the creation of data and indexes. 

![Screenshot from 2020-07-29 13-36-58](https://user-images.githubusercontent.com/46842087/88774491-25a91800-d1a1-11ea-8e02-9aeeb7beffb7.png)

Add the complete path of the empty folder while running the client file.

![image](https://user-images.githubusercontent.com/46842087/88775658-98ff5980-d1a2-11ea-940b-f9bcd7e1945c.png)

3. Here you go! The window launches with first page as the **home page** giving a brief summary about the project.

### Home Panel
[
![B+trees](https://user-images.githubusercontent.com/46842087/88757045-c5a37900-d182-11ea-9feb-4c4b30f917ee.png)
](url)

4. Users can create data by switching to the data panel and then enter the number of rows to be created.

### Data Panel

![Screenshot from 2020-07-29 10-10-37](https://user-images.githubusercontent.com/46842087/88757476-cb4d8e80-d183-11ea-9ecc-1ae8d32200e1.png)

![image](https://user-images.githubusercontent.com/46842087/88776975-5474bd80-d1a4-11ea-9feb-334250464bab.png)

Data will be stored in the form of extents. 

Extent ->  Pages -> Rows
![image](https://user-images.githubusercontent.com/46842087/88777098-78d09a00-d1a4-11ea-86bf-e00bb9b1ee37.png)

For demonstration purpose, the schema of the table is as :
     Roll number  |   Name   |   Username  |    Password

6.  Users can create Non-Clustered indexing [[?]](https://www.sqlshack.com/what-is-the-difference-between-clustered-and-non-clustered-indexes-in-sql-server/) on any attribute of the table from the index panel which has a drop-down list to select the attribute name for the creation of indexes.

### Index Panel
![ind](https://user-images.githubusercontent.com/46842087/88757389-7dd12180-d183-11ea-9ac0-eaddd7cec996.png)

![image](https://user-images.githubusercontent.com/46842087/88777407-cc42e800-d1a4-11ea-8272-f0fef330f48a.png)


7. Now, it's time to enjoy the benefits of indexing. Switch to query panel.

### Query Panel
![search](https://user-images.githubusercontent.com/46842087/88757370-73af2300-d183-11ea-9162-1212890a42f4.png)

#### Index Seek

**Index seek** is performed if query is made using the attribute on which indexes are created.

![image](https://user-images.githubusercontent.com/46842087/88779186-19c05480-d1a7-11ea-8711-1dc89a6e3ae6.png)

#### Table Scan

**Table scan** is performed otherwise. Time taken in table scan is considerably more than that in index seek.

![image](https://user-images.githubusercontent.com/46842087/88779494-7885ce00-d1a7-11ea-8de1-0264def1d7e5.png)

## Theory

**Why Is Indexing Used in the Database?** 

Imagine you need to store a list of numbers in a file and search a given number on that list. The simplest solution is to store data in an array and append values when new values come. But if you need to check if a given value exists in the array, then you need to search through all of the array elements one by one and check whether the given value exists. If you are lucky enough, you can find the given value in the first element. In the worst case, the value can be the last element in the array. We can denote this worst-case as O(n) in asymptotic notation. This means if your array size is “n,” at most, you need to do “n” number of searches to find a given value in an array. Such type of search is called a Table scan.

**B-Tree Indexes**

This is the default index for most storage engines in MySql. The general idea of a B-Tree is that all the values are stored in order, and each leaf page is the same distance from the root.

A B-Tree index speeds up data access because the storage engine doesn’t have to scan the whole table to find the desired data. Instead, it starts at the root node. The slots in the root node hold pointers to child nodes, and the storage engine follows these pointers. It finds the right pointer by looking at the values in the node pages, which define the upper and lower bounds of the values in the child nodes. Eventually, the storage engine either determines that the desired value doesn’t exist or successfully reaches a leaf page. Leaf pages are special because they have pointers to the indexed data instead of pointers to other pages.

![b-tree](https://user-images.githubusercontent.com/46842087/88758387-f0db9780-d185-11ea-8971-3501d63c8db9.png)


**B+ -Tree Indexes**

B+tree is another data structure used to store data, which is almost the same as the B-tree. The only difference of B+tree is that it stores data on the leaf nodes. This means that all non-leaf node values are duplicated in leaf nodes again. Below is a sample B+tree.

![b-plus-tree](https://user-images.githubusercontent.com/46842087/88758324-cf7aab80-d185-11ea-9ce6-cfba75b2e24f.png)
