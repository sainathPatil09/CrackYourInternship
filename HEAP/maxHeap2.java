// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // MaxHeap heap = new MaxHeap();
        // heap.peek();
        // heap.poll();
//         heap.insert(4);
//         heap.insert(7);
//          heap.insert(1);
//          heap.insert(8);
//         heap.insert(8);
        
//         System.out.println(heap.peek());
//         System.out.println(heap.poll());
//         System.out.println(heap.poll());
//         heap.getAll();
        
        // MaxHeap heap = new MaxHeap(new int[]{1,2,3,4});
        // heap.getAll();
        // System.out.println(heap.poll());
        // heap.getAll();
        
        MaxHeap heap = new MaxHeap(new int[]{20, 10, 30, 17, 40});
        heap.sort();
        heap.getAll();
        
    }
}


class MaxHeap{
    ArrayList<Integer> arr;
    
    public MaxHeap(){
        arr = new ArrayList<>();
    }
    
    public MaxHeap(int[] nums){
        arr = new ArrayList<>();
        for(int ele : nums)arr.add(ele);
        int n = nums.length;
        for(int i=n/2-1;i>=0;i=i-1){
            heapify(i);
        }
    }
    
    public void sort(){
        
        for(int i=arr.size()-1;i>=0;i--){
            Collections.swap(arr, 0, i);
            hepify2(0, i);
        }
    }
    
    public void hepify2(int index, int size){
        int largest = index;
        
        while(index < size){
            int leftChildIdx = (index*2)+1;
            int rightChildIdx = (index*2)+2;
            
            if(leftChildIdx < size && arr.get(leftChildIdx) > arr.get(largest)){
                largest = leftChildIdx;
            }
            if(rightChildIdx < size && arr.get(rightChildIdx) > arr.get(largest)){
                largest = rightChildIdx;
            }
            
            if(largest != index){
                Collections.swap(arr, index, largest);
                index= largest;
            }
            else break;
        }
    }
    
    public int peek(){
        int size = arr.size();
        if(size == 0){
            System.out.println("HEAP is EMPTY");
            return -1;
        }
        return arr.get(0);
    }
    
    public void heapify(int index){
        int size = arr.size();
        int largest = index;
        
        while(index < size){
            int leftChildIdx = (index*2)+1;
            int rightChildIdx = (index*2)+2;
            
            if(leftChildIdx < size && arr.get(leftChildIdx) > arr.get(largest)){
                largest = leftChildIdx;
            }
            if(rightChildIdx < size && arr.get(rightChildIdx) > arr.get(largest)){
                largest = rightChildIdx;
            }
            
            if(largest != index){
                Collections.swap(arr, index, largest);
                index= largest;
            }
            else break;
        }
    }
    
    public void insert(int num){
        arr.add(num);
        int index = arr.size()-1;
        
        while(index > 0){
            int parentIdx = (index-1)/2;
            
            if(arr.get(parentIdx) < arr.get(index)){
                Collections.swap(arr, parentIdx, index);
                index = parentIdx;
            }
            else break;
        }
        
    }
    
    public int poll(){
        int size = arr.size();
        if(size == 0){
            System.out.println("HEAP is EMPTY");
            return -1;
        }
        int popEle = arr.get(0);
        int topNewVal = arr.get(arr.size() - 1);
        arr.remove(arr.size()-1);
        arr.set(0, topNewVal);
        heapify(0);
        return popEle;
    }
    
    public void getAll(){
        System.out.println("========Heap Start=============");
        
        for(int ele : arr){
            System.out.print(ele +" ");
        }
        System.out.println();
        System.out.println("========Heap END=============");
    }
}
