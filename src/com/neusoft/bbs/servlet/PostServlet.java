package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.ClientAccessIpUtil;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.dao.impl.ModeratorDaoImpl;
import com.neusoft.bbs.domain.Accessory;
import com.neusoft.bbs.domain.Collection;
import com.neusoft.bbs.domain.Comment;
import com.neusoft.bbs.domain.Moderator;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.form.ModeratorForm;
import com.neusoft.bbs.domain.form.PostForm;
import com.neusoft.bbs.domain.json.CollectionJson;
import com.neusoft.bbs.domain.json.CommentJson;
import com.neusoft.bbs.domain.json.PostFormJson;
import com.neusoft.bbs.domain.json.PostJson;
import com.neusoft.bbs.service.AccessoryService;
import com.neusoft.bbs.service.CollectionService;
import com.neusoft.bbs.service.CommentService;
import com.neusoft.bbs.service.PostService;
import com.neusoft.bbs.service.impl.AccessoryServiceImpl;
import com.neusoft.bbs.service.impl.CollectionServiceImpl;
import com.neusoft.bbs.service.impl.CommentServiceImpl;
import com.neusoft.bbs.service.impl.ModeratorServiceImpl;
import com.neusoft.bbs.service.impl.PostServiceImpl;
import com.neusoft.bbs.service.impl.UserServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			// 根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		} else {
			//
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			// 根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		} else {
			//
		}
	}

	/**
	 * 获取置顶贴 
	 * 
	 * @param request
	 * @param response
	 */
	private void findOverheadPost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId; // 板块ID（前端参数）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		
		//无需传递参数
		UserBase userBase; // 用户基本
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		
		// 获取并处理参数
		bId = request.getParameter("bId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");
		
		// 所需封装参数封装
		post = new Post();
		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}

			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

			post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
			if(userBase!=null) {
				if (userBase.getUserId() != null) {
					// 判断是否是版主
					Moderator moderator = new Moderator();
					moderator.setAreaId(Short.parseShort(bId));
					moderator.setModeratorType(Short.parseShort("0"));//版块
					moderator.setUserId(Short.parseShort(String.valueOf(userBase.getUserId())));// 需要底层支持
					List<ModeratorForm> moderatorFormList = ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator);
					if(moderatorFormList!=null) {
						for (ModeratorForm moderatorForm : moderatorFormList) {
							if (Short.parseShort(String.valueOf(userBase.getUserId())) == moderatorForm.getUserId()) {
								post.setIsHidden(null);// 所有帖子
							}
						}
					}
					
					//本人可见自己隐藏和别人公开的帖子
					if(post.getIsHidden()!=null) {
						//需要底层支持（select中where子句加入OR判断）
						post.setUserId(userBase.getUserId());
						post.setIsSelf("1");//1是本人
					}
				}else {
					post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
				}
			}else {
				post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsOverhead(Short.parseShort("1"));// 置顶
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		postJson = new PostJson();
		List<PostForm> postFormList = postService.findFormList(pageSize, pageNum, post);
		// 获取分页结果
		postJson.setPostFormList(postFormList);

		// 获取最大页数
		postJson.setMaxPage(postService.getListPageCount(pageSize, post));
		// 传回json
		JSONUtils.writeJSON(response, postJson);
	}

	/**
	 * 获取普通贴
	 * 
	 * @param request
	 * @param response
	 */
	private void findOrdinaryPost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId; // 板块ID（前端参数）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		
		//无需传递参数
		UserBase userBase; // 用户基本
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		
		// 获取并处理参数
		bId = request.getParameter("bId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");
		
		// 所需封装参数封装
		post = new Post();
		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}

			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

			if(userBase!=null) {
				if (userBase.getUserId() != null) {
					// 判断是否是版主
					Moderator moderator = new Moderator();
					moderator.setAreaId(Short.parseShort(bId));
					moderator.setModeratorType(Short.parseShort("0"));//版块
					moderator.setUserId(Short.parseShort(String.valueOf(userBase.getUserId())));// 需要底层支持
					List<ModeratorForm> moderatorFormList = ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator);
					if(moderatorFormList!=null) {
						for (ModeratorForm moderatorForm : moderatorFormList) {
							if (Short.parseShort(String.valueOf(userBase.getUserId())) == moderatorForm.getUserId()) {
								post.setIsHidden(null);// 所有帖子
							}
						}
					}
					
					//本人可见自己隐藏和别人公开的帖子
					if(post.getIsHidden()!=null) {
						//需要底层支持（select中where子句加入OR判断）
						post.setUserId(userBase.getUserId());
						post.setIsSelf("1");//1是本人
					}
				}else {
					post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
				}
			}else {
				post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsOverhead(Short.parseShort("0"));// 非置顶
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		postJson = new PostJson();
		List<PostForm> postFormList = postService.findFormList(pageSize, pageNum, post);
		// 获取分页结果
		postJson.setPostFormList(postFormList);

		// 获取最大页数
		postJson.setMaxPage(postService.getListPageCount(pageSize, post));
		// 传回json
		JSONUtils.writeJSON(response, postJson);
	}

	/**
	 * 获取精华贴
	 * 
	 * @param request
	 * @param response
	 */
	private void findElitePost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId;  // 板块ID（前端参数）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		
		//无需传递参数
		Post post; // 所需封装参数
		UserBase userBase; // 用户基本
		PostJson postJson; // json结构
		// 获取并处理参数
		bId = request.getParameter("bId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");
		// 所需封装参数封装
		post = new Post();

		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}

			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

			if(userBase!=null) {
				if (userBase.getUserId() != null) {
					// 判断是否是版主
					Moderator moderator = new Moderator();
					moderator.setAreaId(Short.parseShort(bId));
					moderator.setModeratorType(Short.parseShort("0"));//版块
					moderator.setUserId(Short.parseShort(String.valueOf(userBase.getUserId())));// 需要底层支持
					List<ModeratorForm> moderatorFormList = ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator);
					if(moderatorFormList!=null) {
						for (ModeratorForm moderatorForm : moderatorFormList) {
							if (Short.parseShort(String.valueOf(userBase.getUserId())) == moderatorForm.getUserId()) {
								post.setIsHidden(null);// 所有帖子
							}
						}
					}
					
					//本人可见自己隐藏和别人公开的帖子
					if(post.getIsHidden()!=null) {
						//需要底层支持（select中where子句加入OR判断）
						post.setUserId(userBase.getUserId());
						post.setIsSelf("1");//1是本人
					}
				}else {
					post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
				}
			}else {
				post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		
		post.setIsElite(Short.parseShort("1"));// 精华帖
//		System.out.println(post);
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		postJson = new PostJson();
		List<PostForm> postFormList = postService.findFormList(pageSize, pageNum, post);
		// 获取分页结果
		postJson.setPostFormList(postFormList);

		// 获取最大页数
		postJson.setMaxPage(postService.getListPageCount(pageSize, post));
		// 传回json
		JSONUtils.writeJSON(response, postJson);
	}

	/**
	 * 查看贴子详情（根据postId）（版主和发帖人可见隐藏需传入uid）
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void findPostbyPostId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 参数声明
		String tId; // 帖子ID（前端参数）

		//无需传递参数
		UserBase userBase; // 用户基本
		Post post;         // 所需封装参数
		PostForm postForm = null;// PostForm结构
		Accessory accessory = null;//附件
		PostFormJson postFormJson = null;//帖子详情
		// 获取并处理参数
		tId = request.getParameter("tId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");

		// 所需封装参数封装
		post = new Post();
		Post postcopy;
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		if(tId!=null&&!tId.equals("")) {//参数限定
			post = postService.findByPostId(Long.parseLong(tId));
//			System.out.println(post);
			if(post!=null) {
				postcopy = new Post();
				postcopy.setPostId(post.getPostId());;
			}else {
				JSONUtils.writeJSON(response, new PostFormJson());
				return;
			}
		}else {
			JSONUtils.writeJSON(response, new PostFormJson());
			return;
		}
		try {
			if(userBase!=null) {//登陆用户
				if (post!=null) {
					if(userBase.getUserId().longValue()==post.getUserId().longValue()) {
						// 本人可见被隐藏的帖子
						postcopy.setIsHidden(null);
					}else {
						// 判断是否是版主
						Moderator moderator = new Moderator();
						moderator.setAreaId(Short.parseShort(String.valueOf(post.getSectionId())));
						moderator.setModeratorType(Short.parseShort("0"));//版块
						moderator.setUserId(Short.parseShort(String.valueOf(userBase.getUserId())));// 需要底层支持
						List<ModeratorForm> moderatorFormList = ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator);
						if(moderatorFormList!=null) {
							for (ModeratorForm moderatorForm : moderatorFormList) {
								if (Short.parseShort(String.valueOf(userBase.getUserId())) == moderatorForm.getUserId()) {
									postcopy.setIsHidden(null);// 所有帖子
								}
							}
						}else {
							postcopy.setIsHidden(Short.parseShort("1"));
						}
					}
				}
			}else {
				postcopy.setIsHidden(Short.parseShort("1"));//未登录用户
			}
		} catch (Exception e) {
//			e.printStackTrace();
			JSONUtils.writeJSON(response, new PostFormJson());
			return;
		}
		
		// 获取帖子详情
//		System.out.println(postcopy);
		List<PostForm> postFormList = postService.findFormList(1, 1, postcopy);
		if(postFormList!=null) {
			postForm = postFormList.get(0);
			// 帖子记录数更新
			if (post.getHitNum() != null) {
				post.setHitNum(post.getHitNum() + 1L);
			} else {
				post.setHitNum(0L);
			}
			postService.setPost(post);

		}else {
			postForm = null;
		}
		if(postForm!=null) {
			AccessoryService accessoryService = AccessoryServiceImpl.getInstance();
			List<Accessory> accessoryList = accessoryService.findAccessory(postForm.getPostId());
			if(accessoryList!=null) {
				accessory = accessoryList.get(0);
			}else {
				accessory = null;
			}
			postFormJson = new PostFormJson();
			postFormJson.setPostForm(postForm);
			postFormJson.setAccessory(accessory);
		}
		if(accessory!=null) {//请求下载文件列表（存放到session中fileNameMap）
			//提交fileNameMap中url到DownLoadServlet进行下载（待测试）
//			request.getRequestDispatcher("/ListFileServlet").forward(request, response);
		}
		// 传回json
		JSONUtils.writeJSON(response, postFormJson);
	}

	/**
	 * 跟贴显示（根据postId）
	 * 
	 * @param request
	 * @param response
	 */
	private void findCommentbyPostId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String tId;   // 帖子ID（前端参数）
		int pageSize; // 页面大小
		int pageNum;  // 所需页数
		
		//无需传递参数
		UserBase userBase; // 用户基本
		Comment comment; // 所需封装参数
		CommentJson commentJson;// 跟帖Json数据
		
		// 获取并处理参数
		tId = request.getParameter("tId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");

		// 所需封装参数封装
		comment = new Comment();

		try {
			if (tId != null) {//指定帖子Id
				comment.setPostId(Long.parseLong(tId));
				comment.setIsHidden(Short.parseShort("1"));//仅可见未隐藏跟帖
			}else {
				JSONUtils.writeJSON(response, new CommentJson());
			}
			Post post = new Post();
			post.setPostId(comment.getPostId());//查找对应帖子
			if (userBase != null) {
				List<PostForm> postFormList = PostServiceImpl.getInstance().findFormList(1, 1, post);

				if(postFormList!=null) {//查询帖子
					if(userBase.getUserId().longValue()==postFormList.get(0).getUserId().longValue()){
						//发帖人
						comment.setIsHidden(null);// 发帖人，可见被隐藏的跟帖
					}else{//其他登陆用户
						//本人（可查看本人隐藏和别人公开的跟帖）
						//需要底层支持（select中where子句加入OR判断）
						comment.setCommentUserId(userBase.getUserId());
					}
				}else {
					JSONUtils.writeJSON(response, new CommentJson());//帖子不存在
				}
			}

			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		// 获取服务
		CommentService commentService = CommentServiceImpl.getInstance();
		commentJson = new CommentJson();
		// 获取分页结果
		commentJson.setCommentFormList(commentService.findFormList(pageSize, pageNum, comment));
		// 获取最大页数
		commentJson.setMaxPage(commentService.getListPageCount(pageSize, comment));
		// 传回json
		JSONUtils.writeJSON(response, commentJson);
	}

	/**
	 * 查看用户最近发布的贴子(top10)根据userId
	 * 
	 * @param request
	 * @param response
	 */
	private void findRecentPost10byUserId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String uId;  // 用户ID（本人无需传参）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		
		//无需传递参数
		UserBase userBase = null;
		Post post;   // 所需封装参数
		PostJson postJson;// json结构
		// 获取并处理参数
		uId = request.getParameter("uId");
		userBase = (UserBase)request.getSession().getAttribute("userBase");
		// 所需封装参数封装
		post = new Post();
		post.setIsHidden(Short.parseShort("1"));//默认只查看未隐藏帖子
		try {
			//判断用户身份
			if(userBase == null && uId == null) {//未登录且未传参
				JSONUtils.writeJSON(response, new Msg(0, "无效参数，查看最近发帖失败"));
				return;
			}else if(uId == null||uId.equals(String.valueOf(userBase.getUserId()))){
				//查看本人
				post.setIsHidden(null);// 本人可见被隐藏的帖子
			}else if(uId != null
					&& (!uId.equals(String.valueOf(userBase.getUserId())))) {
				//查看他人
				post.setUserId(Long.parseLong(uId));
			}
			
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		postJson = new PostJson();
		// 获取分页结果
		postJson.setPostFormList(postService.findFormList(pageSize, pageNum, post));
		// 获取最大页数
		postJson.setMaxPage(postService.getListPageCount(pageSize, post));
		// 传回json
		JSONUtils.writeJSON(response, postJson);
	}

	/**
	 * 查看用户收藏的贴子（隐藏状态需要展示，存在bug）
	 * 
	 * @param request
	 * @param response
	 */
	private void findCollectionPostbyUserId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String uId;  // 用户ID（本人无需传参）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Collection collection; // 所需封装参数
		CollectionJson collectionJson;
		
		//无需传递参数
		UserBase userBase;     // 用户Id
		
		// 获取并处理参数
		uId = request.getParameter("uId");
		userBase = (UserBase) request.getSession().getAttribute("userBase");
		// 所需封装参数封装
		collection = new Collection();
		try {
			//判断用户身份
			if(userBase == null && uId == null) {//未登录且未传参
				JSONUtils.writeJSON(response, new Msg(0, "无效参数，查看收藏失败"));
				return;
			}else if(uId == null||uId.equals(String.valueOf(userBase.getUserId()))){
				//查看本人
				collection.setUserId(userBase.getUserId());
			}else if(uId != null
					&& (!uId.equals(String.valueOf(userBase.getUserId())))) {
				//查看他人
				collection.setUserId(Long.parseLong(uId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		// 获取服务
		CollectionService collectionService = CollectionServiceImpl.getInstance();
		collectionJson = new CollectionJson();
		// 获取分页结果
		collectionJson.setCollectionFormList((collectionService.findFormList(pageSize, pageNum, collection)));
		// 获取最大页数
		collectionJson.setMaxPage(collectionService.getListPageCount(pageSize, collection));
		// 传回json
		JSONUtils.writeJSON(response, collectionJson);
	}

	/**
	 * 发布贴子
	 * 
	 * @param request
	 * @param response
	 */
	private void addPost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String postTitle;  // 帖子标题（前端参数）
		String postType;   // 帖子类型
		String postContent;// 帖子内容	
		String sectionId;  // 板块Id
		
		//无需传递参数
		UserBase userBase;     // 用户Id
		String postFile;   // 帖子附件（二进制文件）
		Post post;         // 封装所需参数

		// 获取参数
		postTitle = (String) request.getAttribute("postTitle");
		postType = (String) request.getAttribute("postType");
		postContent = (String) request.getAttribute("postContent");
		postFile = (String) request.getAttribute("postFile");
		sectionId = (String) request.getAttribute("sectionId");
		userBase = (UserBase) request.getSession().getAttribute("userBase");

		// 封装并处理参数
		post = new Post();
		try {
			//判断用户是否登录
			if(userBase == null) {
				JSONUtils.writeJSON(response, new Msg(0, "未登录用户，发布帖子失败"));
				return;
			}
			post.setPostType(Short.parseShort(postType));
			post.setSectionId(Long.parseLong(sectionId));
			post.setUserId(userBase.getUserId());
			post.setEditUserId(userBase.getUserId());// 默认编辑帖子人是发布者
		} catch (Exception e) {
			e.printStackTrace();
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，发布失败"));
			return;
		}
		Date postDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		dateFormat.format(postDate);

		post.setPostTitle(postTitle);
		post.setThemeContent(postContent);
		post.setIssueTime(postDate); // 发帖时间
		post.setIssueIp(ClientAccessIpUtil.getIpAddress(request));// 发帖IP
		post.setHitNum(0L); // 浏览次数
		post.setAnswerSum(0L); // 跟帖次数
		post.setIsHighlight(Short.parseShort("0"));// 高亮显示（默认不高亮）
		post.setTitleColor("#000000"); // 标题颜色（默认黑色）
		post.setIsOverhead(Short.parseShort("0")); // 帖子置顶状态（默认不置顶）
		post.setIsClose(Short.parseShort("1")); // 帖子状态（默认打开）
		post.setSwitchCause("发布帖子");
		post.setSwitchUserId(0L); // 系统自动设置
		post.setIsElite(Short.parseShort("0")); // 帖子是否精华（默认非精华）
		post.setIsHidden(Short.parseShort("1")); // 帖子是否隐藏（默认显示）
		post.setIsAccessory(Short.parseShort("0"));// 帖子附件（默认没有）
		post.setEditTime(postDate); // 编辑时间（默认发布时间）

		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		int result = 0;
		// 差异化参数
		if (post.getPostType().shortValue() == 1) {// 主题帖

		} else if (post.getPostType().shortValue() == 2) {// 资源帖
			if (postFile != null) {
				// TO-DO 多文件上传
				post.setIsAccessory(Short.parseShort("1"));// 存在资源的主题帖
			}
		} else if (post.getPostType().shortValue() == 3) {// 公告
			post.setIsOverhead(Short.parseShort("1"));
			post.setOverheadCause("公告贴");
			post.setOverheadUserId(0L);// 系统自动设置
		}
		
		result = postService.addPost(post);
		if (result == 0) {
			JSONUtils.writeJSON(response, new Msg(0, "帖子发布失败"));
			return;
		}
		
		if(post.getIsAccessory()!=null && post.getIsAccessory().longValue() == 1) {
			String message = (String) request.getAttribute("message");
			if (message != null && message.equals("文件上传成功！")) {
				Accessory accessory = new Accessory();
				accessory.setAuthor(UserServiceImpl.getInstance().findUserId(post.getUserId()).getUsername());
				accessory.setAccessoryDescri((String) request.getAttribute("accessoryDescri"));
				accessory.setCostCoin(Long.parseLong((String) request.getAttribute("costCoin")));
				accessory.setDownloadNum(0L); // 附件下载次数（默认0次）
				accessory.setFileName((String) request.getAttribute("fileName"));// 决定文件格式
				accessory.setFileSize(BigDecimal.valueOf(0L));// 获取二进制文件大小
				accessory.setPath((String) request.getAttribute("filePath")); // hash生成
				List<PostForm> postFormList = postService.findFormList(1, 1, post);
				if(postFormList!=null) {
					accessory.setPostId(postFormList.get(0).getPostId());
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "帖子未创建，资源帖发布成功"));
					return;
				}
				accessory.setUploadTime(postDate);

				// 获取附件服务
				AccessoryService accessoryService = AccessoryServiceImpl.getInstance();
				result = accessoryService.addAccessory(accessory);
				if (result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "资源帖发布成功"));
				} else {
					JSONUtils.writeJSON(response, new Msg(0, "帖子发布失败，附件上传失败"));
					postService.deletePost(post);
					return;
				}
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(1, "资源帖发布成功"));
		}
	}

	/**
	 * 更新贴子（版主、普通用户）
	 * 
	 * @param request
	 * @param response
	 */
	private void updatePost(HttpServletRequest request, HttpServletResponse response) {
		// （用户）参数声明
		String postId;       // 帖子Id（前端参数）
		String postTitle;    // 帖子标题（前端参数）
		String postType;     // 帖子类型
		String postContent;  // 帖子内容
		String accessoryStatus; // 帖子附件状态（未改动0，删除1，重新上传2）
		String sectionId;    // 板块Id

		// （版主）参数声明
		String isHighlight;  // 高亮状态
		String isOverhead;   // 置顶状态
		String overheadCause;// 置顶原因
		String isClose;      // 帖子关闭状态
		String switchCause;  // 帖子切换（关闭）原因
		String isHidden;     // 帖子可见（是否隐藏）状态
		String hiddenCause;  // 帖子可见状态改变（是否隐藏）原因
		String isElite;      // 帖子精华状态
		String recomValidity;// 帖子精华状态变化原因
		
		//无需传递参数
		UserBase userBase;  // 用户基本
		Post post;          // 封装所需参数

		// 获取用户参数
		postId = (String) request.getAttribute("postId");
		postTitle = (String) request.getAttribute("postTitle");
		postType = (String) request.getAttribute("postType");
		postContent = (String) request.getAttribute("postContent");
		accessoryStatus = (String) request.getAttribute("accessoryStatus");
		sectionId = (String) request.getAttribute("sectionId");
		userBase = (UserBase) request.getSession().getAttribute("userBase");

		// 获取版主参数
		isHighlight = (String) request.getAttribute("isHighlight");
		isOverhead = (String) request.getAttribute("isOverhead");
		overheadCause = (String) request.getAttribute("overheadCause");
		isClose = (String) request.getAttribute("isClose");
		switchCause = (String) request.getAttribute("switchCause");
		isHidden = (String) request.getAttribute("isHidden");
		hiddenCause = (String) request.getAttribute("hiddenCause");
		isElite = (String) request.getAttribute("isElite");
		recomValidity = (String) request.getAttribute("recomValidity");

		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		// 编辑时间
		Date editDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		dateFormat.format(editDate);

		// 封装并处理参数
		try {
			//判断用户是否登录
			if(userBase == null) {
				JSONUtils.writeJSON(response, new Msg(0, "未登录用户，更新帖子失败"));
				return;
			}
			// 获取帖子信息
			post = postService.findByPostId(Long.parseLong(postId));
			if (post == null) {// 防止帖子被删
				JSONUtils.writeJSON(response, new Msg(0, "帖子不存在"));
				return;
			}else if(post != null&&post.getUserId().longValue()==userBase.getUserId().longValue()) {
				post.setPostType(Short.parseShort(postType));
				post.setSectionId(Long.parseLong(sectionId));
				post.setEditUserId(userBase.getUserId()); // 编辑帖子用户
				if (isClose != null) {
					post.setIsClose(Short.parseShort(isClose)); // 帖子状态（默认打开）
					post.setSwitchCause(switchCause); // 帖子状态切换原因
					post.setSwitchUserId(userBase.getUserId());// 帖子状态切换用户
				}
			}else {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setAreaId(Short.parseShort(String.valueOf(post.getSectionId())));
				moderator.setModeratorType(Short.parseShort("0"));//版块
				moderator.setUserId(Short.parseShort(String.valueOf(userBase.getUserId())));// 需要底层支持
				List<ModeratorForm> ModeratorFormList = ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator);
				if(ModeratorFormList!=null) {
					for (ModeratorForm moderatorForm : ModeratorFormList) {
						if (Short.parseShort(String.valueOf(userBase.getUserId())) == moderatorForm.getUserId()) {
							if (isHighlight != null) {
								post.setIsHighlight(Short.parseShort(isHighlight));// 高亮显示（默认不高亮）
								post.setHighlightUserId(userBase.getUserId());
							}

							if (isOverhead != null) {
								post.setIsOverhead(Short.parseShort(isOverhead)); // 帖子置顶状态（默认不置顶）
								post.setOverheadCause(overheadCause); // 帖子置顶原因
								post.setOverheadUserId(userBase.getUserId());// 帖子置顶用户
							}

							if (isClose != null) {
								post.setIsClose(Short.parseShort(isClose)); // 帖子状态（默认打开）
								post.setSwitchCause(switchCause); // 帖子状态切换原因
								post.setSwitchUserId(userBase.getUserId());// 帖子状态切换用户
							}
							
							if (isHidden != null) {
								post.setIsHidden(Short.parseShort(isHidden)); // 帖子状态是否被隐藏
								post.setHiddenCause(hiddenCause);
								post.setHiddenUserId(userBase.getUserId());
							}

							if (isElite != null) {
								post.setIsElite(Short.parseShort(isElite)); // 帖子是否精华（默认非精华）
								if (recomValidity != null) {
									Date date = dateFormat.parse(recomValidity);
									post.setRecomValidity(date); // 帖子精华状态有效时间
								} else {
									// 默认精华状态有效三天
									dateFormat.format(new Date(editDate.getTime() + 3 * 24 * 60 * 60 * 1000));
									post.setRecomValidity(dateFormat.parse(
											dateFormat.format(new Date(editDate.getTime() + 3 * 24 * 60 * 60 * 1000))));
								}
								post.setRecomUserId(userBase.getUserId());// 帖子精华状态切换用户
							}
						}
					}
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "非版主和本人，更新帖子失败"));
					return;
				}
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，修改帖子失败"));
			return;
		}
		
		post.setPostTitle(postTitle);
		post.setThemeContent(postContent);
		post.setEditTime(editDate); // 编辑帖子时间

		// 附件上传处理
		AccessoryService accessoryService = AccessoryServiceImpl.getInstance();
		int result = 0;
		// 差异化参数
		if (post.getPostType() == 1) {// 主题帖
			
		} else if (post.getPostType() == 2) {// 资源帖
			// TO-DO 多文件上传（资源的更改删除）
			if (accessoryStatus.equals("0")) {

			} else if (accessoryStatus.equals("1")) {//删除附件
				post.setIsAccessory(Short.parseShort("0"));// 不存在资源的帖子
				List<Accessory> accessoryList = accessoryService.findAccessory(post.getPostId());
				if(accessoryList!=null) {
					result = accessoryService.deleteAccessory(accessoryList.get(0));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "资源帖修改失败"));
					return;
				}
				
				if (result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "资源帖修改成功，资源已删除"));
				} else {
					JSONUtils.writeJSON(response, new Msg(0, "资源帖修改失败"));
					return;
				}
			} else if (accessoryStatus.equals("2")) {//重新上传
				post.setIsAccessory(Short.parseShort("1"));// 不存在资源的帖子
				String message = (String) request.getAttribute("message");
				if (message != null && message.equals("文件上传成功！")) {
					Accessory accessory = new Accessory();
					accessory.setAuthor(UserServiceImpl.getInstance().findUserId(post.getUserId()).getUsername());
					accessory.setAccessoryDescri((String) request.getAttribute("accessoryDescri"));
					accessory.setCostCoin(Long.parseLong((String) request.getAttribute("costCoin")));
					accessory.setDownloadNum(0L); // 附件下载次数（默认0次）
					accessory.setFileName((String) request.getAttribute("fileName"));// 决定文件格式
					accessory.setFileSize(BigDecimal.valueOf(0L));// 获取二进制文件大小
					accessory.setPath((String) request.getAttribute("filePath")); // hash生成
					List<PostForm> postFormList = postService.findFormList(1, 1, post);
					if(postFormList!=null) {
						accessory.setPostId(postFormList.get(0).getPostId());
					}else {
						JSONUtils.writeJSON(response, new Msg(1, "帖子不存在，更新失败"));
						return;
					}
					accessory.setUploadTime(editDate);

					// 增加附件记录
					result = accessoryService.addAccessory(accessory);
					if (result == 1) {
						JSONUtils.writeJSON(response, new Msg(1, "资源帖更新成功"));
					} else {
						post.setPostId(accessory.getPostId());
						postService.deletePost(post);// 帖子发布失败删除帖子
						JSONUtils.writeJSON(response, new Msg(0, "帖子更新失败，附件上传失败"));
						return;
					}
				}
			} else if (post.getPostType() == 3) {// 公告
				
			}
			// 更新帖子
			result = postService.setPost(post);
			if (result == 0) {
				JSONUtils.writeJSON(response, new Msg(0, "帖子更新失败"));
			}
		}
	}

	/**
	 * 删除帖子（普通用户删除）
	 * @param request
	 * @param response
	 */
	private void deletePost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String tId; // 帖子ID（前端参数）
		
		String uId; // session中获取
		Post post;  // 所需封装参数
		// 获取并处理参数
		tId = request.getParameter("tId");
		uId = request.getParameter("uId");

		// 所需封装参数封装
		post = new Post();
		try {
			uId = String.valueOf(((UserBase)request.getSession().getAttribute("userBase")).getUserId());
			post = PostServiceImpl.getInstance().findByPostId(Long.parseLong(tId));
			if (uId == null) {// 判断是否登录
				JSONUtils.writeJSON(response, new Msg(0, "未登录，删跟帖失败"));
				return;
			}else if(post !=null && uId.equals(String.valueOf(post.getUserId()))){
				//判断帖子是否存在和是否是发帖人
				post.setPostId(Long.parseLong(tId));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "帖子删除失败"));
				return;
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，帖子删除失败"));
			return;
		}
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		int result = postService.deletePost(post);
		List<Comment> commentList = CommentServiceImpl.getInstance().findByPostId(post.getPostId());
		for(Comment comment:commentList) {//删除跟帖
			result = CommentServiceImpl.getInstance().deleteComment(comment);
			if(result == 0) {
				JSONUtils.writeJSON(response, new Msg(0, "跟帖删除错误，删帖终止"));
				return;
			}
		}
		// 传回json
		if(result == 0) {
			JSONUtils.writeJSON(response, new Msg(1, "帖子删除成功"));
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "帖子删除失败"));
		}
	}

	/**
	 * 增加跟帖
	 * @param request
	 * @param response
	 */
	private void addComment(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String tId; // 帖子ID（前端参数）
		String commentContent; // 评论内容
		Comment comment;       // 所需封装参数
		
		// 获取并处理参数
		tId = request.getParameter("tId");
		commentContent = request.getParameter("commentContent");
		
		// 所需封装参数封装
		comment = new Comment();
		Date commentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		dateFormat.format(commentDate);
		
		
		Post post = PostServiceImpl.getInstance().findByPostId(Long.parseLong(tId));
		try {
			if (request.getSession().getAttribute("userBase") == null) {//判断是否登录
				JSONUtils.writeJSON(response, new Msg(0, "未登录，跟帖失败"));
				return;
			}
			if(commentContent==null||commentContent.equals("")) {//待优化，限制内容长度
				JSONUtils.writeJSON(response, new Msg(0, "跟帖内容为空，跟帖失败"));
				return;
			}
			//帖子存在
			if (tId != null && post!=null) {
				comment.setPostId(Long.parseLong(tId));
				comment.setCommentContent(commentContent);
				comment.setCommentIp(ClientAccessIpUtil.getIpAddress(request));
				comment.setCommentTime(commentDate);
				comment.setIsHidden(Short.valueOf("1"));//跟帖状态（默认打开）
				comment.setCommentUserId(((UserBase)request.getSession().getAttribute("userBase")).getUserId());
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，跟帖失败"));
			return;
		}
		// 获取服务
		CommentService commentService = CommentServiceImpl.getInstance();
		int result = commentService.addComment(comment);
		// 传回json
		if(result == 1) {
			post.setAnswerSum(post.getAnswerSum()+1L);
			result = PostServiceImpl.getInstance().setPost(post);//增加回复数
			if(result == 1) {
				JSONUtils.writeJSON(response, new Msg(1, "跟帖成功"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "跟帖失败"));
				return;
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "跟帖失败"));
		}
	}

	/**
	 * 删除跟帖（跟帖人和发帖人）
	 * @param request
	 * @param response
	 */
	private void deleteComment(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String hId; // 跟帖ID（前端参数）
		
		String uId; // session中取得
		Comment comment; // 所需封装参数

		// 获取并处理参数
		hId = request.getParameter("hId");

		// 所需封装参数封装
		comment = null;
		// 获取服务
		CommentService commentService = CommentServiceImpl.getInstance();
		PostService postService = PostServiceImpl.getInstance();
		try {
			uId = String.valueOf(((UserBase)request.getSession().getAttribute("userBase")).getUserId());
			if (uId == null) {// 判断是否登录
				JSONUtils.writeJSON(response, new Msg(0, "未登录，删跟帖失败"));
				return;
			}else {
				comment = commentService.findByCommentId(Long.parseLong(hId));
				// 跟帖是否不存在
				if (hId == null || comment==null) {
					JSONUtils.writeJSON(response, new Msg(0, "跟帖不存在，删跟帖失败"));
					return;
				}else {//判断是否是本人或发帖人
					String tUserId = String.valueOf(postService.findByPostId(comment.getPostId()).getUserId());
					if(uId.equals(String.valueOf(comment.getCommentUserId()))
							||uId.equals(tUserId)) {
						comment.setCommentId(Long.parseLong(hId));
					}
				}
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，跟帖删除失败"));
			return;
		}

		int result = commentService.deleteComment(comment);
		// 传回json
		if (result == 1) {
			Post post = postService.findByPostId(comment.getPostId());
			post.setAnswerSum(post.getAnswerSum()-1L);
			result = postService.setPost(post);
			if(result==1) {
				JSONUtils.writeJSON(response, new Msg(1, "跟帖成功"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "跟帖失败"));
				return;
			}
		} else {
			JSONUtils.writeJSON(response, new Msg(0, "跟帖失败"));
		}
	}

	/**
	 * 更新跟帖
	 * @param request
	 * @param response
	 */
	private void updateComment(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String hId; // 跟帖ID（前端参数）
		String commentContent;// 评论内容
		String isHidden;      // 是否隐藏
		String hiddenCause;   // 是否隐藏的原因
		
		String uId; // session中取得
		Comment comment; // 所需封装参数

		// 获取并处理参数
		hId = request.getParameter("hId");
		commentContent = request.getParameter("commentContent");
		isHidden = request.getParameter("isHidden");
		hiddenCause = request.getParameter("hiddenCause");

		// 所需封装参数封装
		comment = new Comment();
		Date commentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		dateFormat.format(commentDate);
		
		// 获取服务
		CommentService commentService = CommentServiceImpl.getInstance();
		try {
			uId = String.valueOf(((UserBase)request.getSession().getAttribute("userBase")).getUserId());
			if (uId == null) {// 判断是否登录
				JSONUtils.writeJSON(response, new Msg(0, "未登录，删跟帖失败"));
				return;
			}else {
				comment = commentService.findByCommentId(Long.parseLong(hId));
				// 跟帖是否不存在
				if (hId == null || comment==null) {
					JSONUtils.writeJSON(response, new Msg(0, "跟帖不存在，删跟帖失败"));
					return;
				}else {//判断是否是本人或发帖人
					String tUserId = String.valueOf(PostServiceImpl.getInstance().findByPostId(comment.getPostId()).getUserId());
					if(uId.equals(String.valueOf(comment.getCommentUserId()))) {//本人
						comment.setCommentId(Long.parseLong(hId));
						comment.setCommentContent(commentContent);
						comment.setCommentIp(ClientAccessIpUtil.getIpAddress(request));
						comment.setCommentTime(commentDate);
						comment.setCommentUserId(Long.parseLong(uId));
						if(hiddenCause!=null) {
							comment.setHiddenUserId(Long.parseLong(uId));
							comment.setHiddenCause(hiddenCause);
							comment.setIsHidden(Short.parseShort(isHidden));
						}
					}else if(uId.equals(tUserId)){//发帖人
						comment.setCommentId(Long.parseLong(hId));
						if(hiddenCause!=null) {
							comment.setHiddenUserId(Long.parseLong(uId));
							comment.setHiddenCause(hiddenCause);
							comment.setIsHidden(Short.parseShort(isHidden));
						}
					}else {
						JSONUtils.writeJSON(response, new Msg(0, "权限无效，更新跟帖失败"));
						return;
					}
				}
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new Msg(0, "参数错误，更新跟帖失败"));
			return;
		}
		int result = commentService.setComment(comment);
		// 传回json
		if (result == 1) {
			JSONUtils.writeJSON(response, new Msg(1, "跟帖更新成功"));
		} else {
			JSONUtils.writeJSON(response, new Msg(0, "跟帖更新失败"));
		}
	}
}
