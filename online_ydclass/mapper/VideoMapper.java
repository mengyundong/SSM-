package net.ydclass.online_ydclass.mapper;

import net.ydclass.online_ydclass.model.entity.Video;
import net.ydclass.online_ydclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询视频详情
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id") int videoId);
}
