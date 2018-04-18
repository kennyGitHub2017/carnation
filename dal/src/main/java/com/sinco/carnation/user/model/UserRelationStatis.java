package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserRelationStatis extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
    private Long id;

    /** 用户id **/
    private Long uid;

    /** 用户团队关系数量 **/
    private Long relationCount;

    /**  **/
    private Boolean deleteStatus;

    /**  **/
    private Date createTime;

    /**  **/
    private String createUser;

    /**  **/
    private Date lastUpdateTime;

    /**  **/
    private String lastUpdateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRelationCount() {
        return relationCount;
    }

    public void setRelationCount(Long relationCount) {
        this.relationCount = relationCount;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }
}