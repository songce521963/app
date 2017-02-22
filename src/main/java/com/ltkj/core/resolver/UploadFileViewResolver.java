/**
 * 
 */
package com.ltkj.core.resolver;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.ltkj.core.Consts;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author SONGCE
 *
 */
@Component("uploadFile")
public class UploadFileViewResolver extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // 返回值设定
        JSONObject json = new JSONObject();
        Object obj = model.get(Consts.SRC);
        if (obj != null) {
            // 上传图片
            json.accumulate(Consts.SRC, (String) obj);
        }

        Object erroList = model.get("messageList");
        if (erroList != null) {
            // 错误信息list
            JSONArray erroArray = JSONArray.fromObject(erroList);
            json.accumulate("messageList", erroArray);
        }
        json.accumulate("error", false);
        json.accumulate("message", "上传成功！");
        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
        out.close();
    }

}
