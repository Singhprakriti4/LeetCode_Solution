public class Node{
    
    int data;
	int startInterval;
	int endInterval;
	Node leftNode;
	Node rightNode;
		
	public Node(int data, int startInterval, int endInterval){
		this.data=data;
		this.startInterval=startInterval;
		this.endInterval=endInterval;
		this.leftNode=null;
		this.rightNode=null;
	}
    
}
class NumArray {
    //creation of segment tree
    private static Node createSegmentTree(int[] arr, int left, int right) {
		//recursively creation;
		if(left>right) {
			return null;
		}
		if(left==right) {
			return new Node(arr[left],left,left);
		}
		
		Node leftNode=createSegmentTree(arr,left,(left+right)/2);
		Node rightNode=createSegmentTree(arr,((left+right)/2)+1,right);
		
		Node curr=new Node(leftNode.data+rightNode.data, left, right);
		curr.leftNode=leftNode;
		curr.rightNode=rightNode;
		
		return curr;
	}

    //finding the sum 
	private static int findsum(Node tree,int[] arr, int left, int right) {
		int nodestart=tree.startInterval;
		int nodeend=tree.endInterval;
		int data=tree.data;
		
		//if out of desired range
		if(nodestart>right || nodeend<left) {
			//default value
			return 0;
		}
		
		//if completely within the desired range
		if(nodestart>=left && nodeend<=right) {
			return data;
		}
		
		return findsum(tree.leftNode,arr,left,right)+findsum(tree.rightNode,arr,left,right);
	}

    //updating an index
	private static int updateTree(Node tree, int idx, int value, int[] arr) {
		int nodestart=tree.startInterval;
		int nodeend=tree.endInterval;
		int data=tree.data;
		
		//not my required range
		if(idx<nodestart || idx>nodeend) {
			return data;
		}
		
		if(tree.leftNode==null && tree.rightNode==null  && nodestart==idx) {
			arr[idx]=value;
			tree.data=value;
			return value;
		}
		
		int leftdata=updateTree(tree.leftNode,idx,value,arr);
		int rightdata=updateTree(tree.rightNode,idx,value,arr);
		
		tree.data=leftdata+rightdata;
		return tree.data;

	}
    int[] arr;
    Node beginnode=null;
    public NumArray(int[] nums) {
       arr=nums;
       beginnode=createSegmentTree(arr,0,arr.length-1);
    }
    
    public void update(int index, int val) {
        updateTree(beginnode, index, val, arr);
    }
    
    public int sumRange(int left, int right) {
        return findsum(beginnode, arr, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */