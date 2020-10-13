package Hash;

public class EmpLinkedList {
    private Emp head;

    public void add(Emp emp){
        if (head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null){
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    public void deleteById(int id,int i){
        if (head==null){
            System.out.println("链表"+i+"为空");
            return;
        }
        if (head.id == id && head.next == null){
            head = null;
            System.out.println("删除成功");
            return;
        }else if (head.id == id && head.next != null){
            head =head.next;
            System.out.println("删除成功");
            return;
        }

        Emp befor = head;
        Emp curEmp = head.next;

        while (curEmp != null) {
            if (curEmp.id == id && curEmp.next != null) {
                 befor.next = curEmp.next;
                System.out.println("删除成功");
                return;
            } else if (curEmp.id == id && curEmp.next == null) {
                befor.next = null;
                System.out.println("删除成功");
                return;
            }else{
                befor = befor.next;
                curEmp = curEmp.next;
            }

        }
        System.out.println("链表"+i+"没有此id");

    }

    public Emp findById(int id,int i){
        if (head==null){
            System.out.println("链表"+i+"为空");
            return null;
        }
        Emp curEmp = head;
        while (curEmp != null){
            if (curEmp.id == id){
                return curEmp;
            }else {
                curEmp = curEmp.next;
            }
        }
        System.out.println("链表"+i+"没有此id");
        return null;
    }


    public void list(int i){
        if (head == null){
            System.out.println("当前链表"+i+"为空");
            return;
        }
        System.out.println();
        System.out.print("第"+i+"链表的信息为");
        Emp curEmp = head;
        System.out.print("=>"+curEmp);
        while (curEmp.next != null){
            System.out.print("=>");
            curEmp = curEmp.next;
            System.out.print(curEmp);
        }
        System.out.println();
    }

}
