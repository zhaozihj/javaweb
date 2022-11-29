package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class UploadServlet extends HttpServlet {
    /**
     * 用来处理文件上传
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //1.先判断上传的数据是否是多段数据，只有是多端的数据才可能是文件上传的
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);

            try {
                //解析上传的数据，得到一个表单项FileItem
                List<FileItem> list=servletFileUpload.parseRequest(req);

                //循环判断每一个表单项是上传的文件还是普通类型
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        //UTF-8是为了防止出现乱码
                        System.out.println("表单项的value属性"+fileItem.getString("UTF-8"));
                    }
                    else
                    {
                        //上传的文件
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        System.out.println("表单项的value属性"+fileItem.getName());

                        //将上传的文件写入e盘
                        fileItem.write(new File("e:\\"+fileItem.getName()));
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
