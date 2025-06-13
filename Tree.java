import java.util.*;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class Main {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.right.left.right = new TreeNode(10);

		// Test here
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postOrder(root);

		List<List<Integer>> result=new ArrayList<>();
		System.out.println(levelOrder(root, result));
	}

	static void preorder(TreeNode root) {
		if (root == null) return;

		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}
	static void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	static void postOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+" ");

	}

	static List<List<Integer>> levelOrder(TreeNode root,List<List<Integer>> result) {
		Queue<TreeNode> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int levelSize=q.size();
			List<Integer> l=new ArrayList<>();
			for(int i=0; i<levelSize; i++) {
				TreeNode node=q.remove();
				l.add(node.val);
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
				
			}
			result.add(l);
		}
		return result;



	}



}
