package cn.liko.web.archetype.quickstart.controller;

import cn.liko.web.archetype.quickstart.bean.ResponseBean;
import cn.liko.web.archetype.quickstart.mapper.TpDayMapper;
import cn.liko.web.archetype.quickstart.model.TpDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author liko
 * @date 2020/6/20
 */
@RestController
public class TestController {

    @Autowired
    private TpDayMapper tpDayDao;

    @RequestMapping("/{id}")
    public ResponseBean<TpDay> queryOne(@PathVariable("id") Integer id) {
        TpDay tpDay = tpDayDao.selectByPrimaryKey(id);
        return ResponseBean.success(tpDay);
    }
}
