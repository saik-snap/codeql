# New Service Setup 

Follow the instructions given in [README.md](../../tools/msgen/README.md)

## Approach 1

This workflow is for the developers who want all the services in the same workspace.

- Reload the gradle project from the gradle tool window in IntelliJ. Once loaded,you will be able to view the newly 
added service there.
-  After loading, you might face compilation issue.
   

_**Resolution**_ : 
   Clear IntelliJ IDEA cache by following steps :

   File -> Invalidate Caches -> Invalidate & Restart


## Approach 2

This workflow is for the developers who want to work on each service separately.

- Import the newly generated service in IntelliJ IDEA from the local directory.
