package cn.liko.web.archetype.quickstart.mapper;

import cn.liko.web.archetype.quickstart.model.TpPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface TpPlanMapper {
    int deleteByPrimaryKey(Integer tpPlanId);

    int insert(TpPlan record);

    int insertSelective(TpPlan record);

    TpPlan selectByPrimaryKey(Integer tpPlanId);

    int updateByPrimaryKeySelective(TpPlan record);

    int updateByPrimaryKey(TpPlan record);
}