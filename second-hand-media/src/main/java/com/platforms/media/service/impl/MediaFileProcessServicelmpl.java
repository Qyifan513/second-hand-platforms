package com.platforms.media.service.impl;

import com.platforms.media.mapper.MediaMapper;
import com.platforms.media.mapper.MediaProcessMapper;
import com.platforms.media.model.po.MediaProcess;
import com.platforms.media.service.MediaFileProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFileProcessServicelmpl implements MediaFileProcessService {

    @Autowired
    MediaProcessMapper mediaProcessMapper;

    @Autowired
    MediaMapper mediaFilesMapper;

    @Override
    public List<MediaProcess> getMediaProcessList(int shardIndex, int shardTotal, int count) {
        List<MediaProcess> mediaProcesses = mediaProcessMapper.selectListByShardIndex(shardTotal, shardIndex, count);
        return mediaProcesses;
    }

    @Override
    public boolean startTask(long id) {
        int result = mediaProcessMapper.startTask(id);
        return result<=0?false:true;
    }

    @Override
    public void saveProcessFinishStatus(Long taskId, String status, String fileId, String url, String errorMsg) {
        //要更新的任务
        MediaProcess mediaProcess = mediaProcessMapper.selectById(taskId);
        if(mediaProcess == null){
            return ;
        }
        //如果任务执行失败
        //======如果任务执行成功======
        //文件表记录
        //更新media_file表中的url
        //更新MediaProcess表的状态
        //将MediaProcess表记录插入到MediaProcessHistory表
        //从MediaProcess删除当前任务
    }
}
