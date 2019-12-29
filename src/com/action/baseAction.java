package com.action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.ServletActionContext;
/**
* @author Dwt0610
* @Date 2019/12/14
*/
public class baseAction{

    public String ajax(Object out){
        PrintWriter writer = null;
        try {

            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            writer = response.getWriter();
            response.setDateHeader("Expires", 0);
            JSONObject object = JSONObject.fromObject(out);
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