package ali.num11;

/*
11. 盛最多水的容器

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class MaxArea {

    /*
    解题：为什么把left和right中高度比较低的移动？ https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/

     */

    public int maxArea(int[] height) {
        if(height ==null || height.length<2)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            max = Math.max(max, (right-left) * Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int i = new MaxArea().maxArea(arr);
        System.out.println(i);
    }
}
