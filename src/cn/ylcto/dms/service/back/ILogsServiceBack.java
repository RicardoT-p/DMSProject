package cn.ylcto.dms.service.back;

import java.util.Map;

public interface ILogsServiceBack {
    /**
     * 分页和模糊查询
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String,Object> list(String column, String keyWord, int currentPage, int lineSize)throws Exception;
}
