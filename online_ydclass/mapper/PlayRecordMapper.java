package net.ydclass.online_ydclass.mapper;

import net.ydclass.online_ydclass.model.entity.Episode;
import net.ydclass.online_ydclass.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {

    int saveRecord(PlayRecord playRecord);
}
