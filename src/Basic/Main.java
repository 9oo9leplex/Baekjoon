package Basic;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");
		StringTokenizer st = new StringTokenizer(dtf.format(LocalDateTime.now()),"/");
        
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day;
		
		int days[] = {28,29,30,31};
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(28);	list.add(29);
		list.add(30);	list.add(31);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 28);	map.put(1, 29);
		map.put(2, 30); map.put(3, 31);
		
		int key = 0;
		if(month == 2) {
			if( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ) key++;
		} else {
			key+=2;
			if(month > 7) {
				if(month % 2 == 0) key++;
			} else {
				if(month % 2 == 1) key++;
			}
		}
		
		Calendar c = Calendar.getInstance();
		int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println(monthMaxDays);
		System.out.println(days[key]);
		System.out.println(list.get(key));
		System.out.println(map.get(key));
		
	}
}














