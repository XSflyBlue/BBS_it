package com.neusoft.bbs.service.impl;

import java.util.Date;
import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.PostDao;
import com.neusoft.bbs.dao.impl.PostDaoImpl;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.PostForm;
import com.neusoft.bbs.service.PostService;

/**
 * 帖子管理service实现类
 * @author flyblue
 *
 */
public class PostServiceImpl implements PostService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final PostService instance = (PostService) transctionProxy.newProxyInstance(new PostServiceImpl());
	private PostDao postDao = new PostDaoImpl();
	/**
	 * 取得实例
	 */
	public static PostService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private PostServiceImpl() {
	}

	@Override
	public int addPost(Post post) {
		int result = 0;
		result = postDao.insert(post);
		return result;
	}

	@Override
	public int deletePost(Post post) {
		int result = 0;
		result = postDao.delete(post);
		return result;
	}

	@Override
	public int setPost(Post post) {
		int result = 0;
		result = postDao.update(post);
		return result;
	}

	@Override
	public Post findByPostId(Long postId) {
		Post post = null;
		post = postDao.findByPostId(postId);
		return post;
	}
	
	@Override
	public List<Post> findByUserId(Long userId) {
		List<Post> postList = null;
		postList = postDao.findByUserId(userId);
		return postList;
	}

	@Override
	public List<Post> findBySectionId(Long sectionId) {
		List<Post> postList = null;
		postList = postDao.findBySectionId(sectionId);
		return postList;
	}

	@Override
	public int getListPageCount(int pageSize, Post post) {
		int pageCount = 0;
		pageCount = postDao.getListPageCount(pageSize, post);
		return pageCount;
	}

	@Override
	public int getListRowCount(Post post) {
		int rowCount = 0;
		rowCount = postDao.getListRowCount(post);
		return rowCount;
	}

	@Override
	public List<PostForm> findFormList(int pageSize, int rowNum, Post post) {
		List<PostForm> postFormList = null;
		postFormList = postDao.findFormList(pageSize, rowNum, post);
		if(post.getIsElite()!=null){
			// 查询精华帖的时候才进行有效期判断
			for(int i =0;i<postFormList.size();i++){
				String currentDate = new Date().toLocaleString();
				String dbDate = postFormList.get(i).getRecomValidity().toLocaleString();
				if(currentDate.compareTo(dbDate)<0){
					System.out.println("忽略的帖子id:"+postFormList.get(i).getPostId());
					// 当前时间早于帖子精华有效时间，不用处理
				}else{
					// 帖子精华有效期已过（两者相等的话查询出来也已经过期），更改isElite字段并从返回的list中移除
					Post tempPost = new Post();				
					tempPost.setPostId(postFormList.get(i).getPostId());
					tempPost.setUserId(postFormList.get(i).getUserId());
					tempPost.setSectionId(postFormList.get(i).getSectionId());
					tempPost.setPostType(postFormList.get(i).getPostType());
					tempPost.setThemeContent(postFormList.get(i).getThemeContent());
					tempPost.setIssueTime(postFormList.get(i).getIssueTime());
					tempPost.setIssueIp(postFormList.get(i).getIssueIp());
					tempPost.setHitNum(postFormList.get(i).getHitNum());
					tempPost.setAnswerSum(postFormList.get(i).getAnswerSum()); 
					tempPost.setIsHighlight(postFormList.get(i).getIsHighlight());
					tempPost.setHighlightUserId(postFormList.get(i).getHighlightUserId());
					tempPost.setTitleColor(postFormList.get(i).getTitleColor()); 
					tempPost.setIsOverhead(postFormList.get(i).getIsOverhead()); 
					tempPost.setOverheadUserId(postFormList.get(i).getOverheadUserId());
					tempPost.setOverheadCause(postFormList.get(i).getOverheadCause()); 
					tempPost.setIsClose(postFormList.get(i).getIsClose());
					tempPost.setSwitchUserId(postFormList.get(i).getSwitchUserId());
					tempPost.setSwitchCause(postFormList.get(i).getSwitchCause());
					tempPost.setIsElite(Short.parseShort("0"));// 更改帖子精华状态
					tempPost.setRecomUserId(postFormList.get(i).getRecomUserId());
					// 可能需要修改PostDaoImpl的update方法
					tempPost.setRecomValidity(postFormList.get(i).getRecomValidity());
					tempPost.setIsHidden(postFormList.get(i).getIsHidden());
					tempPost.setHiddenCause(postFormList.get(i).getHiddenCause());
					tempPost.setHiddenUserId(postFormList.get(i).getHiddenUserId());
					tempPost.setIsAccessory(postFormList.get(i).getIsAccessory());
					tempPost.setEditUserId(postFormList.get(i).getEditUserId());
					tempPost.setEditTime(postFormList.get(i).getEditTime());
					tempPost.setPostTitle(postFormList.get(i).getPostTitle());
					
					// 更新已过期的精华帖状态
					postDao.update(tempPost);
					// 从结果列表移除
					postFormList.remove(i);	
					// 移除当前元素之后重新从当前位置继续遍历
					i--;
				}
			}
		}
		return postFormList;
	}
}
