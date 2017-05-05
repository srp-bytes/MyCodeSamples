package com.sujeeth.example.solutions;

import com.sujeeth.example.solutions.Solution.ListNode;

public class SolutionII {
	public String reverseString(String s) {
        if(s==null||s.length()==0)
              return s;
       char[] arr = s.toCharArray();
       int left =0,right=arr.length-1;
       while(left<right){
    	   char temp = arr[left];
    	   arr[left] = arr[right];
    	   arr[right] = temp;
    	   left++;
    	   right--;
       }
        return String.valueOf(arr);
    }
	
	//Hint:Reverse K elements for every 2k elements, go until 2k < str.length,
	//after that handle other conditions in the problem 556?.
	public String reverseStr(String s, int k) {
        if(s==null||s.length()==0||k<=0)
           return s;
       
       char[] str = s.toCharArray();
       int idx=(2*k);
       int left = 0, right = k-1;
       while((idx-1)<str.length){
          str = reverse(str,left,right);
          left = idx;
          idx +=2*k;
          right = (left+k)-1;
       }
       
       if(right<str.length){
           str = reverse(str,left,right);
       }else{
           str = reverse(str,left,str.length-1);
       }
       return String.valueOf(str); 
    }
    
   private char[] reverse(char[] arr,int left,int right){
         while(left<right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
          }
         return arr; 
    }
   
   //Hint:Q557 Go until you find Character.isWhitespace(char), reverse the
   //string before white space, last word will be handled after the loop condition.
   public String reverseWords(String s) {
       if(s==null||s.length()==0)
          return s;
          
       char[] str = s.toCharArray();
       
       int i=0, j=0;
       
       while(j<str.length){
           if(Character.isWhitespace(str[j])){
               str = reverse(str,i,j-1);
               i = j+1;
           }
           j++;
       }
       
       //last part
       str = reverse(str,i,str.length-1);
       return String.valueOf(str);
   }
   
   //Hint: We deal in layers, trace the problem
   //first with a 3x3 matrix
   public void rotate(int[][] matrix) {
       
       int n = matrix.length;
       //we deal in layers
       for(int layer=0;layer<n/2;layer++){
           int first = layer;
           int last = n-1-first;
           for(int i = first;i<last;i++){
               int offset = i-first;
               int top = matrix[first][i];
               //top->left
               matrix[first][i] = matrix[last-offset][first];
               //bottom->left
               matrix[last-offset][first] = matrix[last][last-offset];
               //bottom->right
               matrix[last][last-offset] = matrix[i][last];
               //top->right
               matrix[i][last] = top;
           }
       }
       
   }
  
     //Note:We cannot remove last element
    //Hint: Swap the numbers
	public boolean removeNode(ListNode n) {
		if (n.next == null) {
			return false;
		}

		int temp = n.next.val;
		n.next.val = n.val;
		n.val = temp;
		n.next = n.next.next;
		return true;

	}
	
	//Hint:Construct 2 lists with smaller than val on leftList, >= val on rightList
	public ListNode partitionList(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode temp = head;
		ListNode leftList = null, leftHead = null;
		ListNode rightList = null, rightHead = null;
		while (head != null) {
			temp = head;
			head = head.next;
			temp.next = null;

			if (temp.val < val) {
				if (leftHead == null) {
					leftHead = temp;
					leftList = temp;

				} else {
					leftList.next = temp;
					leftList = leftList.next;
				}
			} else {
				if (rightHead == null) {
					rightHead = temp;
					rightList = temp;

				} else {
					rightList.next = temp;
					rightList = rightList.next;
				}
			}
		}
		if (leftHead != null)
			leftList.next = rightHead;
		return leftHead != null ? leftHead : rightHead;
	}
	
	//Note:Sorted Array, BinarySearch
	public int findMagicIdxDistinct(int[] arr, int start, int end){
		if(end<start||start<0||end>=arr.length)
			  return -1;
		int midIdx = (start+end)/2;
		if(arr[midIdx]==midIdx){
     		return midIdx;
		}else if(arr[midIdx]>midIdx){
			return findMagicIdxDistinct(arr,start,midIdx-1);
		}else{
			return findMagicIdxDistinct(arr,midIdx+1,end);
		}
		
	}
	
	//Note:Sorted, contains duplicate elements
	//Hint: Apply binary search logic
	public int findMagicIdxDups(int[] arr, int start, int end){
		if(end<start||start<0||end>=arr.length)
			 return -1;
		
		int midIdx = (start+end)/2;
		System.out.println("midIdx:"+midIdx);
		int midVal = arr[midIdx];
		if(arr[midIdx]==midIdx)
			 return midIdx;
		
		 //search left
		 int leftIdx = Math.min(midIdx-1,midVal);
		 System.out.println("left search");
		 System.out.println("findMagicIdxDups("+arr+","+start+","+leftIdx+")");
		 int leftVal = findMagicIdxDups(arr,start,leftIdx);
		 if(leftVal>=0)
			 return leftVal;
		 
		 //search right
		 int rightIdx = Math.max(midIdx+1, midVal);
		 System.out.println("right search");
		 System.out.println("findMagicIdxDups("+arr+","+rightIdx+","+end+")");
		 int rightVal = findMagicIdxDups(arr, rightIdx, end);
		 
	     return rightVal;	  
	}
	
	boolean isPalindrome(ListNode slow){
		int val = 0;
		if(slow==null){
			return true;
		}
		val = slow.val;
		boolean isPalin = isPalindrome(slow.next);
		if(!isPalin) return false;
		
		if(val==slow.val){
			slow = slow.next;
			return true;
		}
		return false;
	}
	
}
