package barracksWars.interfaces;
//created by J.M.

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
