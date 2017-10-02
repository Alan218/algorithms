package a2.Poj3481;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int num=0;
	static Node nil=new Node();
	public static void main(String[] args) {
		Scanner sc=null;
		try {
			sc=new Scanner(new File("input_a2.txt"));
		} catch (FileNotFoundException e) {
		}
		int code=sc.nextInt();
		while(code!=0){
			switch(code){
			case 1:
				add(sc.nextInt(),sc.nextInt());
				break;
			case 2:
				serveHigh();
				break;
			case 3:
				serveLow();
				break;
			default:
				isError("code:"+code);
			}
			code=sc.nextInt();
			
		}
		sc.close();
	}
	
	private static void add(int k, int p) {
		Node newNode=new Node();
		newNode.K=k;newNode.P=p;
		if(num==0){
			//nil的next为头结点   nil的pre为尾节点
			nil.next=newNode;
			nil.pre=newNode;
			newNode.pre=nil;
			newNode.next=nil;
			num++;
		}else{
			Node temp=nil.next;
			while(newNode.P>temp.P){
				if(temp.next==nil){
					temp.next=newNode;
					nil.pre=newNode;
					newNode.pre=temp;
					newNode.next=nil;
					num++;
					return;
				}else{
					temp=temp.next;
				}
			}
			newNode.next=temp;
			newNode.pre=temp.pre;
			newNode.pre.next=newNode;
			temp.pre=newNode;
			num++;
		}
	}

	private static void serveLow() {
		if(num==0){
			System.out.println(0);
			return;
		}else{
			System.out.println(nil.next.K);
			nil.next=nil.next.next;
			nil.next.pre=nil;
			num--;
		}
	}

	private static void serveHigh() {
		if(num==0){
			System.out.println(0);
			return;
		}else{
			System.out.println(nil.pre.K);
			nil.pre=nil.pre.pre;
			nil.pre.next=nil;
			num--;
		}
	}

	private static int isError(String str) {
		System.out.println(str);
		return 9/0;
	}
}
class Node{
	int K,P;
	Node pre,next;
}

