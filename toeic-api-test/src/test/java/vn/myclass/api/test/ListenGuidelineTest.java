package vn.myclass.api.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest {
    ListenGuidelineDao guidelineDao;
    @BeforeTest
    public void initData() {
        guidelineDao = new ListenGuidelineDaoImpl();
    }

    @Test
    public void findByProperty(){
        Map<String, Object> property = new HashMap<String, Object>();
        property.put("title","Bài 3");
        property.put("content","Nội dung 3");
        Object[] objects = guidelineDao.findByProperty(property, null, null, null, null);
    }
}
