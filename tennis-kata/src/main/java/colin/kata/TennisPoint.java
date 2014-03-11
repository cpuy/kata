package colin.kata;


public enum TennisPoint {

	LOVE, FIFTEEN, THIRTY, FOURTY, DEUCE, ADVANTAGE;
	
	public TennisPoint increment() {
		return values()[ordinal() + 1];
	}
}
