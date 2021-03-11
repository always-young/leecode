package com.kevin.leecode.godzuo.binarytree;

/**
 * @author kevin lau
 */
public class MaxDistance {

    public int getMaxDistance(Node root) {
        return getNodeInfo(root).maxDistance;
    }

    private Info getNodeInfo(Node node) {
        if(node == null) {
            return new Info(0,0);
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);
        int height  = Math.max(left.height, right.height) +1;
        int maxInstance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1) ;
        return new Info(height,maxInstance);
    }


    public static class Info {

        public int height;

        public int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }

    }
}
