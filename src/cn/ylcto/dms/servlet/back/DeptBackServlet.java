package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IDeptServiceBack;
import cn.ylcto.dms.service.back.impl.DeptServiceBackImpl;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/pages/back/admin/dept/DeptBackServlet/*")
public class DeptBackServlet extends DispatcherServlet {
    IDeptServiceBack deptServiceBack = ServiceFactory.getInstance(DeptServiceBackImpl.class);
    private Dept dept = new Dept();

    public Dept getDept() {
        return dept;
    }


    public String update() {
        try {
            if (deptServiceBack.update(this.dept)) {
                super.setMsgAndUrl("update.success.msg", "dept.list.page");
            } else {
                super.setMsgAndUrl("update.failure.msg", "dept.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String delete() {
        try {
            if (deptServiceBack.delete(this.dept.getDid())) {
                super.setMsgAndUrl("delete.success.msg", "dept.list.page");
            } else {
                super.setMsgAndUrl("delete.failure.msg", "dept.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String insertPre() {
        return "DeptServletBack.insert.page";
    }

    public String insert() {
        try {
            if (deptServiceBack.insert(this.dept)) {
                super.setMsgAndUrl("insert.success.msg", "DeptServletBack.insert.page");
            } else {
                super.setMsgAndUrl("insert.failure.msg", "DeptServletBack.insert.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String list() {
        try {
            super.request.setAttribute("allDept", deptServiceBack.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DeptServletBack.list.page";
    }

    @Override
    public String getTitle() {
        return "部门";
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
