package verifyavl;

public class VerifyAVL {
    public static boolean verifyAVL(AVLNode root) {

        return AVLCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean AVLCheck(AVLNode root, int leftBound, int rightBound) {
        if (root == null) {
            return true;
        } else {



            boolean correctBalance = checkCorrectBalance(root);
            boolean correctHeightLabel = checkCorrectHeightLabel(root);

            if((root.key > leftBound && root.key < rightBound) && correctHeightLabel && correctBalance) {


                    boolean leftAVLCheck = AVLCheck(root.left, leftBound, root.key);
                    boolean rightAVLCheck = AVLCheck(root.right, root.key, rightBound);


                    return (leftAVLCheck && rightAVLCheck);


            } else {
                return false;
            }
        }
    }

    public static boolean checkCorrectOrder(AVLNode current) {

        if((current.left != null && current.left.key > current.key) ||
                (current.right != null && current.right.key < current.key)) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean checkCorrectHeightLabel (AVLNode current) {

        int maxHeight = -1;
        if(current.left != null && current.right != null) {
            maxHeight = Math.max(current.left.height, current.right.height);
        } else if(current.left != null) {
            maxHeight = current.left.height;
        } else if(current.right != null) {
            maxHeight = current.right.height;
        }

        if(maxHeight+1 == current.height) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkCorrectBalance(AVLNode current) {

        int leftHeight = -1;
        if(current.left != null) {
            leftHeight = current.left.height;
        }

        int rightHeight = -1;
        if(current.right != null) {
            rightHeight = current.right.height;
        }

        if((rightHeight - leftHeight) < 2 && (rightHeight - leftHeight) > -2) {
            return true;
        } else {
            return false;
        }
    }




    /* TODO: Add private methods if you want (recommended) */
}