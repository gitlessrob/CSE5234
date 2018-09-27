package edu.osu.cse5234.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	ArrayList<Item> itemList;
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
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
		
		Order order = new Order();
		itemList = new ArrayList<>();
		itemList.add(snowballBlast);
		itemList.add(granolaSurprise);
		itemList.add(chocolateOverload);
		itemList.add(theBigOne);
		itemList.add(goldenEgg);
		order.setItems(itemList);
		
		//TODO should this be request or session scoped?
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingOrderEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
//		Object shipping = request.getSession().getAttribute("shipping");
//		request.setAttribute("shipping", shipping);
//		Object order = request.getSession().getAttribute("order");
//		request.setAttribute("order", order);
//		Object payment = request.getSession().getAttribute("payment");
//		request.setAttribute("payment", payment);
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}

}