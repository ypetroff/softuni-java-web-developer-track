package collectionHierarchy;

public class MyListImpl extends Collection implements MyList{

    @Override
    public int add(String item) {

        getItems().add(0, item);
        return getItems().indexOf(item);
    }

    @Override
    public String remove() {

        return String.format("%s", getItems().remove(0)); //getItems().size()-1
    }

    public int getUsed() {
        return getItems().size();
    }
}
