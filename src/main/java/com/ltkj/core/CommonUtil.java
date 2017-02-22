package com.ltkj.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ltkj.app.management.model.UserCus;

import net.sf.json.JSONObject;

public class CommonUtil {

    public static List<String> getFullOrgId(String fid, String id) {
        // 获取ids
        String[] ids = fid.split("/");
        List<String> idss = new ArrayList<String>();
        for (int i = 0; i < ids.length; i++) {
            if (!"".equals(ids[i]) && !ids[i].equals(id)) {
                idss.add(ids[i]);
            }
        }
        return idss;
    }

    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "";
        try {
            dateStr = format.format(date);
        } catch (Exception ex) {
            dateStr = "";
        }

        return dateStr;
    }

    public static String DateToStr(Date date, String fmt) {
        SimpleDateFormat format = new SimpleDateFormat(fmt);
        String dateStr = "";
        try {
            dateStr = format.format(date);
        } catch (Exception ex) {
            dateStr = "";
        }

        return dateStr;
    }
    
    /**
     * 根据用户组织id 获取公司id
     * @param user
     * @return
     */
    public static String getCompanyIdByUser(String userFid) {
    	String[] ids= userFid.split("/");
    	return ids[1];
    }

    /**
     * 获取流程定义绑定业务key
     * 
     * @param obj
     * @param id
     * @return
     */
    public static String getProcessDefinitionBusinessKey(Object obj, Integer id) {
        String businessName = obj.getClass().getSimpleName();
        String businessKey = businessName + "." + id;
        return businessKey;
    }

    public static void main(String[] args) {

        // get password
        // password1:123456
        // System.out.println(getMD5("123456".getBytes()));
        // password1:111111
        // System.out.println(getMD5("111111".getBytes()));

        Md5PasswordEncoder passwordEncode = new Md5PasswordEncoder();
        String password = "123456";
        System.out.println(password + "=" + passwordEncode.encodePassword(password, ""));
        password = "111111";
        System.out.println(password + "=" + passwordEncode.encodePassword(password, null));
    }

    /**
     * @param owner
     * @param methodName
     * @param args
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void setUpdateInfo(Object owner, String flag) throws Exception {
        Class ownerClass = owner.getClass();

        UserCus user = SessionContext.getLogInUser();
        String userId = user.getUserCode();
        String userName = user.getUserName();

        Date date = getCurrentDate();

        Method setCreateDt = ownerClass.getMethod("setCreateDt", Date.class);
        Method setCreateOp = ownerClass.getMethod("setCreateOp", String.class);
        Method setCreatePg = ownerClass.getMethod("setCreatePg", String.class);

        Method setUpdateDt = ownerClass.getMethod("setUpdateDt", Date.class);
        Method setUpdateOp = ownerClass.getMethod("setUpdateOp", String.class);
        Method setUpdatePg = ownerClass.getMethod("setUpdatePg", String.class);

        if ("insert".equals(flag)) {
            setCreateDt.invoke(owner, date);
            setCreateOp.invoke(owner, userId);
            setCreatePg.invoke(owner, userName);
        }

        setUpdateDt.invoke(owner, date);
        setUpdateOp.invoke(owner, userId);
        setUpdatePg.invoke(owner, userName);
    }

    /**
     * 获取当前时间
     * 
     * @return 当前时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }
    
    public static String getUuid(){
    	return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static void responseJson(Object obj) throws IOException{
    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
	    HttpServletResponse response = ((ServletRequestAttributes)ra).getResponse(); 
    	PrintWriter out = response.getWriter();
      	out.print(JSONObject.fromObject(obj).toString());
      	out.flush();
      	out.close();
    }
}
