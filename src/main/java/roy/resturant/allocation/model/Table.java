package roy.resturant.allocation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Table {
  private int size;
  private TableStatus status;

  public Table(int size) {
    this.size = size;
  }
}
