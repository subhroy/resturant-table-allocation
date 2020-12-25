package roy.resturant.allocation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientsGroup {
  private int size;
  private Table table;

  public ClientsGroup(int size) {
    this.size = size;
  }
}
