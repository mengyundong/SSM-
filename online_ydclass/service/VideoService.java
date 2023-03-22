package net.ydclass.online_ydclass.service;

import net.ydclass.online_ydclass.model.entity.Video;
import net.ydclass.online_ydclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
