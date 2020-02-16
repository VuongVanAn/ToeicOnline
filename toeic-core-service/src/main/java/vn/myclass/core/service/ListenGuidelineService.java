package vn.myclass.core.service;

import java.util.Map;

public interface ListenGuidelineService {
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
