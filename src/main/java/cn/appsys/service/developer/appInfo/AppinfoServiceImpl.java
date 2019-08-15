package cn.appsys.service.developer.appInfo;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppinfoServiceImpl implements AppinfoService{
    @Autowired
    private AppInfoMapper appInfoMapper;


    @Override
    public PageInfo<AppInfo> getAppList(Long devId,String querySoftwareName,
                                        Long queryStatus,
                                        Long queryFlatformId,
                                        Long queryCategoryLevel1,
                                        Long queryCategoryLevel2,
                                        Long queryCategoryLevel3,
                                        Integer currentPageNo,Integer pageSize) {
        PageInfo pageInfo=null;
        AppInfoExample example=new AppInfoExample();

        AppInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDevIdEqualTo(devId);
        if (null!=querySoftwareName&&!("").equals(querySoftwareName)){
            criteria.andSoftwareNameLike("%"+querySoftwareName+"%");
        }
        if (null!=queryStatus&&0!=queryStatus){
            criteria.andStatusEqualTo(queryStatus);
        }
        if (null!=queryFlatformId&&0!=queryFlatformId){
            criteria.andFlatformIdEqualTo(queryFlatformId);
        }
        if (null!=queryCategoryLevel1&&0!=queryCategoryLevel1){
            criteria.andCategoryLevel1EqualTo(queryCategoryLevel1);
        }
        if (null!=queryCategoryLevel2&&0!=queryCategoryLevel2){
            criteria.andCategoryLevel2EqualTo(queryCategoryLevel2);
        }
        if (null!=queryCategoryLevel3&&0!=queryCategoryLevel3){
            criteria.andCategoryLevel3EqualTo(queryCategoryLevel3);
        }

        PageHelper.startPage(currentPageNo, pageSize);
        List<AppInfo> list = appInfoMapper.selectByExample(example);
        pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
