package com.action;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * @author cr
 * @Date 2019/12/17s
 */
public class baseActionConfig10 {
    public String ajax(Object out){
        PrintWriter writer = null;
        try {
            JsonConfig cfg = new JsonConfig();
            cfg.setJsonPropertyFilter(new PropertyFilter() {
                @Override
                public boolean apply(Object source, String name, Object value) {
                    if(name.equals("ddupPptteachercontenthardsByDdupTno")||name.equals("ddupPptteachercontentimportantsByDdupTno")
                            ||name.equals("ddupPptteachercontentimportanthardsByDdupTno")
                            ||name.equals("ddupTeachesByDdupTno")) {
//                    if(name.equals("ddupMajorByDdupMajor")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            writer = response.getWriter();
            response.setDateHeader("Expires", 0);
            JSONObject object = JSONObject.fromObject(out,cfg);
            writer.write(object.toString());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(writer!=null){
                writer.close();
            }
        }
        return null;
    }
}
