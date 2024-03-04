import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaBai5 {

	public static void main(String[] args) {
		List<Integer> list = getInputList();
		Add(list, 0);
		Remove(list, 5);
		Collections.sort(list); // Sap xep day
		double average = GetAverage(list);
		ClosetToAverage(list, average);
		Output(list);		
    }
	
	//Ham nhap day so
	public static List<Integer> getInputList() {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Enter input:");
		
		String inputLine = console.nextLine();	
		Scanner input = new Scanner(inputLine);
		List<Integer> numbers = new ArrayList<>();
		while (input.hasNext()) {
		    numbers.add(Integer.parseInt(input.next()));
		}
		console.close();  
        return numbers;
    }	
	
	//Ham xuat day so
	public static void Output(List<Integer> list) {
		for (int i =0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	//Ham them phan tu
	public static void Add(List<Integer> list, int num) {
		list.add(num);
	}
	
	//Ham xoa phan tu
	public static void Remove(List<Integer> list, Integer num) {
		boolean removed = list.remove(num);
	}
	
	//Ham tinh gia tri trung binh
	public static double GetAverage(List<Integer> list) {
		double average = 0;	
		for (int nukmber : list) {
			average += nukmber;
		}
		average /= list.size();	
		System.out.print(average); 
		return average;
	}
	
	//Ham tim phan tu gan voi gia tri trung binh nhat
	public static void ClosetToAverage(List<Integer> list, double average) {
		double minDistance = Double.MAX_VALUE;
		int position = -1;
		for (int i = 0; i < list.size(); i++) {
		    double distance = Math.abs(list.get(i) - average);
		    if (distance < minDistance) {
		    	minDistance = distance;
		        position = i;
		    }
		}
		System.out.print(position);
	}
}

