package cn.appsys.service.developer.DataDictionary;

import cn.appsys.dao.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DataDictionaryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements  DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getStatusList() {

        DataDictionaryExample example =new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("APP_STATUS");

        List<DataDictionary> list = dataDictionaryMapper.selectByExample(example);

        return list;
    }

    @Override
    public List<DataDictionary> getFlatFormList() {
        DataDictionaryExample example =new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("APP_FLATFORM");

        List<DataDictionary> list = dataDictionaryMapper.selectByExample(example);

        return list;
    }
}
