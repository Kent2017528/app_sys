package cn.appsys.service.developer.appinfo;

import cn.appsys.pojo.AppInfo;
import com.github.pagehelper.PageInfo;

public interface AppinfoService {

    public PageInfo<AppInfo> getAppList(Long devId,Integer currentPageNo,Integer pageSize);
}
