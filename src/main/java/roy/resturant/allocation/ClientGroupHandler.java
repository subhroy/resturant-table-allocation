package roy.resturant.allocation;

import roy.resturant.allocation.model.ClientsGroup;
import roy.resturant.allocation.model.Table;

import java.util.*;

public class ClientGroupHandler {
  private final LinkedList<ClientsGroup> clientsGroupList;
  private final List<ClientsGroup> clientsWithTables;

  public ClientGroupHandler() {
    this.clientsGroupList = new LinkedList<>();
    this.clientsWithTables = new ArrayList<>();
  }

/*  public ClientsGroup findInClientQueue(ClientsGroup clientsGroup) {
    ClientsGroup foundClientGroup = null;
    for (ClientsGroup client : clientsGroupList) {
      if (client == clientsGroup) {
        foundClientGroup = client;
        break;
      }
    }
    return foundClientGroup;
  }*/

  public ClientsGroup findClientGroup(int size) {
    ClientsGroup foundClientGroup = null;
    Iterator<ClientsGroup> cgIterator = clientsGroupList.iterator();

    while (cgIterator.hasNext()) {
      ClientsGroup clientsGroup = cgIterator.next();
      if (clientsGroup.getSize() <= size) {
        foundClientGroup = clientsGroup;
        cgIterator.remove();
      }
    }
    return foundClientGroup;
  }

  public void addToClientQueue(ClientsGroup clientsGroup) {
    this.clientsGroupList.add(clientsGroup);
  }

  public void removeClient(ClientsGroup clientsGroup) {
    this.clientsGroupList.remove(clientsGroup);
    this.clientsWithTables.remove(clientsGroup);
  }

  public Table findClientGroupTable(ClientsGroup clientsGroup) {
    Table foundTable = null;

    for (ClientsGroup group : clientsGroupList ) {
      if (group == clientsGroup) foundTable = group.getTable();
    }
    for (ClientsGroup group : clientsWithTables ) {
      if (group == clientsGroup) foundTable = group.getTable();
    }

    return foundTable;
  }

  public void checkTablesForClient(List<Table> availableTables) {
    if (availableTables.size() == 0) return;

    ListIterator<Table> tableIterator = availableTables.listIterator();

    while (tableIterator.hasNext()) {
      Table table = tableIterator.next();
      ClientsGroup group = findClientGroup(table.getSize());

      if (group != null) {
        group.setTable(table);
        tableIterator.remove();
        clientsWithTables.add(group);
      }
    }
  }
}
