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
		snowballBlast.setStock(2);
		
		Item granolaSurprise = new Item();
		granolaSurprise.setName("Granola Surprise");
		granolaSurprise.setPrice("1.99");
		granolaSurprise.setStock(2);
		
		Item chocolateOverload = new Item();
		chocolateOverload.setName("Chocolate Overload");
		chocolateOverload.setPrice("9.99");
		chocolateOverload.setStock(2);
		
		Item theBigOne = new Item();
		theBigOne.setName("The Big One");
		theBigOne.setPrice("15.99");
		theBigOne.setStock(2);
		
		Item goldenEgg = new Item();
		goldenEgg.setName("Golden Egg");
		goldenEgg.setPrice("59.99");
		goldenEgg.setStock(2);
		
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
		boolean cond=true;
		try {
		for (Item item : items) {
			if(item.getQuantity().equals(""))
					item.setQuantity("0");
			if(Integer.parseInt(item.getQuantity())>item.getStock())
			{
				cond=false;
			}
		}}
		catch(NullPointerException e)
		{
			
		}
		return cond;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO temporary infinite inventory
		try {
for (Item item : items) {
			int k=Integer.parseInt(item.getQuantity());
			if(k<=item.getStock())
			{
				k=item.getStock()-k;
				item.setStock(k);
			}
		}}
catch(NullPointerException e)
{
	
}
		return true;
	}

}
