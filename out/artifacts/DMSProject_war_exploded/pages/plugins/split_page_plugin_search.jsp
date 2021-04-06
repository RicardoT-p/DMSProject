<%@ page pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    request.setCharacterEncoding("UTF-8") ;
%>
<%
    String url = basePath + (String) request.getAttribute("url") ;
    String allRecorders = request.getAttribute("allRecorders").toString() ;
    String columnData = (String) request.getAttribute("columnData") ;
    String column = (String) request.getAttribute("column") ;
    String keyWord = (String) request.getAttribute("keyWord") ;
%>
<div id="searchDiv">
    <form action="<%=url%>" method="post">
        <%
            if (!(columnData == null || "".equals(columnData))) {
                String result [] = columnData.split("\\|") ;	// 拆分
        %>
        <select id="colSel" name="colSel">
            <%
                for (int x = 0 ; x < result.length ; x ++) {
                    String temp [] = result[x].split(":") ;
            %>
            <option value="<%=temp[1]%>" <%=temp[1].equals(column) ? "selected" : ""%>><%=temp[0]%></option>
            <%
                }
            %>
        </select>
        <%
            }
        %>
        <input type="text" name="kw" id="kw" placeholder="请输入检索关键字" value="<%=keyWord%>">
        <input type="submit" value="检索">本次查询一共返回有“<%=allRecorders%>”行记录！
    </form>
</div>