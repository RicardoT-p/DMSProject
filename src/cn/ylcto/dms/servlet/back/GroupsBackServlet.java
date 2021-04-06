package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IGroupsServiceBack;
import cn.ylcto.dms.service.back.impl.GroupsServiceBackImpl;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.HashSet;
import java.util.Set;

//                                        GroupsBackServlet
@WebServlet("/pages/back/admin/groups/GroupsBackServlet/*")
public class GroupsBackServlet extends DispatcherServlet {
    private IGroupsServiceBack groupsServiceBack = ServiceFactory.getInstance(GroupsServiceBackImpl.class);
    private Groups groups = new Groups();

    public Groups getGroups() {
        return groups;
    }

    public String delete(){
        // 1|2|3
        String ids = super.request.getParameter("ids");
        Set<Integer> set = new HashSet<Integer>();
        String result[] = ids.split("\\.");
        for (int x = 0;x < result.length;x++){
            set.add(Integer.parseInt(result[x]));
        }
        try {
            if(groupsServiceBack.delete(set)){
                super.setMsgAndUrl("delete.success.msg","GroupsBackServlet.list.page");
            }else{
                super.setMsgAndUrl("delete.failure.msg","GroupsBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }
    public String update(){
        try {
            if(groupsServiceBack.update(this.groups)){
                super.setMsgAndUrl("update.success.msg","GroupsBackServlet.list.page");
            }else{
                super.setMsgAndUrl("update.failure.msg","GroupsBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String updatePre(){
        try {
            super.request.setAttribute("groups",groupsServiceBack.show(this.groups.getGid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "groups.updatePre.page";
    }
    public String insertPre(){
        return "groups.insertPre.page";
    }

    public String insert(){
        try {
            if(groupsServiceBack.insert(this.groups)){
                super.setMsgAndUrl("insert.success.msg","GroupsBackServlet.insert.page");
            }else{
                super.setMsgAndUrl("insert.failure.msg","GroupsBackServlet.insert.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String list(){
        try {
            super.request.setAttribute("allGroups",groupsServiceBack.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "groups.list.page";
    }


    @Override
    public String getTitle() {
        return "权限组";
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
