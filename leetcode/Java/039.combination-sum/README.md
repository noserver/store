### 解答分析
这个题目一开始题目看混了，然后实现起来有点混乱，所以这里理一下，清晰一下思路，不然accept之后也没有什么收获。
首先是题目里几个关键点，一个数组num，一个目标值target，可以重复使用的num中的值求出目标值，列出这些组合，并且组合不可以重复。num中的数字也是不重复的。
主要思路是使用递归，有两个问题需要解决，一个是怎样遍历所有的可能性，第二个问题是怎样保证不重复，解决了这两个问题，这个题目也就解决了。
下面是整体的思路流程，在流程中会说明如何解决了上面提出的这两个问题。以`num = {2,3,6,7} target = 7`为例。
对数组进行遍历，如果此时`sum==target`，则该次遍历完成，如果`sum>target`说明此时值已经超了，直接进入下次遍历。如果此时`sum<target`则需要通过递归来进行下次遍历，注意由于可以重复，所以第二个数字还有可能是2，所以递归时传递的数组还是`{2,3,6,7}`,这样进行一遍遍历后，保证了所有可能的结果。
那么按照上面的思路，会不会出现重复呢，其实是不会的`{2,2,3}`这个组合来说产生的途径只有一条，就是就是第一次遍历2，第二次遍历2，第三次遍历3。而2,3,2这种组合由于遍历到3后无法回头找2，所以是不会出现的。
除此之外，还需要注意的是，Stack，List，数组这些传入函数后，传递的都是引用，而不是值，所以传递时应该需要注意，如果该值以后不会再用了，那么可以直接传，否则务必创建一个新值传递。
首先是递归函数的定义，需要传递哪些量，以下是递归函数的函数头
``` java
public void solver(List<List<Integer>> list,List<Integer> curList,int[] arr,int target,int sum)
```
几个量以此表示，最终返回结果集，目前的可能列表，可选数组，目标值，目前合计值。
该递归函数的功能就是，将arr中每个数字以此尝试，加入curList后是否可以使得`sum==target`，如果成立该次遍历成功。
测试里面不要求list里面的顺序，如果要求的话可以先对数组进行排序，这样顺序就一致了。