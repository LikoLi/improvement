package cn.liko.web.archetype.quickstart.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * TP_PLAN
 * @author 
 */
@Data
public class TpPlan implements Serializable {
    private Integer tpPlanId;

    private Integer tpDayId;

    private String content;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}