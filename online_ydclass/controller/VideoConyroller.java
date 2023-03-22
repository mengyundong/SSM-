package net.ydclass.online_ydclass.controller;

import net.ydclass.online_ydclass.model.entity.Video;
import net.ydclass.online_ydclass.model.entity.VideoBanner;
import net.ydclass.online_ydclass.service.VideoService;
import net.ydclass.online_ydclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoConyroller {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     *
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner() {
        List<VideoBanner> bannerList = videoService.listBanner();

        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     *
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo() {
        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * 查询视频详情，包含章集信息
     *
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true) int videoId) {
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }

}
