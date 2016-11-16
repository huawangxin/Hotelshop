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
	@Resource//请求Spring注入资源buyService
	private SellerService sellerService;
	@RequestMapping("/login.form")
	public String loginForm(){
		//可以向表单传递一些参数
		return "sellerlogin";//映射到login.jsp
	}
	@RequestMapping("/sellerlogin_action1.form")
	public String checkLogin(HttpServletRequest req){
		try {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			Seller seller=sellerService.login(name, pwd);
			//登陆成功将登陆用户信息保存到当前会话中
			req.getSession().setAttribute("seller", seller);
			/*将购物车信息保存到页面中*/
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
	/*查询全部商品*/
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
		
		//可以向表单传递一些参数
		return "sellerdesign";
	}
	/*下一页列表*/
	@RequestMapping("/ordersnext.form")
	public String orderNextForm(HttpServletRequest req){
		int page=Integer.parseInt(req.getParameter("page"));
		int pagesum=0;
		int pagenum=2;
		//将商品信息表获取返回到界面
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
			//可以向表单传递一些参数
			return "sellerdesign";
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
			//可以向表单传递一些参数
			return "sellerdesign";//映射到orders.jsp
		}
	}
	/*模糊查询*/
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
		
		//可以向表单传递一些参数
		return "sellerdesign";
	}
}
