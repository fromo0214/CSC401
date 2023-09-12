import java.io.*;

class TreeNode {
    String name;
    TreeNode[] children;

    //Constructor
    TreeNode(String name, int numChildren) {
        this.name = name;
        children = new TreeNode[numChildren];
    }
}

public class DirectoryTree {
    public static TreeNode buildTree(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        TreeNode root = new TreeNode(file.getName(), file.listFiles().length);

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (int i = 0; i < children.length; i++) {
                    root.children[i] = buildTree(children[i].getAbsolutePath());
                }
            }
        }

        return root;
    }

    public static void displayTree(TreeNode node, String indent) {
        System.out.println(indent + node.name);
        if (node.children != null) {
            for (TreeNode child : node.children) {
                if (child != null) {
                    displayTree(child, indent + "|---");
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("To run this program you must use the terminal and read the README file for instructions.");
            System.exit(1);
        }

        String path = args[0];
        TreeNode tree = buildTree(path);

        if (tree != null) {
            displayTree(tree, "");
        } else {
            System.out.println("Invalid directory path or DNE.");
        }
    }
}
