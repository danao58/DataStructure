package Hash;

public class HashTable {
    private EmpLinkedList[]  empLinkedListArray;
    private int size;

    public HashTable(int size) {
        empLinkedListArray =new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void deleteById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].deleteById(id,empLinkedListNo);

    }

    public void findById(int id){
        int empLinkedListNo = hashFun(id);
        Emp result = empLinkedListArray[empLinkedListNo].findById(id,empLinkedListNo);
        if (result != null){
            System.out.println(result);
        }
    }

    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public int hashFun(int id){
        return id % size;
    }
}
