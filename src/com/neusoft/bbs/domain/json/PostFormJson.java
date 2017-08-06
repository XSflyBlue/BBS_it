package com.neusoft.bbs.domain.json;

import com.neusoft.bbs.domain.Accessory;
import com.neusoft.bbs.domain.form.PostForm;
/**
 * 单个帖子详情（for json）
 * @author flyblue
 *
 */
public class PostFormJson {
	private PostForm postForm;
	private Accessory accessory;
	public PostForm getPostForm() {
		return postForm;
	}
	public void setPostForm(PostForm postForm) {
		this.postForm = postForm;
	}
	public Accessory getAccessory() {
		return accessory;
	}
	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}
}
