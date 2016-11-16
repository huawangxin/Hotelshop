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
	@Resource//����Springע����ԴbuyService
	private BuyService buyService;
	@RequestMapping("/login.form")
	public String loginForm(){
		//�����������һЩ����
		return "login";//ӳ�䵽login.jsp
	}
	@RequestMapping("/loginaction.form")//Spring mvc�Զ�����ע��
	public String checkLogin(HttpServletRequest req){
		try {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			Buyer buyer=buyService.login(name, pwd);
			//��½�ɹ�����½�û���Ϣ���浽��ǰ�Ự��
			req.getSession().setAttribute("buyer", buyer);
			/*�����ﳵ��Ϣ���浽ҳ����*/
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
	@RequestMapping("/registeraction.form")//Spring mvc�Զ�����ע��
	public String checkRegister(HttpServletRequest req){
		System.out.println("registeraction.form");
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		System.out.println(name);
		try {
			Buyer buyer=buyService.register(name, pwd);
			//��½�ɹ�����½�û���Ϣ���浽��ǰ�Ự��
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
		//�����������һЩ����
		return "index";//ӳ�䵽index.jsp
	}
	/*����ֵ��б�*/
	@RequestMapping("/resturants.form")
	public String resturantForm(){
		//�����������һЩ����
		return "resturants";//ӳ�䵽resturants.jsp
	}
	/*����ѡ�����б�*/
	@RequestMapping("/orders.form")
	public String orderForm(HttpServletRequest req){
		int page=1;
		int pagesum=0;
		int pagenum=2;
		//����Ʒ��Ϣ���ȡ���ص�����
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
		
		//�����������һЩ����
		return "orders";//ӳ�䵽orders.jsp
	}
	/*��һҳ�б�*/
	@RequestMapping("/ordersnext.form")
	public String orderNextForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//����Ʒ��Ϣ���ȡ���ص�����
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
			//�����������һЩ����
			return "orders";//ӳ�䵽orders.jsp
		}
		
	}
	/*��һҳ�б�*/
	@RequestMapping("/ordersbefore.form")
	public String orderBeforeForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//����Ʒ��Ϣ���ȡ���ص�����
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
			//�����������һЩ����
			return "orders";//ӳ�䵽orders.jsp
		}
		
	}
	/*���빺�ﳵ*/
	@RequestMapping("/addCart.form")
	public String addCartForm(HttpServletRequest req){
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		int numbers=1;
		int price=Integer.parseInt(req.getParameter("price"));
		buyService.addCart(name,goodname,numbers,price);
		return "orders";//ӳ�䵽orders.jsp
	}
	/*�����û�Name���빺�ﳵ*/
	@RequestMapping("/checkout.form")
	public String checkoutForm(HttpServletRequest req){
		String name=req.getParameter("name");
		/*�����ﳵ��Ϣ���浽ҳ����*/
		List<Cart> cartlist=buyService.findCarts(name);
		req.getSession().setAttribute("cartlist", cartlist);
		return "checkout";//ӳ�䵽checkout.jsp
	}
	/*���ݹ��ﳵIDɾ�����ﳵ��Ʒ*/
	@RequestMapping("/delCart.form")
	public String delCartForm(HttpServletRequest req){
		int cartid=Integer.parseInt(req.getParameter("cartid"));
		buyService.delCart(cartid);
		String name=req.getParameter("name");
		/*�����ﳵ��Ϣ���浽ҳ����*/
		List<Cart> cartlist=buyService.findCarts(name);
		req.getSession().setAttribute("cartlist", cartlist);
		return "checkout";
	}
	/*����Ԥ���������*/
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
		return "pay";//ӳ�䵽pay.jsp
	}
	/*�����ύ��������*/
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
		String states="��Ԥ��";
		BuyList buyList=new BuyList(1, goodname,numbers, prices, name, phone, date1, date2, states);
		//�����µĶ���
		buyService.addList(buyList);
		//ɾ����Ӧ�Ĺ��ﳵ��Ϣ
		buyService.delCart(cartid);
		req.getSession().setAttribute("buyList", buyList);
		return "count";//ӳ�䵽count.jsp
	}
	/*�ɶ���ҳ���븶�����*/
	@RequestMapping("/count1.form")
	public String countForm1(HttpServletRequest req){
		String states=req.getParameter("states");
		if(states.equals("��ԤԼ")){
			return "list";
		}
		int listid=Integer.parseInt(req.getParameter("listid"));
		BuyList buyList=buyService.findListById(listid);
		req.getSession().setAttribute("buyList", buyList);
		return "count1";//ӳ�䵽count.jsp
	}
	/*�����������û���������*/
	@RequestMapping("/countaction.form")
	public String countactionForm(HttpServletRequest req){
		String name=req.getParameter("name");
		String goodname=req.getParameter("goodname");
		String date1=req.getParameter("date1");
		buyService.updateList(name,goodname,date1);
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//ӳ�䵽list.jsp
	}
	/*�����������û���������1*/
	@RequestMapping("/countaction1.form")
	public String countactionForm1(HttpServletRequest req){
		int listid=Integer.parseInt(req.getParameter("listid"));
		String name=req.getParameter("name");
		buyService.updateList(listid);
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//ӳ�䵽list.jsp
	}
	/*�����û���������*/
	@RequestMapping("/list.form")
	public String listForm(HttpServletRequest req){
		String name=req.getParameter("name");
		List<BuyList> orderlist=buyService.findList(name);
		req.getSession().setAttribute("orderlist", orderlist);
		return "list";//ӳ�䵽list.jsp
	}
	/*ɾ��������*/
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
	/*�����û�����ȡ�û�����Ϣ*/
	@RequestMapping("/person.form")
	public String personForm(HttpServletRequest req){
		String name=req.getParameter("name");
		Buyer buyer=buyService.findBuyer(name);
		req.getSession().setAttribute("orderlist", buyer);
		return "person";
	}
	/*�޸��û�����*/
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
