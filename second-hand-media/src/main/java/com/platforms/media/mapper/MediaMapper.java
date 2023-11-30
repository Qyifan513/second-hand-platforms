package com.platforms.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platforms.media.model.po.MediaFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 媒资信息 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Mapper
public interface MediaMapper extends BaseMapper<MediaFiles> {
    int updateByBatch(@Param(value = "updateMediaList") List<MediaFiles> mediaFilesList);
}
