package cn.appsys.service.developer.appVersion;

import cn.appsys.dao.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.AppVersionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> getAppVersionByAppId(Long appId) {
        AppVersionExample example =new AppVersionExample();
        example.createCriteria().andAppIdEqualTo(appId);
        List<AppVersion> versionList = appVersionMapper.selectByExample(example);

        return versionList;
    }
}
