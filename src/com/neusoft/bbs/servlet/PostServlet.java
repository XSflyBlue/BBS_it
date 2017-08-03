package com.neusoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.json.PostJson;
import com.neusoft.bbs.service.PostService;
import com.neusoft.bbs.service.impl.PostServiceImpl;

/**
 * 贴子Servlet
 */
@WebServlet("/PostServlet")
@SuppressWarnings("unused")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	 * 获取版块置顶贴
	 * @param request
	 * @param response
	 */
	private void findOverheadPost(HttpServletRequest request, HttpServletResponse response) {
		//参数声明
		String bId;  //板块ID（前端参数）
		int pageSize;//页面大小
		int pageNum; //所需页数
		Post post;   //所需封装参数
		PostJson postJson;//json结构
		//获取并处理参数
		bId = request.getParameter("bId");
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		//所需封装参数封装
		post = new Post();
		post.setSectionId(Long.parseLong(bId));
		//获取服务
		PostService postService = PostServiceImpl.getInstance();
		postJson = new PostJson();
		//获取分页结果
		postJson.setPostFormList(postService.findFormList(pageSize, pageNum, post));
		//获取最大页数
		postJson.setMaxPage(postService.getListPageCount(pageSize, post));
		//传回json
		JSONUtils.writeJSON(response, postJson);
	}
}
