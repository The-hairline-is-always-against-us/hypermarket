package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 物流表(tb_buycar)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_buycar")
public class BuyCar {
	//物流信息表主键ID
	private Integer i_id;
	//与订单表主键进行关联
	private Integer o_id;
	//与商品表主键进行关联
	private Integer g_id;
	//与商铺表主键进行关联
	private Integer s_id;
	//与卖家主键进行关联（用户主键）
	private Integer u_id;
	//发货时间
	private Date send_time;
	//收货时间
	private Date receive_time;
	//订单发货状态
	private Integer i_status;
}
