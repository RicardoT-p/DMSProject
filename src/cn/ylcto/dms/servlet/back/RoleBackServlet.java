package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IDeptServiceBack;
import cn.ylcto.dms.service.back.IRoleServicBack;
import cn.ylcto.dms.service.back.impl.DeptServiceBackImpl;
import cn.ylcto.dms.service.back.impl.RoleServicBackImpl;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/pages/back/admin/role/RoleBackServlet/*")
public class RoleBackServlet extends DispatcherServlet {

    IRoleServicBack roleServicBack = ServiceFactory.getInstance(RoleServicBackImpl.class);
    private Role role = new Role();

    public Role getRole() {
        return role;
    }

    public String delete(){
        try {
            if(roleServicBack.delete(this.role.getRid())){
                super.setMsgAndUrl("delete.success.msg","RoleBackServlet.list.page");
            }else{
                super.setMsgAndUrl("delete.failure.msg","RoleBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String update() {
        String gid[] = super.request.getParameterValues("gid");
        if(gid == null){
            super.setMsgAndUrl("insert.failure.msg","RoleBackServlet.list.page");
        }else {
            List<Groups> allGroups = new ArrayList<>();
            for(int x = 0;x < gid.length;x++){
                Groups g = new Groups();
                g.setGid(Integer.parseInt(gid[x]));
                allGroups.add(g);
            }
            this.role.setGroups(allGroups);
            try {
                if (roleServicBack.update(this.role)) {
                    super.setMsgAndUrl("update.success.msg", "RoleBackServlet.list.page");
                } else {
                    super.setMsgAndUrl("update.failure.msg", "RoleBackServlet.list.page");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "forward.page";
    }

    public String updatePre(){
        try {
            Map<String,Object> map = roleServicBack.updatePre(this.role.getRid());
            Map<String,Object> mapa = roleServicBack.insertPre();
            Role role = (Role) map.get("role");
            super.request.setAttribute("allGroups",mapa.get("allGroups"));
            super.request.setAttribute("role",role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "role.update.page";
    }

    public String list(){
        try {
            super.request.setAttribute("allRole",roleServicBack.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "role.list.page";
    }

    public String insertPre() {
        try {
            Map<String,Object> map = roleServicBack.insertPre();
            super.request.setAttribute("allGroups",map.get("allGroups"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "role.insert.page";
    }

    public String insert() {
        String gid[] = super.request.getParameterValues("gid");
        if(gid == null){
            super.setMsgAndUrl("insert.failure.msg","RoleBackServlet.insertPre.page");
        }else {
            List<Groups> allGroups = new ArrayList<>();
            for(int x = 0;x < gid.length;x++){
                Groups g = new Groups();
                g.setGid(Integer.parseInt(gid[x]));
                allGroups.add(g);
            }
            this.role.setGroups(allGroups);
            try {
                if (roleServicBack.insert(this.role)) {
                    super.setMsgAndUrl("insert.success.msg", "RoleBackServlet.insertPre.page");
                } else {
                    super.setMsgAndUrl("insert.failure.msg", "RoleBackServlet.insertPre.page");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "forward.page";
    }


    @Override
    public String getTitle() {
        return "角色";
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
