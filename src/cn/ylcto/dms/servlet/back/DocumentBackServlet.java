package cn.ylcto.dms.servlet.back;

import cn.ylcto.dms.service.back.IDocumentServiceBack;
import cn.ylcto.dms.service.back.impl.DocumentServiceBackImpl;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Document;
import cn.ylcto.util.factory.ServiceFactory;
import cn.ylcto.util.servlet.DispatcherServlet;
import cn.ylcto.util.split.SplitPageUtils;

import javax.servlet.annotation.WebServlet;
import java.util.Date;
import java.util.Map;

@WebServlet("/pages/back/admin/document/DocumentBackServlet/*")
public class DocumentBackServlet extends DispatcherServlet {
    IDocumentServiceBack documentServiceBack = ServiceFactory.getInstance(DocumentServiceBackImpl.class);
    private Document document = new Document();
    public String showByDid(){
        try {
            super.request.setAttribute("Document",documentServiceBack.show(this.document.getDcid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.showByDid.page";
    }
    public String listByDid(){
        // 取得did
        Admin vo = (Admin) super.request.getSession().getAttribute("admin");
        // 每次跳转的页面路径
        String url = "DocumentBackServlet.listByDid.page";
        SplitPageUtils spu = new SplitPageUtils(super.request);
        int currentPage = spu.getCurrentPage(); // 表单当前页
        int lineSize = spu.getLineSize(); // 表示每页显示记录数
        try {
            Map<String,Object> map = documentServiceBack.listByStatus(currentPage,lineSize,vo.getDept().getDid());
            super.request.setAttribute("allDocuments",map.get("allDocuments"));
            int allRecorders = (int)map.get("allCounts");
            super.setSplitPage(super.getPagesValue(url),allRecorders,spu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.listByDid.page";
    }

    public String delete() {
        try {
            if(documentServiceBack.delete(this.document.getDcid())){
                super.setMsgAndUrl("delete.success.msg","DocumentBackServlet.listByAll.page");
            }else{
                super.setMsgAndUrl("delete.failure.msg","DocumentBackServlet.listByAll.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String updatePre(){
        try {
            super.request.setAttribute("Document",documentServiceBack.show(this.document.getDcid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.updatePre.page";
    }

    public String update() {
        String oldFileName = this.document.getFilename();
        String fileName = super.credateFileName();
        this.document.setFilename(fileName);
        this.document.setStatus(2);
        this.document.setCredate(new Date());
        try {
            if(documentServiceBack.update(this.document)){
                if(isFileUpload()){
                    // 在文件名称保存后进行数据删除操作
                    super.deletUplodFile(oldFileName);
                     // 最后在保存新的文件名称
                    super.saveUploadFile(fileName);
                }
                super.setMsgAndUrl("update.success.msg","DocumentBackServlet.listByAll.page");
            }else{
                super.setMsgAndUrl("update.failure.msg","DocumentBackServlet.listByAll.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }
    public String updateByStatus(){
        try {
            if(documentServiceBack.updateByStatys(this.document.getDcid(),this.document.getStatus())){
                super.setMsgAndUrl("document.updateByStatus.success.msg","DocumentBackServlet.list.page");
            }else{
                super.setMsgAndUrl("document.updateByStatus.failure.msg","DocumentBackServlet.list.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public String show(){
        try {
            super.request.setAttribute("Document",documentServiceBack.show(this.document.getDcid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.show.page";
    }

    public String list(){
        // 每次跳转的页面路径
        String url = "DocumentBackServlet.list.page";
        SplitPageUtils spu = new SplitPageUtils(super.request);
        int currentPage = spu.getCurrentPage(); // 表单当前页
        int lineSize = spu.getLineSize(); // 表示每页显示记录数
        try {
            Map<String,Object> map = documentServiceBack.listByStatus(currentPage,lineSize,2);
            super.request.setAttribute("allDocuments",map.get("allDocuments"));
            int allRecorders = (int)map.get("allCounts");
            super.setSplitPage(super.getPagesValue(url),allRecorders,spu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.list.page";
    }

    public String listByAll(){
        // 每次跳转的页面路径
        String url = "DocumentBackServlet.listByAll.page";
        SplitPageUtils spu = new SplitPageUtils(super.request);
        int currentPage = spu.getCurrentPage(); // 表单当前页
        int lineSize = spu.getLineSize(); // 表示每页显示记录数
        Admin admin = (Admin) super.request.getSession().getAttribute("admin");
        try {
            Map<String,Object> map = documentServiceBack.listByStatus(currentPage,lineSize,admin.getAid());
            super.request.setAttribute("allDocuments",map.get("allDocuments"));
            int allRecorders = (int)map.get("allCounts");
            super.setSplitPage(super.getPagesValue(url),allRecorders,spu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "document.listByAll.page";
    }

    public  String insertPre(){
        return  "document.insert.page";
    }

    public String insert(){
        // 创建文件名称
        String fileName = super.credateFileName() ;
        Admin admin = (Admin)super.request.getSession().getAttribute("admin");
        this.document.setDept(admin.getDept()); // did
        this.document.setAdmin(admin); // aid
        this.document.setCredate(new Date()); // 当前日期
        this.document.setStatus(2); // 默认锁定状态
        this.document.setFilename(fileName);
        try {
            if(documentServiceBack.insert(this.document)){
                if(super.isFileUpload()) {
                    super.saveUploadFile(fileName); // 保存文件到本地磁盘
                }
                super.setMsgAndUrl("insert.success.msg","DocumentBackServlet.insert.page");
            }else{
                super.setMsgAndUrl("insert.failure.msg","DocumentBackServlet.insert.page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward.page";
    }

    public Document getDocument() {
        return document;
    }

    @Override
    public String getTitle() {
        return "文档";
    }

    @Override
    public String getUploaDir() {
        return "/upload/document/";
    }

    @Override
    public String getColumnData() {
        return null;
    }
}
