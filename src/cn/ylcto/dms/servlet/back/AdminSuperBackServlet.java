package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IAdminServiceBack;
import cn.ylcto.dms.service.back.IDeptServiceBack;
import cn.ylcto.dms.service.back.impl.AdminServiceBackImpl;
import cn.ylcto.dms.service.back.impl.DeptServiceBackImpl;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.md5.MD5Code;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.Map;

@WebServlet("/pages/back/admin/admin/AdminSuperBackServlet/*")
public class AdminSuperBackServlet extends DispatcherServlet {
    IAdminServiceBack adminServiceBack = ServiceFactory.getInstance(AdminServiceBackImpl.class);
    IDeptServiceBack deptServiceBack = ServiceFactory.getInstance(DeptServiceBackImpl.class);
    private Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public String  updateByStatus(){
        try {
            if (adminServiceBack.updateByStatus(this.admin.getStatus(),this.admin.getAid())){
                super.setMsgAndUrl("update.success.msg","AdminSuperBackServlet.list.success.page");
            }else{
                super.setMsgAndUrl("update.failure.msg","AdminSuperBackServlet.list.success.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String list() {
        try {
            super.request.setAttribute("allAdminByType",adminServiceBack.list(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin.list.page";
    }


    public String insertPre() {
        // 取得所有部门信息
        try {
            super.request.setAttribute("allDept", deptServiceBack.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin.insert.page";
    }

    public String insert() {
        try {
            this.admin.setPassword("75896DE193D77C9D1577931DC4F1790E"); // 加密密码，默认密码为12345678
            this.admin.setType(2);  // 部门经理
            this.admin.setStatus(1); // 可以登录
            Role role = new Role();
            role.setRid(2); // 部门经理角色信息
            this.admin.setRole(role);
            if (adminServiceBack.insert(this.admin)) {
                super.setMsgAndUrl("insert.success.msg", "AdminSuperBackServlet.insert.success.page");
            } else {
                super.setMsgAndUrl("insert.failure.msg", "AdminSuperBackServlet.insert.success.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }


    @Override
    public String getTitle() {
        return "用户";
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
