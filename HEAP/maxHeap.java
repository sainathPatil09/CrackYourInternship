// "static void main" must be defined in a public class.
class MaxHeap{
    ArrayList<Integer> heap;
    public MaxHeap(){
        heap = new ArrayList<>();
    }
    
    public MaxHeap(int[] nums){
        int n = nums.length;
        
        heap = new ArrayList<>();
        
        for(int num : nums){
            heap.add(num);
        }
        for(int i= n / 2 - 1; i>=0; i=i-1 ){
            heapify(i);
        }
        
    }
    
    public int peek(){                             TC = O(1)   SC O(1)
        if(heap.size() == 0){
            System.out.println("Heap is empty");
        }
        System.out.println(heap.get(0));
        return heap.get(0);
    }
    
    public void heapify(int index){                TC O(logn)  SC O(1)                
        int size = heap.size();
        int larget = index;
        while(index < size){
            int leftChildIdx = 2 * index + 1;
            int rightChildIdx = 2 * index + 2;
            
            if(leftChildIdx < size && heap.get(leftChildIdx) > heap.get(larget)){
                larget = leftChildIdx;
            }
            if(rightChildIdx < size && heap.get(rightChildIdx) > heap.get(larget)){
                larget = rightChildIdx;
            }
            
            if(index != larget){
                Collections.swap(heap, index, larget);
                index = larget;
            }
            else break;
        }
    }
    
    public void insert(int val){                TC O(logn)   SC O(1)
        heap.add(val);
        int index = heap.size()-1;
        
        while(index > 0){
            int parentIdx = (index - 1)/2;
            
            if(heap.get(parentIdx) < heap.get(index)){
                Collections.swap(heap, parentIdx, index);
                index = parentIdx;
            }
            else break;
        }
        
        
        
    }
    
    public int pop(){                                          TC O(logn)   SC O(1)
        if(heap.size() == 0){
            System.out.println("Heap is Empty");
            return -1;
        }
        else if(heap.size() == 1){
            int val = heap.get(0);
            System.out.println(heap.get(0));
            heap.remove(0);
            return val;
        }
        
        int popVal = heap.get(0);
        int topNewVal = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        
        heap.set(0, topNewVal);
        
        heapify(0);
        
        System.out.println(popVal);
        return popVal;
    }
    
    public void print(){
        System.out.println("========HEAP START===============");
        for(int ele : heap){
            System.out.println(ele);
        }
        System.out.println("========HEAP END===============");
    }
    
}
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{20,10,17,30,40};
        MapHeap mh = new MaxHeap(arr);
        
        mh.print();
        
//         MapHeap mh = new MaxHeap();
        
//         mh.insert(25);
//         mh.insert(30);
//         mh.insert(15);
//         mh.insert(100);
        
//         mh.print();
        
//         mh.pop();
//         mh.pop();
        
//         mh.print();
        
//         mh.peek();
//         mh.pop();
//         mh.pop();
        
//         mh.print();
        
        
        
    }
}
