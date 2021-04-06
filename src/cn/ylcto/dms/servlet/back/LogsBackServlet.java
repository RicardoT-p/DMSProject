package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.ILogsServiceBack;
import cn.ylcto.dms.service.back.impl.LogsServiceBackImpl;
import cn.ylcto.dms.vo.Logs;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;
import cn.ylcto.util.split.SplitPageUtils;

import javax.servlet.annotation.WebServlet;
import java.util.Map;
@WebServlet("/pages/back/admin/logs/LogsBackServlet/*")
public class LogsBackServlet extends DispatcherServlet {
    private ILogsServiceBack logsServiceBack = ServiceFactory.getInstance(LogsServiceBackImpl.class);
    private Logs logs = new Logs();

    public Logs getLogs() {
        return logs;
    }

    public String list(){
        String url = "LogsBackServlet.list.page";
        SplitPageUtils spu = new SplitPageUtils(super.request);
        int currentPage = spu.getCurrentPage(); // 表单当前页
        int lineSize = spu.getLineSize(); // 表示每页显示记录数
        String keyWord = spu.getKeyWord();
        String column = spu.getColumn();
        // 设置默认列
        if(column == null){
            column = "aid";
        }
        try{
            Map<String,Object> map = logsServiceBack.list(column,keyWord,currentPage,lineSize);
            super.request.setAttribute("allLogs",map.get("allLogs"));
            int allRecorders = (int)map.get("allCount");
            super.setSplitPage(super.getPagesValue(url),allRecorders,spu);
        }catch (Exception e){}
        return "logs.list.page";
    }
    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getUploaDir() {
        return null;
    }

    @Override
    public String getColumnData() {
        return "用户ID:aid";
    }
}
