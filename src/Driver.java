import java.util.*;
import java.io.*;

public class Driver extends Numerology{
	
	//Creating Singly Linked list
	public static SinglyLinkedList<Numerology> Snum = new SinglyLinkedList<Numerology>();
	//Creating Double Linked Lists
	public static DoublyLinkedList<Numerology> Dnum = new DoublyLinkedList<Numerology>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		writeDates();
		readDates();
		writeSLL();
		writeDLL();
	}
	

	
	private static void writeDLL() {
		// TODO Auto-generated method stub
		try {
			File doublyFile = new File("DLL.txt");
			PrintWriter printDLL = new PrintWriter(doublyFile);
			
			while(!Dnum.isEmpty()) {
				printDLL.println(Dnum.removeLast().getNumerology());
			}
			
			printDLL.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static void writeSLL() {
		// TODO Auto-generated method stub
	
		try {
			File singlyFile = new File("SLL.txt");
			PrintWriter printSLL = new PrintWriter(singlyFile);
			
			while(!Snum.isEmpty()) {
				printSLL.println(Snum.removeFirst().getNumerology());
			}
			
			printSLL.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reads dates from dates.txt file
	 */
	public static void readDates() {
		// TODO Auto-generated method stub
		try {
			FileReader read = new FileReader("dates.txt");
			Scanner input = new Scanner(read);
			
			input.nextLine();
			input.useDelimiter("\t|\n");
			
			
			while(input.hasNext()) {
				int month = Integer.valueOf(input.next());
//				if (month.toCharArray().length == 1){
//		            month = "0"+month;
//		        }
				int day = Integer.valueOf(input.next());
//		        if (day.toCharArray().length == 1){
//		            day = "0"+day;
//		        }
				int year = Integer.valueOf(input.next().trim());
				int sum = 0; 
				int num = month + day + year;
				while(num > 0 || sum > 9) {
					if (num == 0) {
						num = sum;
						sum = 0;
					}
					sum += num % 10;
		          
					num /= 10;
				}
				int result = sum;
				String prediction = null;				
				if(result == 1)
					prediction = "You will see the ghost of your Ancestors";
				else if (result == 2)
					prediction = "You will be transported to a dead star, 3....2...1";
				else if (result == 3)
					prediction = "Just be on guard for the rest of the month";
				else if (result == 4)
					prediction = "Remember that 100 dollar you lost last week, you will find it in your left favorite shoe";
				else if (result == 5)
					prediction = "Great news is coming your way at the end of the month.";
				else if (result == 6)
					prediction = "Waking up in a super hero world sounds fun. Wear your super suit to bed today.";
				else if (result == 7)
					prediction = "Vampires are coming for you and your family. Get the garlic";
				else if (result == 8)
					prediction = "Your reality is a lie. Question everything you see.";
				else if (result == 9)
					prediction = "You are cursed for the rest of the year until you do something nice for your mom.";
//				System.out.println(result);
				
				Numerology numbers = new Numerology();
				numbers.setMonth(month);
				numbers.setDay(day);
				numbers.setYear(year);
				numbers.setResult(result);
				numbers.setPrediction(prediction);
//				System.out.println("Read Numbers: " + numbers.getMonth()+ "\t" + numbers.getDay() + "\t" + numbers.getYear() + "\t" + numbers.getPrediction() + "\t" + numbers.getResult());
				
				//Add Linked Lists
				Snum.addLast(numbers);
				Dnum.addLast(numbers);
			}
			
//			while(!Snum.isEmpty()) {
//				System.out.println("Singly:" + Snum.removeFirst().getNumerology());
//			}
//			
//			while(!Dnum.isEmpty())
//				System.out.println("Doubly:" + Dnum.removeFirst().getNumerology());
//			
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generates 100 random valid dates
	 */
	public static String genDates() {
		Random rand = new Random();
		int month = 0;
		int day = 0;
		int year = 0;
		String date ="";
		
		//Month
		month = rand.nextInt(12)+ 1;
//		System.out.println(month);
		
		//Day
		if (month == 2 )
			day = rand.nextInt(28) + 1;
		else if(month == 4 || month == 6 || month == 9 || month == 11)
			day = rand.nextInt(30)+ 1;
		else
			day = rand.nextInt(31) + 1;
		
		//Year
		year = rand.nextInt(521) + 1500;
		date = month + "\t" + day + "\t" + year;
		
//		System.out.println(date);
		
		return date;
	}
	
	/**
	 * Writes dates to file
	 */
	public static void writeDates() {
		
		try {
			FileWriter write = new FileWriter("dates.txt");
			PrintWriter out = new PrintWriter(write);
			int count = 0;
			
			out.println("Month\tDay\tYear");
			while(count < 100) {
				String dates = genDates();
				out.println(dates);
				count ++;
				
			}
			
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
