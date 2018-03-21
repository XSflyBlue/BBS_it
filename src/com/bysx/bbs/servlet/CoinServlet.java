package com.bysx.bbs.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bysx.bbs.commons.config.CoinConfig;
import com.bysx.bbs.commons.struct.Msg;
import com.bysx.bbs.commons.util.JSONUtils;
import com.bysx.bbs.commons.util.ServletUtils;
import com.bysx.bbs.commons.util.StringUtils;
import com.bysx.bbs.domain.Coin;
import com.bysx.bbs.domain.CoinRecord;
import com.bysx.bbs.domain.UserBase;
import com.bysx.bbs.domain.json.CoinRecordJson;
import com.bysx.bbs.domain.json.SignReturnJson;
import com.bysx.bbs.service.CoinService;
import com.bysx.bbs.service.impl.CoinServiceImpl;

/**
 * 金币 CoinServlet
 */
@WebServlet("/CoinServlet")
public class CoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CoinService coinService = CoinServiceImpl.getInstance();
    public CoinServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}
	/**
	 * demo示例，仅供参考
	 * @param request
	 * @param response
	 */
	private void demo(HttpServletRequest request, HttpServletResponse response) {
		//从前端得到的金币修改类型
		Long type = 0L;
		//取得应该修改的金币数
		Long coin = CoinConfig.valueOfCoinType(type);
		//从前端获取原因
		String cause = "";
		//从后台获取userID
		UserBase userBase = (UserBase) request.getAttribute("userBase"); 
		if(userBase != null) {
			Long userId = userBase.getUserId();
		}
		//do things...
		/**
		 * 要做两件事：
		 * 1、更新金币表
		 * 2、插入金币记录表
		 */
	}
	/**
	 * 金币记录表更新,当金币数目改变时，只能添加纪录
	 * @param request
	 * @param response
	 */
	private void updateCoin(HttpServletRequest request, HttpServletResponse response) {
		//从前端得到的金币修改类型
		Long type = 0L;
		//从前端获取原因
		String cause = "";
		
		//从后台获取userID
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		//测试使用
//		UserBase userBase = new UserBase();
//		userBase.setUserId(1L);
		if(userBase != null) {
			Long userId = userBase.getUserId();
			if (userId!=null) {
				cause = request.getParameter("mCause");
				String mType = request.getParameter("mType");
				Pattern pattern = Pattern.compile("^-?[0-9]+");//修改类型格式校验
				if (pattern.matcher(mType).matches()&&StringUtils.isNotNullString(cause,mType)) {
					type = Long.parseLong(mType);
					//取得应该修改的金币数
					Long coin = CoinConfig.valueOfCoinType(type);
					
					CoinRecord coinRecord = new CoinRecord();
					coinRecord.setCoinCause(cause);
					coinRecord.setCoinGetNum(coin);
//					System.out.println("cause:"+cause+" userId"+userId+"coin:"+coin);
					
					List<CoinRecord> coinRecordList = null;
					coinRecordList = coinService.findCoinRecord(userId, coinRecord);
					CoinRecord tmpRecord = new CoinRecord();
					if(coinRecordList!=null&&coinRecordList.size()>0){
						tmpRecord = coinRecordList.get(0);// 获取最近一次签到经验记录
						
						// 截取日期
						String lastSignDay = tmpRecord.getCoinGetTime().toLocaleString().substring(0, 8);
//						System.out.println("上次签到日期：" + lastSignDay);
						String today = new Date().toLocaleString().substring(0, 8);
//						System.out.println("现在时间：" + today);
						
						// 构造签到结果Json对象
						SignReturnJson signReturnJson = new SignReturnJson();
						if(today.compareTo(lastSignDay)>0){
							// 今天还没签到
							signReturnJson.setSignResult("还没签到");
							signReturnJson.setSingedDays(coinRecordList.size());
							JSONUtils.writeJSON(response, signReturnJson);
						}else {
							// 已经签过到
							signReturnJson.setSignResult("今天已经签过到了");
							signReturnJson.setSingedDays(coinRecordList.size());
							JSONUtils.writeJSON(response, signReturnJson);
							return ;
						}
					}
					
						
					//更新金币记录
					if(coinService.addCoinRecord(userId, coinRecord)!=0){
						
						//查询金币数
						Long coinNum = coinService.findCoinNum(userId);
//						System.out.println("金币总数："+coinNum);
						if(coinNum!=null){
							Coin bCoin = new Coin();
							//查询到金币总数coinNum,再+-coin,更新金币总数
							bCoin.setCoinNum(coinNum+coin);
							coinService.setCoinNum(userId, bCoin);
							JSONUtils.writeJSON(response, new Msg(1, "添加成功！"));
						}else{
							JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
						}
					}else{
						JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
					}
				}else{
					JSONUtils.writeJSON(response, new Msg(0, "修改类型的格式错误！"));
				}	
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
		}
	}
	
	/**
	 * 根据用户id查询金币记录，分页显示
	 * @param request
	 * @param response
	 */
	private void findCoin(HttpServletRequest request, HttpServletResponse response) {
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		
		//无需传递参数
		UserBase userbase; // 用户基本
		//获取并处理参数
		userbase = (UserBase)request.getSession().getAttribute("userBase");
		//测试
//		userbase = new UserBase();
//		userbase.setUserId(1L);
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			
		} catch (Exception e) {
			pageSize = 10;//设置默认值
			pageNum = 1;
		}
		if(userbase!=null){
			CoinRecordJson coinRecordJson = new CoinRecordJson();//封装最大页，json数据
//			System.out.println("userId:"+userbase.getUserId());
//			System.out.println(coinService.findFormList(pageSize, pageNum, userbase.getUserId()));
			if(coinService.findFormList(pageSize, pageNum, userbase.getUserId())!=null){
				//获取查询结果
				coinRecordJson.setCoinRecordFormList(
						coinService.findFormList(pageSize, pageNum,  userbase.getUserId()));
				//获取最大页
				coinRecordJson.setMaxPage(
						coinService.getListPageCount(pageSize, userbase.getUserId()));
				JSONUtils.writeJSON(response, coinRecordJson);
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "查询金币记录失败！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "查询金币记录失败！"));
		}
	}
	/**
	 * 减少金币数
	 * @param request
	 * @param response
	 */
	private void reduceCoin(HttpServletRequest request, HttpServletResponse response) {
		//从前端得到的金币修改类型
		Long type = 0L;
		//从前端获取原因
		String cause = "";
		
		//从后台获取userID
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		//测试使用
//		UserBase userBase = new UserBase();
//		userBase.setUserId(1L);
		if(userBase != null) {
			Long userId = userBase.getUserId();
			if (userId!=null) {
				cause = request.getParameter("mCause");
				String mType = request.getParameter("mType");
				Pattern pattern = Pattern.compile("^-?[0-9]+");//修改类型格式校验
				if (pattern.matcher(mType).matches()&&StringUtils.isNotNullString(cause,mType)) {
					type = Long.parseLong(mType);
					//取得应该修改的金币数
					Long coin = CoinConfig.valueOfCoinType(type);
					CoinRecord coinRecord = new CoinRecord();
					coinRecord.setCoinCause(cause);
					coinRecord.setCoinGetNum(coin);
//					System.out.println("cause:"+cause+" userId"+userId+"coin:"+coin);
					//查询金币数
					Long coinNum = coinService.findCoinNum(userId);
//					System.out.println("已有的金币总数："+coinNum);
					if(coinNum>=coin){
						//更新金币记录
						if(coinService.addCoinRecord(userId, coinRecord)!=0){
							if(coinNum!=null){
								Coin bCoin = new Coin();
								//查询到金币总数coinNum,再+-coin,更新金币总数
								bCoin.setCoinNum(coinNum-coin);
								coinService.setCoinNum(userId, bCoin);
								JSONUtils.writeJSON(response, new Msg(1, "金币更新成功！"));
							}
						}else{
							JSONUtils.writeJSON(response, new Msg(0, "金币更新失败！"));
						}
				}else{
					JSONUtils.writeJSON(response, new Msg(0, "您的金币数不够！"));
				}		
				}else{
					JSONUtils.writeJSON(response, new Msg(0, "修改类型的格式错误！"));
				}	
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "更新失败！"));
		}
	}
}
