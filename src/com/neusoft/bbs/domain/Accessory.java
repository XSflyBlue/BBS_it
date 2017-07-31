package com.neusoft.bbs.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Accessory {
    private Long accessoryId;

    private Long postId;

    private String fileName;

    private String path;

    private String author;

    private Date uploadTime;

    private String accessoryDescri;

    private BigDecimal fileSize;

    private Long downloadNum;

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