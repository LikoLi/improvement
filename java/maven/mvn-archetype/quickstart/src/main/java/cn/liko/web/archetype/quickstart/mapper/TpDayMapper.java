package cn.liko.web.archetype.quickstart.mapper;

import cn.liko.web.archetype.quickstart.model.TpDay;
import org.springframework.stereotype.Repository;

@Repository
public interface TpDayMapper {
    int deleteByPrimaryKey(Integer tpDayId);

    int insert(TpDay record);

    int insertSelective(TpDay record);

    TpDay selectByPrimaryKey(Integer tpDayId);

    int updateByPrimaryKeySelective(TpDay record);

    int updateByPrimaryKey(TpDay record);
}