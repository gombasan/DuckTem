package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.Category;
import com.ducktem.web.entity.SubCategory;

public interface CategoryService {

    // 코드 짜기 전에 미리 팀원들끼리 인터페이스를 만들어 두고
    // 주석으로 해당 기능을 정의 해두면 협업할 때 수월해요
    List<Category> getList();

    List<SubCategory> getSubList();

}
