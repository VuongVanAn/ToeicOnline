package vn.myclass.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.common.utils.UploadUtil;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html", "/admin-guideline-listen-edit.html"})
public class ListenGuidelineController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, request);
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            executeSearchListenGuideline(request, command);
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            request.getRequestDispatcher("/views/admin/listenguideline/list.jsp").forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            request.setAttribute(WebConstant.FORM_ITEM, command);
            request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp").forward(request, response);
        }
    }

    private void executeSearchListenGuideline(HttpServletRequest request, ListenGuidelineCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getListenGuidelineServiceInstance().findByProperty(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String, Object> buildMapProperties(ListenGuidelineCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getTitle())) {
            properties.put("title", command.getPojo());
        }
        return properties;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> valueTitle = buildSetValueListenGuideline();
        Object[] objects = uploadUtil.writeOrUpdateFile(request, valueTitle, WebConstant.LISTENGUIDELINE);
        Map<String, String> mapValue = new HashMap<String, String>();
    }

    private Set<String> buildSetValueListenGuideline() {
        Set<String> stringSet = new HashSet<String>();
        return stringSet;
    }

}
