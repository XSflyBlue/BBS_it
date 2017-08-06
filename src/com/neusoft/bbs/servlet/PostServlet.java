package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * 获取置顶贴 （版主可见隐藏传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findOverheadPost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId; // 板块ID（前端参数）
		String uId; // 非必须参数（版主需要）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		// 获取并处理参数
		bId = request.getParameter("bId");
		uId = request.getParameter("uId");
		// 所需封装参数封装
		post = new Post();
		post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			if (uId != null) {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setUserId(Short.parseShort(uId));// 需要底层支持
				for (ModeratorForm moderatorForm : ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator)) {
					if (Short.parseShort(uId) == moderatorForm.getUserId()) {
						post.setIsHidden(null);// 所有帖子
					}
				}
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsOverhead(Short.parseShort("1"));// 置顶
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
	 * 获取普通贴（版主可见隐藏传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findOrdinaryPost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId; // 板块ID（前端参数）
		String uId; // 非必须参数（版主需要）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		// 获取并处理参数
		bId = request.getParameter("bId");
		uId = request.getParameter("uId");
		// 所需封装参数封装
		post = new Post();
		post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

			if (uId != null) {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setUserId(Short.parseShort(uId));// 需要底层支持
				for (ModeratorForm moderatorForm : ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator)) {
					if (Short.parseShort(uId) == moderatorForm.getUserId()) {
						post.setIsHidden(null);// 所有帖子
					}
				}
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsOverhead(Short.parseShort("0"));// 置顶
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
	 * 获取精华贴（版主可见隐藏传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findElitePost(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String bId; // 板块ID（前端参数）
		String uId; // 非必须参数（版主需要）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		// 获取并处理参数
		bId = request.getParameter("bId");
		uId = request.getParameter("uId");
		// 所需封装参数封装
		post = new Post();

		try {
			if (bId != null) {
				post.setSectionId(Long.parseLong(bId));
			}

			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

			if (uId != null) {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setUserId(Short.parseShort(uId));// 需要底层支持
				for (ModeratorForm moderatorForm : ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator)) {
					if (Short.parseShort(uId) == moderatorForm.getUserId()) {
						post.setIsHidden(null);// 所有帖子
					}
				}
			}
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		post.setIsHidden(Short.parseShort("1"));// 除去隐藏贴
		post.setIsElite(Short.parseShort("1"));// 精华帖
		System.out.println(post);
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
	 * 查看贴子详情（根据postId）（版主和发帖人可见隐藏需传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findPostbyPostId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String tId; // 帖子ID（前端参数）
		String uId; // 前端非必须（发帖者需要传）
		Post post; // 所需封装参数
		PostForm postForm = null;// PostForm结构
		// 获取并处理参数
		tId = request.getParameter("tId");
		uId = request.getParameter("uId");

		// 所需封装参数封装
		post = new Post();
		post.setIsHidden(Short.parseShort("1"));
		try {
			post.setPostId(Long.parseLong(tId));
			if (uId != null && uId
					.equals(String.valueOf(((UserBase) request.getSession().getAttribute("userBase")).getUserId()))) {
				post.setIsHidden(Short.parseShort(null));// 本人可见被隐藏的帖子
			}
			if (uId != null) {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setUserId(Short.parseShort(uId));// 需要底层支持
				for (ModeratorForm moderatorForm : ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator)) {
					if (Short.parseShort(uId) == moderatorForm.getUserId()) {
						post.setIsHidden(null);// 所有帖子
					}
				}
			}
		} catch (Exception e) {
			JSONUtils.writeJSON(response, new PostForm());
			return;
		}
		// post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
		// 获取服务
		PostService postService = PostServiceImpl.getInstance();
		// 获取帖子详情
		postForm = postService.findFormList(1, 1, post).get(0);
		// 传回json
		JSONUtils.writeJSON(response, postForm);
	}

	/**
	 * 跟贴显示（根据postId）（本用户和发帖人可见隐藏需传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findCommentbyPostId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String tId; // 帖子ID（前端参数）
		String uId; // 前端非必须（发帖者需要传）
		Comment comment; // 所需封装参数
		int pageSize; // 页面大小
		int pageNum; // 所需页数
		CommentJson commentJson;// 跟帖Json数据
		// 获取并处理参数
		tId = request.getParameter("tId");
		uId = request.getParameter("uId");

		// 所需封装参数封装
		comment = new Comment();

		try {
			if (tId != null) {
				comment.setPostId(Long.parseLong(tId));
			}
			Post post = new Post();
			post.setPostId(comment.getPostId());
			if (uId != null
					&& (!uId.equals(
							String.valueOf(((UserBase) request.getSession().getAttribute("userBase")).getUserId())))
					&& (!uId.equals(String.valueOf(PostServiceImpl.getInstance().findFormList(1, 1, post))))) {
				comment.setIsHidden(Short.parseShort("1"));// 不是本人且不是发帖人，仅可见不被隐藏的回帖
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
	 * 查看用户最近发布的贴子(top10)根据userId（本用户和发帖人可见隐藏需传入uid）
	 * 
	 * @param request
	 * @param response
	 */
	private void findRecentPost10byUserId(HttpServletRequest request, HttpServletResponse response) {
		// 参数声明
		String uId; // 用户ID（前端参数）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Post post; // 所需封装参数
		PostJson postJson;// json结构
		// 获取并处理参数
		uId = request.getParameter("uId");
		// 所需封装参数封装
		post = new Post();
		post.setIsHidden(Short.parseShort("1"));
		try {
			if (uId != null) {
				post.setUserId(Long.parseLong(uId));
			}
			if (uId != null && uId
					.equals(String.valueOf(((UserBase) request.getSession().getAttribute("userBase")).getUserId()))) {
				post.setIsHidden(Short.parseShort(null));// 本人可见被隐藏的帖子
			}
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}

		// post.setIsHidden(Short.parseShort("1"));//除去隐藏贴
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
		String uId; // 用户ID（前端参数）
		int pageSize;// 页面大小
		int pageNum; // 所需页数
		Collection collection; // 所需封装参数
		CollectionJson collectionJson;
		// 获取并处理参数
		uId = request.getParameter("uId");
		// 所需封装参数封装
		collection = new Collection();
		try {
			if (uId != null) {
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
		String postTitle; // 帖子标题（前端参数）
		String postType; // 帖子类型
		String postContent;// 帖子内容
		String postFile; // 帖子附件（二进制文件）
		String sectionId; // 板块Id
		String userId; // 用户Id
		Post post; // 封装所需参数

		// 获取参数
		postTitle = (String) request.getAttribute("postTitle");
		postType = (String) request.getAttribute("postType");
		postContent = (String) request.getAttribute("postContent");
		postFile = (String) request.getAttribute("postFile");
		sectionId = (String) request.getAttribute("sectionId");
		userId = String.valueOf(((UserBase) request.getSession().getAttribute("userBase")).getUserId());

		// 封装并处理参数
		post = new Post();
		try {
			post.setPostType(Short.parseShort(postType));
			post.setSectionId(Long.parseLong(sectionId));
			post.setUserId(Long.parseLong(userId));
			post.setEditUserId(Long.parseLong(userId));// 默认编辑帖子人是发布者
		} catch (Exception e) {
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
		post.setAnswerSum(0L); // 回帖次数
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
		if (post.getPostType() == 1) {// 主题帖

		} else if (post.getPostType() == 2) {// 资源帖
			if (postFile != null) {
				// TO-DO 多文件上传
				post.setIsAccessory(Short.parseShort("1"));// 存在资源的主题帖
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
					accessory.setPostId(postService.findFormList(1, 1, post).get(0).getPostId());
					accessory.setUploadTime(postDate);

					// 获取附件服务
					AccessoryService accessoryService = AccessoryServiceImpl.getInstance();
					result = accessoryService.addAccessory(accessory);
					if (result == 1) {
						JSONUtils.writeJSON(response, new Msg(1, "资源帖发布成功"));
					} else {
						JSONUtils.writeJSON(response, new Msg(0, "帖子发布失败，附件上传失败"));
						return;
					}
				}
			}
		} else if (post.getPostType() == 3) {// 公告
			post.setIsOverhead(Short.parseShort("1"));
			post.setOverheadCause("公告贴");
			post.setOverheadUserId(0L);// 系统自动设置
		}
		
		result = postService.addPost(post);
		if (result == 0) {
			JSONUtils.writeJSON(response, new Msg(0, "帖子发布失败"));
		}else {
			JSONUtils.writeJSON(response, new Msg(1, "帖子发布成功"));
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
		String postId; // 帖子Id（前端参数）
		String postTitle; // 帖子标题（前端参数）
		String uId; // 前端普通用户非必须（版主必须）
		String postType; // 帖子类型
		String postContent;// 帖子内容
		String accessoryStatus; // 帖子附件状态（未改动0，删除1，重新上传2）
		String sectionId; // 板块Id
		String userId; // 用户Id
		Post post; // 封装所需参数

		// （版主）参数声明
		String isHighlight; // 高亮状态
		String isOverhead; // 置顶状态
		String overheadCause;// 置顶原因
		String isClose; // 帖子关闭状态
		String switchCause; // 帖子切换（关闭）原因
		String isElite; // 帖子精华状态
		String recomValidity;// 帖子精华状态变化原因

		// 获取用户参数
		postId = (String) request.getAttribute("postId");
		postTitle = (String) request.getAttribute("postTitle");
		postType = (String) request.getAttribute("postType");
		postContent = (String) request.getAttribute("postContent");
		accessoryStatus = (String) request.getAttribute("accessoryStatus");
		sectionId = (String) request.getAttribute("sectionId");
		uId = (String) request.getAttribute("uId");
		userId = String.valueOf(((UserBase) request.getSession().getAttribute("userBase")).getUserId());

		// 获取版主参数
		isHighlight = (String) request.getAttribute("isHighlight");
		isOverhead = (String) request.getAttribute("isOverhead");
		overheadCause = (String) request.getAttribute("overheadCause");
		isClose = (String) request.getAttribute("isClose");
		switchCause = (String) request.getAttribute("switchCause");
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
			// 获取帖子信息
			post = postService.findByPostId(Long.parseLong(postId));
			if (post == null) {// 防止帖子被删
				JSONUtils.writeJSON(response, new Msg(0, "帖子不存在"));
				return;
			}
			post.setPostType(Short.parseShort(postType));
			post.setSectionId(Long.parseLong(sectionId));
			post.setEditUserId(Long.parseLong(userId)); // 编辑帖子用户

			if (uId != null) {
				// 判断是否是版主
				Moderator moderator = new Moderator();
				moderator.setUserId(Short.parseShort(uId));// 需要底层支持
				for (ModeratorForm moderatorForm : ModeratorServiceImpl.getInstance().findFormList(1, 1, moderator)) {
					if (Short.parseShort(uId) == moderatorForm.getUserId()) {
						if (isHighlight != null) {
							post.setIsHighlight(Short.parseShort(isHighlight));// 高亮显示（默认不高亮）
							post.setHighlightUserId(Long.parseLong(uId));
						}

						if (isOverhead != null) {
							post.setIsOverhead(Short.parseShort(isOverhead)); // 帖子置顶状态（默认不置顶）
							post.setOverheadCause(overheadCause); // 帖子置顶原因
							post.setOverheadUserId(Long.parseLong(uId));// 帖子置顶用户
						}

						if (isClose != null) {
							post.setIsClose(Short.parseShort(isClose)); // 帖子状态（默认打开）
							post.setSwitchCause(switchCause); // 帖子状态切换原因
							post.setSwitchUserId(Long.parseLong(uId));// 帖子状态切换用户
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
							post.setRecomUserId(Long.parseLong(uId));// 帖子精华状态切换用户
						}
					}
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
				
				result = accessoryService.deleteAccessory(accessoryService.findAccessory(post.getPostId()).get(0));
				if (result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "资源帖修改成功，资源已删除"));
				} else {
					JSONUtils.writeJSON(response, new Msg(0, "资源帖修改失败"));
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
					accessory.setPostId(postService.findFormList(1, 1, post).get(0).getPostId());
					accessory.setUploadTime(editDate);

					// 增加附件记录
					result = accessoryService.addAccessory(accessory);
					if (result == 1) {
						JSONUtils.writeJSON(response, new Msg(1, "资源帖发布成功"));
					} else {
						post.setPostId(accessory.getPostId());
						postService.deletePost(post);// 帖子发布失败删除帖子
						JSONUtils.writeJSON(response, new Msg(0, "帖子发布失败，附件上传失败"));
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
}
