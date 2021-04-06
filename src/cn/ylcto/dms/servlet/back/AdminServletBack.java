package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IAdminServiceBack;
import cn.ylcto.dms.service.back.impl.AdminServiceBackImpl;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.md5.MD5Code;
import cn.ylcto.util.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AdminServletBack/*")
public class AdminServletBack extends DispatcherServlet {
    IAdminServiceBack adminServiceBack = ServiceFactory.getInstance(AdminServiceBackImpl.class);
    private Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }


    public String updateByPasswordAndPhoto(){
        String fileName = super.credateFileName();
        Admin admin = (Admin)super.request.getSession().getAttribute("admin");
        this.admin.setPassword(new MD5Code().getMD5ofStr("{" + this.admin.getPassword() + "}"));
        this.admin.setPhoto(fileName);
        try {
            if(adminServiceBack.updateByPasswordAndPhoto(this.admin.getPassword(),this.admin.getPhoto(),admin.getAid())){
                if(super.isFileUpload()){ // 判断是否有文件上传
                    super.saveUploadFile(fileName);
                }
                super.setMsgAndUrl("insert.success.msg","AdminServletBack.update.page");
            }else{
                super.setMsgAndUrl("insert.failure.msg","AdminServletBack.update.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String login() {
        // 对数据进行md5加密处理
        this.admin.setPassword(new MD5Code().getMD5ofStr("{" + this.admin.getPassword() + "}"));
        // 取得客服端ip地址
        this.admin.setIp(super.request.getRemoteAddr());
        try {
            Map<String, Object> map = adminServiceBack.login(this.admin);
            Admin vo = (Admin) map.get("admin");
            boolean flag = (boolean) map.get("flag");
            if (map != null) {
                if (flag) { // 登录成功
                    super.request.getSession().setAttribute("admin", vo);
                    super.setMsgAndUrl("admin.login.success.msg", "admin.login.success.page");
                } else { // 登录失败
                    super.setMsgAndUrl("admin.login.failure.msg", "admin.login.failure.page");
                }
            } else {
                super.setMsgAndUrl("admin.login.failure.msg", "admin.login.failure.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String logout() {
        super.request.getSession().invalidate(); // 让session失效
        super.setMsgAndUrl("admin.logout.success.msg", "admin.logout.success.page");
        return "forward.page";
    }

    @Override
    public String getTitle() {
        return "用户";
    }

    @Override
    public String getUploaDir() {
        return "/upload/admin/";
    }

    @Override
    public String getColumnData() {
        return null;
    }
}
