package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidelineEntity;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return new Object[0];
    }
}
