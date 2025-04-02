package org.example.alcohol_inventory;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*")
public class InventoryController{
    private final Inventory inventory = new Inventory();

    //Get all items
    @GetMapping
    public Collection<Alcohol> getAllItems(){
        return inventory.getAllItems();
    }
    //Get one item by ID
    @GetMapping("/{id}")
    public Alcohol getItem(@PathVariable String id){
        return inventory.getItem(id);
    }
    //Add new item
    @PostMapping
    public String addItem(@RequestBody Alcohol item){
        if(inventory.idExists(item.getId())){
            return "Item with this ID already exists";
        }
        inventory.addItem(item);
        return "Item added";
    }
    //Update quantity
    @PutMapping("/{id}/quantity")
    public String updateQuantity(@PathVariable String id, @RequestBody int newQuantity){
        if(!inventory.idExists(id)){
            return "Item not found";
        }
        inventory.updateQuantity(id, newQuantity);
        return "Quantity updated";
    }
    //Delete Item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable String id){
        if(!inventory.idExists(id)){
            return "Item not found";
        }
        inventory.removeItem(id);
        return "Item deleted";
    }



}
