package cn.liko.web.archetype.quickstart.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * TP_DAY
 * @author 
 */
@Data
public class TpDay implements Serializable {
    private Integer tpDayId;

    private Date day;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}