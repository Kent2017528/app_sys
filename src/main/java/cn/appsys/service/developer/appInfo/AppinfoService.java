package cn.appsys.service.developer.appInfo;

import cn.appsys.pojo.AppInfo;
import com.github.pagehelper.PageInfo;

public interface AppinfoService {

    public PageInfo<AppInfo> getAppList(Long devId,String querySoftwareName,
                                        Long queryStatus,
                                        Long queryFlatformId,
                                        Long queryCategoryLevel1,
                                        Long queryCategoryLevel2,
                                        Long queryCategoryLevel3,Integer currentPageNo,Integer pageSize);
}
