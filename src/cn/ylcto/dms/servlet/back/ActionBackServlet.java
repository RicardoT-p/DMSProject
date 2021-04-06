package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IActionServiceBack;
import cn.ylcto.dms.service.back.IGroupsServiceBack;
import cn.ylcto.dms.service.back.impl.ActionServiceBackImpl;
import cn.ylcto.dms.service.back.impl.GroupsServiceBackImpl;
import cn.ylcto.dms.vo.Action;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//                                        GroupsBackServlet
@WebServlet("/pages/back/admin/action/ActionBackServlet/*")
public class ActionBackServlet extends DispatcherServlet {
    private IActionServiceBack actionServiceBack = ServiceFactory.getInstance(ActionServiceBackImpl.class);
    private IGroupsServiceBack groupsServiceBack = ServiceFactory.getInstance(GroupsServiceBackImpl.class);
    private Action action = new Action();

    public Action getAction() {
        return action;
    }

    public String delete(){
        String ids = super.request.getParameter("ids");
        Set<Integer> set = new HashSet<Integer>();
        String result[] = ids.split("\\.");
        for (int x = 0;x < result.length;x++){
            set.add(Integer.parseInt(result[x]));
        }
        try {
            if(actionServiceBack.delete(set)){
                super.setMsgAndUrl("delete.success.msg","ActionBackServlet.list.page");
            }else{
                super.setMsgAndUrl("delete.failure.msg","ActionBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }
    public String update(){
        try {
            if(actionServiceBack.update(this.action)){
                super.setMsgAndUrl("update.success.msg","ActionBackServlet.list.page");
            }else{
                super.setMsgAndUrl("update.failure.msg","ActionBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String updatePre(){
        try {
            Map<String ,Object> map  = actionServiceBack.insertPre();
            super.request.setAttribute("allGroups",map.get("allGroups"));
            super.request.setAttribute("action",actionServiceBack.show(this.action.getActid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "action.updatePre.page";
    }
    public String insertPre(){
        try {
            Map<String ,Object> map  = actionServiceBack.insertPre();
            super.request.setAttribute("allGroups",map.get("allGroups"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "action.insertPre.page";
    }

    public String insert(){
        try {
            if(actionServiceBack.insert(this.action)){
                super.setMsgAndUrl("insert.success.msg","ActionBackServlet.insert.page");
            }else{
                super.setMsgAndUrl("insert.failure.msg","ActionBackServlet.insert.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String list(){
        try {
            Map<String,Object> map = actionServiceBack.list();
            super.request.setAttribute("allGroups",map.get("allGroups"));
            super.request.setAttribute("allActions",map.get("allActions"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "action.list.page";
    }


    @Override
    public String getTitle() {
        return "权限";
    }

    @Override
    public String getUploaDir() {
        return null;
    }

    @Override
    public String getColumnData() {
        return null;
    }
}
