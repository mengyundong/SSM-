package net.ydclass.online_ydclass.service.impl;

import net.ydclass.online_ydclass.config.CacheKeyManager;
import net.ydclass.online_ydclass.model.entity.Video;
import net.ydclass.online_ydclass.model.entity.VideoBanner;
import net.ydclass.online_ydclass.mapper.VideoMapper;
import net.ydclass.online_ydclass.service.VideoService;
import net.ydclass.online_ydclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, () -> {
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });
            if (cacheObj instanceof List) {
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //可以返回兜底数据，业务系统降级-》SpringCloud专题课程
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("从数据库里面找轮播图列表");
                return bannerList;
            });
            if (cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
        try {
            Object cacheObject = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                // 需要使用mybatis关联复杂查询
                Video video = videoMapper.findDetailById(videoId);

                return video;
            });
            if (cacheObject instanceof Video) {
                Video video = (Video) cacheObject;
                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
