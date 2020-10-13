package Hash;

public class HashTab {
    public static void main(String[] args) {
        HashTable hashTable =new HashTable(7);
        Emp emp1 = new Emp(1,"tom");
        Emp emp2 = new Emp(2,"jack");
        Emp emp8 = new Emp(8,"smith");
        Emp emp15 = new Emp(15,"smith");

        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp8);
        hashTable.add(emp15);

        //hashTable.findById(2);
        hashTable.deleteById(2);

        hashTable.list();


    }
}
