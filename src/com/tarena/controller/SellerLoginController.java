package com.tarena.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.entity.Seller;
import com.tarena.entity.Sellergoods;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.NullParamException;
import com.tarena.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerLoginController {
	@Resource//����Springע����ԴbuyService
	private SellerService sellerService;
	@RequestMapping("/login.form")
	public String loginForm(){
		//�����������һЩ����
		return "sellerlogin";//ӳ�䵽login.jsp
	}
	@RequestMapping("/sellerlogin_action1.form")
	public String checkLogin(HttpServletRequest req){
		try {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			Seller seller=sellerService.login(name, pwd);
			//��½�ɹ�����½�û���Ϣ���浽��ǰ�Ự��
			req.getSession().setAttribute("seller", seller);
			/*�����ﳵ��Ϣ���浽ҳ����*/
//			List<Cart> cartlist=sellerService.findCarts(name);
//			req.getSession().setAttribute("cartlist", cartlist);
			return "sellerindex";
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
	/*��ѯȫ����Ʒ*/
	@RequestMapping("/sellergoods.form")
	public String sellergoodsForm(HttpServletRequest req){
		int page=1;
		int pagesum=0;
		int pagenum=2;
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=sellerService.findGood();
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
		return "sellerdesign";
	}
	/*��һҳ�б�*/
	@RequestMapping("/ordersnext.form")
	public String orderNextForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//����Ʒ��Ϣ���ȡ���ص�����
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=sellerService.findGood();
		if(sellergoodslist.size()%pagenum==0){
			pagesum=sellergoodslist.size()/pagenum;
		}else {
			pagesum=sellergoodslist.size()/pagenum+1;
		}
		if(page==pagesum){
			return "sellerdesign";
		}else {
			page++;
			int result=0;
			if(page==pagesum){
				result=sellergoodslist.size();
			}else {
				result=page*pagenum;
			}
			sellergoodslist = sellergoodslist.subList((page-1)*pagenum, result);
			req.getSession().setAttribute("sellergoodslist", sellergoodslist);
			req.getSession().setAttribute("pagesum", pagesum);
			req.getSession().setAttribute("page", page);
			//�����������һЩ����
			return "sellerdesign";
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
		sellergoodslist=sellerService.findGood();
		if(sellergoodslist.size()%pagenum==0){
			pagesum=sellergoodslist.size()/pagenum;
		}else {
			pagesum=sellergoodslist.size()/pagenum+1;
		}
		if(page==1){
			return "sellerdesign";
		}else {
			page--;
			sellergoodslist = sellergoodslist.subList((page-1)*pagenum, page*pagenum);
			req.getSession().setAttribute("sellergoodslist", sellergoodslist);
			req.getSession().setAttribute("pagesum", pagesum);
			req.getSession().setAttribute("page", page);
			//�����������һЩ����
			return "sellerdesign";//ӳ�䵽orders.jsp
		}
	}
	/*ģ����ѯ*/
	@RequestMapping("/search.form")
	public String searchForm(HttpServletRequest req){
		String keywords=req.getParameter("keywords");
		int page=1;
		int pagesum=0;
		int pagenum=2;
		List<Sellergoods> sellergoodslist=new ArrayList<Sellergoods>();
		sellergoodslist=sellerService.findGoodByName(keywords);
		req.getSession().setAttribute("sellergoodslist", sellergoodslist);
		req.getSession().setAttribute("pagesum", pagesum);
		req.getSession().setAttribute("page", page);
		
		//�����������һЩ����
		return "sellerdesign";
	}
}
