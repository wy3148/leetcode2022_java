### start + 1 < end 写法


这种基本的写法是不容易溢出，最后是剩下start, end我们依次判断一下就可以

```
while (start  + 1 < end){

	int mid = start + (end - start) / 2;


	if (Condition){
		start = mid;
	}else{
		end = mid;
	}


	//we have start , and end left

	if (Condition(start)) return start;
	return end;
}

```


//这种写法是 start, end 会移动， 为了在start<=end,的时候退出循环
//需要mid +1, mid -1

```

	while(start <= end){


		int mid = start + (end - start)/ 2;


		if (Condition()){

			start = mid +1;
		}else{
			end = mid -1;
		}

	}

	return start or end;


```



代表题目
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

```

//这种写法相对比较容易出错，在保证条件满足的前提下，start = mid+1 得到执行 否则容易进入死循环

	while(start < end){


		if (Condition){

			start = mid +1; 满足的条件时候移动start,左侧，
		}else{
			end = mid;
		}

		//或者是

		if (Condition){
			end = mid -1;  //满足条件的时候移动右侧end
		}else{
			start = mid;
		}

	}

```


```
class Solution {
    
    
    public int searchLessK(int[][]matrix, int target){
        
        
        //seach from the left corner
        int n = matrix.length;
        int i = n -1; int j =0;
        
        int count = 0;
        while(i >=0 && j < n){
            
            if (matrix[i][j] <= target){
                count += i  + 1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        
        
        int n = matrix.length;
        
        int start = matrix[0][0];
        int end = matrix[n -1][n-1];
        
        
        while(start < end){
            int mid = start + (end - start)/2;
            int count = searchLessK(matrix, mid);
        
            if (count < k ){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        
        return end;
    }
}

```



//378. Kth Smallest Element in a Sorted Matrix的两种写法 start + 1< end.  start < end 

```
class Solution {
    
    
    public int searchLessK(int[][]matrix, int target){
        
        
        //seach from the left corner
        int n = matrix.length;
        int i = n -1; int j =0;
        
        int count = 0;
        while(i >=0 && j < n){
            
            if (matrix[i][j] <= target){
                count += i  + 1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        
        
        int n = matrix.length;
        
        int start = matrix[0][0];
        int end = matrix[n -1][n-1];
        
        
        while(start < end){
            int mid = start + (end - start)/2;
            int count = searchLessK(matrix, mid);
        
            if (count < k ){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        
        return end;
    }
}
```

```
    vector<int> searchRange(vector<int> &nums, int target) {
        if (nums.empty())
            return {-1, -1};

        int l = 0;
        int r = len - 1;
        vector<int> res;
        while (l < r)
        {
            int mid = (l + r) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        if (nums[l] != target)
            return {-1, -1};
        res.push_back(l);
        l = 0;
        r = len - 1;
        while (l < r)
        {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target)
                l = mid;
            else
                r = mid - 1;
        }
        res.push_back(l);

        return res;
    }
 ```


