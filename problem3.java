import java.util.*;

class cow{
	String direction;
	int x;
	int y;
}
public class problem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cows = sc.nextInt();
		cow[] allCows = new cow[cows];
		List<cow> eastCows = new ArrayList<cow>();
		List<cow> northCows = new ArrayList<cow>();
		for(int i = 0;i<cows;i++) {
			cow newCow = new cow();
			newCow.direction = sc.next();
			newCow.x = sc.nextInt();
			newCow.y = sc.nextInt();
			allCows[i] = newCow;
			if (newCow.direction.equals("N")) {
				northCows.add(newCow);
			}else {
				eastCows.add(newCow);
			}
		}
		int[] shortestBlocks = new int[cows];
		for(int i = 0;i<allCows.length;i++) {
	//		System.out.println("currcow" + allCows[i].x + " " + allCows[i].y);
			if(allCows[i].direction.equals("E")) {
				int shortestBlock = Integer.MAX_VALUE;
			//	System.out.println(shortestBlock);
				for(int j = 0; j<northCows.size();j++) {
					if(findBlockedEast(allCows[i], northCows.get(j)) <shortestBlock) {
					//	System.out.println(northCows.get(j).x + " " + northCows.get(j).y);
						shortestBlock = findBlockedEast(eastCows.get(i), northCows.get(j));
					}
				}
				shortestBlocks[i] = shortestBlock;
			}else {
				int shortestBlock = Integer.MAX_VALUE;
				for(int j = 0; j<eastCows.size();j++) {
					if(findBlockedNorth(eastCows.get(j), allCows[i]) <shortestBlock) {
					//	System.out.println(eastCows.get(j).x + " "+ eastCows.get(j).y);
						shortestBlock = findBlockedNorth(eastCows.get(j), allCows[i]);
					}
				}
				shortestBlocks[i] = shortestBlock;
			}
		}
		for(int i = 0;i<shortestBlocks.length;i++) {
			if(shortestBlocks[i] == Integer.MAX_VALUE) {
				System.out.println("Infinity");
			}else{
				System.out.println(shortestBlocks[i]);
			}
		}
		
		
	}
	static int findBlockedEast(cow eastCow, cow northCow) {
		if(eastCow.x < northCow.x && eastCow.y > northCow.y) {
			if(eastCow.y-northCow.y < northCow.x-eastCow.x) {
				return northCow.x-eastCow.x;
			}
		}
		return Integer.MAX_VALUE;
	}
	static int findBlockedNorth(cow eastCow, cow northCow) {
		if(eastCow.x< northCow.x && eastCow.y>northCow.y) {
			if(eastCow.y-northCow.y > northCow.x-eastCow.x) {
				return eastCow.y-northCow.y;
			}
		}
		return Integer.MAX_VALUE;
	}
}
