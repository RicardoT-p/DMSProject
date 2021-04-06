package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IAdminServiceBack;
import cn.ylcto.dms.service.back.IDeptServiceBack;
import cn.ylcto.dms.service.back.impl.AdminServiceBackImpl;
import cn.ylcto.dms.service.back.impl.DeptServiceBackImpl;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
//           /pages/back/admin/admin/adminFrontServlet/insertPre
@WebServlet("/pages/back/admin/admin/AdminFrontServlet/*")
public class AdminFrontServlet extends DispatcherServlet {
    IAdminServiceBack adminServiceBack = ServiceFactory.getInstance(AdminServiceBackImpl.class);
    IDeptServiceBack deptServiceBack = ServiceFactory.getInstance(DeptServiceBackImpl.class);
    private Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public String  updateByStatus(){
        try {
            if (adminServiceBack.updateByStatus(this.admin.getStatus(),this.admin.getAid())){
                super.setMsgAndUrl("update.success.msg","AdminFrontServlet.list.success.page");
            }else{
                super.setMsgAndUrl("update.failure.msg","AdminFrontServlet.list.success.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String list() {
        Admin vo = (Admin)super.request.getSession().getAttribute("admin");
        try {
            super.request.setAttribute("allAdminByType",adminServiceBack.list(0,vo.getDept().getDid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin.list.success.page";
    }


    public String insertPre() {
        return "admin.insertPre.page";
    }

    public String insert() {
        try {
            this.admin.setPassword("75896DE193D77C9D1577931DC4F1790E"); // 加密密码，默认密码为12345678
            this.admin.setType(0);  // 部门经理
            this.admin.setStatus(1); // 可以登录
            Role role = new Role();
            role.setRid(3); // 部门员工角色信息
            this.admin.setRole(role);
            if (adminServiceBack.insert(this.admin)) {
                super.setMsgAndUrl("insert.success.msg", "AdminFrontServlet.insert.success.page");
            } else {
                super.setMsgAndUrl("insert.failure.msg", "AdminFrontServlet.insert.success.page");
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
