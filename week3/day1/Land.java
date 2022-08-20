package week3.day1;

public class Land implements Plan{

	@Override
	public void sqrtOfHouse() {
		// TODO Auto-generated method stub
		System.out.println("The sqft of house is "+totalSqft);
		
	}

	@Override
	public void carParking() {
		// TODO Auto-generated method stub
		System.out.println("The car parking under available ");
		
	}

	@Override
	public int numberOfBedRooms(int bedRoomSize) {
		// TODO Auto-generated method stub
		System.out.println("The Number of bedroom in house "+bedRoomSize);
		return bedRoomSize;
	}
	
	public void gardening()
	{
		System.out.println("The Garding is there ");
	}

}
