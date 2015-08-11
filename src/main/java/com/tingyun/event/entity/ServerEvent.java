package com.tingyun.event.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.tingyun.event.bean.AbstractEventEntity;

@Entity
@Table(name="NL_U_SERVER_EVENTS")
@Where(clause = "disk_id = 0")
public class ServerEvent extends AbstractEventEntity {
	
	private int id;
	/**
	 * 关联服务器 ID
	 */
	@Column(name="server_id", nullable=false)
	private int serverId;
	/**
	 * 关联服务器磁盘ID。CPU报警该字段置0
	 */
	@Column(name="disk_id", nullable=false)
	private int diskId;
	/**
	 * 关联应用配置ID
	 */
	@Column(name="event_setting_id", nullable=false)
	private int eventSettingId;
	/**
	 * 事件跟踪ID（同一组事件使用同一个跟踪ID）
	 */
	@Column(name="evnet_trace_id", nullable=false)
	private int eventTraceId;
	/**
	 * 关联事件的ID。
	 */
	@Column(name="related_event_id", nullable=false)
	private int relatedEventId;
	/**
	 * 事件类型：0 - 无 6 - 错误率超过阈值 7 - Apdex超过阈值 9 - 触发报警 10 - 解除报警通知 100 - 备忘
	 */
	@Column(name="event_type", nullable=false)
	private int eventType;
	/**
	 * 事件级别：0 - 无 1 - 警告 2 - 严重
	 */
	@Column(name="event_level", nullable=false)
	private int eventLevel;
	/**
	 * 关联事件的事件类型
	 */
	@Column(name="related_event_type", nullable=false)
	private int relatedEventType;
	/**
	 * 当前触发警告的阈值
	 */
	@Column(name="threshold", nullable=false)
	private float threshold;
	/**
	 * 警报触发时间段内的平均值或错误率
	 */
	@Column(name="value", nullable=false)
	private float value;
	/**
	 * 警报触发时间段内的请求数
	 */
	@Column(name="count", nullable=false)
	private int count;
	/**
	 * 消息（仅对注释有效）
	 */
	private String message;
	/**
	 * 事件开始时间
	 */
	@Column(name="begin_time", nullable=false)
	private Date beginTime;
	/**
	 * 事件结束时间
	 */
	private Date endTime;
	/**
	 * 事件触发或创建时间
	 */
	@Column(name="ctime", nullable=false)
	private Date ctime;
	/**
	 * 状态：0 - 关闭 1 - 开放
	 */
	@Column(name="status", nullable=false)
	private int status;
	/**
	 * 阅读状态：0 - 未读 1 - 已读
	 */
	@Column(name="read_status", nullable=false)
	private int readStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public int getDiskId() {
		return diskId;
	}
	public void setDiskId(int diskId) {
		this.diskId = diskId;
	}
	public int getEventSettingId() {
		return eventSettingId;
	}
	public void setEventSettingId(int eventSettingId) {
		this.eventSettingId = eventSettingId;
	}
	public int getEventTraceId() {
		return eventTraceId;
	}
	public void setEventTraceId(int eventTraceId) {
		this.eventTraceId = eventTraceId;
	}
	public int getRelatedEventId() {
		return relatedEventId;
	}
	public void setRelatedEventId(int relatedEventId) {
		this.relatedEventId = relatedEventId;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public int getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(int eventLevel) {
		this.eventLevel = eventLevel;
	}
	public int getRelatedEventType() {
		return relatedEventType;
	}
	public void setRelatedEventType(int relatedEventType) {
		this.relatedEventType = relatedEventType;
	}
	public float getThreshold() {
		return threshold;
	}
	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}

}
