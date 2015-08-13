package com.tingyun.event;

/**
 * 事件相关常量类
 * @author qi guan yi
 *
 */
public interface EventConstants {
	
	/**
	 * 警报数据统计延时（单位：秒）
	 */
	public static int ALARM_DATA_DELAY = 180;

	/**
	 * 警报级别：无需警报
	 */
	public static int EVENT_LEVEL_NONE = 0;
	/**
	 * 警报级别：告警警报
	 */
	public static int EVENT_LEVEL_WARN = 1;
	/**
	 * 警报级别：严重警报
	 */
	public static int EVENT_LEVEL_CRITICAL = 2;
	
	

	/**
	 * 事件状态：删除
	 * 因为没有达成触发警报条件而被删除
	 */
	public static int EVENT_STATUS_DELETE = -1;
	/**
	 * 事件状态：开启
	 * 已经触发警报的状态
	 */
	public static int EVENT_STATUS_OPEN = 1;
	/**
	 * 事件状态：关闭
	 * 警报已经被关闭的状态
	 */
	public static int EVNET_STATUS_CLOSE = 0;
	
	

	/**
	 * 事件类型：警报通知
	 */
	public static int EVENT_TYPE_NOTIFICATION = 9;
	/**
	 * 事件类型：警报解除通知
	 */
	public static int EVENT_TYPE_NOTIFICATION_CLOSED = 10;
	/**
	 * 事件类型：apdex值
	 */
	public static int EVENT_TYPE_APDEX = 7;
	/**
	 * 事件类型：错误率
	 */
	public static int EVENT_TYPE_ERROR_RATE = 6;
	/**
	 * 事件类型：cpu
	 */
	public static int EVENT_TYPE_CPU = 11;
	/**
	 * 事件类型：io
	 */
	public static int EVENT_TYPE_IO = 12;
	/**
	 * 事件类型：内存
	 */
	public static int EVENT_TYPE_MEMORY = 13;
	/**
	 * 事件类型：硬盘
	 */
	public static int EVENT_TYPE_DISK = 14;
	
	/**
	 * 事件目标类型：应用
	 */
	public static int EVENT_TARGET_TYPE_APPLICATION = 1;
	/**
	 * 事件目标类型：关键应用
	 */
	public static int EVENT_TARGET_TYPE_KEYACTION = 2;
	/**
	 * 事件目标类型：硬盘
	 */
	public static int EVENT_TARGET_TYPE_DISK = 3;
	/**
	 * 事件目标类型：服务器
	 */
	public static int EVENT_TARGET_TYPE_SYS = 4;
	
}
