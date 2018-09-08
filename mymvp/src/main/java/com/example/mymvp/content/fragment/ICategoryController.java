package com.example.mymvp.content.fragment;


import com.example.mymvp.content.util.GanHuoEntity;

import java.util.List;

/**
 * Created by ryan on 18-8-30.
 */

public interface ICategoryController {
    String getCategoryType();

    void updateGanHuo(List<GanHuoEntity> data);

    void onLoadFailed();
}
