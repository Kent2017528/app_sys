package cn.appsys.service.developer.DataDictionary;

import cn.appsys.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    public List<DataDictionary> getStatusList();
    public List<DataDictionary> getFlatFormList();
}
