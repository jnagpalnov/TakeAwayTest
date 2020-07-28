package requests;

import java.util.ArrayList;
import java.util.List;

public class AddItemsRequest {
    private List<Items> items;

    public void setItems(List<Items> items){
        this.items = items;
    }
    public List<Items> getItems(){
        return this.items;
    }

  
}
