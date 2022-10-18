package collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable  {


    @Override
    public int add(String item) {

        getItems().add(0, item);
        return super.getItems().indexOf(item);
    }


    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }
}
