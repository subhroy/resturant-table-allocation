package roy.resturant.allocation;

import roy.resturant.allocation.model.ClientsGroup;
import roy.resturant.allocation.model.Table;

import java.util.List;

public class RestManager {
  private final List<Table> tables;
  private final ClientGroupHandler clientGroupHandler;

  public RestManager(List<Table> tables) {
    this.tables = tables;
    this.clientGroupHandler = new ClientGroupHandler();
  }

  // new client(s) show up
  public void onArrive(ClientsGroup group) {
    clientGroupHandler.addToClientQueue(group);
    assignTable();
  }

  // client(s) leave, either served or simply abandoning the queue
  public void onLeave(ClientsGroup group) {
    if (group.getTable() != null) {
      tables.add(group.getTable());
    }
    clientGroupHandler.removeClient(group);
    assignTable();
  }

  // return table where a given client group is seated,
  // or null if it is still queuing or has already left
  public Table lookup(ClientsGroup group) {
    return clientGroupHandler.findClientGroupTable(group);
  }

  private void assignTable() {
    clientGroupHandler.checkTablesForClient(tables);
  }
}
