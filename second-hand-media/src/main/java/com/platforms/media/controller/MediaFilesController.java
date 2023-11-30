package com.platforms.media.controller;

import com.platforms.media.model.dto.UploadFileParamsDto;
import com.platforms.media.model.dto.UploadFileResultDto;
import com.platforms.media.service.MediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api(value = "媒资文件管理接口",tags = "媒资文件管理接口")
@RestController
public class MediaFilesController {

    @Autowired
    MediaService mediaService;

    @ApiOperation("上传图片")
    @RequestMapping(value = "/upload/mediafile",method = RequestMethod.POST)
    public UploadFileResultDto upload(@RequestPart("file") MultipartFile filedata,
                                      @RequestParam(value= "objectName",required=false) String objectName) throws Exception {

        //准备上传文件的信息
        UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
        //原始文件名称
        uploadFileParamsDto.setFilename(filedata.getOriginalFilename());
        //文件大小
        uploadFileParamsDto.setFileSize(filedata.getSize());
        //文件类型
        uploadFileParamsDto.setFileType("001001");
        //创建一个临时文件
        File tempFile = File.createTempFile("minio", ".temp");
        filedata.transferTo(tempFile);

        //学校id
        Long schoolId = 1232141425L;
        //文件路径
        String localFilePath = tempFile.getAbsolutePath();

        //调用service上传图片
        UploadFileResultDto uploadFileResultDto = mediaService.uploadFile(schoolId, uploadFileParamsDto, localFilePath,objectName);

        return uploadFileResultDto;
    }
}
