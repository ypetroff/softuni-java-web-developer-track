package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.Repository;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableRepositoryImpl implements Repository<Table>, TableRepository<Table> {
    List<Table> tableList;

    public TableRepositoryImpl() {
        tableList = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tableList);
    }

    @Override
    public void add(Table table) {
        this.tableList.add(table);
    }

    @Override
    public Table byNumber(int number) {
        return this.tableList.stream().filter(t -> t.getTableNumber() == number).findFirst().orElse(null);
    }
}
