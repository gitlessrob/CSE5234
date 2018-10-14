package edu.osu.cse5234.business;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.controller.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	static int k=0;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	// TODO Objective 3 (instructions unclear)
    	k=k+1;

    	InventoryService orderProcServ = ServiceLocator.getInventoryService();
    	boolean chk=validateItemAvailability(order);
    	if(chk)
    		orderProcServ.updateInventory(order.getItems());
    	return String.valueOf(k);
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService invServ = ServiceLocator.getInventoryService();
    	ArrayList<Item> items = order.getItems();
    	return invServ.validateQuantity(items);
    }

}
