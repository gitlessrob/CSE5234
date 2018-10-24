package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.controller.LineItem;
import edu.osu.cse5234.controller.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	static int k=0;
	 @PersistenceContext
	    private EntityManager entityManager;

	    @Produces
	    @RequestScoped
	    public EntityManager getEntityManager() {
	        return entityManager;
	    }
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
    		{
    		List<LineItem> items = order.getItems();
    		List<Item> orderlist = new ArrayList<Item>();
    		for(LineItem e:items)
    		{
    			Item item1=new Item();
    			item1.setId(e.getId());
    			item1.setQuantity(e.getQuantity());
    			item1.setPrice(e.getPrice());
    			orderlist.add(item1);
    		}
    		orderProcServ.updateInventory(orderlist);
    		
    			entityManager.persist(order);
    			entityManager.flush();
    		}
    	return String.valueOf(k);
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService invServ = ServiceLocator.getInventoryService();
    	List<LineItem> items = order.getItems();
    	List<Item> orderlist = new ArrayList<Item>();
		for(LineItem e:items)
		{
			Item item1=new Item();
			item1.setId(e.getId());
			item1.setQuantity(e.getQuantity());
			item1.setPrice(e.getPrice());
			orderlist.add(item1);
		}
    	return invServ.validateQuantity(orderlist);
    }

}
