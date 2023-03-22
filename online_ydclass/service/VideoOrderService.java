package net.ydclass.online_ydclass.service;

import net.ydclass.online_ydclass.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(int userId);
}
