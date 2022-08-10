## SearchWord & resultWord   searchword需要添加多少个字符

一个searchWord和一个resultWord，问最少给searchWord末尾添加几个字符，可以让resultWord成为它的一个subsequence。举个栗子：search给Word=“armaze”，resultWord=”amazon”，则应该返回2（添加on）。思路是两个指针p1，p2分别遍历两个字符串，如果指向的字符相同，则将双指针同时向后移动一位，反之只移动指向searchWord的指针，直到任意指针到达末尾。返回resultString的长度与resultString指针位置的差

![Untitled (7)](/Users/sawyer_ren/Downloads/Untitled (7).png)

![Untitled (6)](/Users/sawyer_ren/Downloads/Untitled (6).png)

