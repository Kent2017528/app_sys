package cn.appsys.service.developer.appinfo;

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
    public PageInfo<AppInfo> getAppList(Long devId,Integer currentPageNo,Integer pageSize) {
        PageInfo pageInfo=null;
        AppInfoExample example=new AppInfoExample();
        example.createCriteria().andDevIdEqualTo(devId);
        PageHelper.startPage(currentPageNo, pageSize);
        List<AppInfo> list = appInfoMapper.selectByExample(example);
        pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
