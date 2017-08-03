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
import com.neusoft.bbs.domain.Comment;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.CommentForm;
import com.neusoft.bbs.domain.form.PostForm;
import com.neusoft.bbs.domain.json.CommentJson;
import com.neusoft.bbs.domain.json.PostJson;
import com.neusoft.bbs.service.CommentService;
import com.neusoft.bbs.service.PostService;
import com.neusoft.bbs.service.impl.CommentServiceImpl;
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
	 * 获取置顶贴
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
		//所需封装参数封装
		post = new Post();
		try {
			if(bId!=null) {
				post.setSectionId(Long.parseLong(bId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
		post.setIsOverhead(Short.parseShort("1"));//置顶
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
	
	/**
	 * 获取普通贴
	 * @param request
	 * @param response
	 */
	private void findOrdinaryPost(HttpServletRequest request, HttpServletResponse response) {
		//参数声明
		String bId;  //板块ID（前端参数）
		int pageSize;//页面大小
		int pageNum; //所需页数
		Post post;   //所需封装参数
		PostJson postJson;//json结构
		//获取并处理参数
		bId = request.getParameter("bId");
		//所需封装参数封装
		post = new Post();
		try {
			if(bId!=null) {
				post.setSectionId(Long.parseLong(bId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
		post.setIsOverhead(Short.parseShort("0"));//置顶
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
	
	/**
	 * 获取精华贴
	 * @param request
	 * @param response
	 */
	private void findElitePost(HttpServletRequest request, HttpServletResponse response) {
		//参数声明
		String bId;  //板块ID（前端参数）
		int pageSize;//页面大小
		int pageNum; //所需页数
		Post post;   //所需封装参数
		PostJson postJson;//json结构
		//获取并处理参数
		bId = request.getParameter("bId");
		//所需封装参数封装
		post = new Post();
		
		try {
			if(bId!=null) {
				post.setSectionId(Long.parseLong(bId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
		post.setIsElite(Short.parseShort("1"));//精华帖
		System.out.println(post);
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

	/**
	 * 查看贴子详情（根据postId）
	 * @param request
	 * @param response
	 */
	private void findPostbyPostId(HttpServletRequest request, HttpServletResponse response) {
		//参数声明
		String tId;       //帖子ID（前端参数）
		Post post;        //所需封装参数
		PostForm postForm = null;//PostForm结构
		//获取并处理参数
		tId = request.getParameter("tId");

		//所需封装参数封装
		post = new Post();
		try {
			post.setPostId(Long.parseLong(tId));
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new PostForm());
			return;
		}
//		post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
		//获取服务
		PostService postService = PostServiceImpl.getInstance();
		//获取帖子详情
		postForm = postService.findFormList(1, 1, post).get(0);
		//传回json
		JSONUtils.writeJSON(response, postForm);
	}

	/**
	 * 跟贴显示（根据postId）
	 * @param request
	 * @param response
	 */
	private void findCommentbyPostId(HttpServletRequest request, HttpServletResponse response) {
		//参数声明
		String tId;       //帖子ID（前端参数）
		Comment comment;        //所需封装参数
		int pageSize;     //页面大小
		int pageNum;      //所需页数
		CommentJson commentJson;//跟帖Json数据
		//获取并处理参数
		tId = request.getParameter("tId");

		//所需封装参数封装
		comment = new Comment();
		
		try {
			if(tId!=null) {
				comment.setPostId(Long.parseLong(tId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		
		//获取服务
		CommentService commentService = CommentServiceImpl.getInstance();
		commentJson = new CommentJson();
		//获取分页结果
		commentJson.setCommentFormList(commentService.findFormList(pageSize, pageNum, comment));
		//获取最大页数
		commentJson.setMaxPage(commentService.getListPageCount(pageSize, comment));
		//传回json
		JSONUtils.writeJSON(response, commentJson);
	}

	
}
