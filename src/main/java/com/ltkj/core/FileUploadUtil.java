package com.ltkj.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ltkj.app.management.model.UserCus;

/**
 * 类描述：文件上传工具
 * 
 * @author: WYJ @date： 2015/08/07
 * @version 1.0
 */
public class FileUploadUtil {

    /**
     * 上传图片文件
     * 
     * @param file
     *            上传的文件
     * @param tempFlag
     *            是否是临时预览文件， true为临时预览文件
     * @param req
     * @return
     * @throws Exception
     */
    public static String fileUp(MultipartFile file, boolean tempFlag, HttpServletRequest req) throws Exception {
        System.out.println(MessageConsts.ENVIRONMENT_GOODS_PICTURE_PATH);
        // 返回图片路径
        String filePath = Consts.CONTEXTPATH;
        String savePath = "";
        String fileEnd = file.getOriginalFilename();

        if (file != null && !StringUtils.isEmpty(fileEnd)) {
            // 获取文件后缀名

            fileEnd = fileEnd.substring(fileEnd.length() - 4, fileEnd.length());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            String dataTime = sdf.format(new Date());

            UserCus user = SessionContext.getLogInUser();
            String userId = user.getUserCode();

            // 临时预览文件夹路径
            String tempPath = req.getServletContext().getRealPath(Consts.TEMP_FILE_PATH + userId);
            
            // 删除用户单位临时预览文件夹  提交后将文件保存到sava文件夹下
//            delFolder(tempPath);
            
            // 如果是临时预览文件
            if (tempFlag) {
                savePath = tempPath;

                filePath += "/" + Consts.TEMP_FILE_PATH + userId + "/" + dataTime + fileEnd;
            } else {
                savePath = req.getServletContext().getRealPath(Consts.SAVE_FILE_PATH + userId);

                filePath += "/" + Consts.SAVE_FILE_PATH + userId + "/" + dataTime + fileEnd;
            }

            // 新建临时文件夹
            newFolder(savePath);

            savePath += "\\" + dataTime + fileEnd;

            // 读取文件内容到InputStream里
            InputStream is = file.getInputStream();

            // 创建输出流，生成新文件
            OutputStream os = new FileOutputStream(savePath);

            // 将InputStream里的byte拷贝到OutputStream
            IOUtils.copy(is, os);

            os.flush();
            is.close();
            os.close();
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        } else {
            filePath = "";
        }

        return filePath;
    }

    /**
     * 创建文件夹
     * 
     * @param folderPath
     */
    public static void newFolder(String folderPath) {
        try {
            String filePath = folderPath;
            File myFilePath = new File(filePath);
            if (!myFilePath.exists()) {
                myFilePath.mkdir();

                System.out.println("创建文件夹路径：" + filePath);
            }
        } catch (Exception e) {
            System.out.println("新建文件夹操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹及其下一级目录内容
     * 
     * @param folderPath
     */
    public static void delFolder(String folderPath) {
        try {
            File delFile = new File(folderPath);

            if (delFile.exists()) {
                if (delFile.isDirectory()) {
                    String[] children = delFile.list();

                    // 删除目录中的图片文件
                    for (int i = 0; i < children.length; i++) {
                        File picFile = new File(delFile, children[i]);

                        picFile.delete();
                    }
                }

                delFile.delete();

                System.out.println("删除文件地址：" + folderPath);
            }
        } catch (Exception e) {
            System.out.println("删除文件夹操作出错");
            e.printStackTrace();
        }
    }
    
    /**
     * 提交商品信息时，将临时文件夹下的图片copy到正式文件夹下
     * @param tempPath
     * @param confirmPath
     */
    public static void copyPictureToSave(HttpServletRequest req) throws IOException{
    	String userCode = SessionContext.getLogInUser().getUserCode();
    	//临时文件夹路径
    	String tempPath = req.getServletContext().getRealPath(Consts.TEMP_FILE_PATH + userCode);
    	//正式文件夹路径
    	String confirmPath = req.getServletContext().getRealPath(Consts.SAVE_FILE_PATH + userCode);
    	
    	File tempfile = new File(tempPath);
    	newFolder(confirmPath);
    	File savefile = new File(confirmPath);
    	
        if (tempfile.exists()) {
            if (tempfile.isDirectory()) {
            	//获取临时文件夹下的所有目录
            	String[] children = tempfile.list();
                // copy目录中的图片文件
                for (int i = 0; i < children.length; i++) {
                	String tempChildPath = tempfile+File.separator+children[i];
                	String saveChildPath = savefile+File.separator+children[i];
                	// 新建文件输入流并对它进行缓冲   
                    FileInputStream input = new FileInputStream(tempChildPath);  
                    BufferedInputStream inBuff=new BufferedInputStream(input);  
              
                    // 新建文件输出流并对它进行缓冲   
                    FileOutputStream output = new FileOutputStream(saveChildPath);  
                      
                    // 缓冲数组   
                    byte[] b = new byte[1024];  
                    int len;
                    
                    try {
						while ((len =inBuff.read(b)) != -1) {  
							output.write(b, 0, len);  
						}
						// 刷新此缓冲的输出流   
						output.flush();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{    
	                    //关闭流   
	                    inBuff.close();  
	                    output.close();  
	                    input.close(); 
					}
                }
            }
        }
        //删除临时文件夹
        delFolder(tempPath);
    }
    
    /**
     * 删除商品同时删除该用户在savafile目录下对应的图片
     * 如果该用户的savefile为空时，删除文件夹
     * @param PicPath
     * @throws Exception
     */
    public static void deletePicture(List<String> picSrc,HttpServletRequest req) throws Exception{
    	String userCode = SessionContext.getLogInUser().getUserCode();
    	String savePath = req.getServletContext().getRealPath(Consts.SAVE_FILE_PATH + userCode);
    	
    	for(int i=0; i<picSrc.size(); i++){
    		String pic = picSrc.get(i).substring(picSrc.get(i).length() - 21, picSrc.get(i).length());
    		File picture = new File(savePath,pic); 
    		picture.delete();
    	}
    	File save = new File(savePath);
    	String[] content = save.list();
    	if(content.length==0){
    		save.delete();
    	}
    }
}