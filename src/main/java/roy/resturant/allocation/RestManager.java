package roy.resturant.allocation;

import java.util.List;

public class RestManager {
    public RestManager (List<Table> tables)
    {
        // TODO
    }

    // new client(s) show up
    public void onArrive (ClientsGroup group)
    {
        // TODO

    }

    // client(s) leave, either served or simply abandoning the queue
    public void onLeave (ClientsGroup group)
    {
        // TODO
    }

    // return table where a given client group is seated,
    // or null if it is still queuing or has already left
    public Table lookup (ClientsGroup group)
    {
        // TODO
        return null;
    }
}

