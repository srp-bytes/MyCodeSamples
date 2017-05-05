package com.sujeeth.example.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author SP028847
 * 
 */
public class Solution {
	
	private void setZeroes(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		// search for a cell which is 0,set the
		// rows index, cols index to true
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0)
					rows[i] = true;
				cols[j] = true;
			}
		}

		// set the rows,cols arr index true to 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows[i] || cols[j])
					matrix[i][j] = 0;
			}
		}

	}
	
	 private boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length==0||matrix[0].length==0)
	               return false;
	        boolean found = bSearch(matrix,0,target);       
	        int rowIdx = matrix.length-1;
	        while(rowIdx>0){
	              if(target==matrix[rowIdx][0])
	                  return true;
	                else if(target<matrix[rowIdx][0]){
	                    rowIdx--;
	                }else{
	                    found = bSearch(matrix,rowIdx,target);
	                    if(!found){
	                        rowIdx--;
	                    }else{
	                        return true;
	                    }    
	                }
	         }
	          
	           found = bSearch(matrix,0,target);
	        if(!found && matrix.length>0){
	            found = bSearch(matrix,matrix.length-1,target);
	        }
	        
	       return found;        
	    }
	       
	    private boolean bSearch(int arr[][], int rowIdx,int target){
	        boolean ascend = arr[rowIdx][0]<arr[rowIdx][arr[rowIdx].length-1];
	        int low = 0,high=arr[rowIdx].length-1,mid=(arr[rowIdx].length-1)/2;
	        while(low<=high){
	            if(target==arr[rowIdx][mid])
	                return true;
	            else if(target>arr[rowIdx][mid]){
	                if(ascend){
	                   low = mid+1;
	                   mid = (low+high)/2;    
	                }else{
	                    high = mid-1;
	                    mid = (low+high)/2;
	                }   
	            }else if(target<arr[rowIdx][mid]){
	                if(ascend){
	                    high = mid-1;
	                    mid = (low+high)/2;
	                }else{
	                   low = mid+1;
	                   mid = (low+high)/2;
	                }   
	            }    
	        }
	         return false;
	     }   
	
	
	// There are 2 options to reach last step using either 1 or 2 steps at a
	// time i.e., n-1 and n-2
	private int climbStairs(int n) {
		int num = 1;
		int prev = 0;
		int temp = 1;
		for (int i = 1; i <= n; i++) {
			num = prev + temp;
			prev = temp;
			temp = num;
		}

		return num;
	}
	
	//TODO
	private List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}
	 
	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
			System.out.println("list.add(new ArrayList<>(tempList))");
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				System.out.println("i->"+i);
				tempList.add(nums[i]);
				System.out.println("backtrack(list, tempList, nums)");
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
				System.out.println("tempList.remove(tempList.size() - 1)");
			}
		}
	}
	
	private int[][] generateMatrix(int n) {
		int[][] a = new int[n][n];
		int num = 1;
		int rowIdx = 0, colIdx = 0;
		int leftLimit = 0, rightLimit = n - 1, upLimit = 0, downLimit = n - 1;
		while (leftLimit <= rightLimit && upLimit <= downLimit) {

			// cols var, row const
			while (colIdx <= rightLimit) {
				a[rowIdx][colIdx] = num++;
				colIdx++;
			}
			colIdx--;
			rowIdx++;
			upLimit++;
			// row var,col const
			while (rowIdx <= downLimit) {
				a[rowIdx][colIdx] = num++;
				rowIdx++;
			}
			rowIdx--;
			colIdx--;
			rightLimit--;
			// col var, row const
			while (colIdx >= leftLimit) {
				a[rowIdx][colIdx] = num++;
				colIdx--;
			}
			rowIdx--;
			colIdx++;
			downLimit--;
			// row var,col const
			while (rowIdx >= upLimit) {
				a[rowIdx][colIdx] = num++;
				rowIdx--;
			}
			rowIdx++;
			colIdx++;
			leftLimit++;
		}
		return a;
    }
	
	//Hint:Move curr,next if they're different. If equal, move only next until
	//they're not equal. Track previous node of curr
	private ListNode deleteDuplicates(ListNode head) {
		 if(head==null||head.next==null)
		     return head;

		 ListNode prev = null;	 
		 ListNode curr = head;
		 ListNode fast = head.next;
		 int i = 0;
		 
		 while(fast!=null){
		   if(curr.val==fast.val){
		     fast=fast.next;
			 i++;
		   }else{
		     //if there are gaps b/w curr and fast  
		     if(i>0){
			 //if duplicates are from the very first node
			 if(prev==null){
			   curr = fast;
			   head = curr;
			   fast = fast.next;
			 }else{
			   //if the duplicates doesn't start from the very first node
			   prev.next = fast;
			   curr = fast;
			   fast =fast.next;
			  }
			 }else{
			 //if no gaps between curr and fast
			 prev = curr;
			 curr = curr.next;
			 fast = fast.next;
			 }
			 i=0;
		   }
		 }

		  //whole list is of duplicates 
		  if(prev==fast&&curr.next!=null){
		      return null;
		  }else if(prev!=null&&i>0){
		      //duplicates never ended
		      prev.next = null;
		  }
		    
		     return head;
		  }
	
	//prob 448 1<=nums[i]<=n, negate nums[i]th index if nums[i]th index is not negative 
	private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingIndexes = new ArrayList<Integer>();
        int i=0;
        while(i<nums.length){
            int val = Math.abs(nums[i])-1;
            if(nums[val]>0){
                nums[val] = -nums[val];
            }
            i++;
        }
        i=0;
        while(i<nums.length){
            if(nums[i]>0){
                missingIndexes.add(i+1);
            }
            i++;
        }
        
        return missingIndexes;
    }
	
	//prob num:442 1<=nums[i]<=n, where n is size of array
	private List<Integer> findDuplicates(int[] nums) {
		List<Integer> dups = new ArrayList<Integer>();
		if (nums.length == 0)
			return dups;
		int i = 0;
		while (i < nums.length) {
			if (nums[Math.abs(nums[i]) - 1] < 0) {
				dups.add(Math.abs(nums[i]));
			} else {
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
			}
			i++;
		}
		return dups;
	}
	
	//hint:Consider replacing (i+k)element if distance b/w i and j indexes is >=k+1
	//i.e., if (j-i>=k+1) replace i+k th element
	private int removeDuplicatesII(int[] nums) {
		int i = 0, j = 1, k = 2;

		while (j < nums.length) {

			if (nums[i] != nums[j]) {
				// find out whether distance b/w i and j is more than k
				// if more than k, replace element in nums[i+k] position with
				// nums[j]
				if (j - i >= k + 1) {
					swap(nums, i + k, j);
				}

				i++;
			} else {
				if (j - i >= k + 1) {
					swap(nums, i + k, j);
				}
			}
			j++;
		}
		// for finding out final size
		return j - i >= k + 1 ? (nums.length - ((j - i) - k)) : nums.length;
	}
    
    private void swap(int[] arr,int leftIdx,int rightIdx){
        int temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
    }
	
	//Hint:one loop for each direction,(right,bottom,left,top)
	private List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralList = new ArrayList<Integer>();
		if (matrix.length == 0)
			return spiralList;
		int leftColLimit = 0;
		int rightColLimit = matrix[0].length;
		int topRowLimit = 0;
		int bottomRowLimit = matrix.length;
		int rowIdx = 0, colIdx = 0;
		while ((rowIdx >= topRowLimit && rowIdx < bottomRowLimit)
				&& (colIdx >= leftColLimit && colIdx < rightColLimit)) {
			boolean breakIt = true;
			// right traversal ->
			while (colIdx < rightColLimit) {
				spiralList.add(matrix[rowIdx][colIdx]);
				colIdx++;
				breakIt = false;
			}
			
			// next row
			rowIdx++;
			// decrement colIdx
			colIdx--;
			topRowLimit++;
			breakIt = true;
			// bottom traversal
			while (rowIdx < bottomRowLimit) {
				spiralList.add(matrix[rowIdx][colIdx]);
				rowIdx++;
				breakIt = false;
			}

			if(breakIt) break;
			breakIt = true;
			// next colIdx
			colIdx--;
			// decrement rowIdx
			rowIdx--;
			// decrement col limit
			rightColLimit--;

			// left traversal <-
			while (colIdx >= leftColLimit) {
				spiralList.add(matrix[rowIdx][colIdx]);
				colIdx--;
				breakIt = false;
			}
			if(breakIt) break;
			breakIt=true;
			// decrement rowIdx
			rowIdx--;
			// increment col to make it 0 again
			colIdx++;
			// remove row from visiting again
			bottomRowLimit--;
            //if there is only one column
			if(matrix[0].length==1)
				break;
			//move up 
			while (rowIdx >= topRowLimit) {
				spiralList.add(matrix[rowIdx][colIdx]);
				rowIdx--;
				breakIt = false;
			}
			if(breakIt) break;
			// increment row Idx
			rowIdx++;
			// move to next column
			colIdx++;
			// remove column from visiting again
			leftColLimit++;

		}
		return spiralList;
	}
	
	
  private ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        //travel until we find a loop or until end of list
        while(fast!=null&&fast.next!=null){
         slow = slow.next;
         fast = fast.next.next;
         if(slow == fast)
             break;
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow = head;
        //traverse both slow and fast at same pace until they meet at begining of the cycle
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
	
	
	private ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		int cnt = 0;
		// move fast 'n' steps forward in the list
		while (fast != null && cnt != n) {
			fast = fast.next;
			cnt++;
		}

		if (cnt != n)
			return null;
		// move fast and slow nodes, at one node at a time
		while (fast != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		if (prev == null) {
			head = slow.next;
			slow.next = null;
		} else {
			prev.next = slow.next;
			slow = null;
		}

		return head;
	}
	
	private boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}

		return false;

	}
	
	
	/**
	 *Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	 *Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
	 *the linked list should become 1 -> 2 -> 4 after calling your function.
	 * 
	 *Hint:Push the value to last of the linked list and delete the node
	 *
	 * */
	private void deleteNode(ListNode node) {
		if (node == null) {
			return;
		} else if (node.next == null) {
			node = null;
			return;
		}

		int temp = node.val;
		while (node.next.next != null) {
			node.val = node.next.val;
			node.next.val = temp;
			node = node.next;
		}
		// last swap
		node.val = node.next.val;
		node.next = null;

	}
	
	
	private ListNode removeElements(ListNode head, int val) {
		if (head == null || (head.val == val && head.next == null)) {
			return null;
		}
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val == val) {
				if (prev != null) {
					prev.next = curr.next;
					curr = curr.next;
				} else {
					curr = curr.next;
					head = curr;
				}
			} else {
				prev = curr;
				curr = curr.next;
			}

		}

		return head;
	}
	
	/*
	 * 	"A man, a plan, a canal: Panama" is a palindrome.
	 *	"race a car" is not a palindrome.
	 *  ",." is a palindrome
	 *  "a111a" is a palindrome
	 * */
	private boolean isPalindromeAlphaNumeric(String s) {
        if(s==null) return false;
        else if(s.trim().length()==1||s.trim().length()==0)
          return true;
          
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }else if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }else{
                continue;
            }
        }
        
        String str = sb.toString();
        if(str.length()==0||str.length()==1) return true;
        boolean even = str.length()%2==0;
        int i=0,j=0;
        if(even){
            j=str.length()/2;
            i=j-1;
        }else{
            i=(str.length()/2)-1;
            j=i+2;
        }
        
       while(i>=0&&j<str.length()){
         if(str.charAt(i)!=str.charAt(j))
              return false;
          i--;
          j++;
       }
       return true;
    }
	
	//O(n),O(1)
	private boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        else if(head.next.next==null){
            if(head.val!=head.next.val)
               return false;
             return true;  
        }
        ListNode slow = head;
        ListNode aheadSlow = head.next;
        ListNode fast = head;
        ListNode prev = null;
        //Go until half the length of linked list with slow and fast pointers
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
            //for even case
            if(fast==null){
                aheadSlow = slow;
                slow = prev;
            }
        }
        
        //if odd length
        if(fast!=null){
            //reverse move to next element
            aheadSlow = slow.next;
            slow = prev;
        }
        
        //traverse the next half
        while(slow!=null){
            if(slow.val!=aheadSlow.val)
                return false;
        
            slow = slow.next;
            aheadSlow = aheadSlow.next;
        }
        return true;
    }
	
	private ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
             return head;
        ListNode curr = head;
        ListNode fast = head.next;
        //point head to null, as this will be last when reversed.
        curr.next = null;
        while(fast!=null){
         ListNode temp = fast.next;
         fast.next = curr;
         curr = fast;
         fast = temp;
        }
        head = curr;
        return head;
    }
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private boolean isValid(String s) {
		if (s.length() <= 1)
			return false;
		Map<Character, Character> parenMap = new HashMap<Character, Character>();
		parenMap.put('(', ')');
		parenMap.put('{', '}');
		parenMap.put('[', ']');
		Stack<Character> parenStack = new Stack<Character>(); 
		for (int i = 0; i < s.length(); i++) {
			if (parenMap.containsKey(s.charAt(i))) {
				parenStack.push(s.charAt(i));
				System.out.println(s.charAt(i));
			} else {
				System.out.println(s.charAt(i));
				if(parenStack.size()==0) return false;
				Character top = parenStack.pop();
				if(top==null||parenMap.get(top)!=s.charAt(i))
					return false;
			}
		}

		return parenStack.size() == 0;
	}
	
	private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 1)
			return false;
		else if (k < 0 || t < 0)
			return false;
		else if (nums.length == 2) {
			int val = Math.abs(nums[1] - nums[0]);
			if (Math.abs(nums[1] - nums[0])>=0 && Math.abs(nums[1] - nums[0])<= t
					||  Math.abs(nums[0] - nums[1])>=0 && Math.abs(nums[0] - nums[1]) <= t && 1 <= k)
				return true;
			return false;
		}
		// range b/w nums[i]+t to nums[i]-t(i.e j>=nums[i]-t)
		TreeSet<Long> sortedSet = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			// convert to long so that int doesn't overflow for Integer.MAX_VAL
			Long floorVal = sortedSet.floor(new Long(nums[i] + t));
			if (floorVal != null && floorVal >= nums[i] - t) {
				return true;
			}

			sortedSet.add(new Long(nums[i]));

			if (i >= k) {
				sortedSet.remove(nums[i - k]);
			}
		}

		return false;
	}
	
	/* static int[] sort(int[] sequence, int maxValue) 
	    {
	        // Bucket Sort
	        int[] Bucket = new int[maxValue + 1];
	        int[] sorted_sequence = new int[sequence.length];
	 
	        for (int i = 0; i < sequence.length; i++)
	            Bucket[sequence[i]]++;
	 
	        int outPos = 0;
		for (int i = 0; i < Bucket.length; i++) {
			for (int j = 0; j < Bucket[i]; j++) {
				sorted_sequence[outPos++] = i;
			}
		}

	        return sorted_sequence;
	    }
	 
	    static void printSequence(int[] sorted_sequence) 
	    {
	        for (int i = 0; i < sorted_sequence.length; i++)
	            System.out.print(sorted_sequence[i] + " ");
	    }
	 
	    static int maxValue(int[] sequence) 
	    {
	        int maxValue = 0;
	        for (int i = 0; i < sequence.length; i++)
	            if (sequence[i] > maxValue)
	                maxValue = sequence[i];
	        return maxValue;
	    }*/
	
	private boolean containsDuplicate(int[] nums) {
        if(nums.length==0) return false;
        Map<Integer,Integer> findDup = new HashMap<Integer,Integer>();
        int i=0,cnt=1;
		while (i < nums.length) {
			if (findDup.get(nums[i]) == null) {
				findDup.put(nums[i], 1);
			} else {
				cnt = findDup.get(nums[i]);
				findDup.put(nums[i],cnt+=1);
			}
			if (findDup.get(nums[i]) > 1) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	
	private boolean containsNearbyDuplicate(int[] nums, int k) {
        int size = nums.length;
        if(size==0) return false;
        Map<Integer,Integer> findDups = new HashMap<Integer,Integer>(size);
        int i = 0;
        while(i<size){
            if(findDups.get(nums[i])!=null&&Math.abs(findDups.get(nums[i])-i)<=k){
                return true;
            }
			findDups.put(nums[i],i);
			i++;
        }
        return false;
    }
	
	private void moveZeroes(int[] nums) {
        int left=0,right=1;
        
        while(right<nums.length){
            if(nums[left]==0&&nums[right]==0){
                right++;
            }else if(nums[left]==0&&nums[right]!=0){
                nums[left]=nums[right];
                nums[right]=0;
                left++;
                right++;
            }else if((nums[left]!=0&&nums[right]!=0)||(nums[left]!=0&&nums[right]==0)){
                left++;
                right++;
            }
        }
    }
	
	private int removeDuplicates(int[] nums) {
	        if (nums.length == 0)
				return 0;
			else if (nums.length == 1)
				return 1;
			int size = nums.length;
			int left=0,right=1;
			while(right<nums.length){
		         if(nums[left]==nums[right]){
		             right++;
		             size--;
		         }else if(nums[left]!=nums[right]){
		             if(right-left>1){
		                 int temp = nums[left+1];
		                 nums[left+1] = nums[right];
		                 nums[right] = temp;
		             }
		             left++;
		             right++;
		         }
			}
			return size;    
	}
	
	private boolean isPalindrome(int x) {
		if (x >= 0 && x < 10)
			return true;
		else if(x<0)
			return false;
		else if(x>Integer.MAX_VALUE)
			return false;
		int rev = 0;
		int temp = x;
		try {
			//reverse the number by mod operator && multiply 10 with each digit
			while(temp>0){
				rev*=10;
				rev+=(temp%10);
				temp=temp/10;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
		return x==rev;

	}

	
	private boolean circularArrayLoop(int[] nums) {
		//p,p+2
		if(nums.length==0) return false;
		int movingDirection = nums[0] > 0 ? 1 : -1;
		int initialDirection = movingDirection;   
		int curr = 0,next=0;
		next = initialDirection>0? moveForward(nums[0], curr, nums):moveBackward(nums[0], curr, nums);
		if (nums[next] > 0) {
			next = moveForward(nums[next], next, nums);
		} else {
			next = moveBackward(nums[next], next, nums);
		}
			
		
		while (curr != next&&initialDirection==movingDirection) {
			if (nums[curr] > 0) {
				curr = moveForward(nums[curr], curr, nums);
				if(nums[next]<0) {movingDirection = -1; break;}
				next = moveForward(nums[next], next, nums);
				if(nums[next]<0) {movingDirection = -1; break;}
				next = moveForward(nums[next], next, nums);
				if(nums[next]<0) {movingDirection = -1; break;}
				movingDirection = 1;	
			} else if (nums[curr] < 0) {
				curr = moveBackward(nums[curr], curr, nums);
				if(nums[next]>0) {movingDirection = 1; break;}
				next = moveBackward(nums[next], next, nums);
				if(nums[next]>0) {movingDirection = 1; break;}
			    next = moveBackward(nums[next], next, nums);
			    if(nums[next]>0) {movingDirection = 1; break;}
			    movingDirection = -1;
			}
		}
		if(initialDirection!=movingDirection) return false;
		return true;
	}
    
	private int moveForward(int nSteps, int currIdx, int[] nums) {
		int totalMoves = (nSteps + currIdx);
		int arrLength = nums.length;
		int resultIdx = totalMoves >= arrLength ? (totalMoves % arrLength)
				: totalMoves;
		return resultIdx;
	}
    
	private int moveBackward(int nSteps, int currIdx, int[] nums) {
		int totalMoves = (nSteps + currIdx);
		int arrLength = nums.length;
		if(Math.abs(totalMoves)>=arrLength){
			totalMoves%=10;
		}
		int resultIdx = totalMoves < 0 ? (totalMoves + arrLength) : totalMoves;
		return resultIdx;
	}
	
	
	 //O(n^2) case
    private String longestPalindrome(String s) {
        String longestPal = "";
        //optimization statements
        if(s==null||s.trim().length()==0){
        return s;
        }
        else if(s.length()==1){
        return s;
        }
        else if(s.equals(new StringBuilder(s).reverse().toString())){
        return s;
        }
        else{
        for(int i=0;i<s.length();i++){
            //odd length case
            String pal1 = isPalindrome(s,i-1,i+1);
            //even length case
            String pal2 = isPalindrome(s,i,i+1);
            pal1 = pal1.length()>pal2.length()?pal1:pal2;
            if(pal1.length()>longestPal.length()){
                longestPal = pal1;
            }//end-if
            
        }//end-for
            
      }//end-else
      return longestPal;
        
 }//end-method
    
  private String isPalindrome(String s, int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
    return s.substring(left+1,right);
  }
    //Bad approach
	private String longestPalindromeBruteForce(String s) {
		String longestPal = "";
		// optimization statements
		if (s == null) {
			return null;
		} else if (s.length() == 1) {
			return s;
		} else if (s.equals(new StringBuilder(s).reverse().toString())) {
			return s;
		} else {
			for (int i = 0; i < s.length(); i++) {
				String subString = isPalindrome(s.substring(0, i+1));
				if (subString.length() > longestPal.length()) {
					longestPal = subString;
				}// end-if

			}// end-for

		}// end-else
		return longestPal;

	}// end-method

	private String isPalindrome(String s) {
		String longestPal = "";
		for (int i = 0; i < s.length(); i++) {
			String subs = s.substring(i, s.length());
			if (subs.equals(new StringBuilder(subs).reverse().toString())
					&& subs.length() > longestPal.length()) {
				longestPal = subs;
			}
		}
		return longestPal;
    }

	/**
	 * @param s
	 * @return
	 */
	private int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		else if (s.length() == 1)
			return 1;
		else if (s.length() == 2) {
			return s.charAt(0) == s.charAt(1) ? 1 : 2;
		}
		StringBuilder sb = new StringBuilder();
		String unique = "";
		Map<Character, Integer> uniqueChars = new HashMap<Character, Integer>();
		uniqueChars.put(s.charAt(0), 0);
		sb.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			// case where character is unique and never encountered before
			if (s.charAt(i) != s.charAt(i - 1)
					&& uniqueChars.get(s.charAt(i)) == null) {
				uniqueChars.put(s.charAt(i), i);
				sb.append(s.charAt(i));
				// case to check if a character is repeated somewhere in the
				// current string
			} else if (s.charAt(i) != s.charAt(i - 1)
					&& uniqueChars.get(s.charAt(i)) != null) {
				int foundIdx = containsChar(sb.toString(), s.charAt(i));
				// current string already contains same character, splice the
				// string until the repeating character
				if (foundIdx >= 0) {
					// check if current unique string size is less than
					// constructed one
					if (unique.trim().length() < sb.toString().length()) {
						unique = sb.toString();
					}

					if (foundIdx + 1 < sb.toString().length()) {
						sb = new StringBuilder(sb.toString().substring(
								foundIdx + 1, sb.toString().length())
								+ String.valueOf(s.charAt(i)));

					} else {
						sb = new StringBuilder();
						sb.append(s.charAt(i));
					}
				} else {
					sb.append(s.charAt(i));
				}
				// case for repeating characters
			} else if (s.charAt(i) == s.charAt(i - 1)
					&& uniqueChars.get(s.charAt(i)) != null) {
				// check if current unique string size is less than constructed
				// one
				if (unique.trim().length() < sb.toString().length()) {
					unique = new String(sb.toString());
				}
				sb = new StringBuilder();
				sb.append(s.charAt(i));

			}
		}

		// check if current unique string size is less than constructed one
		if (unique.trim().length() < sb.toString().length()) {
			unique = new String(sb.toString());
		}
		return unique.length();
	}

	private int containsChar(String subStr, Character ch) {
		for (int i = 0; i < subStr.length(); i++) {
			if (subStr.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// "pwwkewzyxzz"
		//int length = sol.lengthOfLongestSubstring("wzebxyzdefghi");
		/*String breakCode = "civilwartestingwhetherthatnaptionoranynartionsoconcei"
				+ "vedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhat"
				+ "warWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforth"
				+ "osewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandp"
				+ "roperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecra"
				+ "tewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehavecons"
				+ "ecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlong"
				+ "rememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertob"
				+ "ededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItis"
				+ "ratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetake"
				+ "increaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvet"
				+ "hatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernme"
				+ "ntofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		//String test = "abxasa";
		String longPal =sol.longestPalindrome(breakCode);*/
		//new int[]{2, -1, 1, 2, 2}
		//new int[]{-1,-2,3,-4,-5}
		//new int[]{-1,2}
		//boolean circular = sol.circularArrayLoop(new int[]{-1,-2,-3,-4,-5});
		//System.out.println("arr is circular: " + circular);
		//1000000001//1181111811
		//boolean isPalindrome = sol.isPalindrome(1000000001);
		//int size = sol.removeDuplicates(new int[]{1,1,2,2,3});
		//System.out.println("number length: " + size);
		//int[] nums = {-959151711,623836953,209446690,-1950418142,1339915067,-733626417,481171539,-2125997010,-1225423476,1462109565,147434687,-1800073781,-1431212205,-450443973,50097298,753533734,-747189404,-2070885638,0,-1484353894,-340296594,-2133744570,619639811,-1626162038,669689561,0,112220218,502447212,-787793179,0,-726846372,-1611013491,204107194,1605165582,-566891128,2082852116,0,532995238,-1502590712,0,2136989777,-2031153343,371398938,-1907397429,342796391,609166045,-2007448660,-1096076344,-323570318,0,-2082980371,2129956379,-243553361,-1549960929,1502383415,0,-1394618779,694799815,78595689,-1439173023,-1416578800,685225786,-333502212,-1181308536,-380569313,772035354,0,-915266376,663709718,1443496021,-777017729,-883300731,-387828385,1907473488,-725483724,-972961871,-1255712537,383120918,1383877998,1722751914,0,-1156050682,1952527902,-560244497,1304305692,1173974542,-1313227247,-201476579,-298899493,-1828496581,-1724396350,1933643204,1531804925,1728655262,-955565449,0,-69843702,-461760848,268336768,1446130876};
		//sol.moveZeroes(nums);
		//System.out.println("number length: " + nums);
		/*int[] nums = {3,3};
		boolean containsDup = sol.containsDuplicate(nums);
		System.out.println("Array contains dup: "+containsDup);*/
		
		 /*System.out.println("Sorting of randomly generated numbers using BUCKET SORT");
		 Random random = new Random();
		 int N = 20;
		 int[] sequence = new int[N];

		 for (int i = 0; i < N; i++)
			 sequence[i] = Math.abs(random.nextInt(100));

		 int maxValue = maxValue(sequence);

		 System.out.println("\nOriginal Sequence: ");
		 printSequence(sequence);

		 System.out.println("\nSorted Sequence: ");
		 printSequence(sort(sequence, maxValue));*/
		//int nums[] = {0,Integer.MAX_VALUE};
		//int nums[] ={-1,Integer.MAX_VALUE};
		//int nums[]={-1,-1};
		/*int nums[] = {Integer.MAX_VALUE,Integer.MIN_VALUE+1};
		boolean contains = sol.containsNearbyAlmostDuplicate(nums, 1, Integer.MAX_VALUE);
		System.out.println("Contains near by almost duplicate :"+contains);*/
		/*String s = "{{{{{{{";//false
		String s1 ="";//false
		String s2 ="(";//false
		String s3="({[{[{[]}]}]})";//true
		String s4="(){}[]";//true
		String s5 ="({[]})";//true
		String s6 ="({[]}";//false
		String s7="([)]";//false
		String s8 = "}}}";
		String s9 = "()";
		System.out.println("Valid Parantheses: "+sol.isValid(s9));*/
		//sol.reverseList(node);
		/*Solution.ListNode node = sol.new ListNode(1);
		ListNode node2 = sol.new ListNode(2);
		node.next = node2;
		ListNode node3 =sol.new ListNode(2);
		node2.next = node3;
		ListNode node4 =sol.new ListNode(2);
		node3.next = node4; 
		ListNode node5 =sol.new ListNode(1);
		node4.next = node5; 
		node5.next = null;
		sol.isPalindrome(node);*/
		//System.out.println("Spiral list: "+sol.spiralOrder(new int[][]{{1}}));
		//System.out.println("Size of array: "+sol.removeDuplicatesII(new int[]{1,2,3,4,5}));
		//System.out.println(sol.generateMatrix(2));
		//sol.searchMatrix(new int[][]{{1,3,5,7}},7);
		//System.out.println(sol.permute(new int[]{1,2,3}));
		//sol.setZeroes(new int[][]{{1}});
		//SolutionII sol2 = new SolutionII();
		//sol2.reverseString("hello");
		//sol2.reverseStr("abcdefghij", 2);
		SolutionII sol2 = new SolutionII();
		/*ListNode n = sol.new ListNode(3);
		ListNode n2 = sol.new ListNode(4);
		n.next = n2;
		ListNode n3 = sol.new ListNode(7);
		n2.next = n3;
		ListNode n4 = sol.new ListNode(8);
		n3.next = n4;
		ListNode n5 = sol.new ListNode(1);
		n4.next = n5;
		//sol2.removeNode(n);
		ListNode partitionList = sol2.partitionList(n, 4);
		while(partitionList!=null){
		System.out.println(partitionList.val);
		partitionList = partitionList.next;
		}*/
		
		/*int[] arr = new int[]{-1,0,1,2,3,5};
		int magicIdx = sol2.findMagicIdxDups(arr, 0, arr.length-1);
		String val = magicIdx>=0?"found":"not found";
		System.out.println("Magic_Idx:"+val +":"+magicIdx);*/
		ListNode n0 = sol.new ListNode(1);
		ListNode n2 = sol.new ListNode(2);
		n0.next = n2;
		ListNode n3 = sol.new ListNode(2);
		n2.next = n3;
		ListNode n4 = sol.new ListNode(3);
		n3.next = n4;
		ListNode n5 = sol.new ListNode(1);
		n4.next = n5;
		n5.next = null;
		System.out.println("list is plaindrome "+sol2.isPalindrome(n0, n0));
	}
}