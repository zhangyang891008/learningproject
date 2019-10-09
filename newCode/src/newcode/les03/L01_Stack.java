package newcode.les03;

public class L01_Stack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        //System.out.println(stack.peek());;
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}

class MyStack{
    int[] arr = new int[3];
    int size = 0;
    int index = 0;

    public void push(int val){
        if(size > arr.length){
            throw new ArrayIndexOutOfBoundsException("push array out of bound!");
        }

        arr[index++] = val;
        size++;
    }

    public int pop(){
        if(size<0){
            throw new ArrayIndexOutOfBoundsException("empty");
        }

        int remove = arr[--index];
        size--;
        return remove;
    }

    public int peek(){
        if(size<0){
            throw new ArrayIndexOutOfBoundsException("empty");
        }
        return arr[index-1];
    }
}