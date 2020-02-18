package vn.myclass.controller.admin;

import vn.myclass.core.common.utils.UploadUtil;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.WebCommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/admin-exericse-upload.html")
public class ExerciseController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/exercise/upload.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle");
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> valueTitle = new HashSet<String>();
        Object[] objects = uploadUtil.writeOrUpdateFile(request, valueTitle, WebConstant.EXERCISE);
        boolean checkStatusUploadImage = (Boolean) objects[0];
        Map<String, String> mapMessage = buidMapRedirectMessage(resourceBundle);
        if (!checkStatusUploadImage) {
            WebCommonUtil.addRedirectMessage(request, "redirect_error", mapMessage);
        } else {
            WebCommonUtil.addRedirectMessage(request, "redirect_insert", mapMessage);
        }
        request.getRequestDispatcher("/views/admin/exercise/upload.jsp").forward(request, response);
    }

    private Map<String,String> buidMapRedirectMessage(ResourceBundle resourceBundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, resourceBundle.getString("label.exercise.add.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, resourceBundle.getString("label.message.error"));
        return mapMessage;
    }
}
