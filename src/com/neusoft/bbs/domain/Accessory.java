package com.neusoft.bbs.domain;

import java.math.BigDecimal;
import java.util.Date;
/***
 * 附件类
 * @author flyblue
 *
 */
public class Accessory {
	/***
	 * 附件ID
	 */
    private Long accessoryId;

    /***
     * 帖子ID
     */
    private Long postId;

    /***
     * 文件名
     */
    private String fileName;

    /***
     * 路径
     */
    private String path;

    /***
     * 作者
     */
    private String author;

    /***
     * 上传时间
     */
    private Date uploadTime;

    /***
     * 附件描述
     */
    private String accessoryDescri;

    /***
     * 附件大小
     */
    private BigDecimal fileSize;

    /***
     * 下载次数
     */
    private Long downloadNum;

    /***
     * 所需消耗金币
     */
    private Long costCoin;

    public Long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAccessoryDescri() {
        return accessoryDescri;
    }

    public void setAccessoryDescri(String accessoryDescri) {
        this.accessoryDescri = accessoryDescri;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public Long getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Long downloadNum) {
        this.downloadNum = downloadNum;
    }

    public Long getCostCoin() {
        return costCoin;
    }

    public void setCostCoin(Long costCoin) {
        this.costCoin = costCoin;
    }
}