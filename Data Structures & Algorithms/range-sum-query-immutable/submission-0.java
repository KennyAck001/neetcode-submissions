class NumArray {
    public class Node{
        int val;
        Node left;
        Node right;
        int start;
        int end;

        Node(){};
        Node(int val) {this.val = val;}
        Node(int start, int end){this.start = start; this.end = end;}
    }

    Node root;

    public Node build(int[] nums, int start, int end){
        if(start == end){
            Node node = new Node(start, end);
            node.val = nums[start];
            return node;
        }
        Node node = new Node(start, end);
        int mid = start + (end - start) /2;

        node.left = build(nums, start, mid);
        node.right = build(nums, mid+1, end);

        node.val = node.left.val + node.right.val;
        return node;

    }

    public NumArray(int[] nums) {
        this.root = build(nums, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        this.root.val = update(root, index, val); 
    }

    private int update(Node node, int index, int val){
        if(node.start <= index && node.end >= index){
            if(index == node.start && index == node.end){
                node.val = val;
                return node.val;
            }else{
                int left = update(node.left, index, val);
                int right = update(node.right, index, val);

                node.val = left + right;
                return node.val;
            }
        }
        return node.val;
    }
    
    public int sumRange(int left, int right) {
        return range(this.root, left, right);
    }

    private int range(Node node, int left, int right){
        if(node.start >= left && node.end <= right){
            return node.val;
        }else if(node.end < left || node.start > right){
            return 0;
        }else{
            return range(node.left, left, right) + range(node.right, left, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */