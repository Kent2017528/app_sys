package cn.appsys.service.developer.appVersion;

import cn.appsys.pojo.AppVersion;

import java.util.List;

public interface AppVersionService {

    public List<AppVersion> getAppVersionByAppId(Long appId);
}
