package duilie;

import duilie.ArrayQueue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		System.out.println("请输入队列长度");
		Scanner sca=new Scanner(System.in);
		int sss =sca.nextInt();
		ArrayQueue arr=new ArrayQueue(sss);
		boolean loop = true;
		while (loop){
			System.out.println("1:显示队列");
			System.out.println("2:添加数据");
			System.out.println("3:查找指定数据");
			System.out.println("4:退出程序");
			int sss2 =sca.nextInt();
			switch (sss2){
				case 1:
					arr.showQueue();
					break;
				case 2:
					System.out.println("请输入要添加的数据");
					int sss3 =sca.nextInt();
					arr.addQueue(sss3);
					break;
				case 3:
					System.out.println("请输入要查询第几个数");
					int sss4 =sca.nextInt();
					arr.getQueue(sss4);
					break;
				case 4:
					loop=false;
					break;
				default:
					System.out.println("请按规定输入数据");
					break;
			}

		}


    }
}
