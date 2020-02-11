package vn.myclass.api.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

public class ListenGuidelineTest {

    @Test
    public void findByProperty(){
        ListenGuidelineDao guidelineDao = new ListenGuidelineDaoImpl();
        Object[] result = guidelineDao.findByProperty(null, null, null, null, 0, 2);
    }
}
