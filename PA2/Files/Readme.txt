Biggest challenge you faced while rearranging the nodes in SLL?
I struggled with the swap and reassignment of nodes but also get the nodes
themselves because the get method we were supposed to implement was for the values rather than
the nodes.

Do you think a double linked list would have been a better option? Why?
I don't think that using a DLL would have been better. Using a DLL wouldn't improve the time complexity,
but it could potentially improve the space complexity.

 Difference report: linked list was much slower.

      ArrayList | Linked List
 _______________|__________________
 14 miliseconds | 59 miliseconds -->inorder100.txt
 02 miliseconds | 141 miliseconds -->inorder1000.txt
 02 miliseconds | 2422 miliseconds -->inorder10000.txt
 04 miliseconds | 48 miliseconds -->random10.txt
 07 miliseconds | 53 miliseconds  -->random100.txt
 01 miliseconds | 170 miliseconds  -->random1000.txt
 13 miliseconds | 4827 miliseconds -->random10000.txt
 10 miliseconds | 44 miliseconds  -->reverse100.txt
 04 miliseconds | 161 miliseconds -->reverse1000.txt
 14 miliseconds | 3398 miliseconds -->reverse10000.txt
