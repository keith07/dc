package com.tingyun.event.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tingyun.event.bean.AbstractEventSetting;

@Entity
@Table(name="NL_U_SERVER_EVENT_SETTINGS")
public class ServerEventSetting extends AbstractEventSetting {
	
	private int id;
	/**
	 * 关联服务器 ID
	 */
	@Column(name="server_id", nullable=false)
	private int serverId;
	/**
	 * CPU使用率率警告阈值(0-1)
	 */
	@Column(name="cpu_warn_threshold", nullable=false)
	private float cpuWarnThreshold;
	/**
	 * CPU使用率严重阈值(0-1)
	 */
	@Column(name="cpu_critical_threshold", nullable=false)
	private float cpuCriticalThreshold;
	/**
	 * IO利用率警告阈值(0-1)
	 */
	@Column(name="disk_io_warn_threshold", nullable=false)
	private float diskIoWarnThreshold;
	/**
	 * IO利用率严重阈值(0-1)
	 */
	@Column(name="disk_io_critical_threshold", nullable=false)
	private float diskIoCriticalThreshold;
	/**
	 * 内存使用率警告阈值(0-1)
	 */
	@Column(name="memory_warn_threshold", nullable=false)
	private float memoryWarnThreshold;
	/**
	 * 内存使用率严重阈值(0-1)
	 */
	@Column(name="memory_critical_threshold", nullable=false)
	private float memoryCriticalThreshold;
	/**
	 * 磁盘空间使用率警告阈值(0-1)
	 */
	@Column(name="disk_usage_warn_threshold", nullable=false)
	private float diskUsageWarnThreshold;
	/**
	 * 磁盘空间使用率严重阈值(0-1)
	 */
	@Column(name="disk_usage_critical_threshold", nullable=false)
	private float diskUsageCriticalThreshold;
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
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public float getCpuWarnThreshold() {
		return cpuWarnThreshold;
	}
	public void setCpuWarnThreshold(float cpuWarnThreshold) {
		this.cpuWarnThreshold = cpuWarnThreshold;
	}
	public float getCpuCriticalThreshold() {
		return cpuCriticalThreshold;
	}
	public void setCpuCriticalThreshold(float cpuCriticalThreshold) {
		this.cpuCriticalThreshold = cpuCriticalThreshold;
	}
	public float getDiskIoWarnThreshold() {
		return diskIoWarnThreshold;
	}
	public void setDiskIoWarnThreshold(float diskIoWarnThreshold) {
		this.diskIoWarnThreshold = diskIoWarnThreshold;
	}
	public float getDiskIoCriticalThreshold() {
		return diskIoCriticalThreshold;
	}
	public void setDiskIoCriticalThreshold(float diskIoCriticalThreshold) {
		this.diskIoCriticalThreshold = diskIoCriticalThreshold;
	}
	public float getMemoryWarnThreshold() {
		return memoryWarnThreshold;
	}
	public void setMemoryWarnThreshold(float memoryWarnThreshold) {
		this.memoryWarnThreshold = memoryWarnThreshold;
	}
	public float getMemoryCriticalThreshold() {
		return memoryCriticalThreshold;
	}
	public void setMemoryCriticalThreshold(float memoryCriticalThreshold) {
		this.memoryCriticalThreshold = memoryCriticalThreshold;
	}
	public float getDiskUsageWarnThreshold() {
		return diskUsageWarnThreshold;
	}
	public void setDiskUsageWarnThreshold(float diskUsageWarnThreshold) {
		this.diskUsageWarnThreshold = diskUsageWarnThreshold;
	}
	public float getDiskUsageCriticalThreshold() {
		return diskUsageCriticalThreshold;
	}
	public void setDiskUsageCriticalThreshold(float diskUsageCriticalThreshold) {
		this.diskUsageCriticalThreshold = diskUsageCriticalThreshold;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
