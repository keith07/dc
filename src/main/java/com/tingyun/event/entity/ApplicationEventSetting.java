package com.tingyun.event.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tingyun.event.bean.AbstractEventSetting;

@Entity
@Table(name="NL_U_APPLICATION_EVENT_SETTINGS")
public class ApplicationEventSetting extends AbstractEventSetting {
	
	private int id;
	/**
	 * 关联应用 ID
	 */
	@Column(name="application_id", nullable=false)
	private int applicationId;
	/**
	 * HTTP错误率警告阈值(0-1)
	 */
	@Column(name="error_warn_threshold", nullable=false)
	private float errorWarnThreshold;
	/**
	 * HTTP错误率严重阈值(0-1)
	 */
	@Column(name="error_critical_threshold", nullable=false)
	private float errorCriticalThreshold;
	/**
	 * Apdex警告阈值(0-1)
	 */
	@Column(name="apdex_warn_threshold", nullable=false)
	private float apdexWarnThreshold;
	/**
	 * Apdex严重阈值(0-1)
	 */
	@Column(name="apdex_critical_threshold", nullable=false)
	private float apdexCriticalThreshold;
	/**
	 * 状态：0 - 禁用 1 - 启用
	 */
	@Column(name="status", nullable=false)
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public float getErrorWarnThreshold() {
		return errorWarnThreshold;
	}
	public void setErrorWarnThreshold(float errorWarnThreshold) {
		this.errorWarnThreshold = errorWarnThreshold;
	}
	public float getErrorCriticalThreshold() {
		return errorCriticalThreshold;
	}
	public void setErrorCriticalThreshold(float errorCriticalThreshold) {
		this.errorCriticalThreshold = errorCriticalThreshold;
	}
	public float getApdexWarnThreshold() {
		return apdexWarnThreshold;
	}
	public void setApdexWarnThreshold(float apdexWarnThreshold) {
		this.apdexWarnThreshold = apdexWarnThreshold;
	}
	public float getApdexCriticalThreshold() {
		return apdexCriticalThreshold;
	}
	public void setApdexCriticalThreshold(float apdexCriticalThreshold) {
		this.apdexCriticalThreshold = apdexCriticalThreshold;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
