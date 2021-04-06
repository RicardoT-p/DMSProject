package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.ILogsDAO;
import cn.ylcto.dms.dao.impl.LogsDAOImpl;
import cn.ylcto.dms.service.back.ILogsServiceBack;
import cn.ylcto.util.factory.DAOFactory;

import java.util.HashMap;
import java.util.Map;

public class LogsServiceBackImpl implements ILogsServiceBack {
    private ILogsDAO logsDAO = DAOFactory.getInstance(LogsDAOImpl.class);
    @Override
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allLogs",logsDAO.findAllBySplit(column,keyWord,currentPage,lineSize));
        map.put("allCount",logsDAO.getAllCount(column,keyWord));
        return map;
    }
}
