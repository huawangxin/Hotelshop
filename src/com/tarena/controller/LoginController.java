package com.tarena.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;
import com.tarena.service.BuyService;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.NullParamException;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource//请求Spring注入资源buyService
	private BuyService buyService;
	@RequestMapping("/login.form")
	public String loginForm(){
		//可以向表单传递一些参数
		return "login";//映射到login.jsp
	}
	@RequestMapping("/loginaction.form")//Spring mvc自动参数注入
	public String checkLogin(HttpServletRequest req){
		try {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			Buyer buyer=buyService.login(name, pwd);
			//登陆成功将登陆用户信息保存到当前会话中
			req.getSession().setAttribute("buyer", buyer);
			/*将购物车信息保存到页面中*/
			List<Cart> cartlist=buyService.findCarts(name);
			req.getSession().setAttribute("cartlist", cartlist);
			return "index";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login";
		}catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login";
		}catch (RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	@RequestMapping("/register.form")
	public String register(){
		return "register";
	}
	@RequestMapping("/registeraction.form")//Spring mvc自动参数注入
	public String checkRegister(HttpServletRequest req){
		System.out.println("registeraction.form");
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		System.out.println(name);
		try {
			Buyer buyer=buyService.register(name, pwd);
			//登陆成功将登陆用户信息保存到当前会话中
			req.getSession().setAttribute("buyer", buyer);
			return "index";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login";
		}catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login";
		}catch (RuntimeException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	@RequestMapping("/index.form")
	public String indexForm(){
		//可以向表单传递一些参数
		return "index";//映射到index.jsp
	}
	/*进入分店列表*/
	@RequestMapping("/resturants.form")
	public String resturantForm(){
		//可以向表单传递一些参数
		return "resturants";//映射到resturants.jsp
	}
	/*进入选房间列表*/
	@RequestMapping("/orders.form")
	public String orderForm(HttpServletRequest req){
		int page=1;
		int pagesum=0;
		int pagenum=2;
		//将商品信息表获取返回到界面
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=buyService.findGood();
		if(sellergoodslist.size()%pagenum==0){
			pagesum=sellergoodslist.size()/pagenum;
		}else {
			pagesum=sellergoodslist.size()/pagenum+1;
		}
		sellergoodslist = sellergoodslist.subList((page-1)*pagenum, page*pagenum);
		req.getSession().setAttribute("sellergoodslist", sellergoodslist);
		req.getSession().setAttribute("pagesum", pagesum);
		req.getSession().setAttribute("page", page);
		
		//可以向表单传递一些参数
		return "orders";//映射到orders.jsp
	}
	/*下一页列表*/
	@RequestMapping("/ordersnext.form")
	public String orderNextForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//将商品信息表获取返回到界面
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=buyService.findGood();
		if(sellergoodslist.size()%pagenum==0){
			pagesum=sellergoodslist.size()/pagenum;
		}else {
			pagesum=sellergoodslist.size()/pagenum+1;
		}
		if(page==pagesum){
			return "orders";
		}else {
			page++;
			sellergoodslist = sellergoodslist.subList((page-1)*pagenum, page*pagenum);
			req.getSession().setAttribute("sellergoodslist", sellergoodslist);
			req.getSession().setAttribute("pagesum", pagesum);
			req.getSession().setAttribute("page", page);
			//可以向表单传递一些参数
			return "orders";//映射到orders.jsp
		}
		
	}
	/*上一页列表*/
	@RequestMapping("/ordersbefore.form")
	public String orderBeforeForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//将商品信息表获取返回到界面
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=buyService.findGood();
		if(sellergoodslist.size()%pagenum==0){
			pagesum=sellergoodslist.size()/pagenum;
		}else {
			pagesum=sellergoodslist.size()/pagenum+1;
		}
		if(page==1){
			return "orders";
		}else {
			page--;
			sellergoodslist = sellergoodslist.subList((page-1)*pagenum, page*pagenum);
			req.getSession().setAttribute("sellergoodslist", sellergoodslist);
			req.getSession().setAttribute("pagesum", pagesum);
			req.getSession().setAttribute("page", page);
			//可以向表单传递一些参数
			return "orders";//映射到orders.jsp
		}
		
	}
	/*加入购物车*/
	@RequestMapping("/addCart.form")
	public String addCartForm(HttpServletRequest req){
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		int numbers=1;
		int price=Integer.parseInt(req.getParameter("price"));
		buyService.addCart(name,goodname,numbers,price);
		return "orders";//映射到orders.jsp
	}
	/*根据用户Name进入购物车*/
	@RequestMapping("/checkout.form")
	public String checkoutForm(HttpServletRequest req){
		String name=req.getParameter("name");
		/*将购物车信息保存到页面中*/
		List<Cart> cartlist=buyService.findCarts(name);
		req.getSession().setAttribute("cartlist", cartlist);
		return "checkout";//映射到checkout.jsp
	}
	/*根据购物车ID删除购物车商品*/
	@RequestMapping("/delCart.form")
	public String delCartForm(HttpServletRequest req){
		int cartid=Integer.parseInt(req.getParameter("cartid"));
		buyService.delCart(cartid);
		String name=req.getParameter("name");
		/*将购物车信息保存到页面中*/
		List<Cart> cartlist=buyService.findCarts(name);
		req.getSession().setAttribute("cartlist", cartlist);
		return "checkout";
	}
	/*进入预订房间界面*/
	@RequestMapping("/paycart.form")
	public String paycartForm(HttpServletRequest req){
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		int numbers=Integer.parseInt(req.getParameter("numbers"));
		int price=Integer.parseInt(req.getParameter("price"));
		int cartid=Integer.parseInt(req.getParameter("cartid"));
		Sellergoods sellergoods=buyService.findGoodById(goodname);
		Cart cart=new Cart(cartid, name, goodname, numbers, price);
		req.getSession().setAttribute("cart", cart);
		req.getSession().setAttribute("sellergoods", sellergoods);
		return "pay";//映射到pay.jsp
	}
	/*进入提交订单界面*/
	@RequestMapping("/count.form")
	public String countForm(HttpServletRequest req){
		int cartid=Integer.parseInt(req.getParameter("cartid"));
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		int numbers=Integer.parseInt(req.getParameter("numbers"));
		int prices=Integer.parseInt(req.getParameter("prices"));prices=numbers*prices;
		String phone=req.getParameter("phone");
		String date1=req.getParameter("date1");
		String date2=req.getParameter("date2");
		String states="可预订";
		BuyList buyList=new BuyList(1, goodname,numbers, prices, name, phone, date1, date2, states);
		//生成新的订单
		buyService.addList(buyList);
		//删除对应的购物车信息
		buyService.delCart(cartid);
		req.getSession().setAttribute("buyList", buyList);
		return "count";//映射到count.jsp
	}
	/*由订单页进入付款界面*/
	@RequestMapping("/count1.form")
	public String countForm1(HttpServletRequest req){
		String states=req.getParameter("states");
		if(states.equals("已预约")){
			return "list";
		}
		int listid=Integer.parseInt(req.getParameter("listid"));
		BuyList buyList=buyService.findListById(listid);
		req.getSession().setAttribute("buyList", buyList);
		return "count1";//映射到count.jsp
	}
	/*付款界面进入用户订单界面*/
	@RequestMapping("/countaction.form")
	public String countactionForm(HttpServletRequest req){
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		String date1=req.getParameter("date1");
		buyService.updateList(name,goodname,date1);
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//映射到list.jsp
	}
	/*付款界面进入用户订单界面1*/
	@RequestMapping("/countaction1.form")
	public String countactionForm1(HttpServletRequest req){
		int listid=Integer.parseInt(req.getParameter("listid"));
		String name=req.getParameter("name");
		buyService.updateList(listid);
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//映射到list.jsp
	}
	/*进入用户订单界面*/
	@RequestMapping("/list.form")
	public String listForm(HttpServletRequest req){
		String name=req.getParameter("name");
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//映射到list.jsp
	}
	/*删除订单表*/
	@RequestMapping("/delList.form")
	public String delListForm(HttpServletRequest req){
		String name=req.getParameter("name");
		int listid=Integer.parseInt(req.getParameter("listid"));
		buyService.delList(listid);
		List<BuyList> orderlist=buyService.findList(name);
		System.out.println(orderlist);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";
	}
	/*根据用户名获取用户表信息*/
	@RequestMapping("/person.form")
	public String personForm(HttpServletRequest req){
		String name=req.getParameter("name");
		Buyer buyer=buyService.findBuyer(name);
		req.getSession().setAttribute("orderlist", buyer);
		return "person";
	}
	/*修改用户密码*/
	@RequestMapping("/updateBuyer.form")
	public String updateBuyerForm(HttpServletRequest req){
		int id=Integer.parseInt(req.getParameter("id"));
		String pwd=req.getParameter("pwd");
		String name=req.getParameter("name");
		Buyer buyer=new Buyer(id, name, pwd);
		buyService.updateBuyer(id,name,pwd);
		req.getSession().setAttribute("buyer", buyer);
		return "person";
	}
}
