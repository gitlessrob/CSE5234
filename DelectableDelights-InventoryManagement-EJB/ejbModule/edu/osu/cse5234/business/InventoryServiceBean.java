package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Item snowballBlast = new Item();
		snowballBlast.setName("Snowball Blast");
		snowballBlast.setPrice("4.99");
		
		Item granolaSurprise = new Item();
		granolaSurprise.setName("Granola Surprise");
		granolaSurprise.setPrice("1.99");
		
		Item chocolateOverload = new Item();
		chocolateOverload.setName("Chocolate Overload");
		chocolateOverload.setPrice("9.99");
		
		Item theBigOne = new Item();
		theBigOne.setName("The Big One");
		theBigOne.setPrice("15.99");
		
		Item goldenEgg = new Item();
		goldenEgg.setName("Golden Egg");
		goldenEgg.setPrice("59.99");
		
		Inventory inv = new Inventory();
		ArrayList<Item> itemList = new ArrayList<>();
		itemList.add(snowballBlast);
		itemList.add(granolaSurprise);
		itemList.add(chocolateOverload);
		itemList.add(theBigOne);
		itemList.add(goldenEgg);
		inv.setList(itemList);

		return inv;
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		// TODO temporary infinite inventory
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO temporary infinite inventory
		return true;
	}

}
