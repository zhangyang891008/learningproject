package ali.num42;

import java.util.Stack;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class Trap {

    /*
    动态规划方法：找到每个列的左右最高峰值，该列存水量为两个峰值最小值-当前列的高度;如果当前列高于左右峰值中的一个，是不能存水的
     */
    public int trap3(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        //1.求最大左侧峰值
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }

        //2.求最大右侧峰值
        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        int sum = 0;
        //3.统计每个列的存水量
        for (int i = 1; i < height.length-1; i++) {
            if((height[i] < leftMax[i]) && (height[i] < rightMax[i])){
                sum = sum + Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return sum;

    }

    /*
    双指针法：只需要一次遍历****
     */

    public int trap4(int[] height) {
        if(height == null || height.length<3)
            return 0;

        int left = 1;
        int right = height.length -2;
        int max_left = height[0];
        int max_right = height[height.length-1];

        int sum  = 0;
        while(left<=right){
            if( max_left < max_right){
                sum = sum + (max_left > height[left] ? ( max_left -  height[left]):0);
                max_left = Math.max(max_left, height[left]);
                left++;
            }else{
                sum = sum + ( max_right > height[right] ? (max_right - height[right]):0);
                max_right = Math.max(max_right, height[right]);
                right--;
            }
        }

        return sum ;

    }

    /*
    栈：如果当前节点值小于等于当前栈顶，直接入栈，
        如果大于栈顶元素的高度，栈顶出栈，保存栈顶高度；
        当前栈顶作为墙，计算  sum = sum +（当前元素index-栈顶元素index ）* （min（栈顶高度，当前高度） - 出栈元素高度）
        重复上述的操作，知道栈顶高度高于当前元素高度，当前元素index入栈，继续重复
     */
    public int trap5(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            while(!stack.empty() && height[i] > height[stack.peek()]){
                //栈顶值小于当前值，需要出栈并统计
                int curHeight = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    //没有墙，不需要统计和
                    break;
                }
                int distance = i - stack.peek() -1 ;
                int min = Math.min(height[stack.peek()], height[i]);
                sum =  sum + distance * (min - curHeight);
            }
            stack.push(i);
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1,4};
        int trap = new Trap().trap5(arr);
        System.out.println(trap);
    }

}
