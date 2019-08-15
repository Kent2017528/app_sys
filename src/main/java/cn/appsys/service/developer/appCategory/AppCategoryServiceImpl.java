package cn.appsys.service.developer.appCategory;

import cn.appsys.dao.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    public List<AppCategory> getAppCategorys(Long pId){
        AppCategoryExample example =new AppCategoryExample();

        AppCategoryExample.Criteria criteria = example.createCriteria();
        if (null!=pId&&0!=pId){
        criteria.andParentIdEqualTo(pId);
        }else {
            criteria.andParentIdIsNull();
        }

        List<AppCategory> list = appCategoryMapper.selectByExample(example);
        return list;


    }
}
